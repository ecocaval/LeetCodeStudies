package linked_list;

public class EX_1669 {

    public static void main(String[] args) throws Exception {

    }

    public class ListNode {
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        int nodeCounter = 0;

        ListNode currentNode = list1;
        ListNode nodeBeforeA = null;
        ListNode nodeAfterB = null;

        while (true) {

            if (nodeCounter + 1 == a) {
                nodeBeforeA = currentNode;
            }

            if (nodeCounter == b) {
                nodeAfterB = currentNode.next;
                nodeBeforeA.next = list2;
                break;
            }

            currentNode = currentNode.next;
            nodeCounter++;
        }

        currentNode = list2;

        while (true) {
            if (currentNode.next == null) {
                currentNode.next = nodeAfterB;
                break;
            }
            currentNode = currentNode.next;
        }

        return list1;
    }

    public ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {

        ListNode currentNode = list1;
        ListNode nodeBeforeA = null;
        ListNode nodeAfterB = null;

        for (int i = 0; i < a - 1; i++) {
            currentNode = currentNode.next;
        }

        nodeBeforeA = currentNode;
        currentNode = currentNode.next;

        for (int i = a; i < b; i++) {
            currentNode = currentNode.next;
        }

        nodeAfterB = currentNode.next;

        nodeBeforeA.next = list2;
        currentNode = list2;

        while (true) {
            if (currentNode.next == null) {
                currentNode.next = nodeAfterB;
                break;
            }
            currentNode = currentNode.next;
        }

        return list1;
    }
}
