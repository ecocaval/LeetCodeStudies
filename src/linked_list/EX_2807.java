package linked_list;

public class EX_2807 {

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

    public static int findGreatestCommonDivisor(int n1, int n2) {

        int ans = 1;
        int divisor = 0;

        divisor = (n1 >= n2) ? n2 : n1;
        while (divisor > 0) {
            if (n1 % divisor == 0 && n2 % divisor == 0) {
                ans = divisor;
                break;
            }
            divisor--;
        }

        return ans;
    }

    class Solution {

        public ListNode insertGreatestCommonDivisors(ListNode head) {

            ListNode referenceNode;
            ListNode ans = referenceNode = head;

            while (referenceNode.next != null) {

                ListNode currentNode = referenceNode;
                ListNode nextNode = currentNode.next;

                ListNode newNode = new ListNode(
                        findGreatestCommonDivisor(currentNode.val, nextNode.val), nextNode);

                currentNode.next = newNode;

                referenceNode = nextNode;
            }

            return ans;
        }

        public int findGreatestCommonDivisor(int n1, int n2) {
            while (n2 != 0) {
                int temp = n2;
                n2 = n1 % n2;
                n1 = temp;
            }
            return n1;
        }
    }
}
