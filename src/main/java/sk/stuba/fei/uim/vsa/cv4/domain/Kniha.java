package sk.stuba.fei.uim.vsa.cv4.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Kniha {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String nazov;
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @ManyToOne(optional = false)
    private Vydavatel vydavatel;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Autor> autori;

    @Override
    public String toString() {
        return "Kniha{" +
                "nazov='" + nazov + '\'' +
                ", vydavatel=" + vydavatel.getNazov() +
                '}';
    }
}
