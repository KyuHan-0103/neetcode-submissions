class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        for(String s : strs){
            if(s.length() >= pre.length()){
                if(pre.equals(s.substring(0, pre.length()))) continue;
                int i = pre.length() - 1;
                while(i > 0 && !pre.substring(0, i).equals(s.substring(0, i))){
                    i--;
                }
                if(i == 0) return "";
                String temp = pre.substring(0, i);
                pre = temp;
            } else {
                if(s.equals("")) return "";
                if(pre.substring(0, s.length()).equals(s.substring(0, s.length()))){
                    pre = s;
                    continue;
                }
                int i = s.length() - 1;
                while(i > 0 && !pre.substring(0, i).equals(s.substring(0, i))){
                    i--;
                }
                if(i == 0) return "";
                String temp = pre.substring(0, i);
                pre = temp;
            }
        }
        return pre;
    }
}