/**
 * Author : Sradha Kedia
 * Page no.: 279, 280, 281 of Epi Java
 * Problem no.: 15.13
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

import java.util.*;

public class Problem15_13_AddCredits {

    public static class ClientsCreditsInfo {

        // hash map to store all the entries of clients to credits for fast lookup, add, remove.
        Map<String, Integer> clientToCredit = new HashMap<>();

        // to return client with maximum credit we need to put that in a sorted hash map, which map credits to client.
        // so, the clients with maximum credits will be the last entry of this sorted map.
        NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();

        // Also, incrementing the credits for all the clients simultaneously would take O(n) time.
        // Better is to take a global variable and keep on incrementing this whenever a credit is to be added to all clients.
        // its an offset.
        int creditsToIncrement = 0;

        public void insert(String clientID, int c) {

            // inserting credits with subtracting the creditsToIncrement
            // because if any before calls were made to add credits to all then the present inserted client was not present
            // at that time. and when we do lookup we increment all the addToCredits till now to its original credit which
            // would lead to an error, so we decrement it earlier before inserting.

            clientToCredit.put(clientID, c - creditsToIncrement);

            // for searching the client with maximum credits we store it in hashmap according to its credits - offset
            if (creditToClients.containsKey(c - creditsToIncrement)) {
                creditToClients.get(c - creditsToIncrement).add(clientID);
            } else {
                creditToClients.put(c - creditsToIncrement, new HashSet<>(Collections.singletonList(clientID)));
            }

        }

        public boolean remove(String clientID) {

            // removing means to remove from the hashmap as well as the creditsToClients sorted map too.
            if (clientToCredit.containsKey(clientID)) {
                int credit = clientToCredit.get(clientID);
                if (creditToClients.get(credit) != null) {
                    creditToClients.get(credit).remove(clientID);
                }
                clientToCredit.remove(clientID);
                return true;
            }
            return false;
        }

        public int lookup(String clientID) {
            // we get the credits from clientId and then add offset to it. if clientID is not there we return -1 then.
            int c = (clientToCredit.get(clientID) != null) ? clientToCredit.get(clientID) + creditsToIncrement : -1;
            return c;
        }

        public void addAll(int C) {
            // increment offset by C.
            creditsToIncrement += C;
        }

        public String max() {
            // get the last entry from sorted map and return the first client from the set of clients
            // as we need to return only a single client.
            Iterator<String> maxCreditClients = creditToClients.lastEntry().getValue().iterator();
            return maxCreditClients.next();
        }
    }
}
