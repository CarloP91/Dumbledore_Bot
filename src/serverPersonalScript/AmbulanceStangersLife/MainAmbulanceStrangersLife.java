package serverPersonalScript.AmbulanceStangersLife;

public class MainAmbulanceStrangersLife {

    //ID SERVER
    public static String ambulanceID = "839067511601365033"; //Ambulance Stanger's Life

    //ID CHANNEL LOG
    public static String chLogID = "839615144107048961"; //CHANNEL DOVE STAMPARE IL LOG

    //STAFF

    private String dominy = "383035474807095296"; //PROPRIETARIO SERVER

    //RUOLI

    private String direttore = "839071738654359572"; //RUOLO DIRETTORE
    private String viceDirettore = "839071683976495155"; //RUOLO VICE DIRETTORE
    private String primario = "840159576905089044"; // RUOLO PRIMARIO
    private String dottore = "839071597327024129"; // RUOLO DOTTORE
    private String paramedico = "839069751073832980"; //RUOLO PARAMEDICO
    private String tirocinante = "844289989831557120"; //RUOLO TIROCINANTE
    private String inProva = "839080375619551292"; // RUOLO IN PROVA

    //CHANNEL SPECIFICI
    public static String chAnnunciID = "851903365587140638";
    public static String certMedici = "867746591607619585";
    public static String medAutMask = "868041746821550080";

    public String getDirettore() {
        return direttore;
    }

    public String getViceDirettore() {
        return viceDirettore;
    }

    public String getPrimario() { return primario;}

    public String getDottore() {
        return dottore;
    }

    public String getParamedico() {
        return paramedico;
    }

    public String getTirocinante() { return tirocinante;}

    public String getInProva() {
        return inProva;
    }
}
