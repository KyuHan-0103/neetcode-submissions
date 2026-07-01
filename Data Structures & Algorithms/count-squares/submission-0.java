class CountSquares {
    private Map<Integer, Map<Integer, Integer>> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        map.putIfAbsent(point[0], new HashMap<Integer, Integer>());
        map.get(point[0]).put(point[1], 
        map.get(point[0]).getOrDefault(point[1], 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0, x = point[0], y = point[1];

        if(!map.containsKey(x)) return res;

        for(int newY : map.get(x).keySet()){
            int side = newY - y;
            if(side == 0) continue;

            int x2 = x + side, x3 = x - side;

            res += map.get(x).get(newY) *
            map.getOrDefault(x2, new HashMap<>()).getOrDefault(y, 0) *
            map.getOrDefault(x2, new HashMap<>()).getOrDefault(newY, 0);

            res += map.get(x).get(newY) *
            map.getOrDefault(x3, new HashMap<>()).getOrDefault(y, 0) *
            map.getOrDefault(x3, new HashMap<>()).getOrDefault(newY, 0);
        }

        return res;
    }
}
