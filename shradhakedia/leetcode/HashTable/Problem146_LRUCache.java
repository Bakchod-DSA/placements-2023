/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/lru-cache/
 * Difficulty level: Hard
 */

package leetcode.HashTable;

import java.util.*;

public class Problem146_LRUCache {

    // class LRUCache {

//     /*  Gives TLE because of insertion order going to linear
//         get is O(1), put is O(n) => TLE
//         Improvement required: Use Doubly Linked List along with hash table.
//     */

//     HashMap<Integer, Value> map;
//     int time;
//     int capacity;

//     public LRUCache(int capacity) {
//         map = new HashMap<>(capacity);
//         time = 0;
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         if(map.containsKey(key)) {
//             map.put(key, new Value(time++, map.get(key).value));
//             return map.get(key).value;
//         } else {
//             return -1;
//         }
//     }

//     public void put(int key, int value) {
//         int minTime = Integer.MAX_VALUE;
//         int minKey = 0;

//         if(map.size() == capacity && !map.containsKey(key)) {
//             for(Map.Entry<Integer, Value> entry : map.entrySet()) {
//                 if(entry.getValue().time < minTime) {
//                     minTime = entry.getValue().time;
//                     minKey = entry.getKey();
//                 }
//             }
//             map.remove(minKey);
//         }

//         map.put(key, new Value(time++, value));
//     }

//     class Value {
//         int time;
//         int value;

//         Value(int time, int value) {
//             this.time = time;
//             this.value = value;
//         }
//     }
// }

    class LRUCache {

        Map<Integer, Integer> lhm;
        int capacity;

        public LRUCache(int capacity) {

            this.capacity = capacity;
            lhm = new LinkedHashMap<>(capacity, 1.0f, true);
        }

        public int get(int key) {

            if(lhm.containsKey(key)) {
                return lhm.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {

            if(lhm.size() == capacity && !lhm.containsKey(key)) {
                int firstKey = lhm.entrySet().iterator().next().getKey();
                lhm.remove(firstKey);
            }
            lhm.put(key, value);
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
