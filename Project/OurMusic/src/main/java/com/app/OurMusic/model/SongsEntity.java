package com.app.OurMusic.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "songs", schema = "public", catalog = "ourmusicapp")
@IdClass(SongsEntityPK.class)
@NamedQueries({
        @NamedQuery(
                name = "Songs.getTopSongs",
                query = "SELECT s FROM SongsEntity s ORDER BY s.numberVotes DESC "
        ),
        @NamedQuery(
                name = "Songs.deleteByTitle",
                query = "DELETE FROM SongsEntity s WHERE s.title = :title"
        ),
        @NamedQuery(
                name = "Songs.deleteById",
                query = "DELETE FROM SongsEntity s WHERE s.idSong = :id_song"
        ),
        @NamedQuery(
                name = "Songs.updateSongVotes",
                query = "UPDATE SongsEntity  s SET s.numberVotes = s.numberVotes + 1 WHERE s.idSong = :id"
        ),
        @NamedQuery(
                name = "Songs.getSongsById",
                query = "SELECT s FROM SongsEntity s WHERE s.idSong = :id "
        )
})
public class SongsEntity {
    private Integer idSong;
    private String singer;
    private String title;
    private String link;
    private Integer numberVotes = 0;

    private static Random rand = new Random();

    public SongsEntity() {
        this.idSong = rand.nextInt(1000);
    }

    public SongsEntity(String singer, String title, String link) {
        this.singer = singer;
        this.title = title;
        this.link = link;
    }

    @Basic
    @Column(name = "id_song")
    public Integer getIdSong() {
        return idSong;
    }

    public void setIdSong(Integer idSong) {
        this.idSong = idSong;
    }

    @Id
    @Column(name = "singer")
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Id
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "number_votes")
    public Integer getNumberVotes() {
        return numberVotes;
    }

    public void setNumberVotes(Integer numberVotes) {
        this.numberVotes = numberVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongsEntity that = (SongsEntity) o;

        if (idSong != null ? !idSong.equals(that.idSong) : that.idSong != null) return false;
        if (singer != null ? !singer.equals(that.singer) : that.singer != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (numberVotes != null ? !numberVotes.equals(that.numberVotes) : that.numberVotes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSong != null ? idSong.hashCode() : 0;
        result = 31 * result + (singer != null ? singer.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (numberVotes != null ? numberVotes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SongsEntity{" +
                "singer='" + singer + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", numberVotes=" + numberVotes +
                '}';
    }
}
