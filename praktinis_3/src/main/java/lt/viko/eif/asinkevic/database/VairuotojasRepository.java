    package lt.viko.eif.asinkevic.database;

    import lt.viko.eif.asinkevic.model.Uzsakovas;
    import lt.viko.eif.asinkevic.model.Vairuotojas;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.Optional;

    /**
     * Represents VairuotojasRepository Object that extends JpaRepository
     * This class is designated to communicate with the database
     * and perform CRUD operations on Vairuotojas objects
     */
    @Repository
    public interface VairuotojasRepository extends JpaRepository<Vairuotojas, Long> {

        // Find By First Name
        Optional<List<Vairuotojas>> findByFirstName(String firstName);

        // Find By Last Name
        Optional<List<Vairuotojas>> findByLastName(String lastName);

        //Find By Last Name And First Name
        Optional<List<Vairuotojas>> findByFirstNameAndLastName(String firstName, String lastName);

        // Find By Telefono Numeris
        Optional<List<Vairuotojas>> findByTelefonoNumeris(String telefonoNumeris);
    }

