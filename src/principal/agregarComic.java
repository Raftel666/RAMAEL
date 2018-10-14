package principal;

import javax.swing.*;
import java.awt.*;

public class agregarComic extends JDialogMethods {
    public agregarComic(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,400,"", false, this);

        this.setVisible(true);
    }
}
