package brian.designparttern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举类型的单例
 */
public enum EnumIdGenerator {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

}
