package Easy;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class No141LinkedListCycle {
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

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head.next;
        if (slow == null) return false;

        ListNode fast = head.next.next;
        if (fast == null) return false;

        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;

            slow = slow.next;
        }
        return fast != null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        assert hasCycle(node1);

        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        node5.next = node6;
        assert !hasCycle(node5);
    }
}
