/**
 * Author : Sradha Kedia
 * Page no.: 248 of Epi Java
 * Problem no.: 14.8
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem14_9_TeamPhotoDay1 {
    class Team {
        private class Player implements Comparable<Player> {
            public Integer height;

            public Player(Integer h) { height = h; }

            @Override
            public String toString() {
                return height + "";
            }

            @Override
            public int compareTo(Player that) {
                return Integer.compare(height, that.height);
            }
        }

        public Team(List<Integer> height) {
            players =
                    height.stream().map(h -> new Player(h)).collect(Collectors.toList());
        }

        // Checks if team0 can be placed in front of team1.
        public boolean validPlacementExists(Team team0, Team team1) {
            List<Player> list0 = team0.players;
            List<Player> list1 = team1.players;
            Collections.sort(list0);
            Collections.sort(list1);
            for(int i = 0; i < list0.size(); i++) {
                if(list1.get(i).height <= list0.get(i).height) {
                    return false;
                }
            }
            return true;
        }

        private List<Player> players;
    }
}
