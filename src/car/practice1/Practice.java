package car.practice1;
import java.util.Locale;
import java.util.Scanner;
import static java.lang.System.*;
public class Practice {
    public static void main(String[] args){
        ArrayList names=new ArrayList();
        collectNameTo(names);
        out.println("訪客名單：");
        printUpperCase(names);
        /*實作1
        printUpperCase(names);
        out.println(names);*/
        /*實作2
        ArrayList arr1=new ArrayList();
        collectNameTo(arr1);
        ArrayList arr2=new ArrayList();
        collectNameTo(arr2);
        out.println(arr1.equals(arr2));*/
    }
     static void collectNameTo(ArrayList names){
     Scanner console=new Scanner(in);
     while (true){
         out.print("訪客名稱：");
         String name=console.nextLine();
         if(name.equals("quit")) break;
         names.add(name);
     }
    }
    static void printUpperCase(ArrayList names){
        for (int i=0;i<names.size();i++){
            String name=(String) names.get(i);
            out.println(name.toUpperCase());
        }
    }
}
