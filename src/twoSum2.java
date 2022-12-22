import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class twoSum2 {
    int[] nums;
    int target;

    public static void main(String[] args){
        System.out.println("在 main 里面");
        int[] inpuu = {33,2,7,11,8,4,16};
//        twoSum2(inpuu,27); 这样不行，一定要new
        twoSum2 cc = new twoSum2(inpuu,27);
        cc.findAns();

    }
    public twoSum2(int[] nums, int target){
        System.out.println("在 constructor 里面");
        this.nums = nums;
        this.target = target;
    }
    public int[] findAns () {
        int[] answer = new int[2];
        Map<Integer, Integer> answerMap = new HashMap();
        ArrayList<Integer> newNums = new ArrayList<Integer>();

        for(int i:nums){
            // transform int[] array into ArrayList to find index of value quicklier
            newNums.add(i);
            // form a map that has each integer as key and corresponding answer as value
            answerMap.put(i,target-i);
        }

        for(int i = 0; i<nums.length; i++){
            // loop through nums first to find the pair that we want
            if(i != newNums.indexOf(target-nums[i]) && answerMap.containsValue(nums[i]) == true){
                answer[0] = i;
                answer[1] = newNums.indexOf(target-nums[i]);
                break;
            }
        }

        newNums.add(5,100);
        System.out.println("twoSum ans: "+ Arrays.toString(answer));
        return answer;
    }
}