package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/k-closest-points-to-origin/
 * Difficulty level : Medium
 */
public class Xproblem973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // return approachOne(points, k);
        // return approachTwo(points, k, 0, points.length - 1);
        return approachFour(points, k);
    }

    /**
     BruteForce
     Time : O(NlogN)
     Space: constant
     Algo : sort the points wrt to least squaredDistances and return first k points
     */
    public int[][] approachFour(int[][] points, int k) {

        Arrays.sort(points, (pt1, pt2) -> squaredDistance(pt1) - squaredDistance(pt2));

        return Arrays.copyOf(points, k);
    }

    /**
     BinarySearch
     Time :
     Space:
     Algo :
     */
    public int[][] approachThree(int[][] points, int k, int start, int end) {

        List<Point> result = new ArrayList<>();
        List<Point> remaining = new ArrayList<>();
        double maxDistance = 0;

        for (int[] point: points) {
            double distance = euclideanDistance(point);
            remaining.add(new Point(point, distance));
            maxDistance = Math.max(maxDistance, distance);
        }

        double l = 0;
        double h = maxDistance;

        while (k > 0) {

            double mid = (h + l)/2;
            List<List<Point>> partition = partitionDistances(remaining, mid);
            List<Point> closer = partition.get(0);
            List<Point> farther = partition.get(1);

            if (result.size() < k) {
                k -= closer.size();
                result.addAll(closer);
                remaining = farther;
                l = mid + 1;
            } else {
                h = mid - 1;
                remaining = closer;
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;

        for (Point point: result) {
            ans[i++] = point.pt;
        }
        return ans;
    }

    private List<List<Point>> partitionDistances(List<Point> points, double mid) {

        List<List<Point>> partition = new ArrayList<>();
        List<Point> closer = new ArrayList<>();
        List<Point> farther = new ArrayList<>();

        partition.add(closer);
        partition.add(farther);

        for (Point point: points) {
            if (point.dist <= mid) {
                closer.add(point);
            } else {
                farther.add(point);
            }
        }
        return partition;
    }

    public int[][] approachTwo(int[][] points, int k, int start, int end) {

        int pivot = partition(points, start, end);

        if (pivot == k - 1) {
            return Arrays.copyOfRange(points, 0, k);
        } else if (pivot > k - 1) {
            return approachTwo(points, k, start, pivot - 1);
        } else {
            return approachTwo(points, k, pivot + 1, end);
        }
    }

    private int partition(int[][] points, int start, int end) {

        int l = start, h = end, pivot = start;
        int pivotDist = squaredDistance(points[pivot]);

        while ( l < h) {

            while (l < end && squaredDistance(points[l]) <= pivotDist) {
                l++;
            }
            while (squaredDistance(points[h]) > pivotDist) {
                h--;
            }
            if (l < h) {
                swap(points, l, h);
            }
        }

        swap(points, pivot, h);
        return h;

    }



    public int[][] approachOne(int[][] points, int k) {

        PriorityQueue<Point> heap = new PriorityQueue<>(k, (p1, p2) -> (int)(p2.dist - p1.dist));

        for (int[] pt: points) {

            int dist = squaredDistance(pt);

            if (heap.size() < k) {
                heap.add(new Point(pt, dist));
            } else if (dist < heap.peek().dist) {
                heap.poll();
                heap.add(new Point(pt, dist));
            }
        }

        int[][] result = new int[k][];
        int i = 0;

        for (Point point: heap) {
            result[i++] = point.pt;
        }
        return result;
    }

    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private double euclideanDistance(int[] point) {
        return Math.pow(point[0] * point[0] + point[1] * point[1], 0.5);
    }

    private void swap(int[][] points, int l, int h) {
        int[] temp = points[l];
        points[l] = points[h];
        points[h] = temp;
    }

    private class Point {
        int[] pt;
        double dist;
        Point(int[] pt, double dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }
}
