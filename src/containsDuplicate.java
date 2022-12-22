import java.util.Arrays;
import java.util.HashSet;

class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        boolean answer = false;
        Arrays.sort(nums);

        int count = 0; // form a hashset with no redundant numbers
        HashSet<Integer> noRedun = new HashSet<Integer> ();
        while(count < nums.length){
            noRedun.add(Integer.valueOf(nums[count]));
            count++;
        }

        count = 0;
        int[] noRedunArray = new int[noRedun.size()];
        for(int i:noRedun){
            noRedunArray[count] = i;
            System.out.println(i);
            count++;
        }
        Arrays.sort(noRedunArray);
        // String newArray = Arrays.toString(noRedunArray);
        // System.out.println(sortedNums);
        System.out.println(Arrays.equals(noRedunArray,nums));
        return Arrays.equals(noRedunArray,nums)?false:true;
    }
}
