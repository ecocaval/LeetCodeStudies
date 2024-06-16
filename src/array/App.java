package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        var points = new int[][] {
                { 1, 3 }, { 3, 3 }, { 5, 3 }, { 2, 2 }
        };

        var queries = new int[][] {
                { 2, 3, 1 }, { 4, 3, 1 }, { 1, 1, 2 }
        };

        countPoints(points, queries);
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

    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            final int currentNum = nums[i];

            if (ans.isEmpty()) {
                List<Integer> listToAdd = new ArrayList<>();
                listToAdd.add(currentNum);
                ans.add(listToAdd);
                continue;
            }

            boolean numWasAdded = false;

            for (List<Integer> list : ans) {
                if (!list.contains(currentNum)) {
                    list.add(currentNum);
                    numWasAdded = true;
                    break;
                }
            }

            if (numWasAdded)
                continue;

            List<Integer> listToAdd = new ArrayList<>();
            listToAdd.add(currentNum);
            ans.add(listToAdd);
        }

        return ans;
    }

    public int minOperations(int[] nums, int k) {

        int bitwiseOperationResult = nums[0];

        for (int i = 1; i < nums.length; i++) {
            bitwiseOperationResult ^= nums[i];
        }

        if (bitwiseOperationResult == k) {
            return 0;
        }

        boolean triedFirtFlippingOption = false;
        boolean triedBothFlippingOptions = false;

        int numberOfOperationsNedded = 0;

        while (!triedBothFlippingOptions) {

            if (triedBothFlippingOptions) {
                int bitLength = Integer.toBinaryString(nums[0]).length();
                int msbMask = 1 << (bitLength - 1);
                bitwiseOperationResult = nums[0] ^ msbMask; // flip the bit from the left
            } else {
                bitwiseOperationResult = nums[0] ^ 1; // flip the bit from the right
            }

            numberOfOperationsNedded++;

            for (int i = 1; i < nums.length; i++) {
                bitwiseOperationResult ^= nums[i];
            }

            if (bitwiseOperationResult == k) {
                return numberOfOperationsNedded;
            }

            if (!triedFirtFlippingOption) {
                triedBothFlippingOptions = true;
                continue;
            }

            triedBothFlippingOptions = true;
        }

        return numberOfOperationsNedded;
    }

    public static int[] countPoints(int[][] points, int[][] queries) {

        int queriesLength = queries.length;

        int[] ans = new int[queriesLength];

        for (int i = 0; i < queriesLength; i++) {

            int[] query = queries[i];

            int circleX = query[0];
            int circleY = query[1];
            int circleR = query[2];

            int numberOfPointsInsideCircle = 0;

            for (int j = 0; j < points.length; j++) {

                int[] point = points[j];

                int pointX = point[0];
                int pointY = point[1];

                boolean radiusConfirm = (((pointX - circleX) * (pointX - circleX))
                        + ((pointY - circleY) * (pointY - circleY))) <= (circleR * circleR);

                if (radiusConfirm) {
                    numberOfPointsInsideCircle++;
                }
            }
            ans[i] = numberOfPointsInsideCircle;
        }
        return ans;
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

    public ListNode middleNode(ListNode head) {

        boolean endWasReached = false;

        List<ListNode> nodeHashMap = new ArrayList<>();
        ListNode currentNode = head;

        while (!endWasReached) {
            nodeHashMap.add(currentNode);
            currentNode = currentNode.next;
            if (currentNode == null) {
                endWasReached = true;
            }
        }

        return nodeHashMap.get((int) Math.ceil(nodeHashMap.size() / 2));
    }

    public int getDecimalValue(ListNode head) {

        int ans = 0;
        List<Integer> nums = new ArrayList<>();
        ListNode node = head;
        boolean endWasReached = false;

        while (!endWasReached) {
            nums.add(node.val);
            node = node.next;
            if (node == null) {
                endWasReached = true;
            }
        }

        int listCounter = nums.size() - 1;

        while (listCounter >= 0) {
            ans += nums.get(listCounter) * Math.pow(2, (nums.size() - 1 - listCounter));
            listCounter--;
        }

        return ans;
    }

    public ListNode reverseList(ListNode head) {

        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode != null) {
            ListNode currentNodeCopy = new ListNode(currentNode.val, currentNode.next);
            currentNode = currentNode.next;
            currentNodeCopy.next = previousNode;
            previousNode = currentNodeCopy;
        }

        return previousNode;
    }

}
