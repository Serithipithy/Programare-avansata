package com.app.OurMusic.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SongsEntityPK implements Serializable {
    private String singer;
    private String title;

    @Column(name = "singer")
    @Id
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Column(name = "title")
    @Id
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongsEntityPK that = (SongsEntityPK) o;

        if (singer != null ? !singer.equals(that.singer) : that.singer != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = singer != null ? singer.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
