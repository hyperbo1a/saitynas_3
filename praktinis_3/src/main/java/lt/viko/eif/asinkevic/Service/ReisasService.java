package lt.viko.eif.asinkevic.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import lt.viko.eif.asinkevic.database.ReisasRepository;
import lt.viko.eif.asinkevic.database.AutobusasRepository;
import lt.viko.eif.asinkevic.database.UzsakovasRepository;
import lt.viko.eif.asinkevic.database.VairuotojasRepository;
import lt.viko.eif.asinkevic.model.Reisas;
import lt.viko.eif.asinkevic.model.Autobusas;
import lt.viko.eif.asinkevic.model.Uzsakovas;
import lt.viko.eif.asinkevic.model.Vairuotojas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ReisasService {

        @Autowired
        private ReisasRepository reisasRepository;

        @Autowired
        private AutobusasRepository autobusasRepository;

        @Autowired
        private UzsakovasRepository uzsakovasRepository;

        @Autowired
        private VairuotojasRepository vairuotojasRepository;

        @Autowired
        private EntityManager entityManager;

        public List<Reisas> getAllReisai() {
            return reisasRepository.findAll();
        }

        public void deleteReisasById(Long id) {
            reisasRepository.deleteById(id);
        }

        @Transactional
        public Reisas insertReisas(Long autobusasId, Long uzsakovasId, Long vairuotojasId, String adresas) throws Exception {
            try {
                Uzsakovas uzsakovas = uzsakovasRepository.findById(uzsakovasId)
                        .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
                Autobusas autobusas = autobusasRepository.findById(autobusasId)
                        .orElseThrow(() -> new RuntimeException("Autobusas not found"));
                Vairuotojas vairuotojas = vairuotojasRepository.findById(vairuotojasId)
                        .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
                Reisas reisas = new Reisas();
                reisas.setAdresas(adresas);  // Set the address
                reisas.setUzsakovas(uzsakovas);
                reisas.setAutobusas(autobusas);
                reisas.setVairuotojas(vairuotojas);
                return reisasRepository.save(reisas);
            } catch (Exception e) {
                throw new Exception(e.getMessage(), e);
            }
        }

        public Reisas getReisasById(Long id) {
            return reisasRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        @Transactional
        @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "false")})
        public void updateReisas(Long id, Long autobusasId, Long uzsakovasId, Long vairuotojasId, String adresas) throws Exception {
            Reisas updateReisas = getReisasById(id);
            entityManager.refresh(updateReisas);

            Uzsakovas uzsakovas = null;
            Autobusas autobusas = null;
            Vairuotojas vairuotojas = null;

            if (uzsakovasId != null) {
                uzsakovas = uzsakovasRepository.findById(uzsakovasId)
                        .orElseThrow(() -> new RuntimeException("Uzsakovas not found"));
                entityManager.refresh(uzsakovas);
            }
            if (autobusasId != null) {
                autobusas = autobusasRepository.findById(autobusasId)
                        .orElseThrow(() -> new RuntimeException("Autobusas not found"));
                entityManager.refresh(autobusas);
            }
            if (vairuotojasId != null) {
                vairuotojas = vairuotojasRepository.findById(vairuotojasId)
                        .orElseThrow(() -> new RuntimeException("Vairuotojas not found"));
                entityManager.refresh(vairuotojas);
            }

            if (adresas != null) {
                updateReisas.setAdresas(adresas);
            }
            if (uzsakovas != null) {
                updateReisas.setUzsakovas(uzsakovas);
            }
            if (autobusas != null) {
                updateReisas.setAutobusas(autobusas);
            }
            if (vairuotojas != null) {
                updateReisas.setVairuotojas(vairuotojas);
            }

            reisasRepository.save(updateReisas);
        }

        public List<Reisas> findByAutobusasValstybinisNumeris(String valstybinisNumeris) {
            return reisasRepository.findByAutobusasValstybinisNumeris(valstybinisNumeris)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        public List<Reisas> findByUzsakovas(String firstName, String lastName) {
            return reisasRepository.findByUzsakovasFirstNameAndLastName(firstName, lastName)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        public List<Reisas> findByUzsakovasFirstName(String firstName) {
            return reisasRepository.findByUzsakovasFirstName(firstName)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        public List<Reisas> findByUzsakovasLastName(String lastName) {
            return reisasRepository.findByUzsakovasLastName(lastName)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        public List<Reisas> findByVairuotojas(String firstName, String lastName) {
            return reisasRepository.findByVairuotojasFirstNameAndLastName(firstName, lastName)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        public List<Reisas> findByVairuotojasFirstName(String firstName) {
            return reisasRepository.findByVairuotojasFirstName(firstName)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

        public List<Reisas> findByVairuotojasLastName(String lastName) {
            return reisasRepository.findByVairuotojasLastName(lastName)
                    .orElseThrow(() -> new RuntimeException("Reisas not found"));
        }

    }

