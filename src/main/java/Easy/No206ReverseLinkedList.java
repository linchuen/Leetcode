package Easy;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class No206ReverseLinkedList {
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

    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;

        while (head != null) {
            ListNode temp = head;
            head = head.next;

            temp.next = reverseHead;
            reverseHead = temp;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reverseHead = reverseList(head);
        while (reverseHead != null) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }
}
