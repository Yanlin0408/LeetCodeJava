import java.util.ArrayList;

class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int first = newInterval[0];
        int sec = newInterval[1];
        int startNum = 0;
        int endNum = 0;

        double firstPos = tellYouWhichInterval(intervals,first);
        double secPos = tellYouWhichInterval(intervals,sec);

        // when intervals is []
        int[][] daaan = new int[1][2];
        if(firstPos == -1 && secPos == -1 && intervals.length == 0){
            daaan[0] = newInterval;
            return daaan;
        }

        // specify startNum and endNum
        if(firstPos % 1 == 0 && firstPos != -1){
            startNum = intervals[(int) firstPos][0];
        }else if(firstPos % 1 == 0.5 || firstPos == -1.0){
            startNum = first;
        }

        if(secPos % 1 == 0 && secPos != -1)
            endNum = intervals[(int) secPos][1];
        else if(secPos % 1 == 0.5 || secPos == -1.0)
            endNum = sec;

        // loop through entire intervals and choose what to add in answer interval
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> mergedInterval = new ArrayList<Integer>();
        mergedInterval.add(startNum);
        mergedInterval.add(endNum);

        for(int j = 0;j<intervals.length;j++){
            // when intervals[j] falls in mergedInterval
            if(intervals[j][0] >= startNum && intervals[j][1] <= endNum){
                if(output.contains(mergedInterval)){
                    continue;
                }else{
                    output.add(mergedInterval);
                }

            }else{   // when it doesn't
                // intervals[j] 完全大于我的 mergedInterval
                if(intervals[j][0] > endNum && (output.contains(mergedInterval) == false)){
                    output.add(mergedInterval);
                }

                ArrayList<Integer> currentInterval = new ArrayList<Integer>();
                currentInterval.add(intervals[j][0]);
                currentInterval.add(intervals[j][1]);
                output.add(currentInterval);
                // intervals[j] 完全小于我的 mergedInterval
                if(intervals[j][1] < startNum && (output.contains(mergedInterval) == false)){
                    //如果有下一个，并且下一个还小，continue
                    if(j!=(intervals.length-1)){
                        if(intervals[j+1][1] < startNum)
                            continue;
                    }
                    //如果有下一个，并且下一个大了 ｜｜ 或者如果没有下一个     那就 add
                    output.add(mergedInterval);
                }

            }

        }

        // transfer what's in ArrayList<ArrayList<Integer>> into int[][]
        int[][] daan = new int[output.size()][2];
        for(int k=0; k<output.size(); k++){
            daan[k][0] = output.get(k).get(0);
            daan[k][1] = output.get(k).get(1);
        }

        return daan;
    }

    public double tellYouWhichInterval(int[][] intervals,int num){
        float pos = 0;
        for(int i=0;i<intervals.length;i++){
            if(i==(intervals.length-1) && num > intervals[i][1]){
                return i+0.5;    // [6,9] be the last one and num == 11
            }
            if(num>=intervals[i][0] && num<=intervals[i][1]){  // [2,5] and 4
                return i;
            }else if(num>intervals[i][1] && num<intervals[i+1][0]){  //[2,4] [7,9] and 6
                double bitch = i+0.5;
                return bitch;
            }

        }
        return -1;
    }
}