package com.app.OurMusic.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "users", schema = "public", catalog = "ourmusicapp")
@NamedQueries({
        @NamedQuery(
                name = "Users.getAllUsers",
                query = "SELECT u FROM UsersEntity u"
        ),
        @NamedQuery(
                name = "Users.findUserByName",
                query = "SELECT u FROM UsersEntity u WHERE u.username LIKE :username"
        ),
        @NamedQuery(
                name = "Users.findByNameAndPass",
                query = "SELECT u FROM UsersEntity u WHERE u.username LIKE :username AND u.password LIKE :password"
        )
})
public class UsersEntity {
    private int idUser;
    private String username;
    private String password;
    private static Random rand = new Random();

    public UsersEntity() {
        this.idUser = rand.nextInt();
    }

    public UsersEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Basic
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

}
