package car.practice1;
import java.util.Arrays;
public class ArrayList extends Object{
    private Object[] elems;
    private int next;
    private String string;
    /*實作1
    @Override
    public String toString(){
        string=(String)elems[0]+"\n";
        for (int i=1;i<next;i++){
            string+=elems[i]+"\n";
        }
        return string;
    }*/
    /* 實作2
    @Override
    public boolean equals(Object obj){
        if(size()!=((ArrayList)obj).size()){
            return false;
        }
        for(int i=0;i<size();i++){
            if(get(i).equals(((ArrayList)obj).get(i)));
            else return false;
        }
        return true;
    }*/
    public ArrayList(){
        this(16);
    }
    public ArrayList(int capacity){
        elems=new Object[capacity];
    }
    public void add(Object o){
        if(next==elems.length){
            elems=Arrays.copyOf(elems,elems.length+1);
        }
        elems[next++]=o;
    }
    public Object get(int index){
        return elems[index];
    }
    public int size(){
        return next;
    }
}
