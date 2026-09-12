public class FindMinimumRotatedSortedArray {
    // Modified binary search to find minimum in rotated sorted array with unique elements
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // Minimum is to the right of mid
                left = mid + 1;
            } else {
                // Minimum is at mid or to the left
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(arr1)); // 1
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(arr2)); // 0
        int[] arr3 = {11, 13, 15, 17};
        System.out.println(findMin(arr3)); // 11
    }
}
