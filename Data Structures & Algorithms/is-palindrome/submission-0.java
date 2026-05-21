class Solution {
    public boolean isPalindrome(String s) {
        String newS = s.replace(" ", "");
        String newestS = newS.replaceAll("\\p{Punct}", "");
        char[] charList = newestS.toCharArray();
        System.out.println(charList);
        for(int i = 0, j = charList.length-1; i < charList.length/2; i++, j--){
            if(Character.toLowerCase(charList[i])!=Character.toLowerCase(charList[j])){
                return false;
            }
        }
        return true;
    }
}
