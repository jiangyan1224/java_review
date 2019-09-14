package character;

public class Hero {
    String name; //姓名

    float hp; //血量

    float armor; //护甲

    int moveSpeed; //移动速度
    public void kill(Mortal m){
        m.die();
    }
    public void self(){
        System.out.println("i m a hero");
    }
}
