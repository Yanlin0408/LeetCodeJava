class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int startColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)    return;   // 如果 row column 超出范围，回
        if(image[sr][sc] == color)   return;    // 如果已经被染过色了，回
        if(image[sr][sc] == startColor)    image[sr][sc] = color;
        else    return;
        fill(image,sr-1,sc,color,startColor);    // 上
        fill(image,sr,sc-1,color,startColor);    // 左
        fill(image,sr+1,sc,color,startColor);    // 下
        fill(image,sr,sc+1,color,startColor);    // 右
    }
}

// **** 自己写的判断，有点冗余