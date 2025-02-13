class MyHashMap {
    private static final int SIZE = 1000;
    private Node[] map;

    static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
        } else {
            Node curr = map[index];
            while (curr.next != null && curr.key != key) curr = curr.next;
            if (curr.key == key) curr.value = value;
            else curr.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) map[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
}
