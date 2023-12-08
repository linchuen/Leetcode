package Medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 */
public class No24SwapNodesInPairs {
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

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode result = new ListNode();
        result.next = head;

        ListNode node = result;
        while (!isNotPairNode(node)) {
            node = swapPairNode(node);
        }
        return result.next;
    }

    private static boolean isNotPairNode(ListNode current) {
        ListNode next = current.next;
        if (next == null) return true;
        return next.next == null;
    }

    private static ListNode swapPairNode(ListNode current) {
        ListNode first = current.next;
        ListNode second = first.next;
        current.next = second;
        first.next = second.next;
        second.next = first;
        return first;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
