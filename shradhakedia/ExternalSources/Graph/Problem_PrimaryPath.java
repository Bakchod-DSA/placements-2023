/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.spoj.com/problems/PPATH/
 * Difficulty level: Medium
 */

package ExternalSources.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_PrimaryPath {

    public static void main(String[] args) throws IOException {


        List<Integer>[] graph = makeGraph();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int[] visited = new int[10000];
            int[] dis = new int[10000];
            Arrays.fill(dis, 1000, 10000, -1);

            bfs(n, dis, visited, graph);

            System.out.println(dis[m]);
        }
    }

    private static boolean isPrime(int n) {
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                count++;
            }
        }

        return count == 0;
    }

    private static boolean isValid(int n, int m) {
        int count = 0;
        while(n > 0) {
            if(n % 10 != m % 10) {
                count++;
            }
            n /= 10;
            m /= 10;
        }

        return count == 1;
    }

    private static List<Integer>[] makeGraph() {
        List<Integer> primes = new ArrayList<>();
        for(int i = 1000; i <= 9999; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }

        LinkedList<Integer>[] graph = new LinkedList[10000];
        for(int i = 1000; i <= 9999; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < primes.size(); i++) {
            for(int j = i + 1; j < primes.size(); j++) {
                int u = primes.get(i);
                int v = primes.get(j);
                if(isValid(u, v)) {
                    graph[u].add(v);
                    graph[v].add(u);
                }
            }
        }

        return graph;
    }

    private static void bfs(int source, int[] dis, int[] visited, List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        dis[source] = 0;
        visited[source] = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int node = queue.remove();

                for(int child : graph[node]) {
                    if(visited[child] == 0) {
                        visited[child] = 1;
                        queue.add(child);
                        dis[child] = dis[node] + 1;
                    }
                }
            }
        }
    }

}
