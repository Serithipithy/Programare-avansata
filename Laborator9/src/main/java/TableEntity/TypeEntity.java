package TableEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TYPE", schema = "main")
public class TypeEntity {
    private Long id;
    private Object idGenre;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_GENRE")
    public Object getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Object idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

        return Objects.equals(idGenre, that.idGenre);
    }

    @Override
    public int hashCode() {
        return idGenre != null ? idGenre.hashCode() : 0;
    }
}
