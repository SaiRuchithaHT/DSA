class TimeMap {
    class Pair{
        int time;
        String value;
        Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
        public int getTime(){
            return this.time;
        }
        public String getValue(){
            return this.value;
        }
    }
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
        // map.put(key, );
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Pair> list = map.get(key);
        int min = 0, max = list.size()-1;
        String res = "";
        while(min<=max){
            int mid = min + (max-min)/2;
            int time = list.get(mid).getTime();
            if(time == timestamp)
                return list.get(mid).getValue();
            else if(time>timestamp){
                max = mid - 1;
            } else {
                res = list.get(mid).getValue();
                min = mid + 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */