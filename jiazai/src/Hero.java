public class Hero {
    protected String company="LOL";
    private static String HP;
    {
//        company="暴雪";
        System.out.println("父类的普通代码块");
    }
    private String name="父类名字";
    static {
//        company="暴雪";
        System.out.println("父类的静态代码块");
    }

    public static void jingtaifu(){
        System.out.println("父类的静态方法");
    }
    public void duixiangfu(){
        System.out.println("父类的普通方法");
    }
    Hero(){
        System.out.println("父类的构造方法");
    }

}
class ADHero extends Hero{
    protected String company="子LOL";
    private static int HP;
    private String name="子类名字";
    static {
//        company="子暴雪";
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类普通代码块");
    }
    public static void jingtaifu(){
        System.out.println("子类静态方法");
    }
    public void duixiangzi(){
        System.out.println("子类普通方法");
    }
    ADHero(){
        System.out.println("子类构造方法");
    }
    public static void main(String[] args){
        ADHero adHero=new ADHero();
        System.out.println(adHero.company);//子暴雪
        Hero hero=new Hero();
        System.out.println(hero.company);//暴雪
        Hero hero1=new ADHero();
        System.out.println(hero1.company);

        adHero.jingtaifu();//子
        hero.jingtaifu();//父
        hero1.jingtaifu();//子
    }
}
