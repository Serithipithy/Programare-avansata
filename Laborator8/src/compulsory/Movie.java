package compulsory;

import java.util.List;
import java.util.Optional;

public class Movie implements Dao<Movie>{
    private final int id;
    private final String title;
    private final String release_date;
    private final int duration;
    private final int score;

    public Movie(int id, String title, String release_date, int duration, int score) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.score = score;
    }

    @Override
    public Optional<Movie> get(DBConnect conn, String string) {
        return Optional.empty();
    }

    @Override
    public List<Movie> getAll(DBConnect conn) {
        return null;
    }

    @Override
    public void insert() {
        StringBuilder q = new StringBuilder();
        q.append("INSERT INTO movies VALUES(");
        q.append(this.id).append(",'").append(this.title).append("','").append(this.release_date).append("',").append(this.duration).append(",").append(this.score).append(");");
        try {
            DBConnect.executeStatement(q.toString());
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
