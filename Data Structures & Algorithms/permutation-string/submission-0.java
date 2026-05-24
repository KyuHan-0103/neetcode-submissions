class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] target = new int[26];
        int[] window = new int[26];

        //Initialize target frequency array
        for(int i = 0; i < s1.length(); i++){
            target[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(target[i] == window[i]){
                matches++;
            }
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(matches==26){
                return true;
            }
            
            int index = s2.charAt(r) - 'a';
            window[index]++;
            if(window[index]==target[index]){
                matches++;
            }else if(window[index]-1==target[index]){
                matches--;
            }
            index = s2.charAt(l) - 'a';
            window[index]--;
            if(window[index]==target[index]){
                matches++;
            } else if(window[index] + 1==target[index]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
