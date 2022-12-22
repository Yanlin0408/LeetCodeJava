import java.util.Arrays;
import java.util.HashMap;class maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        HashMap<Integer,Integer> maxdiffEachDay = new HashMap<Integer,Integer>();

        for(int i=0; i<prices.length-1; i++){
            // System.out.println(findMaxGivenIndex(i,prices));
            int maxdiff = findMaxGivenIndex(i,prices) - prices[i];
            if(maxdiffEachDay.containsKey(prices[i])){  // if we find the same key, we want to keep the largest maxdiff
                if(maxdiff>maxdiffEachDay.get(prices[i])){
                    maxdiffEachDay.put(prices[i],maxdiff);
                }else{continue;}
            }
            maxdiffEachDay.put(prices[i],maxdiff);
        }

        int count = 0;
        int[] maxList = new int[prices.length-1];
        for(int j:maxdiffEachDay.keySet()){
            maxList[count] = maxdiffEachDay.get(j);
            count++;
        }
        Arrays.sort(maxList);
        System.out.println(maxdiffEachDay);
        System.out.println(Arrays.toString(maxList));
        return maxList[maxList.length-1]>=1?maxList[maxList.length-1]:0;
    }

    public int findMaxGivenIndex(int idx, int[] pricesList){
        int[] choppedList = new int[pricesList.length-idx-1];
        // first step: chop the array
        for(int i=idx+1; i<pricesList.length; i++){
            choppedList[i-idx-1] = pricesList[i];
        }
        // sec step: sort them and return the biggest
        Arrays.sort(choppedList);

        return choppedList[choppedList.length-1];
    }
}
