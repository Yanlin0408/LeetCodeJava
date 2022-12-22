public class binarySearch3 {
    public int findAns(int[] nums, int target, int start, int end){
        if (start == end) return -1;
        int mid = (start+end)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target)  return findAns(nums,target,start,mid);
        else    return findAns(nums,target,mid+1,end);
    }

    public int binarySearch3(int[] nums, int target){
        return findAns(nums, target, 0, nums.length-1);
    }
}