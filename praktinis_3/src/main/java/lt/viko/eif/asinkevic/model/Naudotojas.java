package lt.viko.eif.asinkevic.model;



import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlTransient;
import org.springframework.data.annotation.Id;
/**
 * Abstract User Model class
 */
@XmlTransient
@XmlSeeAlso({Uzsakovas.class, Autobusas.class, Vairuotojas.class})
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Naudotojas {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;




    @XmlElement(name = "FirstName")
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    @XmlElement(name = "Lastname")
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getFirstname() {
        return firstName;
    }
    public String getLastname() {
        return lastName;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
