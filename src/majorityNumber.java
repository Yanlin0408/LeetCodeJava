import java.util.HashMap;

public class majorityNumber {
        public int majorityElement(int[] nums) {
            HashMap<Integer,Integer> mapNums = new HashMap<Integer,Integer>();
            int size = nums.length;
            int count = 0;
            while(count<size){
                int theNum = nums[count];
                int howMany = 0;
                if(mapNums.containsKey(theNum)){
                    howMany = mapNums.get(theNum)+1;
                    mapNums.put(theNum,howMany);
                }else{
                    mapNums.put(theNum,1);
                }
                if(howMany > (size/2)){
                    return theNum;
                }
                count++;
            }

            if(size==1){
                return nums[0];
            }

            return 0;
        }
}
