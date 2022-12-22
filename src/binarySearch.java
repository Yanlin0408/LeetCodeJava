import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.search;

public class binarySearch {
    public int binarySearch(int[] nums, int target) {
        if(nums[nums.length/2] == target) return Arrays.binarySearch(nums,target);

        System.out.println(Arrays.toString(nums));
        System.out.println("mid "+nums[nums.length/2]);
        System.out.println(nums.length/2);
        int ans = -1;
        // int b =
        if(target > nums[nums.length/2]){
            System.out.println("> "+nums[nums.length/2]);
            ans = search(Arrays.copyOfRange(nums,1+nums.length/2,nums.length),target);
            return ans + nums.length/2 + 1;
        }
        else{
            System.out.println("< "+nums[nums.length/2]);
            ans = search(Arrays.copyOfRange(nums,0,nums.length/2),target);
            return ans - nums.length/2+1;
        }

        // int[] caobi = Arrays.copyOfRange(nums,2,6);
        // System.out.println(Arrays.toString(caobi));
        // System.out.println(nums[nums.length/2]);
        // System.out.println(Arrays.toString(nums));

        // return ans + nums.length/2;
    }
}
