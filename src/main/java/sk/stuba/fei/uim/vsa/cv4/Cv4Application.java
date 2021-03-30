package sk.stuba.fei.uim.vsa.cv4;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.stuba.fei.uim.vsa.cv4.domain.*;
import sk.stuba.fei.uim.vsa.cv4.repository.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Cv4Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Cv4Application.class, args);
    }

    @Autowired
    private KnihaRepository knihaRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private VydavatelRepository vydavatelRepository;

    @Override
    public void run(String... args) throws Exception {
//        Vydavatel unwin = new Vydavatel();
//        unwin.setNazov("George Allen & Unwin");
//        unwin = vydavatelRepository.save(unwin);
//
//        Autor tolkien = new Autor();
//        tolkien.setMeno("J.R.R. Tolkien");
//        autorRepository.save(tolkien);
//
//        Kniha hobbit = new Kniha();
//        hobbit.setIsbn("9780007440832");
//        hobbit.setNazov("The Hobbit");
//        hobbit.setVydavatel(unwin);
//        hobbit.setAutori(Collections.singleton(tolkien));
//        knihaRepository.save(hobbit);
//
////        tolkien.setKnihy(Collections.singleton(hobbit));
////        tolkien = autorRepository.save(tolkien);
//
////        List<Kniha> knihy = knihaRepository.findAll();
////        for (Kniha kniha : knihy) {
////            System.out.println(kniha);
////        }
//
//        hobbit = knihaRepository.findAll().stream().findFirst().get();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            hobbit.setVydavatel(null);
//            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(hobbit);
//            System.out.println(json);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        Student student = new Student();
        student.setName("Student");
        student = studentRepository.save(student);

        Course course = new Course();
        course.setName("VSA");
        course = courseRepository.save(course);

        CourseRegistration registration = new CourseRegistration();
        registration.setDate(LocalDate.now());
        registration.setStudent(student);
        registration.setCourse(course);

        registration = courseRegistrationRepository.save(registration);
    }

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

}
