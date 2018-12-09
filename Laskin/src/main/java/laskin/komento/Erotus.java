
package laskin.komento;

import laskin.IO;
import laskin.Sovelluslogiikka;

public class Erotus implements Komento {
    private final IO laskinIO;
    private final Sovelluslogiikka sovellus;

    private int edellinenTulos;

    public Erotus(
        IO laskinIO,
        Sovelluslogiikka sovellus
    ) {
        this.laskinIO = laskinIO;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenTulos = laskinIO.lueTuloskentta();

        sovellus.miinus(laskinIO.lueSyotekentta());

        uusiTilanne(sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.setTulos(edellinenTulos);

        uusiTilanne(edellinenTulos);
    }

    private void uusiTilanne(int syoteArvo) {
        laskinIO.paivitaSyotekentta("");
        laskinIO.paivitaTuloskentta("" + syoteArvo);
    }
}
