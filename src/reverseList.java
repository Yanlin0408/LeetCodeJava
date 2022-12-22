import java.util.ArrayList;

class reverseList {
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newH = reverseList3(head.next);
        System.out.println(head.next.val);
        head.next.next = head;      // null 的 next 等于他自己（5），5的下一个是4，等等等等
        head.next = null;
        return newH;

    }

    // 这个方法相当于 curr 一边往后退，一边指向前一个 （用 prev 来 refer）
    public ListNode reverseList2(ListNode head) {  // 直接 reverse list 的方向！
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode stashedNext = cur.next; // cur.next 在后面会被改，所以先 stash 好原本的下一个，之后再用
            cur.next = prev;   // 在之前就定义好curr 的下一个，
            prev = cur;   // 然后移动 prev，然后不管curr.next，然后周而复始。相当于就在循环开始设好curr.next
            cur = stashedNext;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ArrayList sequenceList = new ArrayList();
        ListNode fakeH = head;
        ListNode fakeHH = fakeH;

        while(head != null){
            sequenceList.add(head.val);
            head = head.next;
        }

        for(int i=sequenceList.size()-1;i>=0;i--){
            fakeH.val = (int) sequenceList.get(i);
            fakeH = fakeH.next;
        }

        return fakeHH;
    }
}
