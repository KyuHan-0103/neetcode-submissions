class TimeMap {
    Map<String, Map<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<String, Map<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(this.map.containsKey(key)){
            this.map.get(key).put(timestamp, value);
        }else{
            this.map.put(key,
            new HashMap<Integer, String>(){{put(timestamp, value);}});
        }
    }
    
    public String get(String key, int timestamp) {
        if(!this.map.containsKey(key)){
            return "";
        } else {
            List<Integer> times = 
            new ArrayList<>(this.map.get(key).keySet());
            Collections.sort(times);
            int res = times.get(0);
            if(res >  timestamp) return "";
            int l = 0, r = times.size()-1;
            while(l <= r){
                int mid = (l+r)/2;
                if(times.get(mid) <= timestamp){
                    res = times.get(mid);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
                return this.map.get(key).get(res);
        }
    }
}
