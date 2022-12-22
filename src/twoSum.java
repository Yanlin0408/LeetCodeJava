class twoSum {

    public static void main(String[] args){
        int[] inpu = {2,7,11,8,4,16};
        int[] ans = twoSum(inpu,27);
        System.out.println(ans[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
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
        return answer;
    }
}