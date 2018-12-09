package laskin;

import java.util.HashMap;
import java.util.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.komento.*;

public class Tapahtumankuuntelija implements EventHandler {
    private final Button undo;
    private final Sovelluslogiikka sovellus;
    private final IO laskinIO;
    private final Map<Button, Komento> komennot;

    private Komento edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.laskinIO = new LaskinIO(tuloskentta, syotekentta);
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        komennot = new HashMap<>();
        komennot.put(plus, new Summa(laskinIO, sovellus));
        komennot.put(miinus, new Erotus(laskinIO, sovellus));
        komennot.put(nollaa, new Nollaa(laskinIO, sovellus));
    }

    @Override
    public void handle(Event event) {
        if (event.getTarget() != undo) {
            Komento komento = komennot.get((Button) event.getTarget());
            komento.suorita();
            edellinen = komento;
            undo.disableProperty().set(false);
        } else {
            edellinen.peru();
            edellinen = null;
            undo.disableProperty().set(true);
        }
    }
}
