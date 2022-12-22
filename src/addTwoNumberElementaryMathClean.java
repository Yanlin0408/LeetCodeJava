class addTwoNumberElementaryMathClean {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode currentSum = sum;
        int carry = 0;

        while(l1 != null || l2 != null){
            int newSum = l1.val + l2.val;
            if(carry == 1)
                newSum++;

            carry = newSum/10;
            currentSum.val = newSum % 10;

            if(l1.next != null && l2.next == null){
                l2.next = new ListNode();
            }else if(l2.next != null && l1.next == null){
                l1.next = new ListNode();
            }else if(l2.next == null && l1.next == null){
                if(carry == 1){
                    currentSum.next = new ListNode();
                    currentSum = currentSum.next;
                    currentSum.val = 1;
                    break;
                }
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
            currentSum.next = new ListNode();
            currentSum = currentSum.next;
        }
        return sum;
    }
}