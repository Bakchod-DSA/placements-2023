/**
 * Author : Sradha Kedia
 * Page no.: 246 of Epi Java
 * Problem no.: 14.7
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem14_7_GroupEqualEntries {
    public static class Person {
        public Integer age;
        public String name;

        public Person(Integer k, String n) {
            age = k;
            name = n;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Person person = (Person)o;

            if (!age.equals(person.age))
                return false;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            int result = age.hashCode();
            result = 31 * result + name.hashCode();
            return result;
        }
    }
    public static void groupByAge(List<Person> people) {
        Map<Integer, Integer> ageToCount = new HashMap<>();
        for(Person p : people) {
            ageToCount.put(p.age, ageToCount.getOrDefault(p.age, 0) + 1);
        }

        int offset = 0;
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : ageToCount.entrySet()) {
            ageToOffset.put(entry.getKey(), offset);
            offset += entry.getValue();
        }

        while(ageToOffset.size() > 0) {
            Map.Entry<Integer, Integer> from = ageToOffset.entrySet().iterator().next();
            int index = from.getValue();
            int toAge = people.get(index).age;
            int newIndex = ageToOffset.get(toAge);
            Collections.swap(people, index, newIndex);
            int count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if(count > 0) ageToOffset.put(toAge, newIndex + 1);
            else ageToOffset.remove(toAge);
        }

    }
    private static Map<Person, Integer> buildMultiset(List<Person> people) {
        Map<Person, Integer> m = new HashMap<>();
        for (Person p : people) {
            m.put(p, m.getOrDefault(p, 0) + 1);
        }
        return m;
    }

}
