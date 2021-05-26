package com.app.OurMusic.model;

import javax.persistence.*;

@Entity
@Table(name = "genre", schema = "public", catalog = "ourmusicapp")
@IdClass(GenreEntityPK.class)
@NamedQueries({
        @NamedQuery(
                name = "Genre.getTopSongsGenre",
                query = "SELECT s FROM SongsEntity s JOIN GenreEntity g on s.idSong=g.songId WHERE g.name = :name ORDER BY s.numberVotes DESC"
        )
})
public class GenreEntity {
    private String name;
    private int songId;

    public GenreEntity() {
    }

    public GenreEntity(String name, int songId) {
        this.name = name;
        this.songId = songId;
    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "song_id")
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (songId != that.songId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + songId;
        return result;
    }
}
