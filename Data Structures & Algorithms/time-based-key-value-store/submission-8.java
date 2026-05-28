class TimeMap {
    Map<String, List<int[]>> map;      // int[] = {timestamp}
    Map<String, List<String>> values;

    public TimeMap() {
        map = new HashMap<>();
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!this.map.containsKey(key)){
            return "";
        } else {
            List<int[]> times = map.get(key);
            int l = 0, r = times.size()-1, res = -1;
            while(l <= r){
                int mid = (l+r)/2;
                if(times.get(mid)[0] <= timestamp){
                    res = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
                return res==-1 ? "" : values.get(key).get(res);
        }
    }
}
