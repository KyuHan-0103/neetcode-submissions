class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        Map<Character, Integer> tCounter = new HashMap<>();
        Map<Character, Integer> sCounter = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tCounter.put(t.charAt(i), tCounter.getOrDefault(t.charAt(i), 0)+1);
        }

        int r = 0;
        int start = 0, end = s.length()+1;
        String res = "";
        while(r < s.length() && !tCounter.containsKey(s.charAt(r))){
            r++;
        }
        int l = r;
        int need = tCounter.size();
        int have = 0;
        while(r < s.length()+1){
            while(have == need){
                if((end-start) > (r - l)){
                    end = r;
                    start = l;
                    res = s.substring(start, end);
                }
                if(tCounter.containsKey(s.charAt(l))){
                    sCounter.put(s.charAt(l), sCounter.get(s.charAt(l)) - 1);
                    if(sCounter.get(s.charAt(l)) < tCounter.get(s.charAt(l))
                    && !(sCounter.get(s.charAt(l))+1 < tCounter.get(s.charAt(l)))){
                        have--;
                    }
                    l++;
                } else {
                    l++;
                }
            }
            if(r >= s.length()) break;
            if(tCounter.containsKey(s.charAt(r))){
                sCounter.put(s.charAt(r), sCounter.getOrDefault(s.charAt(r), 0) + 1);
                if(sCounter.get(s.charAt(r)) >= tCounter.get(s.charAt(r))
                && !(sCounter.get(s.charAt(r))-1 >= tCounter.get(s.charAt(r)))){
                    have++;
                }
                r++;
            } else {
                r++;
            }
        }
        /*
        if(have==need){
                if((end-start) > (r - l)){
                    end = r;
                    start = l;
                    res = s.substring(start, end);
                }
        } */
        return res;
    }
}