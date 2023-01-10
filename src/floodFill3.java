import java.util.LinkedList;
import java.util.Queue;

class floodFill3 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldC = image[sr][sc];
        int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};   // 上下左右
        Queue theQ = new LinkedList<int[]>();   // queue up the positions of grids which hasn't been processed yet.
        theQ.offer(new int[] {sr,sc});

        while(theQ.peek() != null){
            int[] currentG = (int[]) theQ.poll();
            image[currentG[0]][currentG[1]] = color;    // 给最前面的染色;
            for(int[] di:directions){
                int R = currentG[0] + di[0], C = currentG[1] + di[1];
                if(isValid(image, R,C,color,oldC))   theQ.offer(new int[]{R,C});
            }
        }
        return image;
    }

    public boolean isValid(int[][] image, int r, int c, int color, int oldC){
        if(r >= image.length || r<0 || c >= image[0].length || c < 0 || image[r][c] != oldC || image[r][c] == color)   return false;
        return true;
    }
}
