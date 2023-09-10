package Sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode148SortList {
//    public ListNode sortList(ListNode head) {
//        if(head == null || head.next == null)
//            return head;
//
//        ListNode temp=null;
//        ListNode slow=head;
//        ListNode fast=head;
//
//        while(fast!=null && fast.next!=null){
//            temp=slow;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        temp.next=null;
//
//        ListNode left = sortList(head);
//        ListNode right = sortList(slow);
//        return merge(left,right);
//    }
//    public ListNode merge(ListNode p1,ListNode p2)
//    {
//        ListNode l = new ListNode(0);
//        ListNode curr = l;
//
//        while(p1!=null && p2!=null){
//            if(p1.val>p2.val)
//            {
//                curr.next=p2;
//                p2=p2.next;
//            }
//            else
//            {
//                curr.next=p1;
//                p1=p1.next;
//            }
//            curr=curr.next;
//
//        }
//
//        if(p1!=null)
//        {
//            curr.next=p1;
//        }
//        if(p2!=null)
//        {
//            curr.next=p2;
//        }
//        return l.next;
//    }


    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        List<ListNode> headList = splitList(head);
        return mergeList(headList);
    }

    public ListNode sortListV2(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);

        ListNode newNode = head;
        int i = 0;
        while (newNode != null) {
            newNode.val = list.get(i);
            i++;
            newNode = newNode.next;
        }
        return head;
    }

    private static List<ListNode> splitList(ListNode head) {
        List<ListNode> headList = new LinkedList<>();
        headList.add(head);
        ListNode current = head;
        while (current.next != null) {
            ListNode nextNode = current.next;

            if (current.val > nextNode.val) {
                headList.add(nextNode);
                current.next = null;
            }
            current = nextNode;
        }
        return headList;
    }

    private static ListNode mergeList(List<ListNode> headList) {
        ListNode result = null;

        for (ListNode head : headList) {
            if (result == null) {
                result = head;
            } else {
                ListNode node1 = result;
                ListNode node2 = head;
                result = node1.val < node2.val ? node1 : node2;

                ListNode temp = null;
                while (node1 != null && node2 != null) {
                    if (node1.val < node2.val) {
                        ListNode nextNode = node1.next;
                        node1.next = null;

                        if (temp == null) {
                            temp = node1;
                        } else {
                            temp.next = node1;
                            temp = temp.next;
                        }

                        node1 = nextNode;
                    } else {
                        ListNode nextNode = node2.next;
                        node2.next = null;

                        if (temp == null) {
                            temp = node2;
                        } else {
                            temp.next = node2;
                            temp = temp.next;
                        }

                        node2 = nextNode;
                    }
                }

                if (node1 != null) {
                    temp.next = node1;
                }

                if (node2 != null) {
                    temp.next = node2;
                }
            }
        }
        return result;
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
        List<ListNode> listNodes = IntStream.range(0, 10)
                .mapToObj(i -> new ListNode(new Random().nextInt(10)))
                .collect(Collectors.toList());

        for (int i = 0; i < listNodes.size() - 2; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        ListNode head = listNodes.get(0);
        printLinkedList(head);
        List<ListNode> headList = splitList(head);
        headList.forEach(Leetcode148SortList::printLinkedList);

        ListNode result = mergeList(headList);
        printLinkedList(result);
    }

    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
