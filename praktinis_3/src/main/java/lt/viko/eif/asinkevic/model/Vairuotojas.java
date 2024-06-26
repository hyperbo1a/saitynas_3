package lt.viko.eif.asinkevic.model;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.*;

/**
 * Public Vairuotojas Model class
 */
@XmlRootElement(name="Vairuotojas")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"id","firstname","lastname","telefonoNumeris"})
@Entity
@DiscriminatorColumn(name = "vairuotojas")
public class Vairuotojas extends Naudotojas {

    private String telefonoNumeris;

    public Vairuotojas(String firstname, String lastname, String telefonoNumeris)
    {
        setFirstname(firstname);
        setLastname(lastname);
        this.telefonoNumeris = telefonoNumeris;
    }

    public Vairuotojas() {

    }
    @Override
    public String toString() {
        return String.format("\n" +
                        "\t\t\tVardas:   %s \n" +
                        "\t\t\tPavarde:    %s \n" +
                        "\t\t\tTelefono numeris: %s  \n",
                getFirstname(),getLastname(),this.telefonoNumeris);
    }
    @XmlElement(name="telefonoNumeris")
    public String getTelefonoNumeris() {
        return telefonoNumeris;
    }
    public void setTelefonoNumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }
}
