package car.practice5;

public class Queen {
    char[][] board=new char[8][8];
    int[] check1=new int[8];
    int[] check2=new int[8];
    int count=0;
    public Queen(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                board[i][j]='.';
            }
        }
        search();
    }
    private void search(){
        search(0);
    }
    private void search(int x){
        for (int y=0;y<8;y++){
            if(safe(x, y)){
                   board[y][x]='Q';
                   check1[x]=y+x;
                   check2[x]=y-x;
                   if(x==7){
                       count++;
                       printBoard();
                       board[y][x]='.';
                       return;
                }
                search(x+1);
                board[y][x]='.';
            }
        }
    }
    private boolean safe(int x,int y){
        if(x<0||x>7||y<0||y>7)return false;
        for(int i=0;i<=x;i++){
            if(y+x==check1[i]&&board[check1[i]-i][i]=='Q')return false;
            if(y-x==check2[i]&&board[check2[i]+i][i]=='Q')return false;
        }
        for(int i=0;i<=x;i++){
            if(board[y][x-i]=='Q')return false;//左
        }
        for(int i=0;i<8-x;i++){
            if(board[y][x+i]=='Q')return false;//右
        }
        for(int i=0;i<=y;i++){
            if(board[y-i][x]=='Q')return false;//上
        }
        for(int i=0;i<8-y;i++){
            if(board[y+i][x]=='Q')return false;//下
        }
        return true;
    }
    private void printBoard(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.printf("%3c",board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
