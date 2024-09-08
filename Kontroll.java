public class Kontroll { //All my homies hate kontroll 😑🗿🤬
    GrafiskBrukergrensesnitt gui;
    Verden modell;

    public Kontroll() {
        gui = new GrafiskBrukergrensesnitt();
        modell = new Verden(8, 12);
    }
    public void init() {
        gui.init(this);
    }

}
