package linked_list;

import java.util.ArrayList;
import java.util.List;

public class EX_2130 {

    public static void main(String[] args) throws Exception {
        pairSum(new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3)))));
    }

    public static int pairSum(ListNode head) {

        if (head.next.next == null) {
            return head.val + head.next.val;
        }

        int n = 0;

        ListNode currentNode = head;

        int[] nodeValues = new int[100000];

        while (currentNode != null) {
            nodeValues[n] = currentNode.val;
            currentNode = currentNode.next;
            n++;
        }

        int highestSum = 0;

        for (int i = 0; i < n / 2; i++) {

            if (i <= (n / 2) - 1) {

                int currentTwinsSum = nodeValues[i] + nodeValues[n - 1 - i];

                if (highestSum < currentTwinsSum) {
                    highestSum = currentTwinsSum;
                }
            }
        }

        return highestSum;
    }
}
