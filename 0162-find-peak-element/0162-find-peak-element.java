class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than next element,
            // peak must be in left half (including mid)
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                // else peak is in right half (excluding mid)
                left = mid + 1;
            }
        }
        // left == right -> peak found
        return left;
    }
}
