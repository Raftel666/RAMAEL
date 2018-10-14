package principal;

import javax.swing.*;
import java.awt.*;

public class agregarPelicula extends JDialog {
    public agregarPelicula(Frame owner, boolean modal) {
        super(owner, modal);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar Pelicula");
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(87,87,87));
        this.setLayout(null);
        this.setVisible(true);
    }
}
