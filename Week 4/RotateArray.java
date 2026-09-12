public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] rotated = rotate(nums, k);
        System.out.print("{");
        for (int i = 0; i < rotated.length; i++) {
            System.out.print(rotated[i]);
            if (i < rotated.length - 1) System.out.print(", ");
        }
        System.out.println("}");
    }

    private static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k > n
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        return result;
    }
}
