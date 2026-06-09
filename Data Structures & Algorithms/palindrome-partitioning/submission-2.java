class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(0, s, new ArrayList<String>(), "");
        return res;
    }

    private void backtrack(int i, String s, List<String> cur, String palindrome){
        if(i == s.length()){
            if(!cur.isEmpty() && palindrome.equals("")) res.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder palBuilder = new StringBuilder(palindrome);
        palBuilder.append(s.substring(i, i + 1));
        if(isPalindrome(new String(palBuilder))){
            cur.add(new String(palBuilder));
            backtrack(i + 1, s, cur, "");
            cur.remove(cur.size() - 1);
        }
        

        backtrack(i + 1, s, cur, new String(palBuilder));
        
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
