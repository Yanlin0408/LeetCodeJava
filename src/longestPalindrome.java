import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class longestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> alphaRecord = new HashMap<Character, Integer>();
        int count;
        for(char c:s.toCharArray()){
            count = (alphaRecord.get(c) == null)? 1: alphaRecord.get(c)+1;
            alphaRecord.put(c, count);
        }
        int ansCounter = 0;
        ArrayList<Integer> oddRecord = new ArrayList<Integer>();
        for(int k:alphaRecord.values()){
            if(k%2 == 0){
                ansCounter += k;
            }else{
                oddRecord.add(k);
            }
        }

        if(oddRecord.size() == 0)
            return ansCounter;

        // if oddRecord only have ones, we just add 1 and return
        if(oddRecord.size() == 1 && oddRecord.get(0) == 1){
            return ansCounter + 1;
        }else if(oddRecord.contains(1)){
            boolean quanshiyi = true;
            for(int jj = 0; jj<oddRecord.size(); jj++){
                if(oddRecord.get(jj) != 1){
                    quanshiyi = false;
                    break;
                }
            }
            if(quanshiyi == true)
                return ansCounter + 1;
        }

        // if we pick the biggest as the center of the Palindrome, the rest odd num have to be minused by 1
        Collections.sort(oddRecord);

        ansCounter += oddRecord.get(oddRecord.size()-1);
        oddRecord.remove(oddRecord.size()-1);
        for(int h:oddRecord){
            ansCounter = ansCounter + (h-1);
        }
        return ansCounter;
    }
}
