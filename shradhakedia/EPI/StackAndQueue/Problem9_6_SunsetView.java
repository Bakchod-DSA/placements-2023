/**
 * Author : Sradha Kedia
 * Page no.: 140, 141 of Epi Java
 * Problem no.: 9.6
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.*;

public class Problem9_6_SunsetView {

    public static List<Integer> examineBuildingsWithSunset(Iterator<Integer> sequence) {
        // east to west iterator means if view is like this : sun 4 2 3 5 (only 4 and 5 can see the sun) iterator has 5 3 2 4 (east to west)

//    return approachOne(sequence);
        return approachTwo(sequence);
    }

    private static List<Integer> approachOne(Iterator<Integer> sequence) {
    /*  Approach: Brute Force
        Time complexity: O(2n)
        Space Complexity: O(n) always since we are using an array to store all elements first.
    */

        List<Integer> buildings = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while (sequence.hasNext()) {
            buildings.add(sequence.next());
        }

        int max = Integer.MIN_VALUE;
        for(int i = buildings.size() - 1; i >= 0; i--) {
            if(buildings.get(i) > max) {
                max = buildings.get(i);
                result.add(i);
            }
        }

        return result;
    }

    private static List<Integer> approachTwo(Iterator<Integer> sequence) {
    /*  Approach: Stack
        Time complexity: O(n)
        Space Complexity: O(1) in best case when sequence is 1 2 3 4 5, O(n) in worst case when sequence is 5 4 3 2 1 5
    */
        // edge case when there are no buildings.
        if(!sequence.hasNext()) return new ArrayList<>();

        int buildingIdx = 0;
        Deque<BuildingWithHeight> buildingWithSunsets = new LinkedList<>();
        buildingWithSunsets.addFirst(new BuildingWithHeight(buildingIdx++, sequence.next()));
        while(sequence.hasNext()) {
            int ht = sequence.next();
            while(!buildingWithSunsets.isEmpty() && buildingWithSunsets.peekFirst().height <= ht) {
                buildingWithSunsets.removeFirst();
            }
            buildingWithSunsets.addFirst(new BuildingWithHeight(buildingIdx++, ht));
        }

        List<Integer> result = new ArrayList<>();
        while(!buildingWithSunsets.isEmpty()) {
            BuildingWithHeight building = buildingWithSunsets.removeFirst();
            result.add(building.id);
        }

        return result;
    }

    private static class BuildingWithHeight {
        int id, height;

        BuildingWithHeight(int id, int height) {
            this.id = id;
            this.height = height;
        }
    }
}
