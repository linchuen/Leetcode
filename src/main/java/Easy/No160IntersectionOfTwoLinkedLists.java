package Easy;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 */
public class No160IntersectionOfTwoLinkedLists {
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode copyHeadA = headA;
        ListNode copyHeadB = headB;

        while (headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }

        boolean isSameSize = headA == null && headB == null;
        if (isSameSize) {
            return getIntersectionNodeOnSameSize(copyHeadA, copyHeadB);
        }

        if (headA != null) {
            ListNode newANode = makeSlowNodeSameSize(headA, copyHeadA);
            return getIntersectionNodeOnSameSize(newANode, copyHeadB);
        } else {
            ListNode newBNode = makeSlowNodeSameSize(headB, copyHeadB);
            return getIntersectionNodeOnSameSize(newBNode, copyHeadA);
        }
    }

    private static ListNode getIntersectionNodeOnSameSize(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static ListNode makeSlowNodeSameSize(ListNode slowNode, ListNode slowNodeHead) {
        while (slowNode != null) {
            slowNode = slowNode.next;
            slowNodeHead = slowNodeHead.next;
        }
        return slowNodeHead;
    }

    public static void main(String[] args) {
        ListNode commonNode = new ListNode(2, new ListNode(4));
        ListNode node1 = new ListNode(5, new ListNode(9, new ListNode(1, commonNode)));
        ListNode node2 = new ListNode(3, commonNode);

        ListNode result = getIntersectionNode(node1, node2);
        System.out.println(result == commonNode);

        ListNode commonNode2 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode node3 = new ListNode(4, new ListNode(1, commonNode2));
        ListNode node4 = new ListNode(5, new ListNode(6, new ListNode(1, commonNode2)));

        ListNode result2 = getIntersectionNode(node3, node4);
        System.out.println(result2 == commonNode2);
    }
}
