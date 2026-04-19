import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        if (!containsTarget(target, words)) {
            return 0;
        }

        WordGraph graph = new WordGraph(begin, words);
        return bfs(begin, target, graph);
    }

    private int bfs(String begin, String target, WordGraph graph) {
        Queue<WordState> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new WordState(begin, 0));
        visited.add(begin);

        while (!queue.isEmpty()) {
            WordState current = queue.poll();

            if (current.word.equals(target)) {
                return current.count;
            }

            for (String nextWord : graph.getNextWords(current.word)) {
                if (visited.contains(nextWord)) {
                    continue;
                }

                visited.add(nextWord);
                queue.offer(new WordState(nextWord, current.count + 1));
            }
        }

        return 0;
    }

    private boolean containsTarget(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }

    private static final class WordState {
        private final String word;
        private final int count;

        private WordState(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    private static final class WordGraph {
        private final Map<String, List<String>> adjacency = new HashMap<>();

        private WordGraph(String begin, String[] words) {
            List<String> allWords = new ArrayList<>();
            allWords.add(begin);
            Collections.addAll(allWords, words);

            for (String word : allWords) {
                adjacency.put(word, new ArrayList<>());
            }

            for (int i = 0; i < allWords.size(); i++) {
                for (int j = i + 1; j < allWords.size(); j++) {
                    String word1 = allWords.get(i);
                    String word2 = allWords.get(j);

                    if (canTransform(word1, word2)) {
                        adjacency.get(word1).add(word2);
                        adjacency.get(word2).add(word1);
                    }
                }
            }
        }

        private List<String> getNextWords(String word) {
            return adjacency.getOrDefault(word, Collections.emptyList());
        }

        private boolean canTransform(String word1, String word2) {
            int diffCount = 0;

            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1) {
                        return false;
                    }
                }
            }

            return diffCount == 1;
        }
    }
}