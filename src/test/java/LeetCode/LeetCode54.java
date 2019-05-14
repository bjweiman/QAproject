package LeetCode;

import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: QAproject
 * @description: 顺时针打印矩阵
 * @author: bjweiman
 * @create: 2019-04-03 20:25
 **/
public class LeetCode54 {
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ls=new ArrayList<>();
        if(matrix.length==0){
            return ls;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int right=1;
        int down=2;
        int left=3;
        int up=4;
        int num=row*col;
        int direction=right;
        int x=0;
        int y=0;
        for(int i=0;i<num;i++){
            ls.add(matrix[x][y]);
            matrix[x][y]=0;
            if(direction==right){
                if(y+1<col&&matrix[x][y+1]!=0){
                    y++;
                }
                else{
                    direction=down;
                    x++;
                    continue;//因为这里改变了方向，如果不结束当前的循环的话，可能会继续执行下去造成结果错误，所以要continue
                }
            }
            if(direction==down){
                if(x+1<row&&matrix[x+1][y]!=0){
                    x++;
                }
                else{
                    direction=left;
                    y--;
                    continue;
                }
            }
            if(direction==left){
                if(y-1>=0&&matrix[x][y-1]!=0){
                    y--;

                }
                else{
                    direction=up;
                    x--;
                    continue;
                }
            }
            if(direction==up){
                if(x-1>=0&&matrix[x-1][y]!=0){
                    x--;
                }
                else{
                    direction=right;
                    y++;
                    continue;
                }
            }
        }
        return ls;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null) return null;
        List<Integer> list = Lists.newArrayList();
        int row = matrix.length;
        int column = matrix[0].length;
        int i=0,j=0;
        int start = 0;
        while (start<row/2&&start<column/2){
            //左-右
            printNums(matrix, 0, row, column,list);
        }


        return list;
    }

    public void printNums(int[][] matrix, int start, int row, int column ,  List list){
        int endx = column-1-start;
        int endy = row-1-start;

        //左-右
        for(int i=start; i< endx;i++){
            list.add(matrix[start][i]);
        }
        //上-下
        if(start<endy){
            for(int i=start+1; i<endy; i++){
                list.add(matrix[i][endx]);
            }
        }
        //右-左
        if (start<endx&&start<endy){
            for(int i=endx-1; i>=start; i--){
                list.add(matrix[endy][i]);
            }
        }
        if(start<endx&&start<endy-1){
            for(int i=endy-1; i>start; i--){
                list.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
