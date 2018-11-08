package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class agregarPelicula extends JDialogMethods {
    JLabel lbId = new JLabel("Id:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbProductor = new JLabel("Productor:");
    JLabel lbDuracion = new JLabel("Duración:");
    JLabel lbGenero = new JLabel("Genero:");
    JLabel lbTipo = new JLabel("Tipo:");
    JTextField txtId = new JTextField();
    JTextField txtTitulo = new JTextField();
    JTextField txtProductor = new JTextField();
    JTextField txtDuracion = new JTextField();
    JTextField txtGenero = new JTextField();
    JTextField txtTipo = new JTextField();

    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnSalir = new JButton("Salir");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnConsultar = new JButton("Consultar");

    public agregarPelicula(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,400,"Agregar Pelicula", false, this);
        addLabel(lbId, 10,10,100,30, this);
        addLabel(lbTitulo, 10,70,100,30, this);
        addLabel(lbProductor, 10,130,150,30, this);
        addLabel(lbDuracion, 10, 190, 150, 30, this);
        addLabel(lbGenero, 10, 250, 150, 30, this);
        addLabel(lbTipo, 10, 310, 150, 30, this);
        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnModificar, null, 250, 100, 120, 30, this);
        addButton(btnConsultar, null, 250, 160, 120, 30, this);
        addButton(btnEliminar, null, 250, 220, 120, 30, this);
        addButton(btnSalir, null, 250, 280, 120, 30, this);

        addTextField(txtId, 10, 40, 200,30, "Id..", this);
        addTextField(txtTitulo, 10, 100, 200,30, "Titulo...", this);
        addTextField(txtProductor, 10, 160, 200, 30, "Productor...", this);
        addTextField(txtDuracion, 10, 220, 200, 30, "Duración...", this);
        addTextField(txtGenero, 10, 280, 200, 30, "Genero...", this);
        addTextField(txtTipo, 10, 340, 200, 30, "Tipo...", this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            if (txtTitulo.getText().isEmpty()){
                textFieldRed(txtTitulo);
            }
            if (txtProductor.getText().isEmpty()){
                textFieldRed(txtProductor);
            }
            if (txtDuracion.getText().isEmpty()){
                textFieldRed(txtDuracion);
            }
            if (txtGenero.getText().isEmpty()){
                textFieldRed(txtGenero);
            }
            if (txtTipo.getText().isEmpty()){
                textFieldRed(txtTipo);
            }
        }
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
        if (!txtTitulo.getText().isEmpty()){
            textFieldWhite(txtTitulo);
        }
        if (!txtProductor.getText().isEmpty()){
            textFieldWhite(txtProductor);
        }
        if (!txtDuracion.getText().isEmpty()){
            textFieldWhite(txtDuracion);
        }
        if (!txtGenero.getText().isEmpty()){
            textFieldWhite(txtGenero);
        }
        if (!txtTipo.getText().isEmpty()){
            textFieldWhite(txtTipo);
        }
    }
}
