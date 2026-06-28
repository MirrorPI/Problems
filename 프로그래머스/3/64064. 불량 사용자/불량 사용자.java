import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];

        dfs(0, user_id, banned_id, new ArrayList<>());

        return result.size();
    }

    private void dfs(int depth, String[] user_id, String[] banned_id, List<String> selected) {
        if (depth == banned_id.length) {
            List<String> copy = new ArrayList<>(selected);
            Collections.sort(copy);

            String key = String.join(",", copy);
            result.add(key);

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (!isMatch(user_id[i], banned_id[depth])) {
                continue;
            }

            visited[i] = true;
            selected.add(user_id[i]);

            dfs(depth + 1, user_id, banned_id, selected);

            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    private boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }

            if (userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}