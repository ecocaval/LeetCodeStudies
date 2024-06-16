package array;

class MyHashMap {

    // private static void printHashMap(MyHashMap hashMap) {
    // for (int i = 0; i < 20; i++) {
    // System.out.println(i + ": " + hashMap.map[i]);
    // }
    // System.out.println();
    // System.out.println();
    // }

    public static void main(String[] args) throws Exception {

        var hashMap = new MyHashMap();

        hashMap.remove(2);
        // printHashMap(hashMap);
        hashMap.put(3, 1);
        // printHashMap(hashMap);
        hashMap.put(4, 13);
        // printHashMap(hashMap);
        hashMap.put(15, 6);
        // printHashMap(hashMap);
        hashMap.put(6, 15);
        // printHashMap(hashMap);
        hashMap.put(8, 8);
        // printHashMap(hashMap);
        hashMap.put(11, 0);
        // printHashMap(hashMap);
        hashMap.put(1, 10);
        // printHashMap(hashMap);
        hashMap.put(12, 14);
        // printHashMap(hashMap);

    }

    int[] map = new int[1000001];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        map[key] = ((value != 0) ? value : -1);
    }

    public int get(int key) {

        if (map[key] == -1) {
            return 0;
        }

        return map[key] != 0 ? map[key] : -1;
    }

    public void remove(int key) {
        map[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */