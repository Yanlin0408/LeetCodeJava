import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 最后一个test每过,这是我能写的最优的了
public class updateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        // iterating through all grids and find the distances accordingly
        int gao = mat.length;
        int chang = mat[0].length;

        // use Queue (add grids around certain grid) to do BFS return the smallest distance when found a 0
        int count = 0;
        for(int i=0;i<gao;i++){
            for(int j=0;j<chang;j++){
                int caobi = (mat[i][j] == 0)? 0: findDistance(mat, new int[]{i,j}, gao, chang);
                mat[i][j] = caobi;
            }
        }

        return mat;
    }

    public int findDistance(int[][] mat, int[] dangQian, int gao, int chang){
        int[][] fangXiang = {{-1,0},{1,0},{0,-1},{0,1}}; // 上下左右
        HashSet<int[]> noRepeat = new HashSet<>();
        noRepeat.add(new int[]{dangQian[0], dangQian[1]});

        Queue<int[]> theQ = new LinkedList<>();
        theQ.add(new int[]{dangQian[0], dangQian[1]});
        boolean found = false;

        while(!found){
            int[] curGrid = theQ.poll();
            for(int[] dir:fangXiang){       // 扫四个方向, 看有没有0, 有就 return, 没有就加入 queue 开始下一轮
                int R = curGrid[0] + dir[0], L = curGrid[1] + dir[1];
                if(R < gao && R >= 0 && L < chang && L >= 0){
                    if(mat[R][L] == 0){
                        int absF = ((R-dangQian[0]) < 0) ? -(R-dangQian[0]) : (R-dangQian[0]);
                        int absS = ((L-dangQian[1]) < 0) ? -(L-dangQian[1]) : (L-dangQian[1]);
                        return absF + absS;
                    }else{
                        if(!noRepeat.stream().anyMatch(c -> Arrays.equals(c, new int[]{R,L}))){  //如果坐标没存过,就存. 否则不存
                            noRepeat.add(new int[]{R,L});
                            theQ.offer(new int[]{R,L});
                        }
                    }
                }
            }
        }
        return 0;
    }
}
