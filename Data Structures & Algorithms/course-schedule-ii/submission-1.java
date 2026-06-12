class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> v = new HashSet<>();
    private List<Integer> tempRes = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        
        for(int[] pres : prerequisites){
            preMap.get(pres[0]).add(pres[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                System.out.println("test");
                return new int[]{};
            }
        }
        int i = 0;
        for(int num : tempRes){
            res[i] = num;
            i++;
        }

        return res;
    }

    private boolean dfs(int course){
        if(v.contains(course)){
            return false;
        }
        if(!preMap.containsKey(course)){
            return true;
        }
        if(preMap.get(course).isEmpty()){
            tempRes.add(course);
            preMap.remove(course);
            return true;
        }

        v.add(course);
        for(int p : preMap.get(course)){
            if(!dfs(p)){
                return false;
            }
        }

        tempRes.add(course);
        v.remove(course);
        preMap.remove(course);
        return true;
    }
}
