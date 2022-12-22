import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class threeSum {

    public static void main(String[] args){
        int[] inpu = {7,-13,-1,1,-6,14,10,-2,1,9,11,-10,8,-10,14,13,-1,4,-6,-3,-5,3,3,12,-5,11,5,-6,-2,0,-6,12,3,0,-2,12,-1,-7,-5,8,10,13,13,3,10,12,-7,-6,-7,-5,-1,3,5,-13,-8,-15,13,13,-14,-12,-2,-5,-15,8,11,-1,6,-13,-1,8,10,-14,-1,0,-4,-6,-3,5,-4,-2,7,10,8,-3,12,-14,-10,3,14,-9,-2,-11,-6,-9,13,12,-3,4,14,3,-11,2,5,-5,-13,-14,-3,-8};
        List<List<Integer>> ans = threeSum(inpu);
        System.out.println(ans);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // ArrayList<Integer> newNumList = new ArrayList<Integer> ();
        List<List<Integer>> allAns = new ArrayList<>();
        int[] passIn = new int[2];
        int[] ansss =  new int[2];

        // for (int i:nums){
        //     newNumList.add(i);
        // }

        ArrayList<Integer> newNumList = IntStream.of(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        // System.out.println(newNumList.toString()+"----");

        for (int i = 0;i<newNumList.size();i++){
            // System.out.println("rep "+i);

            ArrayList<Integer> tempArrayList = new ArrayList<Integer> ();
            tempArrayList = new ArrayList<Integer>(newNumList);
            tempArrayList.remove(i);
            // System.out.println("now temp --- "+tempArrayList);

            int target = 0 - newNumList.get(i);


            passIn = new int[]{0,0};
            // find all twoSums' that bring us the target
            // we use ansss to temporarily store (index of) ansss pair
            ansss = new int[]{0,0};

//             singleAns stores [x,x,x]
            List<Integer> singleAns = new ArrayList<Integer> ();
            // while 里面的条件是，找不到更多满足 target 的了就停下
            while(ansss[0] != -1){
                passIn = ArrayListToArray(tempArrayList);
                ansss = twoSum2(passIn, target);

                if(ansss[0] != -1){
                    // append answer in singleAns
                    singleAns = Arrays.asList(newNumList.get(i),passIn[ansss[0]],passIn[ansss[1]]);
                    // sort ArrayList then check duplicated or not
                    Collections.sort(singleAns);
                    // System.out.println("one answer is : "+singleAns);
                    if(allAns.contains(singleAns) == false){
                        allAns.add(singleAns);
                    }

                    // System.out.println("---------------"+tempArrayList);
                    // System.out.println("---------------"+Arrays.toString(ansss));

                    // 排好序，先 remove 小的那个
                    Arrays.sort(ansss);
                    tempArrayList.remove(ansss[0]);
                    tempArrayList.remove(ansss[1]-1);
                    // System.out.println("---------------"+tempArrayList);
                }else{
                    break;
                }


            }
            // System.out.println("twoSum index: "+ allAns.toString());
        }

        // System.out.println(allAns);

        return allAns;
    }

    public static int[] ArrayListToArray(ArrayList<Integer> ArrayL){
        int[] resultArray = new int[ArrayL.size()];

        for(int j=0; j<ArrayL.size();j++){
            resultArray[j] = ArrayL.get(j);
        }

        return resultArray;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++){
                if(i == j){
                    continue;
                }else{
                    if(nums[i]+nums[j] == target){
                        answer[0] = i;
                        answer[1] = j;
                        return answer;
                    }else{
                        continue;
                    }
                }
            }
        }

        if(answer[0] != answer[1]){
            return answer;
        }else{
            answer[0] = -1;
            return answer;
        }

    }

//     public int[] twoSum(int[] nums, int target) {
//         int[] answer = new int[2];
//         Map<Integer, Integer> answerMap = new HashMap();
//         ArrayList<Integer> newNums = new ArrayList<Integer>();

//         for(int i:nums){
//             // transform int[] array into ArrayList to find index of value quicklier
//             newNums.add(i);
//             // form a map that has each integer as key and corresponding answer as value
//             answerMap.put(i,target-i);
//         }

//         for(int i = 0; i<nums.length; i++){
//             // loop through nums first to find the pair that we want
//             if(i != newNums.indexOf(target-nums[i]) && answerMap.containsValue(nums[i]) == true){
//                 answer[0] = i;
//                 answer[1] = newNums.indexOf(target-nums[i]);
//                 break;
//             }
//         }

//         if(answer[0] != answer[1]){
//             return answer;
//         }else{
//             answer[0] = -1;
//             return answer;
//         }

//     }

}
