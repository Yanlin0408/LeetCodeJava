class floodFill2 {
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int startColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != startColor)    return;
        // 如果 row column 超出范围，回
        // 如果 image[sr][sc] 不是 startColor --> 可能被染过色,可能是别的颜色,都有可能.所以这一个判断 顶我原来三个
        image[sr][sc] = color;

        fill(image,sr-1,sc,color,startColor);    // 上
        fill(image,sr,sc-1,color,startColor);    // 左
        fill(image,sr+1,sc,color,startColor);    // 下
        fill(image,sr,sc+1,color,startColor);    // 右
    }
}
