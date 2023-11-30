package Category.Hashmap;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;

public class Leetcode146LRUCache {
    private static class LRUCache {
        private final int capacity;
        private final HashMap<Integer, Pair<Integer, Integer>> hashMap = new HashMap<>();
        private final LinkedList<Pair<Integer, Integer>> linkedList = new LinkedList<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Pair<Integer, Integer> pair = hashMap.get(key);
            if (pair == null) return -1;
            linkedList.remove(pair);
            linkedList.addFirst(pair);
            return pair.getValue();
        }

        public void put(int key, int value) {
            if (capacity == linkedList.size()) {
                Pair<Integer, Integer> pair = linkedList.removeLast();
                hashMap.remove(pair.getKey());
            }

            Pair<Integer, Integer> pair = new Pair<>(key, value);
            linkedList.addFirst(pair);
            hashMap.put(key, pair);
        }

        public void print() {
            System.out.println("linkedList = " + linkedList);
            System.out.println("hashMap = " + hashMap);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 1);
        lruCache.put(3, 1);
        lruCache.put(4, 1);
        lruCache.print();
    }
}
