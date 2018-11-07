package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnSalir = new JButton("Salir");

    public agregarPelicula(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,360,"Agregar Pelicula", false, this);

        addLabel(lbTitulo, 10,10,100,30, this);
        addLabel(lbProductor, 10,70,150,30, this);
        addLabel(lbDuracion, 10, 130, 150, 30, this);
        addLabel(lbGenero, 10, 190, 150, 30, this);
        addLabel(lbTipo, 10, 250, 150, 30, this);
        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnSalir, null, 250, 100, 120, 30, this);

        addTextField(txtTitulo, 10, 40, 200,30, "Titulo...", this);
        addTextField(txtProductor, 10, 100, 200, 30, "Productor...", this);
        addTextField(txtDuracion, 10, 160, 200, 30, "Duración...", this);
        addTextField(txtGenero, 10, 220, 200, 30, "Genero...", this);
        addTextField(txtTipo, 10, 280, 200, 30, "Tipo...", this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSalir){
            this.dispose();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
