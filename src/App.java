import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        int[] nums = new int[] { 5, 2, 0, 3, 1 };

        System.out.println();
        for (int num : findArray(nums)) {
            System.out.print(num);
        }
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (hashMap.get(groupSizes[i]) == null) {
                hashMap.put(groupSizes[i], new ArrayList<>());
            }
            hashMap.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {

            final int groupSize = entry.getKey();
            final List<Integer> elementsWithGroupSize = entry.getValue();

            boolean onlyOneGroupIsNeededForSize = groupSize >= elementsWithGroupSize.size();

            if (onlyOneGroupIsNeededForSize) {
                ans.add(elementsWithGroupSize);
                continue;
            }

            int elementsCounter = 0;
            int elementsAdded = 0;

            while (elementsCounter < elementsWithGroupSize.size()) {

                List<Integer> listToAdd = new ArrayList<>();

                while (elementsAdded < groupSize) {
                    listToAdd.add(elementsWithGroupSize.get(elementsCounter));
                    elementsCounter++;
                    elementsAdded++;
                }

                ans.add(listToAdd);
                elementsAdded = 0;
            }
        }
        return ans;
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

    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        final List<String> INCREMENTORS = List.of("++X", "X++");
        final List<String> DECREMENTORS = List.of("--X", "X--");

        for (String operation : operations) {
            if (INCREMENTORS.contains(operation)) {
                x++;
                continue;
            }
            if (DECREMENTORS.contains(operation)) {
                x--;
            }
        }

        return x;
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] ans = new int[2 * n];

        int ansCounter = 0;

        for (int i = 0; i < n; i++) {
            ans[ansCounter] = nums[i];
            ans[ansCounter + 1] = nums[i + n];
            ansCounter += 2;
        }

        return ans;
    }

    public static int[] findArray(int[] pref) {

        int n = pref.length;

        int[] arr = new int[n];

        arr[0] = pref[0];

        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }

    public static List<List<Integer>> groupThePeopleBad(int[] groupSizes) {

        // Map of Value & GroupSize
        List<List<Map<Integer, Integer>>> listOfGroups = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            final int groupSize = groupSizes[i];

            if (listOfGroups.isEmpty()) {
                List<Map<Integer, Integer>> newGroup = new ArrayList<>();
                Map<Integer, Integer> newMap = new HashMap<>();
                newMap.put(i, groupSize);
                newGroup.add(newMap);
                listOfGroups.add(newGroup);
                continue;
            }

            Optional<List<Map<Integer, Integer>>> optionalIncompleteList = listOfGroups.stream()
                    .filter(list -> list.get(0).containsValue(groupSize) && list.size() != groupSize)
                    .findFirst();

            var incompleteListAlreadyExists = optionalIncompleteList.isPresent();

            if (incompleteListAlreadyExists) {
                var incompleteList = optionalIncompleteList.get();
                Map<Integer, Integer> newMap = new HashMap<>();
                newMap.put(i, groupSize);
                incompleteList.add(newMap);
            } else {
                List<Map<Integer, Integer>> newGroup = new ArrayList<>();
                Map<Integer, Integer> newMap = new HashMap<>();
                newMap.put(i, groupSize);
                newGroup.add(newMap);
                listOfGroups.add(newGroup);
            }
        }

        return listOfGroups.stream()
                .map(mapList -> mapList.stream()
                        .map(map -> map.entrySet().iterator().next().getKey())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
