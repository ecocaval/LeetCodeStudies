package linked_list;

public class EX_2181 {

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

    public ListNode mergeNodes(ListNode head) {

        int nodesAccumulator = 0;

        ListNode referenceNode;
        ListNode currentNode = referenceNode = head;

        while (true) {

            ListNode nextNode = currentNode.next;

            nodesAccumulator += currentNode.val;

            if (nextNode.val == 0) {

                if (nextNode.next == null) {
                    referenceNode.val = nodesAccumulator;
                    referenceNode.next = null;
                    break;
                }

                referenceNode.val = nodesAccumulator;
                referenceNode.next = nextNode;
                referenceNode = currentNode = nextNode;
                nodesAccumulator = 0;
                continue;
            }

            currentNode = nextNode;
        }

        return head;
    }
}
