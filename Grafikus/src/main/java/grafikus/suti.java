package grafikus;

import javax.persistence.*;
@Entity
@Table(name = "suti")
public class suti {
    @Id @GeneratedValue // Elsődleges kulcs, Auto_Increment
    @Column(name = "id")
    public int Id;
    @Column(name = "nev")
    public String Név;
    @Column(name = "tipus")
    public String Típus;
    @Column(name = "dijazott")
    public boolean Díjazott;

    public suti(String név, String tipus,boolean díjazott) {
        Név = név;
        Típus = tipus;
        Díjazott = díjazott;
    }

    public suti() {

    }

    public int getId() {
        return Id;
    }

    public int setId(){return Id; }

    public String getNév() {
        return Név;
    }

    public void setNév(String név) {
        Név = név;
    }

    public String getTípus() {
        return Típus;
    }

    public void setTípus(String típus) {
        Típus = típus;
    }

    public boolean getDíjazott() {
        return Díjazott;
    }

    public void setDíjazott(boolean díjazott) {
        Díjazott = díjazott;
    }
}
