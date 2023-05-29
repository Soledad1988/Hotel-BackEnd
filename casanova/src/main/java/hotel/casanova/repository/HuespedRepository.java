package hotel.casanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.casanova.model.Huesped;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Integer>{

}
