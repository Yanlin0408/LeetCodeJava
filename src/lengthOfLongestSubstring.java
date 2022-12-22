import java.util.ArrayList;
import java.util.HashMap;

class lengthOfLongestSubstring {
    HashMap<Character,Integer> checkMap = new HashMap<Character,Integer>();
    HashMap<Integer,Character> reverseMap = new HashMap<Integer,Character>();

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int counter = 0;
        int left = 0;
        int right = 0;
        int biggest = 0;
        int newMark = 0;
        while(right < s.length()){
            char theChar = s.charAt(right);
            if(!checkMap.containsKey(theChar)){
                checkMap.put(theChar, right);
                reverseMap.put(right, theChar);
                if(right - left >= biggest)     // 每次都是 right 顶不动了就更新
                    biggest = right - left + 1;
                right++;
            }else{  // 此时，right 指向 重复的第二个
                left = checkMap.get(s.charAt(right)) + 1;
                removeHoes(newMark, left);
                newMark = left;
            }
        }
        return biggest;
    }

    public void removeHoes(int mark, int idx){
        ArrayList<Character> keysToBeRemoved = new ArrayList<Character>();
        // get all values in reverse (keys in normal map to remove)
        for(int i=mark; i<idx; i++){
            keysToBeRemoved.add(reverseMap.get(i));
            reverseMap.remove(i);
        }
        for(int j=mark; j<idx; j++){
            checkMap.remove(keysToBeRemoved.get(j-mark));
        }
    }
}
