class Solution {
    List<String> res;
    int[] map;
    StringBuilder s;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        s = new StringBuilder();
        map = new int[8];
        map[0] = 'a';
        map[1] = 'd';
        map[2] = 'g';
        map[3] = 'j';
        map[4] = 'm';
        map[5] = 'p';
        map[6] = 't';
        map[7] = 'w';
        backTrack(0, digits);
        return res;
    }

    private void backTrack(int i, String digits){
        if(i == digits.length()){
            res.add(s.toString());
            return;
        }

        int letters = (digits.charAt(i) == '7' || digits.charAt(i) == '9') ? 4 : 3;
        for (int j = 0; j < letters; j++) {
            s.append((char) (map[digits.charAt(i) - '0' - 2] + j));
            backTrack(i + 1, digits);
            s.deleteCharAt(s.length() - 1);
        }

    }
}
