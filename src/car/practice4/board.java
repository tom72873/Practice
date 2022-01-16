package car.practice4;

import java.util.Arrays;

import static java.lang.System.out;

public class board {
    private int step=0;
    private boolean stop=false;
    private int[] dir1={1,1,-1,-1,2,2,-2,-2};
    private int[] dir2={2,-2,2,-2,1,-1,1,-1};
    private int[][] board={
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
    };
    public board(int x,int y){
        start(x,y);
    }
    public void start(int x,int y){
        if(!safe(x,y)&&step!=64) return;
        if(step==64&&!stop){
            stop=true;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    out.printf("%2d ",board[i][j]);
                }
                out.println();
            }
            out.println();
        }
        if(!stop){
            step+=1;
            board[y][x]=step;
            int[] order=min(x, y);
            for(int i=0;i<8;i++) {
                start(x+dir1[order[i]],y+dir2[order[i]]);
            }
            step-=1;
            board[y][x]=0;
        }
    }
    private boolean safe(int x,int y){
        if(x<0||x>7||y<0||y>7) return false;
        return board[y][x] == 0;
    }
    public int[] min(int x,int y){
        int[] num=new int[8];
        int[] order=new int[8];
        for(int i=0;i<8;i++){
            if(safe(x+dir1[i],y+dir2[i])) num[i]=roadNum(x+dir1[i],y+dir2[i]);
        }
        int j=0,min=9;
        while(true){
            for(int i=0;i<8;i++){
                if(num[i]<=min){
                    min=num[i];
                }
            }
            if(min==9) break;
            for(int i=0;i<8;i++){
                if(num[i]==min){
                    order[j++]=i;
                    num[i]=9;
                }
                if(j==8) break;
            }
            min=9;
        }
        return order;
    }
    private int roadNum(int x,int y){
        int num=0;
        for(int i=0;i<8;i++){
            if(safe(x+dir1[i],y+dir2[i])) num++;
        }
        return num;
    }
}