package serverList.AmbulanceStangersLife;

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
    private String primario = "843912462125891614"; // RUOLO PRIMARIO
    private String dottore = "843912462125891614"; // RUOLO DOTTORE
    private String paramedico = "843912462125891614"; //RUOLO PARAMEDICO
    private String tirocinante = "843912462125891614"; //RUOLO EMS
    private String inProva = "843912462125891614"; // RUOLO IN PROVA

    //CHANNEL SPECIFICI
    public static String chAnnunciID = "851903365587140638";

    public String getDirettore() {
        return direttore;
    }

    public String getViceDirettore() {
        return viceDirettore;
    }

    public String getPrimario() {
        return primario;
    }

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
