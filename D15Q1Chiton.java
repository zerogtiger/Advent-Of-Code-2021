import java.util.*;

/*class position implements Comparable<position>{
    Integer x;
    Integer y;
    Integer dist;
    public position (Integer x, Integer y, Integer dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(position p) {
        int out = this.dist;
        if(this.dist > p.dist) out = p.dist;
        return out;
    }
}
 */

public class D15Q1Chiton {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = 100;
        int T = N+2;

        int[][] caves = new int[T][T];
        int[][] dist = new int[T][T];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        String[] temp;
        for (int i = 1; i <= N; i++) {
            temp = s.nextLine().split("");
            for (int j = 1; j <= N; j++) {
                caves[i][j] = Integer.parseInt(temp[j-1]);
                dist[i][j] = 0x7fffffff;
            }
        }

        PriorityQueue<position> pq = new PriorityQueue<position>();
        dist[1][1] = caves[1][1];
        pq.add(new position(1,1, caves[1][1]));
        position v;
        int nx;
        int ny;
        while (!pq.isEmpty()) {
            v = pq.poll();
            for (int i = 0; i < 4; i++) {
                nx = v.x+dx[i];
                ny = v.y+dy[i];
                if ((caves[nx][ny] + v.dist) < dist[nx][ny]) {
                    pq.add(new position(nx, ny, caves[nx][ny] + v.dist));
                    dist[nx][ny] = caves[nx][ny] + v.dist;
                }
            }
        }
        System.out.println(dist[N][N]-dist[1][1]);

    }
}
