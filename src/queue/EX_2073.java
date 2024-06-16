package queue;

public class EX_2073 {

    public static void main(String[] args) {
        int[] tickets = new int[] { 84, 49, 5, 24, 70, 77, 87, 8 };
        int k = 3;

        System.out.println(timeRequiredToBuySlow(tickets, k));

        tickets = new int[] { 84, 49, 5, 24, 70, 77, 87, 8 };
        k = 3;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    // 0th -> firt in line
    // (n-1)th -> last in line

    // 0th person will buy ticket[0]
    // (n-1)th person will buy ticket[n-1]

    // n == tickets.length
    // 1 <= n <= 100
    // 1 <= tickets[i] <= 100
    // 0 <= k < n

    public static int timeRequiredToBuySlow(int[] tickets, int k) {

        int numberOfSecondsPassed = 0;
        int n = tickets.length;
        boolean breakPointWasReached = false;

        while (true) {

            for (int i = 0; i < n; i++) {

                if (tickets[i] > 0) {
                    tickets[i] -= 1;
                    numberOfSecondsPassed++;
                }

                if (tickets[i] == 0 && i == k) {
                    breakPointWasReached = true;
                    break;
                }
            }

            if (breakPointWasReached) {
                break;
            }
        }

        return numberOfSecondsPassed;
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {

        int numberOfSecondsPassed = 0;
        int n = tickets.length;
        int kTicket = tickets[k];

        for (int i = 0; i < n; i++) {
            if (kTicket > tickets[i]) {
                numberOfSecondsPassed += tickets[i];
            } else {
                numberOfSecondsPassed += (i > k) ? kTicket - 1 : kTicket;
            }
        }
        return numberOfSecondsPassed;
    }
}
