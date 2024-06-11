class MyHashSet {

    private int[] set = new int[0];

    public void add(int key) {

        int setLength = set.length;

        if (setLength == 0) {
            var newSet = new int[1];
            newSet[0] = key;
            this.set = newSet;
            return;
        }

        int[] newSet = new int[setLength + 1];

        for (int i = 0; i < setLength; i++) {
            newSet[i] = set[i];
            if (set[i] == key) { // Do nothing if the num is repeated
                return;
            }
        }

        newSet[setLength] = key;

        this.set = newSet;
    }

    public void remove(int key) {

        int setLength = set.length;

        if (setLength == 0) {
            return;
        }

        if (setLength == 1) {
            if (set[0] != key) {
                return;
            }
            this.set = new int[0];
            return;
        }

        int[] newSet = new int[setLength - 1];

        boolean itemWasRemoved = false;

        for (int i = 0; i < setLength; i++) {

            if (i == setLength - 1 && !itemWasRemoved) {
                if (set[setLength - 1] != key) {
                    return;
                }
                break;
            }

            if (set[i] == key) {
                itemWasRemoved = true;
                continue;
            }

            newSet[!itemWasRemoved ? i : (i - 1)] = set[i];
        }

        this.set = newSet;
    }

    public boolean contains(int key) {

        int setLength = set.length;

        if (setLength == 0) {
            return false;
        }

        if (setLength == 1) {
            return set[0] == key;
        }

        for (int i = 0; i < setLength; i++) {
            if (set[i] == key) {
                return true;
            }
        }

        return false;
    }
}