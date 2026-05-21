class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        char[] charT = t.toCharArray();
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);
    }
}
