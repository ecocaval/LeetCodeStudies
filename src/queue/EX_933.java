package queue;

public class EX_933 {

    class RecentCounter {

        int[] pings = new int[10000];
        int pingsCounter = 0;
        int lastLowestValue = 0;
        int lastLowestValueIndex = 0;
        int lastNumberOfPingsInRange = 1;

        public RecentCounter() {}

        public int ping(int t) {

            pings[pingsCounter] = t;
            pingsCounter++;

            if (pingsCounter == 1) {
                lastLowestValue = t;
                return lastNumberOfPingsInRange;
            }

            if (lastLowestValue >= t - 3000) {
                lastNumberOfPingsInRange++;
                return lastNumberOfPingsInRange;
            }

            for (int i = lastLowestValueIndex + 1; i < pingsCounter; i++) {
                if (pings[i] >= t - 3000) {
                    lastNumberOfPingsInRange = pingsCounter - i;
                    lastLowestValue = pings[i];
                    lastLowestValueIndex = i;
                    return lastNumberOfPingsInRange;
                }
            }

            return 1;
        }
    }
}
