
package laskin.komento;

import laskin.IO;
import laskin.Sovelluslogiikka;

public class Nollaa implements Komento {
    private final IO laskinIO;
    private final Sovelluslogiikka sovellus;

    public Nollaa(
        IO laskinIO,
        Sovelluslogiikka sovellus
    ) {
        this.laskinIO = laskinIO;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        laskinIO.paivitaSyotekentta("");
        laskinIO.paivitaTuloskentta("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
