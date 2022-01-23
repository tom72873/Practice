package car.test;
import static java.lang.System.out;
public class mapGenerate {
    public static void main(String[] args){
        generateMap A=new generateMap(20,15);
        A.generate();
        A.showMap();
    }

}
class generateMap{
    char[][] map;
    int maxStep,maxNowY,maxNowX;
    int nowX,nowY,step;
    public generateMap(int width,int height){
        maxNowY=height-1;
        maxNowX=width-1;
        maxStep=(int)Math.sqrt(width*height);
        map=new char[maxNowY+1][maxNowX+1];
        for(int i=0;i<=maxNowY;i++){
            for(int j=0;j<=maxNowX;j++){
                map[i][j]='*';
            }
        }
        chooseStart();
        map[nowY][nowX]='_';
        map[++nowY][nowX]='_';
        step=0;
    }

    public void showMap(){
        for(int i=0;i<=maxNowY;i++){
            for(int j=0;j<=maxNowX;j++){
                out.printf("%3c",map[i][j]);
            }
            out.println();
        }
        out.println();
    }
    public void chooseStart(){
        nowX=(int)(Math.random()*maxNowX)+1;
        nowY=0;
    }
    public void generate(){
        int ran;
        while(true){
            ran=(int)(Math.random()*7)+1;
            switch (ran){
                case 1:mode1();
                case 2:mode2();
                case 3:mode3();
                case 4:mode4();
                case 5:mode5();
                case 6:mode6();
                case 7:mode7();
            }
            step++;
            if(step==maxStep) while(nowY!=maxNowY) mode2();
            if(nowY==maxNowY) break;
        }
        step=1;
        for(int i=0;i<=maxNowY;i++){
            for(int j=0;j<=maxNowX;j++){
                if(ifSafe(j,i)&&i<maxNowY
                   &&map[i-1][j-1]=='_'&&map[i-1][j]=='_'&&map[i-1][j+1]=='_'
                   &&map[i][j-1]=='_'&&map[i][j]=='_'&&map[i][j+1]=='_'
                   &&map[i+1][j]=='_'&&map[i+1][j]=='_'&&map[i+1][j+1]=='_')
                {
                    map[i][j]='*';
                }
            }
        }
    }
    public boolean ifSafe(int nowX,int nowY){
        return nowX>0&&nowX<maxNowX&&nowY>0&&nowY<=maxNowY&&step!=0;
    }
    public void mode1(){
        //上一格
        if(ifSafe(nowX,nowY-1)&&nowY!=maxNowY)
        {
            step++;
            map[--nowY][nowX]='_';
        }

    }
    public void mode2(){
        //下一格
        if(ifSafe(nowX,nowY+1))
            if((nowY+1==maxNowY&&step>maxStep)||nowY!=maxNowY)
            {
                step++;
                map[++nowY][nowX] = '_';
            }
    }
    public void mode3(){
        //左一格
        if(ifSafe(nowX-1,nowY)&&nowY!=maxNowY) {
            step++;
            map[nowY][--nowX] = '_';
        }
    }
    public void mode4(){
        //右一格
        if(ifSafe(nowX+1,nowY)&&nowY!=maxNowY) {
            step++;
            map[nowY][++nowX] = '_';
        }
    }
    public void mode5(){
        //兩格
        switch ((int)(Math.random()*4)+1){
            case 1:if(ifSafe(nowX,nowY-2)){mode1();mode1();}
            case 2:if(ifSafe(nowX,nowY+2)){mode2();mode2();}
            case 3:if(ifSafe(nowX-2,nowY)){mode3();mode3();}
            case 4:if(ifSafe(nowX+2,nowY)){mode4();mode4();}
        }
    }
    public void mode6(){
        //L型
        switch ((int)(Math.random()*8)+1){
            case 1:if(ifSafe(nowX+1,nowY-2)){mode1();mode1();mode4();}
            case 2:if(ifSafe(nowX-1,nowY-2)){mode1();mode1();mode3();}
            case 3:if(ifSafe(nowX+1,nowY+2)){mode2();mode2();mode4();}
            case 4:if(ifSafe(nowX-1,nowY+2)){mode2();mode2();mode3();}
            case 5:if(ifSafe(nowX-2,nowY+1)){mode3();mode3();mode2();}
            case 6:if(ifSafe(nowX-2,nowY-1)){mode3();mode3();mode1();}
            case 7:if(ifSafe(nowX+2,nowY+1)){mode4();mode4();mode2();}
            case 8:if(ifSafe(nowX+2,nowY-1)){mode4();mode4();mode1();}
        }
    }
    public void mode7(){
        //長L型
        switch ((int)(Math.random()*8)+1){
            case 1:if(ifSafe(nowX+2,nowY-2)){mode1();mode1();mode4();mode4();}
            case 2:if(ifSafe(nowX-2,nowY-2)){mode1();mode1();mode3();mode3();}
            case 3:if(ifSafe(nowX+2,nowY+2)){mode2();mode2();mode4();mode4();}
            case 4:if(ifSafe(nowX-2,nowY+2)){mode2();mode2();mode3();mode3();}
            case 5:if(ifSafe(nowX-2,nowY+2)){mode3();mode3();mode2();mode2();}
            case 6:if(ifSafe(nowX-2,nowY-2)){mode3();mode3();mode1();mode1();}
            case 7:if(ifSafe(nowX+2,nowY+2)){mode4();mode4();mode2();mode2();}
            case 8:if(ifSafe(nowX+2,nowY-2)){mode4();mode4();mode1();mode1();}
        }
    }
}
/*條件:未到map[14][]就一直走
路途中不可經過上左右牆壁
經過下牆壁即停止
若達經過上限即強制停止模式重新選
每步抽一種模式
總步數最多10(暫定 超過10則直接往下到Y=14
* */