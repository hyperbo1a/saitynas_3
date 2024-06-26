package lt.viko.eif.asinkevic.model;



import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.util.List;

/**
 * Generic model class wrapper for marshalling
 */
@XmlRootElement(name = "ReisasList")
@XmlSeeAlso({Reisas.class, Vairuotojas.class, Uzsakovas.class, Autobusas.class})
public class GenericList<T> {
    private List<T> Data;

    public GenericList() {
    }

    @XmlAnyElement(lax = true)
    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> Data) {
        this.Data = Data;
    }
}
