class Solution {
    List<String> res;
    int[] map;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0) return res;
        map = new int[8];
        map[0] = 'a';
        map[1] = 'd';
        map[2] = 'g';
        map[3] = 'j';
        map[4] = 'm';
        map[5] = 'p';
        map[6] = 't';
        map[7] = 'w';
        backTrack(0, digits, "");
        return res;
    }

    private void backTrack(int i, String digits, String builder){
        if(i == digits.length()){
            res.add(builder);
            return;
        }

        if(digits.charAt(i) == '7' || digits.charAt(i) == '9'){
            for(int j = 0; j < 4; j++){
                StringBuilder s = new StringBuilder(builder);
                s.append((char) (map[digits.charAt(i) - '0' - 2] + j));
                backTrack(i + 1, digits, new String(s));
            }
        } else {
            for(int j = 0; j < 3; j++){
                StringBuilder s = new StringBuilder(builder);
                s.append((char) (map[digits.charAt(i) - '0' - 2] + j));
                backTrack(i + 1, digits, new String(s));
            }
        }

    }
}
