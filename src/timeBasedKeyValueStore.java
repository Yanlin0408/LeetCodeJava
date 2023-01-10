import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// my own 1st solution, which failed the 44th test. (time limit exceed)
class timeBasedKeyValueStore {
    HashMap<String, ArrayList<Data>> rongqi;
    public void timeBasedKeyValueStore() {
        this.rongqi = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!rongqi.containsKey(key))    rongqi.put(key,new ArrayList<Data>());
        rongqi.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        ArrayList<Data> arrayFound= rongqi.get(key);
        // use binary search to find the index of timestamp, then use it in the rongqi
        // get all timestamps
        int[] timeArray = new int[arrayFound.size()];
        for(int i=0;i<timeArray.length;i++){
            timeArray[i] = arrayFound.get(i).TS;
        }
        // when the timestamp passed in is larget than no one
        if(timestamp < timeArray[0])    return "";

        // when the exact timestamp exist, just return it
        if(Arrays.binarySearch(timeArray, timestamp) >= 0)  return arrayFound.get(Arrays.binarySearch(timeArray, timestamp)).value;

        // when it doesn't exist, do binary search to find the largest one less than input it
        int left = 0, right = timeArray.length-1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(timeArray[mid] == timestamp){
                return arrayFound.get(mid).value;
            }else if(timeArray[mid] < timestamp){
                if(timeArray[mid+1] > timestamp)    return arrayFound.get(mid).value;
                left = mid + 1;
            }else if(timeArray[mid] > timestamp){
                right = mid - 1;
            }
        }
        return (right >= timeArray.length)? arrayFound.get(right-1).value :arrayFound.get(right).value;
    }
}

class Data {
    String value;
    int TS;
    public Data(String value, int timeStamp){
        this.value = value;
        this.TS = timeStamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */