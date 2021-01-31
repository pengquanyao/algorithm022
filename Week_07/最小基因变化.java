//leetcode 433
//方法1  dfs
//方法2  bfs
//方法3  双方bfs
class Solution {
    Map<String, Integer> genId = new HashMap<>();
    List<String> idGen = new ArrayList<>();
    List<List<Integer>> edge = new ArrayList<>();
    int genSum = 0;

    //方法2 bfs
    public int minMutation2(String start, String end, String[] bank) {
        List<String> bankSet = new ArrayList(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        if (bankSet.contains(start)) {
            bankSet.remove(start);
        }

        for (String gen : bankSet) {
            addGen(gen);
        }
        addGen(start);

        //生成边
        for (String gen : bankSet) {
            if (valid(start, gen)) {
                edge.get(genId.get(start)).add(genId.get(gen));
                edge.get(genId.get(gen)).add(genId.get(start));
            }
        }

        for (int i = 0; i < bankSet.size(); i++) {
            for (int j = i + 1; j < bankSet.size(); j++) {
                if (valid(bankSet.get(i), bankSet.get(j))) {
                    edge.get(genId.get(bankSet.get(i))).add(genId.get(bankSet.get(j)));
                    edge.get(genId.get(bankSet.get(j))).add(genId.get(bankSet.get(i)));
                }
            }
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[genSum];
        int beginId = genId.get(start);
        int endId = genId.get(end);
        queue.offer(beginId);
        visited[beginId] = true;
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currId = queue.poll();
                if (currId == endId) {
                    return res;
                }

                for (int tempId : edge.get(currId)) {
                    if (!visited[tempId]) {
                        queue.offer(tempId);
                        visited[tempId] = true;
                    }
                }
            }
            res++;
        }

        return -1;
    }

    //方法3 双向bfs
    public int minMutation(String start, String end, String[] bank) {
        List<String> bankSet = new ArrayList(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        if (bankSet.contains(start)) {
            bankSet.remove(start);
        }

        for (String gen : bankSet) {
            addGen(gen);
        }
        addGen(start);

        //生成边
        for (String gen : bankSet) {
            if (valid(start, gen)) {
                edge.get(genId.get(start)).add(genId.get(gen));
                edge.get(genId.get(gen)).add(genId.get(start));
            }
        }

        for (int i = 0; i < bankSet.size(); i++) {
            for (int j = i + 1; j < bankSet.size(); j++) {
                if (valid(bankSet.get(i), bankSet.get(j))) {
                    edge.get(genId.get(bankSet.get(i))).add(genId.get(bankSet.get(j)));
                    edge.get(genId.get(bankSet.get(j))).add(genId.get(bankSet.get(i)));
                }
            }
        }

        boolean[] visited = new boolean[genSum];
        int beginId = genId.get(start);
        int endId = genId.get(end);
        //双向bfs
        Set<Integer> queueBegin = new HashSet<>();
        queueBegin.add(beginId);
        Set<Integer> queueEnd = new HashSet<>();
        Set<Integer> tempQueue = new HashSet<>();
        queueEnd.add(endId);
        visited[beginId] = true;
        visited[endId] = true;
        int res = 0;

        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            if (queueBegin.size() > queueEnd.size()) {
                tempQueue = queueBegin;
                queueBegin = queueEnd;
                queueEnd = tempQueue;
                continue;
            }
            res++;
            tempQueue = new HashSet<>();
            for (Integer currId : queueBegin) {
                for (int tempId : edge.get(currId)) {
                    if (queueEnd.contains(tempId)) {
                        return res;
                    }
                    tempQueue.add(tempId);
                }
            }
            queueBegin = tempQueue;
            if(res > genSum) return -1;
        }

        return -1;
    }

    public void addGen(String gen) {
        if (!genId.containsKey(gen)) {
            genId.put(gen, genSum++);
            idGen.add(gen);
            edge.add(new ArrayList<>());
        }
    }

    public boolean valid(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int diff = 0;
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) diff++;
        }
        return diff == 1;
    }

    //方法1 dfs
    public int minMutation1(String start, String end, String[] bank) {
        int[] minStep = new int[]{Integer.MAX_VALUE};
        List<String> path = new ArrayList<>();
        dfs(path, minStep, start, end, bank);
        return minStep[0] == Integer.MAX_VALUE ? -1 : minStep[0];
    }

    public void dfs(List<String> path, int[] minStep, String start, String end, String[] bank) {
        if(start.equals(end)) {
            minStep[0] = Math.min(path.size(), minStep[0]);
            return;
        }

        for(String b: bank) {
            if(path.contains(b)) continue;
            int diff = 0;
            for(int i = 0; i < start.length(); i++) {
                if(start.charAt(i) != b.charAt(i)) diff++;
            }
            if(diff == 1) {
                path.add(b);
                dfs(path, minStep, b, end, bank);
                path.remove(b);
            }
        }
    }


}
