package lt.viko.eif.asinkevic.Service;

import lt.viko.eif.asinkevic.database.AutobusasRepository;
import lt.viko.eif.asinkevic.model.Autobusas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutobusasService {

    @Autowired
    private AutobusasRepository autobusasRepository;

    public List<Autobusas> getAllAutobusai() {
        return autobusasRepository.findAll();
    }

    public void deleteAutobusasById(Long id) {
        autobusasRepository.deleteById(id);
    }

    public Autobusas updateAutobusas(Long id, String spalva, String valstybinisNumeris, Integer vietuSkaicius) {
        Autobusas autobusas = autobusasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autobusas not found"));
        if (spalva != null) {
            autobusas.setSpalva(spalva);
        }
        if (valstybinisNumeris != null) {
            autobusas.setValstybinisNumeris(valstybinisNumeris);
        }
        if (vietuSkaicius != null) {
            autobusas.setVietuSkaicius(vietuSkaicius);
        }
        autobusasRepository.save(autobusas);
        return autobusas;
    }

    public Autobusas getAutobusasById(Long id) {
        return autobusasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autobusas not found"));
    }

    public Autobusas newAutobusas(String spalva, String valstybinisNumeris, int vietuSkaicius) {
        Autobusas autobusas = new Autobusas();
        autobusas.setSpalva(spalva);
        autobusas.setValstybinisNumeris(valstybinisNumeris);
        autobusas.setVietuSkaicius(vietuSkaicius);
        return autobusasRepository.save(autobusas);
    }

    public List<Autobusas> findBySpalva(String spalva) {
        return autobusasRepository.findBySpalva(spalva)
                .orElseThrow(() -> new RuntimeException("Autobusas not found"));
    }

    public List<Autobusas> findByValstybinisNumeris(String valstybinisNumeris) {
        return autobusasRepository.findByValstybinisNumeris(valstybinisNumeris)
                .orElseThrow(() -> new RuntimeException("Autobusas not found"));
    }

    public List<Autobusas> findByVietuSkaicius(Integer vietuSkaicius) {
        return autobusasRepository.findByVietuSkaicius(vietuSkaicius)
                .orElseThrow(() -> new RuntimeException("Autobusas not found"));
    }
}
