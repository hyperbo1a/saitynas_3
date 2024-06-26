package lt.viko.eif.asinkevic.database;

import lt.viko.eif.asinkevic.model.Reisas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents ReisasRepository object that extends JpaRepository
 * This class is designated to communicate with the database and perform CRUD operations on Reisas objects
 */
@Repository
public interface ReisasRepository extends JpaRepository<Reisas, Long> {


    // Find Reisas by Uzsakovas first name and last name
    @Query("SELECT r FROM Reisas r JOIN r.uzsakovas u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    Optional<List<Reisas>> findByUzsakovasFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // Find Reisas by Vairuotojas first name and last name
    @Query("SELECT r FROM Reisas r JOIN r.vairuotojas v WHERE v.firstName = :firstName AND v.lastName = :lastName")
    Optional<List<Reisas>> findByVairuotojasFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // Find Reisas by Autobusas license plate
    @Query("SELECT r FROM Reisas r JOIN r.autobusas a WHERE a.valstybinisNumeris = :valstybinisNumeris")
    Optional<List<Reisas>> findByAutobusasValstybinisNumeris(@Param("valstybinisNumeris") String valstybinisNumeris);


    // Find Reisas by Uzsakovas first name
    @Query("SELECT r FROM Reisas r JOIN r.uzsakovas u WHERE u.firstName = :firstName")
    Optional<List<Reisas>> findByUzsakovasFirstName(@Param("firstName") String firstName);

    // Find Reisas by Uzsakovas last name
    @Query("SELECT r FROM Reisas r JOIN r.uzsakovas u WHERE u.lastName = :lastName")
    Optional<List<Reisas>> findByUzsakovasLastName(@Param("lastName") String lastName);

    // Find Reisas by Vairuotojas last name
    @Query("SELECT r FROM Reisas r JOIN r.vairuotojas u WHERE u.lastName = :lastName")
    Optional<List<Reisas>> findByVairuotojasLastName(@Param("lastName") String lastName);

    // Find Reisas by vairuotojas first name
    @Query("SELECT r FROM Reisas r JOIN r.vairuotojas u WHERE u.firstName = :firstName")
    Optional<List<Reisas>> findByVairuotojasFirstName(@Param("firstName") String firstName);

}







