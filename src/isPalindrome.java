class isPalindrome {
    public boolean isPalindrome2(String s) {
        char[] ss = s.toCharArray();
        // System.out.println(Character.isLetterOrDigit(ss[2]));
        for(int i=0, j=ss.length-1; i<j ;i++, j--){
            while(i<j && Character.isLetterOrDigit(ss[i]) == false){
                i++;
            }

            while(i<j && Character.isLetterOrDigit(ss[j]) == false){
                j--;
            }
            // 对比
            if(Character.toLowerCase(ss[i]) == Character.toLowerCase(ss[j])){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        s = removeNonAlphaNumeric(s); // remove all non-alpha numeric stuff. then reverse it using string builder
        // StringBuilder forward = new StringBuilder();
        StringBuilder backward = new StringBuilder();
        // String lowForward = forward.append(s).toString().toLowerCase();
        String lowForward = s.toLowerCase();
        String lowBackward = backward.append(s).reverse().toString().toLowerCase();
        return lowForward.equals(lowBackward);
    }

    public String removeNonAlphaNumeric(String a){
        a = a.replaceAll("[^a-zA-Z0-9]","");
        return a;
    }
}