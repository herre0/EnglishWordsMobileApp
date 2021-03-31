package mert.prog.ngilizcekelimefinal;


public class veri {
    String bildimi;
    String eng;

    /* renamed from: id */
    int f59id;
    int seviye;
    String tur;

    public int getId() {
        return this.f59id;
    }

    public void setId(int id) {
        this.f59id = id;
    }

    public String getTur() {
        return this.tur;
    }

    public void setTur(String tur2) {
        this.tur = tur2;
    }

    public String getEng() {
        return this.eng;
    }

    public void setEng(String eng2) {
        this.eng = eng2;
    }

    public int getSeviye() {
        return this.seviye;
    }

    public void setSeviye(int seviye2) {
        this.seviye = seviye2;
    }

    public String getBildimi() {
        return this.bildimi;
    }

    public void setBildimi(String bildimi2) {
        this.bildimi = bildimi2;
    }

    public veri(int id, String tur2, String eng2, int seviye2, String bildimi2) {
        this.f59id = id;
        this.tur = tur2;
        this.eng = eng2;
        this.seviye = seviye2;
        this.bildimi = bildimi2;
    }

    public veri(String bildimi2) {
        this.bildimi = bildimi2;
    }

    public veri(String tur2, String eng2, int seviye2, String bildimi2) {
        this.tur = tur2;
        this.eng = eng2;
        this.seviye = seviye2;
        this.bildimi = bildimi2;
    }

    public veri() {
    }

    public String toString() {
        return "" + this.f59id + "  -  " + this.tur + "  -  " + this.eng + "  -  " + this.seviye;
    }

    public String toString2() {
        return this.eng;
    }

    public String toString3() {
        return this.tur;
    }
}
