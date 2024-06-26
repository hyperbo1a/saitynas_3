package lt.viko.eif.asinkevic.Service;

import lt.viko.eif.asinkevic.database.VairuotojasRepository;
import lt.viko.eif.asinkevic.model.Vairuotojas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class VairuotojasService {

        @Autowired
        private VairuotojasRepository vairuotojasRepository;

        public List<Vairuotojas> getAllVairuotojai() {
            return vairuotojasRepository.findAll();
        }

        public void deleteVairuotojasById(Long id) {
            vairuotojasRepository.deleteById(id);
        }

        public Vairuotojas updateVairuotojas(Long id, String firstname, String lastname, String telefonoNumeris) {
            Vairuotojas vairuotojas = vairuotojasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
            if (firstname != null) {
                vairuotojas.setFirstname(firstname);
            }
            if (lastname != null) {
                vairuotojas.setLastname(lastname);
            }
            if (telefonoNumeris != null) {
                vairuotojas.setTelefonoNumeris(telefonoNumeris);
            }
            vairuotojasRepository.save(vairuotojas);
            return vairuotojas;
        }

        public Vairuotojas getVairuotojasById(Long id) {
            return vairuotojasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
        }

        public Vairuotojas newVairuotojas(String firstname, String lastname, String telefonoNumeris) {
            Vairuotojas vairuotojas = new Vairuotojas();
            vairuotojas.setFirstname(firstname);
            vairuotojas.setLastname(lastname);
            vairuotojas.setTelefonoNumeris(telefonoNumeris);
            return vairuotojasRepository.save(vairuotojas);
        }

        public List<Vairuotojas> findByFirstNameAndLastName(String firstname, String lastname) {
            return vairuotojasRepository.findByFirstNameAndLastName(firstname, lastname)
                    .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
        }

        public List<Vairuotojas> findByTelefonoNumeris(String telefononumeris) {
            return vairuotojasRepository.findByTelefonoNumeris(telefononumeris)
                    .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
        }

        public List<Vairuotojas> findByFirstName(String firstname) {
            return vairuotojasRepository.findByFirstName(firstname)
                    .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
        }

        public List<Vairuotojas> findByLastName(String lastname) {
            return vairuotojasRepository.findByLastName(lastname)
                    .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
        }
    }



