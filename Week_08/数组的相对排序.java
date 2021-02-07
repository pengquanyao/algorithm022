class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cache = new int[1001];
        for(int arr:arr1) {
            cache[arr]++;
        }

        int index= 0;
        for(int arr:arr2) {
            for(int i = cache[arr]; i>0;i--) {
                arr1[index++] = arr;
            }
            cache[arr] = 0;
        }

        for(int i = 0; i<1001; i++) {
            for(int j = cache[i]; j>0;j--) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
