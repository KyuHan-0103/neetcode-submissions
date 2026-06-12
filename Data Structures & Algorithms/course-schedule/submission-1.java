class Solution {
    private Map<Integer, List<Integer>> pre = new HashMap<>();
    private Set<Integer> visits = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            pre.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            pre.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course){
        if(visits.contains(course)){
            return false;
        }
        if(pre.get(course).isEmpty()){
            return true;
        }

        visits.add(course);
        for(int p : pre.get(course)){
            if(!dfs(p)){
                return false;
            }
        }

        visits.remove(course);
        pre.put(course, new ArrayList<>());
        return true;
    }
}
