public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] comb = new int[k];
        int i = 0;

        while (i >= 0) {
            comb[i]++;
            if (comb[i] > n) {
                i--;
                continue;
            }

            if (i == k - 1) {
                List<Integer> current = new ArrayList<>();
                for (int num : comb) {
                    current.add(num);
                }
                res.add(current);
            } else {
                i++;
                comb[i] = comb[i - 1];
            }
        }

        return res;
    }
}