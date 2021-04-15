package compulsory;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(DBConnect conn, String string);

    List<T> getAll(DBConnect conn);

    void insert();

    void findIndex();

    void findByName();

}
