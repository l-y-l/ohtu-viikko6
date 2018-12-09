
package laskin.komento;

import laskin.IO;
import laskin.Sovelluslogiikka;

public class Summa implements Komento {
    private final IO laskinIO;
    private final Sovelluslogiikka sovellus;

    private int edellinenTulos;

    public Summa(
        IO laskinIO,
        Sovelluslogiikka sovellus
    ) {
        this.laskinIO = laskinIO;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenTulos = laskinIO.lueTuloskentta();

        sovellus.plus(laskinIO.lueSyotekentta());

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
