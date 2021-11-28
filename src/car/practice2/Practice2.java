package car.practice2;
import java.util.Scanner;
import static java.lang.System.out;
public class Practice2 {
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        Horni horni=new Horni(console.nextInt());
        out.println(horni.maxStep());
        horni.goThrough();
    }
}
