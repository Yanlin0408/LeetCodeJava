public class middleNode {


    public ListNode middleNode2(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t/2];
    }
    public ListNode middleNode(ListNode head) {
        int counter = 0;
        ListNode fakeH = head;

        while(fakeH.next != null){
            counter++;
            fakeH = fakeH.next;
        }

        int midNum = (counter+1)/2;

        int secCounter = 0;
        while(secCounter < midNum){
            System.out.println(head.val);
            head = head.next;
            secCounter++;
        }

        System.out.println(midNum);
        return head;
    }
}
