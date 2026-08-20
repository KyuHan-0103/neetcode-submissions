public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(toList(nums));

        while (true) {
            int i = n - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) i--;

            if (i < 0) break;

            int j = n - 1;
            while (nums[j] <= nums[i]) j--;

            swap(nums, i, j);
            reverse(nums, i + 1, n - 1);
            res.add(toList(nums));
        }

        return res;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        return list;
    }
}