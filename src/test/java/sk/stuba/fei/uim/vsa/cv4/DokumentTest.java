package sk.stuba.fei.uim.vsa.cv4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.stuba.fei.uim.vsa.cv4.domain.Dokument;
import sk.stuba.fei.uim.vsa.cv4.repository.DokumentRepository;

@SpringBootTest
public class DokumentTest {

    private final DokumentRepository repository;

    @Autowired
    public DokumentTest(DokumentRepository repository) {
        this.repository = repository;
    }

    @Test
    void test() {
        Dokument main = new Dokument("main");
        main = repository.save(main);

        for (int i = 0; i < 3; i++) {
            Dokument sub = new Dokument("sub_" + i);
            main.pridajPodkapitolu(sub);
            for (int j = 0; j < 3; j++) {
                sub.pridajPodkapitolu(new Dokument("sub_" + i + "_sub_" + j));
            }
        }
        main = repository.save(main);

        assert main.getPodkapitoly().size() == 3;
        assert repository.count() == 13;

        Dokument dokument = main.getPodkapitoly().stream().findFirst().get();
        main.getPodkapitoly().remove(dokument);
        repository.save(main);
        repository.delete(dokument);

        assert repository.count() == 9;
    }
}
