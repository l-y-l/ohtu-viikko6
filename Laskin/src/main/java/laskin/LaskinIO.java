
package laskin;

import javafx.scene.control.TextField;

public class LaskinIO implements IO {
    private final TextField tuloskentta;
    private final TextField syotekentta;

    public LaskinIO(TextField tuloskentta, TextField syotekentta) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public int lueTuloskentta() {
        return Integer.parseInt(tuloskentta.getText());
    }

    @Override
    public int lueSyotekentta() {
        return Integer.parseInt(syotekentta.getText());
    }

    @Override
    public void paivitaTuloskentta(String arvo) {
        tuloskentta.setText("" + arvo);
    }

    @Override
    public void paivitaSyotekentta(String arvo) {
        syotekentta.setText("" + arvo);
    }
}
