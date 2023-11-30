package Category.LinkedList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode876MiddleoftheLinkedList {

    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

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

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + "" + next + '}';
        }
    }

    public static void main(String[] args) {
        List<ListNode> listNodes = IntStream.range(0, 11)
                .mapToObj(i -> new ListNode(new Random().nextInt(10)))
                .collect(Collectors.toList());

        for (int i = 0; i < listNodes.size() - 2; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        ListNode head = listNodes.get(0);
        printLinkedList(head);

        ListNode middleNode = middleNode(head);
        System.out.println(middleNode.val);
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
