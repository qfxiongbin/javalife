package brian.designparttern.service;

import brian.designparttern.IdGeneratorDistributed;

public interface ShareObjectStorage {

    public void save(Object o1,Object o2);
    public IdGeneratorDistributed load(Class classz);

}
