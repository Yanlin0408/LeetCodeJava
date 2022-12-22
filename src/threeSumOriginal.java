import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class threeSumOriginal {

    private int[] nums;

//    public threeSumOriginal(int[] numssss){
//        System.out.println("_+_+_+_+"+Arrays.toString(numssss));
//        this.nums = numssss;
////        this.nums = new int[] {-1,0,1,2,-1,-4};
////        threeSumOriginal newnew = new threeSumOriginal(this.nums);
////        newnew.fuck();
//    }
    public List<List<Integer>> threeSumOriginal(int[] numssss) {
        this.nums = numssss;
        // ArrayList<Integer> newNumList = new ArrayList<Integer> ();
        List<List<Integer>> allAns = new ArrayList<>();
        int[] passIn = new int[2];
        int[] ansss =  new int[2];

        ArrayList<Integer> newNumList = IntStream.of(this.nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        // System.out.println(newNumList.toString()+"----");

        for (int i = 0;i<newNumList.size();i++){
//             System.out.println("rep "+i);

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

    public int[] ArrayListToArray(ArrayList<Integer> ArrayL){
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

}

