package lt.viko.eif.asinkevic.database;

import lt.viko.eif.asinkevic.model.Autobusas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents AutobusasRepository Object that extends JpaRepository
 * This class is designated to communicate with the database
 * and perform CRUD operations on Autobusas objects
 */
@Repository
public interface AutobusasRepository extends JpaRepository<Autobusas, Long> {

    // Find By Spalva
    Optional<List<Autobusas>> findBySpalva(String spalva);

    // Find By Valstybinis Numeris
    Optional<List<Autobusas>> findByValstybinisNumeris(String valstybinisNumeris);

    // Find By Vietu Skaicius
    Optional<List<Autobusas>> findByVietuSkaicius(Integer vietuSkaicius);
}

