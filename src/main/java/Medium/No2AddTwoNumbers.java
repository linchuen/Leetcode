package Medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class No2AddTwoNumbers {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode result = newHead;

        boolean isCarry = false;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            l1 = l1.next;

            int val2 = l2.val;
            l2 = l2.next;

            int total = isCarry ? val1 + val2 + 1 : val1 + val2;
            isCarry = total > 9;
            newHead.next = new ListNode(isCarry ? total % 10 : total);
            newHead = newHead.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                int val1 = l1.val;
                l1 = l1.next;

                int total = isCarry ? val1 + 1 : val1;
                isCarry = total > 9;
                newHead.next = new ListNode(isCarry ? total % 10 : total);
                newHead = newHead.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                int val2 = l2.val;
                l2 = l2.next;

                int total = isCarry ? val2 + 1 : val2;
                isCarry = total > 9;
                newHead.next = new ListNode(isCarry ? total % 10 : total);
                newHead = newHead.next;
            }
        }

        if (isCarry) {
            newHead.next = new ListNode(1);
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9,new ListNode(9))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7)));

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
