package linked_list;

import utils.Utils;

public class EX_2 {

    public static void main(String[] args) {

        System.out.println(13/10);
        System.out.println(13%10);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int totalSum = 0, sum = 0, carry = 0;

        ListNode ln = new ListNode();
        ListNode aux = ln;

        while(l1 != null || l2 != null) {

            if(l1 != null && l2 != null) {
                totalSum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                totalSum = l1.val + carry;
                l1 = l1.next;
            } else {
                totalSum = l2.val + carry;
                l2 = l2.next;
            }

            sum = totalSum % 10;
            carry = totalSum / 10;

            aux.val = sum;

            if(l1 == null && l2 == null && carry > 0) {
                aux.next = new ListNode(carry);
            } else if(l1 == null && l2 == null) {
                aux.next = null;
            } else {
                aux.next = new ListNode();
                aux = aux.next;
            }
        }

        return ln;
    }

    public static ListNode addTwoNumbersBAD(ListNode l1, ListNode l2) {

        final int MAX_NUMBER_OF_NODES = 100;

        int[] l1Values = new int[MAX_NUMBER_OF_NODES];
        int[] l2Values = new int[MAX_NUMBER_OF_NODES];
        int l1ValuesCounter = 1;
        int l2ValuesCounter = 1;
        ListNode currentNodel1 = l1;
        ListNode currentNodel2 = l2;

        while (currentNodel1 != null || currentNodel2 != null) {

            if (currentNodel1 != null) {
                l1Values[MAX_NUMBER_OF_NODES - l1ValuesCounter] = currentNodel1.val;
                currentNodel1 = currentNodel1.next;
                l1ValuesCounter++;
            }

            if (currentNodel2 != null) {
                l2Values[MAX_NUMBER_OF_NODES - l2ValuesCounter] = currentNodel2.val;
                currentNodel2 = currentNodel2.next;
                l2ValuesCounter++;
            }
        }

        System.out.println("l1Values");
        Utils.printArray(l1Values);
        System.out.println("l2Values");
        Utils.printArray(l2Values);

        int l1Value = 0;
        int l2Value = 0;
        l1ValuesCounter = 1;
        l2ValuesCounter = 1;

        int currentL1Value = l1Values[MAX_NUMBER_OF_NODES - l1ValuesCounter];
        int currentL2Value = l2Values[MAX_NUMBER_OF_NODES - l2ValuesCounter];

        while (currentL1Value != 0 || currentL2Value != 0) {

            l1Value += currentL1Value * (int) Math.pow(10, l1ValuesCounter - 1);
            l1ValuesCounter++;
            currentL1Value = l1Values[MAX_NUMBER_OF_NODES - l1ValuesCounter];

            l2Value += currentL2Value * (int) Math.pow(10, l2ValuesCounter - 1);
            System.out.println("l2Value: " + l2Value);
            l2ValuesCounter++;
            currentL2Value = l2Values[MAX_NUMBER_OF_NODES - l2ValuesCounter];
        }

        System.out.println("l1Value: " + l1Value);
        System.out.println("l2Value: " + l2Value);

        String stringfiedFinalSum = String.valueOf(l1Value + l2Value);

        System.out.println(stringfiedFinalSum);

        int stringCounter = stringfiedFinalSum.length();

        ListNode ans = new ListNode();

        ListNode currentNode = new ListNode();

        ans.val = Integer.parseInt(String.valueOf(stringfiedFinalSum.charAt(stringCounter - 1)));

        stringCounter--;

        if(stringCounter == 0) {
            return ans;
        }

        ans.next = currentNode;

        while (stringCounter > 0) {
            currentNode.val = Integer.parseInt(String.valueOf(stringfiedFinalSum.charAt(stringCounter - 1)));
            stringCounter--;
            if(stringCounter > 0) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }

        return ans;
    }
}
