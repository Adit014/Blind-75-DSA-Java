import java.util.*;

//https://leetcode.com/problems/alien-dictionary/editorial/ = PREMIUM
//https://www.lintcode.com/problem/892/ - Free
public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        new AlienDictionary().alienOrder(words);
    }

    public String alienOrder(String[] words) {
        List<Set<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[26];

        for (int i =0; i < 26; i++) {
            adjList.add(new HashSet<>());
        }

        for(int i = 1; i < words.length; i++) {
            String first = words[i-1];
            String second = words[i];

            int length = Math.min(first.length(), second.length());
             for (int j = 0; j < length; j++) {
                 if (first.charAt(j) != second.charAt(j)) {
                     int key = first.charAt(j) - 'a';
                     adjList.get(key).add(second.charAt(j) - 'a');
                 }
             }
        }

        Stack<Integer> stack = new Stack<>();
        dfs(adjList, words[0].charAt(0) - 'a', visited, stack);

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.append((char) (stack.pop() + 'a'));
        }
        return builder.toString();
    }

    private void dfs(List<Set<Integer>> adjList, int value, boolean[] visited, Stack<Integer> stack ) {
        visited[value] = true;
        for (int num : adjList.get(value)) {
            if (!visited[num]) {
                dfs(adjList, num, visited, stack);
            }
        }
        stack.add(value);
    }
}
