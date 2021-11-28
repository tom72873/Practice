package car.practice2;
import static java.lang.System.out;
public class Horni {
    private int num=3;
    private int[][] horni=new int[3][];
    private int pillar,next=1,count=0;
    public Horni(){
        /*for(int i=0,j=1;i<num;i++,j++){
            horni[1]=new int[this.num];
            horni[1][i]=j;;
        }*/
    }
    public Horni(int num){
        this.num=num;
        /*for (int o=0;o<3;o++){
            for(int i=0,j=1;i<num;i++,j++){
                horni[o]=new int[this.num];
                if(o==0) horni[o][i]=j;
            }
        }*/
    }
    public int maxStep(){
        return maxStep(num);
    }
    private int maxStep(int num){
        if(num==1) return 1;
        return 2*maxStep(num-1)+1;
    }
    private void goThrough(int n,char A,char B,char C){
        if(n==1){
            out.println(n+"號盤子由"+A+"移動到"+C);
        }
        else{
            goThrough(n-1,A,C,B);
            out.println(n+"號盤子由"+A+"移動到"+C);
            goThrough(n-1,B,A,C);
        }
    }
    public void goThrough(){
        goThrough(num,'A','B','C');
    }
}
