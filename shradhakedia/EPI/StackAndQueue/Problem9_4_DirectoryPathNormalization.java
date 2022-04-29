/**
 * Author : Sradha Kedia
 * Page no.: 138, 139 of Epi Java
 * Problem no.: 9.4
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Problem9_4_DirectoryPathNormalization {

    public static String shortestEquivalentPath(String path) {
    /*  Approach: Stack
        Time Complexity: O(n)
        Space Complexity: O(n)
    */

        Deque<String> pathNames = new LinkedList<>();
        if(path.startsWith("/")) {
            // absolute path
            pathNames.addFirst("/");
        }

        for(String token : path.split("/")) {
            if(token.equals("..")) {
                if(pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
                    // eg: ../../etc
                    pathNames.addFirst(token);
                } else if(pathNames.peekFirst().equals("/")) {
                    // eg: /../etc -> illegal path
                    throw new IllegalArgumentException("Illegal path, can't move up the root directory");
                } else {
                    // eg: /etc/../abc, we can remove etc from stack.
                    pathNames.removeFirst();
                }
            } else if(token.equals(".") || token.equals("")) {
                // eg: /./etc///./ -> /etc
                continue;
            } else {
                // token is a valid name.
                pathNames.addFirst(token);
            }
        }

        Iterator<String> it = pathNames.descendingIterator();
        StringBuilder result = new StringBuilder();
        while(it.hasNext()) {
            result.append(it.next());
            if(!result.toString().endsWith("/")) {
                result.append("/");
            }
        }
        return (result.length() == 1)? result.toString() : result.substring(0, result.length() - 1);
    }
}
