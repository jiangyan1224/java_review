public class GiantDragon {
    //构造函数私有化，外界无法通过new新建对象
//    private GiantDragon(){}

    //1。饿汉式单例模式：不管外界是否调用了getInstance方法，式中都已经有一个对象存在
    //static类型指向一个实例化对象，因为是类类型，所以只有一个
//    public static GiantDragon instance=new GiantDragon();
//    public static GiantDragon getInstance(){
//        return instance;
//    }

    //2.懒汉式单例模式：准备一个类属性，但是先设置为null；调用方法时，如果属性指向为空，再创建对象
//    public static GiantDragon instance;
//    public static GiantDragon getInstance(){
//        if(instance==null) instance=new GiantDragon();
//        return instance;
//    }
}
