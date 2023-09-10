package LinkedList;

import Sort.Leetcode148SortList;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode temp = null;
        ListNode node = head;

        while (node != null) {
            ListNode nextNode = node.next;
            node.next = temp;
            temp = node;

            node = nextNode;
        }
        return temp;
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


}
