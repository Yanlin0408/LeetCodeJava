import java.util.*;

class threeSumImproved {
    public List<List<Integer>> threeSumImproved(int[] nums) {
        int j;
        int k;
        int sum;
        List<Integer> singleAns = new ArrayList<Integer>();
        List<List<Integer>> allAns = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            j = i+1;
            k = nums.length - 1;
            while(j<k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    singleAns = Arrays.asList(nums[i],nums[j],nums[k]);
                    if(allAns.contains(singleAns) == false){
                        allAns.add(singleAns);
                    }
                    j++;
                }
                else if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }
            }
        }
        return allAns;
    }
}
