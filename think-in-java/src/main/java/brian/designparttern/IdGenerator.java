package brian.designparttern;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ID生成器
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return instance;
    }

    public Long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGenerator.getInstance().getId());
    }

}
