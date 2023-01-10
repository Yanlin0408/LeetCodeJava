import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class updateMatrix2 {
    int[][] fangXiang = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();

        for(int r=0;r<m;r++)
            for(int c=0;c<n;c++)
                if(mat[r][c] == 0)  q.offer(new int[]{r,c});
                else    mat[r][c] = -1;

        while(!q.isEmpty()){
            int[] currZero = q.poll();  // 把 0 一个一个拿出来, 给每一个 0 做一个 BFS, 渲染一整个 mat
            Queue<int []> zeroQ = new ArrayDeque<>();
            zeroQ.offer(currZero);
            HashSet<int[]> noRepeat = new HashSet<>();
            while(!zeroQ.isEmpty()){
                int[] innerOut = zeroQ.poll();
                for(int[] didi: fangXiang){
                    int newR = innerOut[0] + didi[0];
                    int newC = innerOut[1] + didi[1];
                    if(newR >= m || newR < 0 || newC >= n || newC < 0)  continue;
                    if(mat[newR][newC] == -1){
                        mat[newR][newC] = mat[innerOut[0]][innerOut[1]] + 1;
                    }else{
                        if(mat[innerOut[0]][innerOut[1]] + 1 < mat[newR][newC]){   // 如果新加入的比原本的小, 就覆盖了
                            mat[newR][newC] = mat[innerOut[0]][innerOut[1]] + 1;
                        }
                    }
                    if(mat[newR][newC] != 0 && !noRepeat.stream().anyMatch(c -> Arrays.equals(c, new int[]{newR,newC}))){
                        noRepeat.add(new int[]{newR,newC});
                        zeroQ.offer(new int[]{newR,newC});
                    }
                }
            }

        }
        return mat;
    }
}