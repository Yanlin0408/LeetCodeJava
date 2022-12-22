import java.util.Arrays;

class maxProfit2 {
    public int maxProfit1(int[] prices) {
        if(prices.length == 0 || prices.length == 1){
            return 0;
        }
        int maxdiff = 0;
        for(int i=0; i<prices.length-1; i++){
            int newDiff = findMaxGivenIndex(i,prices) - prices[i];
            if(maxdiff < newDiff){
                maxdiff = newDiff;
            }
        }
        return maxdiff>=1?maxdiff:0;
    }

    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit3(int prices[]) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while(right < prices.length){
            int currentProfit = prices[right] - prices[left];
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
                right++;
                continue;
            }
            if(currentProfit < 0){
                left = right;
                right = left + 1;
            }else{
                right++;
            }
        }
        return maxProfit;
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