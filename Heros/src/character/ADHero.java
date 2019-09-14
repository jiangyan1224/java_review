package character;

public class ADHero extends Hero implements AD,Mortal{

    //实现了AD接口
    //如果实现接口的类是抽象类，实现接口里的部分方法或者一个都不实现都行；如果是具体类，所有方法都要实现

    @Override
    public void physicalAttack() {
        System.out.println("进行物理攻击");
    }

    @Override
    public void die() {
        System.out.println("ADHero died!");
    }


    public void self() {
        super.self();
//        System.out.println("i am a adhero");
    }
}
