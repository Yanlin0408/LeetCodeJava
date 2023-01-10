import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  =============== 答案
class Dataaaa {
    String val;
    int time;
    Dataaaa(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
class timeBasedKeyValueStore3 {

    /** Initialize your data structure here. */
    Map<String, List<Dataaaa>> map;
    public void timeBasedKeyValueStore3() {
        map = new HashMap<String, List<Dataaaa>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<Dataaaa>());
        map.get(key).add(new Dataaaa(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    protected String binarySearch(List<Dataaaa> list, int time) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (list.get(mid).time == time) return list.get(mid).val;
            if (list.get(mid).time < time) {
                if (list.get(mid+1).time > time) return list.get(mid).val;
                low = mid + 1;
            }
            else high = mid -1;
        }
        return list.get(low).time <= time ? list.get(low).val : "";
    }
}
