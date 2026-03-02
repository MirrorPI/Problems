import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genre = new HashMap<>();
        HashMap<String, Integer> pickCnt = new HashMap<>();
        int songNum = genres.length;
        for(int i=0; i<songNum; i++){
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
            pickCnt.put(genres[i], 0);
        }
        Song[] songs = new Song[songNum];
        for(int i=0; i<songNum; i++){
            songs[i] = new Song(genres[i], genre.get(genres[i]), plays[i], i);
        }
        Arrays.sort(songs, (s1, s2) -> {
            if(s1.genrePlayCnt == s2.genrePlayCnt) {
                if(s1.songPlayCnt == s2.songPlayCnt) {
                    return Integer.compare(s1.index, s2.index);
                }
                return Integer.compare(s2.songPlayCnt, s1.songPlayCnt);
            }
            return Integer.compare(s2.genrePlayCnt, s1.genrePlayCnt);
        });
    
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<songNum; i++){
            if(pickCnt.get(songs[i].genre) == 2) continue;
            
            ans.add(songs[i].index);
            pickCnt.put(songs[i].genre, pickCnt.get(songs[i].genre) + 1);
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    class Song {
        String genre;
        int genrePlayCnt;
        int songPlayCnt;
        int index;
        Song (String genre, int genrePlayCnt, int songPlayCnt, int index) {
            this.genre = genre;
            this.genrePlayCnt = genrePlayCnt;
            this.songPlayCnt = songPlayCnt;
            this.index = index;
        }
    }
}