package lt.viko.eif.asinkevic.Service;

import lt.viko.eif.asinkevic.database.UzsakovasRepository;
import lt.viko.eif.asinkevic.model.Uzsakovas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzsakovasService {
    @Autowired
    private UzsakovasRepository uzsakovasRepository;

    public List<Uzsakovas> getAllUzsakovai() {
        return uzsakovasRepository.findAll();
    }

    public void deleteUzsakovasById(Long id) {
        uzsakovasRepository.deleteById(id);
    }

    public Uzsakovas updateUzsakovas(Long id, String firstName, String lastName, String telefonoNumeris) {
        Uzsakovas uzsakovas = uzsakovasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
        if (firstName != null) {
            uzsakovas.setFirstname(firstName);
        }
        if (lastName != null) {
            uzsakovas.setLastname(lastName);
        }
        if (telefonoNumeris != null) {
            uzsakovas.setTelefonoNumeris(telefonoNumeris);
        }
        uzsakovasRepository.save(uzsakovas);
        return uzsakovas;
    }

    public Uzsakovas newUzsakovas(String firstName, String lastName, String telefonoNumeris) {
        Uzsakovas uzsakovas = new Uzsakovas();
        uzsakovas.setFirstname(firstName);
        uzsakovas.setLastname(lastName);
        uzsakovas.setTelefonoNumeris(telefonoNumeris);
        return uzsakovasRepository.save(uzsakovas);
    }

    public List<Uzsakovas> findByFirstNameAndLastName(String firstName, String lastName) {
        return uzsakovasRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
    }

    public List<Uzsakovas> findByTelefonoNumeris(String telefonoNumeris) {
        return uzsakovasRepository.findByTelefonoNumeris(telefonoNumeris)
                .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
    }

    public List<Uzsakovas> findByFirstName(String firstName) {
        return uzsakovasRepository.findByFirstName(firstName)
                .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
    }

    public List<Uzsakovas> findByLastName(String lastName) {
        return uzsakovasRepository.findByLastName(lastName)
                .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
    }

    public Uzsakovas getUzsakovasById(Long id) {
        return uzsakovasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
    }
}
