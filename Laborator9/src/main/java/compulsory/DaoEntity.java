package compulsory;

import TableEntity.MoviesEntity;

import java.util.List;

public interface DaoEntity {
    void create(MoviesEntity movie);
    MoviesEntity findById(String id_movie);
    List<MoviesEntity> findByName(String name);
}
