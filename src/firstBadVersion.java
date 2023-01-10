import java.math.BigInteger;

public class firstBadVersion{
    public int firstBadVersion(int n) {
        int l = 1, r = n;

        while(l < r){
            int mid = calculator(l,r);
            if(isFirstBad(mid) == true) return mid;
            else if(isBadVersion(mid+1) == false){  // mid+1 是 good
                l = mid+1;
            }else if(isBadVersion(mid-1) == true){  // mid-1 是 bad
                r = mid-1;
            }else if(isFirstBad(mid+1) == true){    // mid+1 是 bad，赢了
                return mid+1;
            }
        }
        return l;
    }

    public static int calculator(int fir, int sec){
        BigInteger firBig = new BigInteger(String.valueOf(fir));
        BigInteger secBig = new BigInteger(String.valueOf(sec));
        BigInteger sum = firBig.add(secBig);
        BigInteger ans = sum.divide(new BigInteger(String.valueOf("2")));
        return ans.intValue();
    }

    public boolean isFirstBad(int n){
        if(isBadVersion(n) == true){
            if(n > 1){
                if(isBadVersion(n-1) == false) return true;
                else if(isBadVersion(n-1) == true) return false;
            }else if(n == 1){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }

    public boolean isBadVersion(int n){
        return true;    // 这个function 没用，就是一个mock
    }
}