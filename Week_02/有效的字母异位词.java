//方法1 排序  时间复杂度：O（nlogn）
//方法2  hash 时间复杂要度： O(n)   空间复杂度：O（n）
class Solution {
    //方法1
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] ssort = s.toCharArray();
        char[] tsort = t.toCharArray();
        Arrays.sort(ssort);
        Arrays.sort(tsort);

        for(int i = 0; i < s.length(); i++ ){
            if(ssort[i] != tsort[i]){
                return false;
            }
        }
        return true;
    }


    //方法2
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();

        Map<Character, Integer> smap =  new HashMap<>();
        for(char schar:sarray){
            smap.put(schar, smap.getOrDefault(schar,0) + 1);
        }

        for(char tchar:tarray){
            if(!smap.containsKey(tchar)){
                return false;
            }
            if(smap.get(tchar) <= 0){
                return false;
            }
            smap.put(tchar, smap.get(tchar) - 1);
        }

        return true;
    }
}
