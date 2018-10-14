package principal;

import java.awt.*;

public class agregarPelicula extends JDialogMethods {
    public agregarPelicula(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,400,"", false, this);
        this.setVisible(true);
    }
}
