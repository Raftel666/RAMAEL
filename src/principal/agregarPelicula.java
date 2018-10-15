package principal;

import javax.swing.*;
import java.awt.*;

public class agregarPelicula extends JDialogMethods {
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbProductor = new JLabel("Productor:");
    JLabel lbDuracion = new JLabel("Duración:");
    JLabel lbGenero = new JLabel("Genero:");
    JLabel lbTipo = new JLabel("Tipo:");

    JTextField txtTitulo = new JTextField();
    JTextField txtProductor = new JTextField();
    JTextField txtDuracion = new JTextField();
    JTextField txtGenero = new JTextField();
    JTextField txtTipo = new JTextField();

    public agregarPelicula(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,360,"Agregar Pelicula", false, this);

        addLabel(lbTitulo, 10,10,100,30, this);
        addLabel(lbProductor, 10,70,150,30, this);
        addLabel(lbDuracion, 10, 130, 150, 30, this);
        addLabel(lbGenero, 10, 190, 150, 30, this);
        addLabel(lbTipo, 10, 250, 150, 30, this);

        addTextField(txtTitulo, 10, 40, 200,30, "Titulo...", this);
        addTextField(txtProductor, 10, 100, 200, 30, "Productor...", this);
        addTextField(txtDuracion, 10, 160, 200, 30, "Duración...", this);
        addTextField(txtGenero, 10, 220, 200, 30, "Genero...", this);
        addTextField(txtTipo, 10, 280, 200, 30, "Tipo...", this);
        this.setVisible(true);
    }
}
