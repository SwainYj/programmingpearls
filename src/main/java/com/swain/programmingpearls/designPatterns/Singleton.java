package com.swain.programmingpearls.designPatterns;

/**
 * 懒汉模式：定义一个私有的静态对象instance，之所以定义instance为静态，是因为静态属性或方法是属于类的，能够很好地保障单例对象的唯一性；
 * 然后定义一个加锁的静态方法获取该对象，如果该对象为null，则定义一个对象实例并将其赋值给instance
 */
class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {}
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
/**
 * 饿汉模式： 在定义单例对象的同时将其实例化的，直接使用便可
 */
class HungrySignleton {
    private static HungrySignleton instance = new HungrySignleton();
    private HungrySignleton() {}
    public static HungrySignleton getInstance() {
        return instance;
    }
}
/**
 * 静态内部类：在类中定义一个静态内部类，将对象实例的定义和初始化放在内部类中完成，我们在获取对象时要通过静态内部类调用其单例对象。
 * 之所以这样设计，是因为类的静态内部类在JVM中是唯一的，这很好地保障了单例对象的唯一性
 */
public class Singleton {
    private static class SignletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private  Singleton() {}
    public static final Singleton getInstance() {
        return SignletonHolder.INSTANCE;
    }
}
/**
 * 双重校验锁：双锁模式指在懒汉模式的基础上做进一步优化，给静态对象的定义加上volatile锁来保障初始化时对象的唯一性，
 * 在获取对象时通过synchronized (Singleton.class)给单例类加锁来保障操作的唯一性
 */
class Lock2Singleton {
    private volatile static Lock2Singleton singleton; //对象锁
    private Lock2Singleton() {}
    public static Lock2Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) { //synchronized方法锁
                if (singleton == null) {
                    singleton = new Lock2Singleton();
                }
            }
        }
        return singleton;
    }
}