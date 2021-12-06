import java.util.Objects;

public class Felhasznalo {

    private String felhasznaloNeve;
    private String keresztNeve;
    private String vezeteNeve;
    private int id = 0;
    private String jelszo;

    public Felhasznalo(String felhasznaloNeve, String keresztNeve, String vezeteNeve, int id, String jelszo) {
        this.felhasznaloNeve = felhasznaloNeve;
        this.keresztNeve = keresztNeve;
        this.vezeteNeve = vezeteNeve;
        this.id = id;
        this.jelszo = jelszo;
    }

    public String getFelhasznaloNeve() {
        return felhasznaloNeve;
    }

    public void setFelhasznaloNeve(String felhasznaloNeve) {
        this.felhasznaloNeve = felhasznaloNeve;
    }

    public String getKeresztNeve() {
        return keresztNeve;
    }

    public void setKeresztNeve(String keresztNeve) {
        this.keresztNeve = keresztNeve;
    }

    public String getVezeteNeve() {
        return vezeteNeve;
    }

    public void setVezeteNeve(String vezeteNeve) {
        this.vezeteNeve = vezeteNeve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Felhasznalo that = (Felhasznalo) o;
        return id == that.id && Objects.equals(felhasznaloNeve, that.felhasznaloNeve) && Objects.equals(keresztNeve, that.keresztNeve) && Objects.equals(vezeteNeve, that.vezeteNeve) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(felhasznaloNeve, keresztNeve, vezeteNeve, id, jelszo);
    }

    @Override
    public String toString() {
        return "Felhasznalo{" +
                "felhasznaloNeve='" + felhasznaloNeve + '\'' +
                ", keresztNeve='" + keresztNeve + '\'' +
                ", vezeteNeve='" + vezeteNeve + '\'' +
                ", id=" + id +
                ", jelszo='" + jelszo + '\'' +
                '}';
    }
}
