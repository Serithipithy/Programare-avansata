package compulsory;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(DBconnect conn, String string);

    List<T> getAll(DBconnect conn);

    void insert();

    void findIndex();

    void findByName();

}