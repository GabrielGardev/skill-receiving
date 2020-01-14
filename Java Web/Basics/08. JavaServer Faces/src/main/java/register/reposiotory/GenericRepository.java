package register.reposiotory;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<E, K> {

    E save(E entity);

    E findById(K id);

    List<E> findAll();

    Long size();

    void deleteById(K id);

    Long getCount();
}
