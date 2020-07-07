package brian.designparttern;

import brian.designparttern.service.ShareObjectStorage;
import brian.designparttern.service.impl.FileShareObjectStorage;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorDistributed {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorDistributed instance;
    private static ShareObjectStorage storage = new FileShareObjectStorage();
    private static DistributedLock lock = new DistributedLock();
    private IdGeneratorDistributed() {}

    public synchronized static IdGeneratorDistributed getInstance() {
        if(instance != null) {
            lock.lock();
            instance = storage.load(IdGeneratorDistributed.class);
        }
        return instance;
    }

    public synchronized void freeInstance() {
        storage.save(this, IdGeneratorDistributed.class);
        instance = null;
        lock.unlock();
    }

}
