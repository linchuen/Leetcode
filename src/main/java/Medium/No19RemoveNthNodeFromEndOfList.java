package Medium;

public class No19RemoveNthNodeFromEndOfList {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode();
        result.next = head;

        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        ListNode nthFromEnd = result;
        while (end != null) {
            end = end.next;
            nthFromEnd = nthFromEnd.next;
        }
        nthFromEnd.next = nthFromEnd.next.next;

        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
