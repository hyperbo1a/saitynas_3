package lt.viko.eif.asinkevic.database;

import lt.viko.eif.asinkevic.model.Uzsakovas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents UzsakovasRepository Object that extends JpaRepository
 * This class is designated to communicate with the database
 * and perform CRUD operations on Uzsakovas objects
 */
@Repository
public interface UzsakovasRepository extends JpaRepository<Uzsakovas, Long> {

    // Find By First Name
    Optional<List<Uzsakovas>> findByFirstName(String firstName);

    // Find By Last Name
    Optional<List<Uzsakovas>> findByLastName(String lastName);

    //Find By Last Name And First Name
    Optional<List<Uzsakovas>> findByFirstNameAndLastName(String firstName, String lastName);

    // Find By Telefono Numeris
    Optional<List<Uzsakovas>> findByTelefonoNumeris(String telefonoNumeris);
}

