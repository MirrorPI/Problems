import java.util.*;

class Solution {
    String[][] tickets;
    boolean[] used;
    String[] answer;
    int n;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.n = tickets.length;
        this.used = new boolean[n];

        Arrays.sort(this.tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        String[] path = new String[n + 1];
        path[0] = "ICN";

        dfs("ICN", 0, path);

        return answer;
    }

    boolean dfs(String current, int depth, String[] path) {
        if (depth == n) {
            answer = path.clone();
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                path[depth + 1] = tickets[i][1];

                if (dfs(tickets[i][1], depth + 1, path)) {
                    return true;
                }

                used[i] = false;
            }
        }

        return false;
    }
}