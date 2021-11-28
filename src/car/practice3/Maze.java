package car.practice3;

public class Maze {
     private int[][] maze={
            {2,2,2,2,2,2,2},
            {0,0,0,0,0,0,2},
            {2,0,2,0,2,0,2},
            {2,0,0,2,0,2,2},
            {2,2,0,2,0,2,2},
            {2,0,0,0,0,0,2},
            {2,2,2,2,2,0,2},
    };
    private final int[][] mazeBU={
            {2,2,2,2,2,2,2},
            {0,0,0,0,0,0,2},
            {2,0,2,0,2,0,2},
            {2,0,0,2,0,2,2},
            {2,2,0,2,0,2,2},
            {2,0,0,0,0,0,2},
            {2,2,2,2,2,0,2},
    };
    private int nowPosX,nowPosY;
    private int up=1,down=2,left=3,right=4;
    public Maze(){
        nowPosX=0;
        nowPosY=1;
        maze[nowPosY][nowPosX]=1;
    }
    public void start(){
        chooseRoad();
    }
    private void chooseRoad(){
        if(nowPosY+1>=0&&maze[nowPosY+1][nowPosX]==0)
            move(up);
        if(nowPosY-1>=0&&maze[nowPosY-1][nowPosX]==0)
            move(down);
        if(nowPosX-1>=0&&maze[nowPosY][nowPosX-1]==0)
            move(left);
        if(nowPosX+1>=0&&maze[nowPosY][nowPosX+1]==0)
            move(right);
        if(maze[nowPosY+1][nowPosX]!=0&&maze[nowPosY-1][nowPosX]!=0&&maze[nowPosY][nowPosX-1]!=0&&maze[nowPosY][nowPosX+1]!=0);//如果是死路 倒推回去把路堵住
    }
    private void move(int safeRoad){
        switch (safeRoad){
            case 1:maze[++nowPosY][nowPosX]=1;
            case 2:maze[--nowPosY][nowPosX]=1;
            case 3:maze[nowPosY][--nowPosX]=1;
            case 4:maze[nowPosY][++nowPosX]=1;
        }
    }
    private void recoverMaze(){
        for(int i=0;i<7;i++){
            for (int j=0;j<7;j++){
                maze[i][j]=mazeBU[i][j];
            }
        }
    }
}
