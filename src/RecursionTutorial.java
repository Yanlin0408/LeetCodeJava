public class RecursionTutorial {
    public static void main(String[] args){
        int ddd = sayHi(5);
        System.out.println("==="+ddd);
    }

    private static int sayHi(int count){
        System.out.println("hi");

        if(count <= 1){
            return count;
        }
        int caobi = sayHi(count-1);

        System.out.println(caobi);
        System.out.println(count);
//        caobi++;
        return caobi;
    }

}
