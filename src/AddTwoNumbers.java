/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class AddTwoNumbers {

    static int theLength = 1;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // ！！！ 这个其实没必要，因为一千五百个 case，只有一种是这个情况
        // 所以，你如果每一个都这个 check 一次，就会有 1500 次浪费时间，节约一次时间。
        // 相反，我如果不 check，每次都直接算，省的时间会少很多。两个 listnode 都为 0 的情况我也能 handle

        // if(findLength(l1) == 1 && findLength(l2) == 1 && l1.val == 0 & l2.val == 0){
        //     System.out.println("-+-_+_+_+_+");
        //     ListNode zeroList = new ListNode(0);
        //     return zeroList;
        // }

        // System.out.println(l2.val);
        Stack<Integer> AnsStack = new Stack<Integer>();
        int l1Length = this.findLength(l1);
        BigInteger firstNum = getNumFromReverse(l1);
        theLength = 1;

        int l2Length = this.findLength(l2);
        BigInteger secNum = getNumFromReverse(l2);

        BigInteger sum = firstNum.add(secNum);

        System.out.println(sum);
        System.out.println("length of sum is " + sum.toString().length());
        // System.out.println("length of sum is " + digitLength(sum));

        // if(sum == 0){
        //     System.out.println("-+-_+_+_+_+");
        //     ListNode zeroList = new ListNode(0);
        //     return zeroList;
        // }

        // 把 sum 放入 stack 中
        BigInteger toBeMinused = sum;
        BigInteger singleDigit = new BigInteger("0");
        BigInteger divider = new BigInteger("1");

        for(int i=sum.toString().length()-1; i>=0; i--){

            if(i>=10){
                divider = new BigInteger("1");
                int shang = i/9;
                int yu = i%9;
                for(int k=1;k<=shang;k++){
                    System.out.println("第几次 "+k);
                    divider = divider.multiply(new BigInteger(String.valueOf((int) Math.pow(10,9))));
                }
                // System.out.println("第一段"+divider);
                System.out.println("yu 是 "+ yu);
                divider = divider.multiply(new BigInteger(String.valueOf((int) Math.pow(10,yu))));
                // System.out.println("第二段"+divider);
            }else{
                divider = new BigInteger(String.valueOf((int) Math.pow(10,i)));
            }

            System.out.println("i是 "+i);
            System.out.println("divider is "+divider);

            singleDigit = toBeMinused.divide(divider);
            System.out.println("singledigit is "+singleDigit);
            toBeMinused = toBeMinused.subtract(divider.multiply(singleDigit));
            AnsStack.add(singleDigit.intValue());
        }

        System.out.println(AnsStack.toString());

        // 把 stack 里的 digits 拿出来存入 ArrayList （好像可以不需要）
        List<Integer> exp = new ArrayList<Integer>();
        while(AnsStack.empty() == false){
            exp.add(AnsStack.pop());
        }
        System.out.println(exp.toString());


        // 把东西从 ArrayList 转移到 Singly List 中
        ListNode outputNode = new ListNode();
        ListNode current = outputNode;

        for(int i = 0;i<exp.size();i++){
            // System.out.println(exp.get(i));

            current.next = new ListNode(exp.get(i));
            current = current.next;
        }

        return outputNode.next;
        // return l1;
    }

    public BigInteger getNumFromReverse(ListNode theNode){
        int digit = 1;
        BigInteger result = new BigInteger("0");
        ListNode currentNode = theNode;

        while(currentNode != null){
            System.out.println(currentNode.val);
            BigInteger aa = new BigInteger(String.valueOf(currentNode.val));
            BigInteger bb = new BigInteger("1");

            System.out.println("digit 是 "+digit);
            if(digit>=10){
                System.out.println("--da");
                int shang = digit/9;
                int yu = digit%9;
                System.out.println(shang+"----"+yu);
                for(int k=1;k<=shang;k++){
                    bb = bb.multiply(new BigInteger(String.valueOf((int) Math.pow(10,9))));
                }
                if(yu == 0){
                    bb = bb.divide(new BigInteger("10"));
                    result = result.add(aa.multiply(bb));
                    System.out.println("result is "+result);
                    currentNode = currentNode.next;
                    digit++;
                    continue;
                }else{
                    bb = bb.multiply(new BigInteger(String.valueOf((int) Math.pow(10,yu-1))));
                }

            }else{
                System.out.println("--xiao");
                bb = new BigInteger(String.valueOf((int) Math.pow(10,digit-1)));
            }

            result = result.add(aa.multiply(bb));

            System.out.println("result is "+result);
            currentNode = currentNode.next;
            digit++;
        }

        System.out.println("zuihou "+result);

        return result;
    }

    public int findLength(ListNode listNode){

        if(listNode.next == null){
            return theLength;
        }else{
            theLength++;
            findLength(listNode.next);
        }

        return theLength;
    }

    // public int digitLength(BigInteger theNum){
    //     int count = 0;
    //     while(theNum != 0){
    //         theNum /= 10;
    //         count++;
    //     }
    //     return count;
    // }
}
