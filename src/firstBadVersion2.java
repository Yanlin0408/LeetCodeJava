public class firstBadVersion2 {
    public int firstBadVersion(int n) {
        int l=1;
        while(l<=n){
            int m = l + (n-l)/2;
            System.out.println(l+"   "+m+"   "+n);
            if(isBadVersion(m)){
                n=m-1;  // mid 是 bad，到 mid 左边
            }else{
                l=m+1;  // mid 是 good, 到 mid 右边
            }
        }
        return l;
    }

    public boolean isBadVersion(int n){
        return true;    // 这个function 没用，就是一个mock
    }
}
