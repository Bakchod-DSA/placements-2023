package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/top-k-frequent-elements/
 * Difficulty level : Medium
 */
public class problem347_TopKFrequentElements {

    private static class Entry {

        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        return approachTwo(nums, k);
    }

    private int[] approachOne(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>(k, (Entry e1, Entry e2) -> e2.value - e1.value);

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (pq.size() <= k) {
                pq.add(new Entry(entry.getKey(), entry.getValue()));
            }
            if (pq.peek().value < entry.getValue()) {
                pq.poll();
                pq.add(new Entry(entry.getKey(), entry.getValue()));
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().key;
        }
        return result;
    }

    /**
     Time : NLogN + k (average) , worst case = N^2 + k
     Space: 3*N
     Algo : We will save entry(key - value pair) in array and run quickSelect on it
     if the partition idx == k - 1 (as array is 0 based where k is 1 based),
     we get k most frequent entry object from start to k idx
     if the partition idx > k - 1 -> our k most frequent objects are on left,
     hence we will run quickSelect from start to idx - 1
     if the partition idx < k - 1 -> we still need more frequent entry objects
     hence we will run quickSelect from idx + 1 to end
     */
    private int[] approachTwo(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele: nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        List<Entry> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            arr.add(new Entry(entry.getKey(), entry.getValue()));
        }
        return quickSelect(arr, k, 0, arr.size() - 1);
    }

    private int[] quickSelect(List<Entry> arr, int k, int start, int end) {
        int idx = partition(arr, start, end);
        if (idx == k - 1) {
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = arr.get(i).key;
            }
            return ans;
        } else if (idx > k - 1) {
            return quickSelect(arr, k, start, idx - 1);
        } else {
            return quickSelect(arr, k, idx + 1, end);
        }
    }

    /**
     method partition partitioned the array int two halfs such that most frequent element are on the left
     where less frequent elements are on the right of an index, since that index is partition index,
     we will return it
     */
    private int partition(List<Entry> arr, int start, int end) {

        int pivot = arr.get(start).value;
        int l = start;
        int h = end;

        while (l < h) {
            while (l < end && arr.get(l).value >= pivot) {
                l++;
            }
            while (h > start && arr.get(h).value < pivot) {
                h--;
            }
            if (l < h) {
                swap(arr, l, h);
            }
        }
        swap(arr, start, h);
        return h;
    }

    private void swap(List<Entry> arr, int l, int h) {
        Entry temp = arr.get(l);
        arr.set(l, arr.get(h));
        arr.set(h, temp);
    }
}
