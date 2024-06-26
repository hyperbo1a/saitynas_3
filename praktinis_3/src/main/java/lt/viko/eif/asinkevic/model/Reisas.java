package lt.viko.eif.asinkevic.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;


/**
 * Public Reisas Model class
 */
@XmlRootElement(name = "Reisas")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "adresas", "uzsakovas", "vairuotojas", "autobusas"})
@Entity
@Table(name = "reisas")
public class Reisas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String adresas;
    @OneToOne(targetEntity = Uzsakovas.class,cascade = CascadeType.ALL)
    private Uzsakovas uzsakovas;
    @OneToOne(targetEntity = Vairuotojas.class,cascade = CascadeType.ALL)
    private Vairuotojas vairuotojas;
    @OneToOne(targetEntity = Autobusas.class,cascade = CascadeType.ALL)
    private Autobusas autobusas;

    public Reisas() {

    }

    @Override
    public String toString() {
        return String.format("Reisas: \n" +
                        "\tAdresas:    %s \n" +
                        "\n\tUzsakovas: %s \n" +
                        "\tVairuotojas: %s \n" +
                        "\tAutobusas: %s ",
                this.adresas, this.uzsakovas, this.vairuotojas, this.autobusas);
    }



    public String getAdresas() {
        return adresas;
    }
    //@XmlElement(name = "adresas")
    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }


    public Uzsakovas getUzsakovas() {
        return uzsakovas;
    }
   // @XmlElement(name = "uzsakovas")
    public void setUzsakovas(Uzsakovas uzsakovas) {
        this.uzsakovas = uzsakovas;
    }


    public Vairuotojas getVairuotojas() {
        return vairuotojas;
    }
    //@XmlElement(name = "Vairuotojas")
    public void setVairuotojas(Vairuotojas vairuotojas) {
        this.vairuotojas = vairuotojas;
    }


    public Autobusas getAutobusas() {
        return autobusas;
    }
   // @XmlElement(name = "autobusas")
    public void setAutobusas(Autobusas autobusas) {
        this.autobusas = autobusas;
    }
    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
