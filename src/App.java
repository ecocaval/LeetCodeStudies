import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        int[] nums = new int[] { 1, 2, 3, 1, 1, 3 };

        System.out.println(numIdenticalPairs(nums));
    }

    public static int[] getConcatenation(int[] nums) {

        final int numsLength = nums.length;

        int[] ans = new int[numsLength * 2];

        for (int i = 0; i < numsLength; i++) {
            ans[i] = ans[i + numsLength] = nums[i];
        }

        return ans;
    }

    public static int[] buildArray(int[] nums) {

        // ans[i] = nums[nums[i]]

        final int numsLength = nums.length;

        int[] ans = new int[numsLength];

        for (int i = 0; i < numsLength; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static int numIdenticalPairs(int[] nums) {

        // Given an array of integers nums, return the number of good pairs.
        // A pair (i, j) is called good if nums[i] == nums[j] and i < j.

        Map<Integer, Integer> seenValues = new HashMap<>();
        final int numsLength = nums.length;
        int numberOfGoodPairs = 0;

        for (int i = 0; i < numsLength; i++) {
            int currentValue = nums[i];
            if (seenValues.containsKey(currentValue)) {
                int numberOfOccurencies = seenValues.get(currentValue);
                seenValues.put(currentValue, numberOfOccurencies + 1);
                numberOfGoodPairs += numberOfOccurencies;
            } else {
                seenValues.put(currentValue, 1);
            }
        }

        return numberOfGoodPairs;
    }
}
