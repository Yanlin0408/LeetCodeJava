import java.util.HashSet;
import java.util.Set;

public class hasCycle {
    public boolean hasCycle(ListNode head){
        Set<ListNode> memorySeen = new HashSet<ListNode>();
        while(head != null){
            if(memorySeen.contains(head)){
                return true;
            }else{
                memorySeen.add(head);
                head = head.next;
            }
        }

        return false;
    }

    public boolean hasCycle2(ListNode head){
        if(head == null)
            return false;

        ListNode fast = head.next;
        ListNode slow = head;
        int count = 0;
        while(fast != null && fast.next != null){
            System.out.println("----"+count);
            if(fast == slow)    // 对比的就还是指针的位置
                return true;
            else{
                System.out.println(slow.val);
                System.out.println(fast.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            count++;

        }

        return false;
    }
}
