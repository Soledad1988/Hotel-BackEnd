package hotel.casanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.casanova.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{


}
