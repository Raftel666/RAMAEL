package principal;

import javax.swing.*;
import java.awt.*;

public class agregarUsuario extends JDialog  {

    public agregarUsuario(Frame owner, boolean modal) {
        super(owner, modal);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar Usuario");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(87,87,87));

        this.setVisible(true);
    }
}

