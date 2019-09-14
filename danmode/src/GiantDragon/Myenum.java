package GiantDragon;
//枚举类型，enum本身即就是一种类
//枚举类型一般用来定义常量，常量一般全大写
enum GiantDragon {
    TANK ,
    WIZARD ,
    ASSASSIN,
    ASSIST,
    WARRIOR,
    RANGED,
    PUSH,
    FARMING
}
public class Myenum {
    public static void main(String[] args){
        //枚举类型的values方法可以把枚举类型转换为数组
        for(GiantDragon giantDragon:GiantDragon.values()){
            System.out.println(giantDragon);
        }
        GiantDragon giantDragon=GiantDragon.ASSASSIN;
        switch (giantDragon){
            case PUSH:
                System.out.println("PUSH");break;
            case ASSASSIN:
                System.out.println("ASSASSIN");break;
        }
    }
}
