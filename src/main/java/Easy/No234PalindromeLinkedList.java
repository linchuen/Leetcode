package Easy;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome or false otherwise.
 */
public class No234PalindromeLinkedList {
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

    public static boolean isPalindrome(ListNode head) {
        int size = countSize(head);
        boolean isOdd = size % 2 == 1;

        int count = 0;
        int half = size / 2;
        ListNode reverseHead = null;
        while (count < half) {
            ListNode temp = head;
            head = head.next;

            temp.next = reverseHead;
            reverseHead = temp;
            count++;
        }

        if (isOdd) {
            head = head.next;
        }
        return compareIsSame(reverseHead, head);
    }

    public static int countSize(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size += 1;
        }
        return size;
    }

    private static boolean compareIsSame(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA.val != headB.val) return false;
            headA = headA.next;
            headB = headB.next;
        }
        return true;
    }

    public static boolean isPalindromeV2(ListNode head) {
        ListNode mid = findMid(head);

        ListNode reverseHead = null;
        while (mid != null) {
            ListNode temp = mid;
            mid = mid.next;

            temp.next = reverseHead;
            reverseHead = temp;
        }

        return compareIsSame(reverseHead, head);
    }

    public static ListNode findMid(ListNode head) {
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) return head;
            fast = fast.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeV2(head));
    }
}
