package com.app.OurMusic.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CommentEntityPK implements Serializable {
    private String username;
    private int songId;
    private String comment;

    @Column(name = "username")
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "song_id")
    @Id
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Column(name = "comment")
    @Id
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntityPK that = (CommentEntityPK) o;

        if (songId != that.songId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + songId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
