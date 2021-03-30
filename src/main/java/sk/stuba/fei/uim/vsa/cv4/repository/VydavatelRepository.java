package sk.stuba.fei.uim.vsa.cv4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.vsa.cv4.domain.Vydavatel;

@Repository
public interface VydavatelRepository extends JpaRepository<Vydavatel, Long> {
}
