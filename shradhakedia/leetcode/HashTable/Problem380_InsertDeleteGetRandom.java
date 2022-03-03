/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

import java.util.*;

public class Problem380_InsertDeleteGetRandom {

    static class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            swap(map, list, index, list.size() - 1);

            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        private void swap(Map<Integer, Integer> map, List<Integer> list, int i, int j) {

            list.set(i, list.get(j));
            map.put(list.get(j), i);

        }

        public int getRandom() {


            Random rand = new Random();
            int index = rand.nextInt(list.size());

            return list.get(index);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
