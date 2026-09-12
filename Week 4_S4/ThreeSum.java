import java.util.*;

public class ThreeSum {
    // Returns all unique triplets that sum to zero using sorting and two‑pointer technique
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});
                    // Move left and right to next different values
                    int leftVal = nums[left];
                    int rightVal = nums[right];
                    while (left < right && nums[left] == leftVal) left++;
                    while (left < right && nums[right] == rightVal) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[] input1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(input1);
        System.out.println(java.util.Arrays.deepToString(res1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] input2 = {0, 0, 0};
        int[][] res2 = threeSum(input2);
        System.out.println(java.util.Arrays.deepToString(res2)); // [[0, 0, 0]]
    }
}
