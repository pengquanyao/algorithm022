学习笔记

   六种排序算法

    /**
     * 选择排序
     * <p>
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 不稳定排序
     */
    public static void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    /**
     * 插入排序
     * <p>
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 稳定排序
     */
    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * 稳定排序
     */
    public static void bubbleUpSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 归并排序
     * <p>
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     * 不稳定排序
     */
    public static void mergeSort(int[] nums) {
        int n = nums.length;
        doMergeSort(nums, 0, n - 1);
    }

    private static void doMergeSort(int[] nums, int left, int right) {
        int n = right - left + 1;
        if (n <= 1) return;

        int mid = (right - left) / 2 + left;
        int[] newNums = new int[n];
        doMergeSort(nums, left, mid);
        doMergeSort(nums, mid + 1, right);
        int start1 = left;
        int start2 = mid + 1;
        int index = 0;
        while (start1 <= mid && start2 <= right) {
            newNums[index++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= mid) {
            newNums[index++] = nums[start1++];
        }
        while (start2 <= right) {
            newNums[index++] = nums[start2++];
        }

        for (int i = 0; i < n; i++) {
            nums[left++] = newNums[i];
        }
    }

    /**
     * 快速排序
     * <p>
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     * 不稳定排序
     */
    public static void quickSort(int[] nums) {
        int n = nums.length;
        doQuickSort(nums, 0, n - 1);
    }

    private static void doQuickSort(int[] nums, int low, int high) {
        int left = low;
        int right = high;
        if (left >= right) {
            return;
        }
        int pivot = left;
        left = left + 1;
        while (left < right) {
            while (nums[right] > nums[pivot] && left < right) {
                right--;
            }
            while (nums[left] < nums[pivot] && left < right) {
                left++;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[right];
        nums[right] = temp;
        doQuickSort(nums, low, right - 1);
        doQuickSort(nums, right + 1, high);
    }

    

    /**
     * 堆排序 数组堆化
     * 1、构造大顶堆
     * 2、交换头尾
     * 3、待排序数组堆化，再重复2
     * <p>
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     * 不稳定排序
     */
    public static void heapSort2(int[] nums) {
        int n = nums.length;
        //1、构造大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, 0, i - 1);
        }
    }

    /**
     * 数组nums[start...end]堆化，
     * 除了start其他元素符合堆定义
     * 需要调整start元素下沉，直至叶子。
     *
     * @param nums
     * @param start
     * @param end
     */
    private static void heapify(int[] nums, int start, int end) {
        int temp = nums[start];

        for (int i = start * 2 + 1; i <= end; i = i * 2 + 1) {
            if (i < end && nums[i + 1] > nums[i]) {
                i++;
            }

            if (nums[i] > temp) {
                nums[start] = nums[i];
                start = i;
            } else {
                break;
            }
        }

        nums[start] = temp;
    }

