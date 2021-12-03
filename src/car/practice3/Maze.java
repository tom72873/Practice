package car.practice3;
import static java.lang.System.out;
import java.lang.StringBuilder;
public class Maze {
     public String a;
     private int[][] maze={
            {2,2,2,2,2,2,2},
            {0,0,0,0,0,0,2},
            {2,0,2,0,2,0,2},
            {2,0,0,2,0,2,2},
            {2,2,0,2,0,2,2},
            {2,0,0,0,0,0,2},
            {2,2,2,2,2,0,2},
    };
    private int[][] mazeOut={
            {2,2,2,2,2,2,2},
            {0,0,0,0,0,0,2},
            {2,0,2,0,2,0,2},
            {2,0,0,2,0,2,2},
            {2,2,0,2,0,2,2},
            {2,0,0,0,0,0,2},
            {2,2,2,2,2,0,2},
    };
    private int[][] mk=new int[7][7];
    private int up=1,down=2,left=3,right=4;
    public Maze(){
    }
    public void start(){
        dfs(0,1);
    }
    private void dfs(int nowPosX,int nowPosY){
        /*for(int i=0;i<7;i++) {
            for (int j = 0; j < 7; j++) {
                out.print(maze[i][j]);
            }
            out.println();
        }
        out.println();*/
        if(nowPosX>7||nowPosY>7)
            return;
        if(nowPosX<0||nowPosY<0||mk[nowPosY][nowPosX]!=0)
            return;
        if(maze[nowPosY][nowPosX]==2)
            return;
        if(nowPosX==5&&nowPosY==6){
            //Integer.parseInt()
            for(int i=0;i<7;i++) {
                for (int j = 0; j < 7; j++) {
                    out.print(maze[i][j]);
                }
                out.println();
            }
            return;
        }
        String temp=a;
        a+=String.valueOf(10*nowPosY+nowPosX);
        a=a.deleteCharAt(5);
        mk[nowPosY][nowPosX]=1;
        dfs(nowPosX+1,nowPosY);
        dfs(nowPosX,nowPosY+1);
        dfs(nowPosX,nowPosY-1);
        dfs(nowPosX-1,nowPosY);
        mk[nowPosY][nowPosX]=0;
        a=temp;
    }
    /*private void chooseRoad(int nowPosX,int nowPosY){

        move(1,nowPosX,nowPosY);
        move(2,nowPosX,nowPosY);
        move(3,nowPosX,nowPosY);
        move(4,nowPosX,nowPosY);

    }
    private void move(int safeRoad,int nowPosX,int nowPosY){

        maze[--nowPosY][nowPosX]=1;
        maze[nowPosY][--nowPosX]=1;
        maze[nowPosY][++nowPosX]=1;

        dfs(nowPosX,nowPosY);
    }*/
    /*private void syncMaze(){
        for(int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                mazeBU[i][j]=maze[i][j];
            }
        }
    }*/
}
