package jianzhiOffer;

/**
 * Created by Administrator on 2017/11/13.
 */
public class StringPathinMatrix {
    public boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if(matrix.length<=0||rows<1||cols<1||str.length<=0)
            return false;
        int visited[]=new int[rows*cols];
        int pathLength=0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited))
                    return true;
            }
        }
        return false;
    }

    public boolean hasPathCore(final char[] matrix,int rows,int cols,int row,int col,
                                        final char[] str,int pathlength,int visited[]){
        if(pathlength==str.length)
            return true;
        boolean hasPath=false;

        if(row>=0&&row<rows&col>=0&&col<cols&&matrix[row*cols+col]==str[pathlength]&&visited[row*cols+col]==0){
            ++pathlength;
            visited[row*cols+col]=1;
            hasPath=hasPathCore(matrix,rows,cols,row,col-1,str,pathlength,visited)||
                    hasPathCore(matrix,rows,cols,row-1,col,str,pathlength,visited)||
                    hasPathCore(matrix,rows,cols,row,col+1,str,pathlength,visited)||
                    hasPathCore(matrix,rows,cols,row+1,col,str,pathlength,visited);
            if(!hasPath){
                --pathlength;
                visited[row*cols+col]=0;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix={'a','b','c','e',
                       's','f','c','s',
                       'a','d','e','e'};
        //char[] str1={'b','f','c','e'};
        char[] str2={'a','b','f','b'};
        StringPathinMatrix solution=new StringPathinMatrix();
        //System.out.println(solution.hasPath(matrix,3,4,str1));
        System.out.println(solution.hasPath(matrix,3,4,str2));

    }
}
