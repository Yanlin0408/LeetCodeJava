import java.util.Arrays;

public class searchInRotatedSortedArray2 {
    public int searchInRotatedSortedArray2(int[] nums, int target) {
        if(nums[nums.length-1] > nums[0]){
            // array is not rotated. we can just retru the position of target.
            int left = 0, right = nums.length-1;
            while(left < right){
                int mid = (left + right) / 2;
                if(nums[mid] == target)     return mid;
                else if(nums[mid] > target)     right = mid - 1;
                else    left = mid + 1;
            }
            return (nums[left] == target)? left: -1;
        }else{
            // array is rotated. we need to find position of pivot first
            int left = 0, pivot, ans, right = nums.length-1, standard = nums[nums.length-1];
            while(left < right){
                int mid = (left + right) / 2;
                if(nums[mid] < standard)    right = mid - 1;
                else    left = mid + 1;
            }
            if(nums[left] > nums[nums.length-1])   pivot = left+1;
            else    pivot = left;

            // find the positin of target in a sorted Array
            int[] sortedArray = Arrays.copyOf(nums,nums.length);
            Arrays.sort(sortedArray);
            int posInSorted = Arrays.binarySearch(sortedArray,target);
            if(posInSorted < 0)     return -1;

            // calculate where the target is in rotated Array
            if(target >= nums[0]){   // left of pivot
                if(nums.length == 1)    return 0;
                ans = posInSorted - (nums.length - pivot);
            }else    ans = posInSorted + pivot;     // right of pivot

            return ans;
        }

    }
}
