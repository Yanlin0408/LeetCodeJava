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
import java.util.Stack;

class addTwoNumberCleanOne {

    public ListNode addTwoNumbersCleanOne(ListNode l1, ListNode l2) {
        Stack<Integer> AnsStack = new Stack<Integer>();
        BigInteger firstNum = getNumFromReverse(l1);

        BigInteger secNum = getNumFromReverse(l2);

        BigInteger sum = firstNum.add(secNum);

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
                    divider = divider.multiply(new BigInteger(String.valueOf((int) Math.pow(10,9))));
                }
                divider = divider.multiply(new BigInteger(String.valueOf((int) Math.pow(10,yu))));
            }else{
                divider = new BigInteger(String.valueOf((int) Math.pow(10,i)));
            }

            singleDigit = toBeMinused.divide(divider);
            toBeMinused = toBeMinused.subtract(divider.multiply(singleDigit));
            AnsStack.add(singleDigit.intValue());
        }


        // 把东西从 AnsStack 转移到 Singly List 中
        ListNode outputNode = new ListNode();
        ListNode current = outputNode;

        while(AnsStack.empty() == false){
            current.next = new ListNode(AnsStack.pop());
            current = current.next;
        }

        return outputNode.next;
    }

    public BigInteger getNumFromReverse(ListNode theNode){
        int digit = 1;
        BigInteger result = new BigInteger("0");
        ListNode currentNode = theNode;

        while(currentNode != null){
            BigInteger aa = new BigInteger(String.valueOf(currentNode.val));
            BigInteger bb = new BigInteger("1");

            if(digit>=10){
                int shang = digit/9;
                int yu = digit%9;
                for(int k=1;k<=shang;k++){
                    bb = bb.multiply(new BigInteger(String.valueOf((int) Math.pow(10,9))));
                }
                if(yu == 0){
                    bb = bb.divide(new BigInteger("10"));
                    result = result.add(aa.multiply(bb));
                    currentNode = currentNode.next;
                    digit++;
                    continue;
                }else{
                    bb = bb.multiply(new BigInteger(String.valueOf((int) Math.pow(10,yu-1))));
                }

            }else{
                bb = new BigInteger(String.valueOf((int) Math.pow(10,digit-1)));
            }

            result = result.add(aa.multiply(bb));
            currentNode = currentNode.next;
            digit++;
        }

        return result;
    }
}
