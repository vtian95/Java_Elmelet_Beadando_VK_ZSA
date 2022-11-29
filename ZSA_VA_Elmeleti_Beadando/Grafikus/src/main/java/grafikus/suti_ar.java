package grafikus;

import javax.persistence.*;
@Entity
@Table(name = "ar")
public class suti_ar {


        @javax.persistence.Id
        @GeneratedValue // Elsődleges kulcs, Auto_Increment
        @Column(name = "id")
        public int S_Id;
        @Column(name = "sutiid")
        public String Sutiid;
        @Column(name = "ertek")
        public String Ertek;

    public int getS_Id() {
        return S_Id;
    }

    public void setS_Id(int s_Id) {
        S_Id = s_Id;
    }

    public String getSutiid() {
        return Sutiid;
    }

    public void setSutiid(String sutiid) {
        Sutiid = sutiid;
    }

    public String getErtek() {
        return Ertek;
    }

    public void setErtek(String típus) {
        Ertek = típus;
    }

    public String getEgyseg() {
        return Egyseg;
    }

    public void setEgyseg(String egyseg) {
        Egyseg = egyseg;
    }

    @Column(name = "egyseg")
        public String Egyseg;
}
