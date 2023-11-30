package Easy;

public class No21MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = list1;

        if (list1.val > list2.val) {
            ListNode temp = list2;
            temp.next = list1;
            list2 = list2.next;
        } else {

        }


    }
}
