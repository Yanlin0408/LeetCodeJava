class addTwoNumbersFastest {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            int x = (l1 != null)?l1.val:0;
            int y = (l2 != null)?l2.val:0;
            int sum = x + y + carry;
            carry = sum / 10;
            int addOn = sum % 10;
            ans.next = new ListNode(addOn);
            ans = ans.next;

            if (l1 != null){
                System.out.println("l1: "+l1.val);
                l1 = l1.next;
            }
            if (l2 != null){
                System.out.println(l2.val);
                l2 = l2.next;
            }
        }
        return head.next;
    }
}