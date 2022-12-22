import java.util.Arrays;

class isAnagram {
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] counter = new int[150];

        for(int i=0; i<s.length()-1; i++){
            counter[(int) s.charAt(i)]++;
            System.out.println(Arrays.toString(counter));
            counter[(int) t.charAt(i)]--;
        }

        for(int j:counter){
            if(j != 0){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        char[] cha = s.toCharArray();
        Arrays.sort(cha);

        char[] chi = t.toCharArray();
        Arrays.sort(chi);

        return Arrays.equals(cha,chi);
    }
}
