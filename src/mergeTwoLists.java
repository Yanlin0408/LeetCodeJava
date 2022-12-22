import java.util.ArrayList;
import java.util.Collections;

class mergeTwoLists {
    public ListNode mergeTwoListsFast(ListNode list1, ListNode list2) {
        ListNode thePreHead = new ListNode(-1);
        ListNode preHead = thePreHead;

        while(list1 != null || list2 != null){
            if(list1 == null){
                preHead.next = list2;
                list2 = list2.next;
                preHead = preHead.next;
                continue;
            }else if(list2 == null){
                preHead.next = list1;
                list1 = list1.next;
                preHead = preHead.next;
                continue;
            }

            if(list1.val > list2.val){
                preHead.next = list2;
                list2 = list2.next;
            }else{
                preHead.next = list1;
                list1 = list1.next;
            }
            preHead = preHead.next;
        }

        return thePreHead.next;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return list1;

        ListNode fir = list1;
        ListNode sec = list2;
        ListNode theSortedList = new ListNode();
        ListNode fucker = theSortedList;
        ArrayList caobi = new ArrayList();

        while(fir != null){
            caobi.add(fir.val);
            fir = fir.next;
        }

        while(sec != null){
            caobi.add(sec.val);
            sec = sec.next;
        }

        Collections.sort(caobi);
        System.out.println(caobi.toString());

        int counter = 0;
        while(counter < caobi.size()){  // 用 “<=” 或者 “!=” 防止不了当 size() 为 0 的时候
            theSortedList.val = (int) caobi.get(counter);
            if(counter != (caobi.size() - 1)){
                theSortedList.next = new ListNode();
                theSortedList = theSortedList.next;
            }
            counter++;
        }
        return fucker;
    }
}
