import java.util.*;

class Solution {
    
    static class Point {
        final int x;
        final int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        //좌표를 인코딩해도되지만 클래스로 한 번 풀어보고 싶었음.
        //new 로 생성하면 같은 좌표여도 다른 객체로 인식함 그래서 아래의 메서드들을 오버라이드해줬음
        @Override
        public boolean equals(Object o) {
            if(this == o) return true; //비교대상이 같은 주소인가(같은 객체인가)
            if(!(o instanceof Point)) return false; //Point class의 객체인가
            Point point = (Point) o; //Point인 것만 내려오니까 형변환 안전.
            return x == point.x && y == point.y; //내용물 비교
        }
        //해시 기반 컬렉션(HashSet, HashMap)은 먼저 hashCode()보고 어느 칸(bucket)에 넣을지 정하고
        //같은 위치에 후보가 있으면 그때 equals()로 진짜 같은지 비교. 
        @Override
        public int hashCode() { 
            return Objects.hash(x, y);
        }
        //equals() 가 true 라면 hashCode()는 같아야함
        //hashCode()가 같다고 해서 equals가 true일 필요는 없음
        //해시 충돌로 인해 다른 객체여도 같은 값을 가지고 있을 수 있어서
    }

    static class Edge {
        final Point from;
        final Point to;
        
        Edge(Point from, Point to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Edge)) return false;
            Edge edge = (Edge) o;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }
        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
    final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public int solution(int[] arrows) {
        Set<Point> visitedPoints = new HashSet<>();
        Set<Edge> visitedEdges = new HashSet<>();
        
        Point curr = new Point(0, 0);
        visitedPoints.add(curr);
        
        int answer = 0;
        
        for(int arrow : arrows) {
            //대각선 교차를 처리하기 위해서 한번의 움직임을 2번 나눠서 저장함
            for(int i=0; i<2; i++) {
                Point next = new Point(curr.x + dx[arrow], curr.y + dy[arrow]);
                
                Edge edge = new Edge(curr, next);
                Edge reverseEdge = new Edge(next, curr);
                
                if(visitedPoints.contains(next) && !visitedEdges.contains(edge)){
                    answer++;
                }
                
                visitedPoints.add(next);
                visitedEdges.add(edge);
                visitedEdges.add(reverseEdge);
                
                curr = next;
            }
        }
        return answer;
    }
    
}