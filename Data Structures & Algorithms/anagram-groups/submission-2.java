class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<List<String>>();

        Map<String, Integer> anaMap = new HashMap<String, Integer>();

        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(anaMap.get(sorted)!=null){
                anagramGroups.get(anaMap.get(sorted)).add(strs[i]);
            }else{
                int index = anagramGroups.size();
                anaMap.put(sorted, index);
                
                anagramGroups.add(new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }

        return anagramGroups; 
    }
}
