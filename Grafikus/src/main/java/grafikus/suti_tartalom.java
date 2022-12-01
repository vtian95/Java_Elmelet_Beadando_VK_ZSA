package grafikus;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
@Entity
@Table(name = "tartalom")
public class suti_tartalom {

        @javax.persistence.Id
        @GeneratedValue // Elsődleges kulcs, Auto_Increment
        @Column(name = "id")
        public int T_Id;
        @Column(name = "ssutiid")
        public String Ssutiid;

    public int getT_Id() {
        return T_Id;
    }

    public void setT_Id(int t_Id) {
        T_Id = t_Id;
    }

    public String getSsutiid() {
        return Ssutiid;
    }

    public void setSsutiid(String ssutiid) {
        Ssutiid = ssutiid;
    }

    public String getMentes() {
        return Mentes;
    }

    public void setMentes(String mentes) {
        Mentes = mentes;
    }

    @Column(name = "mentes")
        public String Mentes;

    }
