package principal;

import javax.swing.*;
import java.awt.*;

public class agregarPersonal extends JDialogMethods {
    public agregarPersonal(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,400,"Agregar personal", false, this);
        this.setVisible(true);
    }
}
