package lt.viko.eif.asinkevic.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.*;


/**
 * Public Uzsakovas Model class
 */
@XmlRootElement(name="Uzsakovas")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"id","firstname","lastname","telefonoNumeris"})
@Entity
@DiscriminatorColumn(name = "uzsakovas")
public class Uzsakovas extends Naudotojas {

    private String telefonoNumeris;
    public Uzsakovas(String firstname,String lastname,String telefonoNumeris)
    {
        setFirstname(firstname);
        setLastname(lastname);
        this.telefonoNumeris = telefonoNumeris;
    }

    public Uzsakovas() {

    }
    @Override
    public String toString() {
        return String.format("\n" +
                        "\t\t\tVardas:   %s \n" +
                        "\t\t\tPavarde:    %s \n" +
                        "\t\t\tTelefono numeris: %s  \n",
                getFirstname(),getLastname(),this.telefonoNumeris);
    }


    public String getTelefonoNumeris() {
        return telefonoNumeris;
    }
    @XmlElement(name = "telefonoNumeris")
    public void setTelefonoNumeris(String telefonoNumeris) {
        this.telefonoNumeris = telefonoNumeris;
    }

}
