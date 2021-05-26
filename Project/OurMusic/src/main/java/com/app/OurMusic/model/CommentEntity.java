package com.app.OurMusic.model;

import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "public", catalog = "ourmusicapp")
@IdClass(CommentEntityPK.class)
@NamedQueries({
        @NamedQuery(
                name = "Comment.getCommentForSong",
                query = "SELECT c FROM CommentEntity c WHERE c.songId = :songId"
        )
})
public class CommentEntity {
    private String username;
    private int songId;
    private String comment;

    public CommentEntity() {
    }

    public CommentEntity(String username, int songId, String comment) {
        this.username = username;
        this.songId = songId;
        this.comment = comment;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "song_id")
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Id
    @Column(name = "comment")
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

        CommentEntity that = (CommentEntity) o;

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
