package com.app.OurMusic.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GenreEntityPK implements Serializable {
    private String name;
    private int songId;

    @Column(name = "name")
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "song_id")
    @Id
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

        GenreEntityPK that = (GenreEntityPK) o;

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
