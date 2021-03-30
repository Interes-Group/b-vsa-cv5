package sk.stuba.fei.uim.vsa.cv4;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.transaction.TransactionSystemException;
import sk.stuba.fei.uim.vsa.cv4.domain.Kniha;
import sk.stuba.fei.uim.vsa.cv4.repository.KnihaRepository;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class KnihaTests {

    @Autowired
    private KnihaRepository repository;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeClass");
    }

    @BeforeEach
    void before() {
        System.out.println("BeforeEach");
        repository.deleteAll();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

    @Test
    @Order(2)
    void nazovNotNull() {
        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            Kniha hobbit = new Kniha();
            hobbit.setIsbn("9780007440832");
            hobbit.setNazov(null);
            repository.save(hobbit);
        });
        assertNotNull(exception);
    }

    @Test
    @Order(1)
    void nazovNotBlank() {
        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            Kniha hobbit = new Kniha();
            hobbit.setIsbn("9780007440832");
            hobbit.setNazov("");
            repository.save(hobbit);
        });
        assertNotNull(exception);
    }

}
