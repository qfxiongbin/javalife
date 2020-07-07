package brian.designparttern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ID生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);
    //饿汉式
//    private static final IdGenerator instance = new IdGenerator();
    private static IdGenerator instance;

    private IdGenerator() {}

//    public static IdGenerator getInstance() {
//        return instance;
//    }

    //懒汉式
//    public static synchronized IdGenerator getInstance() {
//        if(instance == null) {
//            instance = new IdGenerator();
//        }
//        return instance;
//    }
//
//    /**
//     * 双重检测
//     * @return
//     */
//    public static IdGenerator getInstance() {
//        if (instance == null) {
//            synchronized (IdGenerator.class){
//                if(instance == null) {
//                    instance = new IdGenerator();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder{
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public Long getId() {
        return SingletonHolder.instance.id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(EnumIdGenerator.INSTANCE.getId());
    }

}
