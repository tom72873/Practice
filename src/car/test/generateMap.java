package car.test;
import static java.lang.System.out;
public class generateMap {
    public static void main(String[] args){
        char[][] map=new char[15][15];
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                map[i][j]='1';
            }
        }
        chooseStart(map);
        showMap(map);
    }
    private static void showMap(char[][] map){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                out.printf("%c ",map[i][j]);
            }
            out.println();
        }
    }
    private static char[][] chooseStart(char[][] map){
        int A;
        A=(int)(Math.random()*14)+1;
        map[0][A]='0';
        return map;
    }
}
/*條件:未到map[14][]就一直走
路途中不可經過上牆壁
經過下牆壁即停止
左右牆壁最多經過三次
若達經過上限即強制停止模式重新選
每步抽一種模式
總步數最多10(暫定
模式1:直走三格
模式2:往前(左右)轉彎(共三格
模式3:橫走三格
456為123的倒著走版本
第一步固定不走模式1

* */