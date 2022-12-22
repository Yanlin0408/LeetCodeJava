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

class Solution {
    public ListNode addTwoNumberElementaryMathOriginal(ListNode l1, ListNode l2) {
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode sum = new ListNode();
        ListNode currentSum = sum;
        int newSum = 0;
        int carry = 0;

        while(currentL1 != null || currentL2 != null){
            newSum = currentL1.val + currentL2.val;
            if(carry == 1){
                newSum++;
                carry = 0;
            }
            if(newSum >= 10){
                currentSum.val = newSum - 10;
                carry = 1;
            }else{
                currentSum.val = newSum;
            }
            // see if we need another ListNode for sum
            // 主意，如果这里 currentL1 的 next 本身就是 null 了，只能像下面这样。不能 currentL1.next.val，会报错
            if(currentL1.next != null && currentL2.next != null){
                currentSum.next = new ListNode();
                currentSum = currentSum.next;
                currentL1 = currentL1.next;
                currentL2 = currentL2.next;
            }else if(currentL1.next != null && currentL2.next == null){
                currentSum.next = new ListNode();
                currentSum = currentSum.next;
                currentL1 = currentL1.next;
                currentL2.next = new ListNode();
                currentL2 = currentL2.next;
            }else if(currentL2.next != null && currentL1.next == null){
                currentSum.next = new ListNode();
                currentSum = currentSum.next;
                currentL2 = currentL2.next;
                currentL1.next = new ListNode();
                currentL1 = currentL1.next;
            }else{
                // 都是 null，handle 一下
                if(carry == 1){
                    currentSum.next = new ListNode();
                    currentSum = currentSum.next;
                    currentSum.val = 1;
                }
                break;
            }
        }
        return sum;
    }

}