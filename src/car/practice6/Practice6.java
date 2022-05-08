package car.practice6;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
public class Practice6 {
    public static void main(String[] args){
        Frame logo = new Frame("片頭 LOGO");

        Playlist playlist1 = new Playlist();
        playlist1.add(new Frame("Duke 左揮手"))
                .add(new Frame("Duke 右揮手"));

        Playlist playlist2 = new Playlist();
        playlist2.add(new Frame("Duke 走左腳"))
                .add(new Frame("Duke 走右腳"));

        Playlist all = new Playlist();
        all.add(logo)
                .add(playlist1)
                .add(playlist2)
                .play();
    }
}
interface Material{
    void play();
}
class Frame implements Material{
    private String image;
    Frame(String image){
        this.image=image;
    }
    public void play(){
        out.println("播放："+image);
    }
}
class Playlist implements Material{
    List<Material> playList=new ArrayList<Material>();
    public Playlist(){
    }
    public Playlist add(Material material){
        playList.add(material);
        return this;
    }
    public void play(){
        for(Object material : playList) {
            ((Material) material).play();
        }
    }
}