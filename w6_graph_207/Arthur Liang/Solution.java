import java.util.*;

public class Solution {
    /*public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];

        for (int[] cp : prerequisites) {
            inDegrees[cp[0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) {
                    continue;
                }

                if (--inDegrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        System.out.println(numCourses);
        return numCourses == 0;
    }*/

    /*public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
    private static boolean dfs(int[][] adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }*/


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> toTake = graph.get(cur);
            for (int i = 0; toTake != null && i < toTake.size(); i++) {
                inDegree[toTake.get(i)]--;
                if (inDegree[toTake.get(i)] == 0) {
                    queue.add(toTake.get(i));
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 6;
//        int[][] prerequisites = {{1, 0}, {2, 6}, {1, 7}, {5, 1}, {3, 4}, {6, 4}, {7, 0}, {0, 5}};
//        int[][] prerequisites = {{1, 0}, {2, 6}, {1, 7}, {3, 4}, {6, 4}, {7, 0}, {0, 5}};
//        int[][] prerequisites = {{4, 0}, {4, 1}, {3, 1}, {3, 2}, {5, 4}, {5, 3}};
        int[][] prerequisites = {{4, 0}, {4, 1}, {3, 1}, {3, 2}, {5, 4}, {5, 3},{0, 5}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
