package car.practice4;
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
        if(x<0||x>7||y<0||y>7) return;
        if(board[y][x]!=0) return;
        if(step==64){
            stop=true;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    out.printf("%2d ",board[i][j]);
                }
                out.println();
            }
        }
        /*if(step==53){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    out.printf("%2d ",board[i][j]);
                }
                out.println();
            }
        }*/
        if(stop==false){
            step+=1;
            board[y][x]=step;
            //out.println(step);
            start(x+dir1[1],y-2);
            step-=1;
            board[y][x]=0;
        }
    }
    private int min(){
        return 0;
    }
}