import java.util.*;

class Solution {
    final int[] dx = {-1, 1, 0, 0};
    final int[] dy = {0, 0, -1, 1};

    class Shape {
        List<Point> points = new ArrayList<>();

        void add(Point point) {
            points.add(point);
        }

        int size() {
            return points.size();
        }

        void sort() {
            Collections.sort(points, (p1, p2) -> {
                if (p1.x == p2.x) return p1.y - p2.y;

                return p1.x - p2.x;
            });
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] game_board, int[][] table) {
        List<Shape> blocks = new ArrayList<>();
        List<Shape> blanks = new ArrayList<>();

        saveShape(blocks, table, 1);
        saveShape(blanks, game_board, 0);

        int ans = 0;
        int blockCnt = blocks.size();
        boolean[] usedBlock = new boolean[blockCnt];

        for (Shape blank : blanks) {
            for (int i = 0; i < blockCnt; i++) {
                if (usedBlock[i]) continue;

                if (canFit(blocks.get(i), blank)) {
                    usedBlock[i] = true;

                    ans += blocks.get(i).size();
                    break;
                }
            }
        }

        return ans;
    }

    public boolean canFit(Shape block, Shape blank) {
        Shape rotatedBlock = block;

        for (int i = 0; i < 4; i++) {
            if (isSameShape(rotatedBlock, blank)) return true;

            rotatedBlock = normalize(rotate90(rotatedBlock));
        }

        return false;
    }

    public Shape normalize(Shape shape) {
        Shape normalizedShape = new Shape();

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Point p : shape.points) {
            int x = p.x;
            int y = p.y;

            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
        }

        for (Point p : shape.points) {
            normalizedShape.add(new Point(p.x - minX, p.y - minY));
        }

        normalizedShape.sort();

        return normalizedShape;
    }

    public boolean isSameShape(Shape block, Shape blank) {
        if (block.size() != blank.size()) return false;

        for (int i = 0; i < block.size(); i++) {
            Point p1 = block.points.get(i);
            Point p2 = blank.points.get(i);

            if (p1.x != p2.x || p1.y != p2.y) return false;
        }

        return true;
    }

    public Shape rotate90(Shape shape) {
        Shape rotatedShape = new Shape();

        for (Point p : shape.points) {
            rotatedShape.add(new Point(p.y, p.x * -1));
        }

        return rotatedShape;
    }

    public void saveShape(List<Shape> shapes, int[][] map, int target) {
        int xLen = map.length;
        int yLen = map[0].length;
        boolean[][] visited = new boolean[xLen][yLen];

        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                if (visited[x][y] || map[x][y] != target) continue;

                Shape shape = findShapeByBFS(x, y, map, visited, target);
                shapes.add(normalize(shape));
            }
        }
    }

    public Shape findShapeByBFS(int x, int y, int[][] map, boolean[][] visited, int target) {
        Shape shape = new Shape();

        Point start = new Point(x, y);
        shape.add(start);

        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cx = curr.x;
            int cy = curr.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || visited[nx][ny]) continue;

                if (map[nx][ny] != target) continue;

                shape.add(new Point(nx, ny));
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }

        return shape;
    }
}