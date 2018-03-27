package OnlineJudge.wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2018/3/26.
 */
public class CmpWeight {
/*    int result=-1;
    public int cmp(int g1, int g2, int[][] records, int n) {
        // write code here
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<records.length;i++){
            for(int j=0;j<records[0].length;j++){
                set.add(records[i][j]);
            }
        }
        int length=set.size();
        int graph[][]=new int[length][length];
        for(int i=0;i<records.length;i++){
            graph[records[i][0]-1][records[i][1]-1]=1;
        }
        int flag[]=new int[length];
        DFS(g1-1,g2-1,flag,graph);
        return result;
    }
    public int DFS(int x,int y,int flag[],int graph[][]){
        flag[x]=1;
        if (graph[x][y] == 1) {
            return 1;
        } else {
            for (int i = 0, len = graph.length; i < len; i++) {
                if (graph[x][i] == 1 && flag[i]!=1) {
                    flag[i] = 1;
                    if (DFS(i,y,flag,graph)==1) {
                        return 1;
                    }
                }
            }
        }
        return -1;
    }*/
    /**
     * 构造有向图,g1>g2,g1->g2存在路径,反之亦然.
     * @param g1
     * @param g2
     * @param records
     * @param n
     * @return
     */
    public int cmp(int g1, int g2, int[][] records, int n) {
        int N = getMaxWeight(records, n) + 1;
        int[][] map = new int[N][N];
        boolean[] isVisited = new boolean[N];
        initMap(records, map, n);
        if (dfs(map, g1, g2, isVisited)) {
            return 1;
        }
        for (int i = 0; i < N; i++) {
            isVisited[i] = false;
        }
        if (dfs(map, g2, g1, isVisited)) {
            return -1;
        }
        return 0;
    }

    public static boolean dfs(int[][] map, int g1, int g2, boolean[] isVisited) {
        isVisited[g1] = true;
        if (map[g1][g2] == 1) {
            return true;
        } else {
            for (int i = 0, len = map.length; i < len; i++) {
                if (map[g1][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    if (dfs(map, i, g2, isVisited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void initMap(int[][] records, int[][] map, int n) {
        for (int i = 0; i < n; i++) {
            map[records[i][0]][records[i][1]] = 1;
        }
    }

    public static int getMaxWeight(int[][] records, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = records[i][0];
            int y = records[i][1];
            max = max > x ? max : x;
            max = max > y ? max : y;
        }
        return max;
    }

    public static void main(String[] args) {
        int g1=2,g2=3;
        int records[][]={{1,2},{2,4},{1,3},{4,1}};
        System.out.println(new CmpWeight().cmp(g1,g2,records,4));
    }
}
