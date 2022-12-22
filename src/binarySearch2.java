public class binarySearch2 {
    public int binarySearch2(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = (l+r)/2;
//            System.out.println(l+" "+r+" "+m);
            if(nums[m] < target)    l = m+1;    // m 的左边全部没用了，所以要 m+1
            else    r = m;  // 有可能 nums[m] == target，所以要 m
        }
        return (nums[l] == target)?l:-1;    // 反正最后 l r 会碰到一起
    }

    public int binarySearch22(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = (l+r)/2;
            System.out.println(l+" "+r+" "+m);
            if(nums[m] >= target)    r = m;
            else    l = m+1;
        }
        return (nums[l] == target)?l:-1;    // 反正最后 l r 会碰到一起
    }

    public int binarySearch222(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l < r){

            int m = (l+r)/2;
//            if(nums[m] > nums[r])
            System.out.println(l+" "+r+" "+m);
            if(nums[m] == target){
                System.out.println("===");
                return m;
                // l = m;
                // break;
            }
            else if(nums[m] > target)    r = m-1;    // m 的左边全部没用了，所以要 m+1
            else    l = m+1;  // 有可能 nums[m] == target，所以要 m
        }
        return (nums[l] == target)?l:-1;    // 反正最后 l r 会碰到一起
    }
}
