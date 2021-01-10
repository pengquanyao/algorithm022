学习笔记

周六参加了leetcode第43场双周赛
共4个题：3分题、4分题、5分题、7分题
只完成了3分题：计算力扣银行的钱
未完成4分题：删除子字符串的最大得分，代码完成但执行到后面case出现执行超时，思路用String.replaceAll来替换子串。
其他题未开始做



周天参加了leetcode第223场周赛
完成了3分题：解码异或后的数组， 4分题：交换链表中的节点
未完成5分题：执行交换操作后的最小汉明距离，该题思路用并查集，跑到11个case出错，1.5小时的比赛时间用完了。 赛后完善代码case执行到59/69出现执行超时，需要优化。
未开始做的题：完成所有工作的最短时间

比赛心得：
1、比赛考验题目转模型的分析能力，时间比较紧，代码在idea中写可以省时间。
2、熟悉了并查集的运用
3、代码写出低时间复杂度很难，自己写的程序很容易就执行超时，要多分析练习。

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中

@Test
    public void test1() {
        //正常casee
        //int[] nums = {4, 5, 6, 7,8，10, 29, 0, 1, 2};
        //极端case 无序数组长度为1
        int[] nums = {4, 5, 6, 7, 8, 10, 29, 0};
        Integer ress = findNode(nums);
        System.out.println("res:" + nums[ress]);
    }

    //使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
    //说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中

    //思路：比较mid、最左端点、最右端点、mid+1、mid-1端点
    //当找到  mid值比mid+1、mid-1都小就返回

    //不考虑特殊情况，一定会有中间无序,
    public int findNode(int[] nums) {
        int n = nums.length - 1;
        int left = 0, right = n;
        int mid = 0;

        while (left <= right) {
            mid = ((right - left) >> 1) + left;

            if (nums[0] < nums[mid]) {
                left = mid + 1;
            } else {
                //在无序端
                if (mid == right) return mid;
                if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            }
        }

        return mid;
    }
