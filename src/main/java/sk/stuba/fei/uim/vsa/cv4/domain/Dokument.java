package sk.stuba.fei.uim.vsa.cv4.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dokument {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nazov;
    private String text;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dokument")
    private Set<Dokument> podkapitoly;
    @ManyToOne(fetch = FetchType.EAGER)
    private Dokument dokument;

    public Dokument(String nazov) {
        this.nazov = nazov;
        this.podkapitoly = new HashSet<>();
    }

    public boolean pridajPodkapitolu(Dokument podkapitola) {
        if (!podkapitoly.add(podkapitola)) {
            return false;
        }
        podkapitola.setDokument(this);
        return true;
    }
}
