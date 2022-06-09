/**
 * Author : Sradha Kedia
 * Page no.: 239 of Epi Java
 * Problem no.: 14.3
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.Collections;
import java.util.List;

public class Problem14_3_RemoveFirstNameDuplicates {
    public static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        public Name(String first, String last) {
            firstName = first;
            lastName = last;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Name)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            Name name = (Name)obj;
            return firstName.equals(name.firstName) && lastName.equals(name.lastName);
        }

        @Override
        public String toString() {
            return firstName;
        }

        @Override
        public int compareTo(Name name) {
            int cmpFirst = firstName.compareTo(name.firstName);
            if (cmpFirst != 0) {
                return cmpFirst;
            }
            return lastName.compareTo(name.lastName);
        }
    }
    public static void eliminateDuplicate(List<Name> names) {
        Collections.sort(names);
        int res = 0;
        for(int i = 1; i < names.size(); i++) {
            if(!names.get(i).firstName.equals(names.get(res).firstName)) {
                names.set(++res, names.get(i));
            }
        }
        names.subList(++res, names.size()).clear();
    }
}
