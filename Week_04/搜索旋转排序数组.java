//leetcode 33
//方法1 暴力法 时间O(n)  空间O(1)
//方法2 二分查找 时间O(logN)  空间O(1)
class Solution {
    //方法1 暴力法
    public int search1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) return i;
        }
        return -1;
    }

    //方法2 二分查找
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;

        while(left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
