import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


// 我参考了一个答案，一步步优化，到 pass

// 3 个点，
// 1，没有从 rongqi 里的 value(arrayFound) 里遍历提取出一个 int[]，省了时间，过了 44th test case
// right = arrayFound.size()-1; // 之前忘了 -1
// if(arrayFound.get(mid).TS < timestamp && arrayFound.get(mid+1).TS > timestamp) 直接 return

class timeBasedKeyValueStore2 {
    HashMap<String, ArrayList<Data>> rongqi = new HashMap<>();
    public void timeBasedKeyValueStore2() {
    }

    public void set(String key, String value, int timestamp) {
        if(!rongqi.containsKey(key))    rongqi.put(key,new ArrayList<Data>());
        rongqi.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(rongqi.containsKey(key)){
            ArrayList<Data> arrayFound = rongqi.get(key);
            int left = 0, right = arrayFound.size()-1;
            while(left < right){
                int mid = (left + right) >> 1;
                if(arrayFound.get(mid).TS == timestamp){
                    return arrayFound.get(mid).value;   // exact timestamp
                }else if(arrayFound.get(mid).TS < timestamp){
                    if(arrayFound.get(mid+1).TS > timestamp)    return arrayFound.get(mid).value;   // exact largest timestamp we need
                    left = mid + 1;
                }else if(arrayFound.get(mid).TS > timestamp){
                    right = mid - 1;
                }
            }
            return arrayFound.get(left).TS <= timestamp ? arrayFound.get(left).value : "";  // handles when timestamp we passed in is too small
        }else   return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
