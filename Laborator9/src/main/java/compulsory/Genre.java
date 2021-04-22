package compulsory;

import java.util.List;
import java.util.Optional;

public class Genre implements Dao<Genre>{
    private final int id;
    private final String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Optional<Genre> get(DBconnect conn, String string) {
        return Optional.empty();
    }

    @Override
    public List<Genre> getAll(DBconnect conn) {
        return null;
    }

    @Override
    public void insert() {
        StringBuilder q = new StringBuilder();
        q.append("INSERT INTO genres VALUES(");
        q.append(this.id).append(",'").append(this.name).append(");");
        try {
            DBconnect.executeStatement(q.toString());
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Override
    public void findIndex() {

    }

    @Override
    public void findByName() {

    }
}