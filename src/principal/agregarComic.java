package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class agregarComic extends JDialogMethods {
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbFecha = new JLabel("Fecha:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbEditorial = new JLabel("Editorial:");
    JLabel lbGenero = new JLabel("Genero:");
    JLabel lbFranquicia = new JLabel("Franquicia:");
    JLabel lbTipo = new JLabel("Tipo:");
    JTextField txtTitulo = new JTextField();
    JTextField txtFecha= new JTextField();
    JTextField txtAutor = new JTextField();
    JTextField txtEditorial = new JTextField();
    JTextField txtGenero = new JTextField();
    JTextField txtFranquicia = new JTextField();
    JTextField txtTipo = new JTextField();
    JButton btnGuardar = new JButton("Guardar");
    JButton btnSalir = new JButton("Salir");

    public agregarComic(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,480,"Agregar Comic-Manga", false, this);

        addLabel(lbTitulo, 10,10,100,30, this);
        addLabel(lbFecha, 10,70,150,30, this);
        addLabel(lbAutor, 10, 130, 150, 30, this);
        addLabel(lbEditorial, 10, 190, 150, 30, this);
        addLabel(lbGenero, 10, 250, 150, 30, this);
        addLabel(lbFranquicia, 10, 310, 150, 30, this);
        addLabel(lbTipo, 10, 370, 150, 30, this);
        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnSalir, null, 250, 100, 120, 30, this);

        addTextField(txtTitulo, 10, 40, 200,30, "Titulo...", this);
        addTextField(txtFecha, 10, 100, 200, 30, "Fecha...", this);
        addTextField(txtAutor, 10, 160, 200, 30, "Autor...", this);
        addTextField(txtEditorial, 10, 220, 200, 30, "Editorial...", this);
        addTextField(txtGenero, 10, 280, 200, 30, "Genero...", this);
        addTextField(txtFranquicia, 10, 340, 200, 30, "Franquicia...", this);
        addTextField(txtTipo, 10, 400, 200, 30, "Tipo...", this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar){
            if (txtTitulo.getText().isEmpty()) textFieldRed(txtTitulo);
            if (txtFecha.getText().isEmpty()) textFieldRed(txtFecha);
            if (txtAutor.getText().isEmpty()) textFieldRed(txtAutor);
            if (txtEditorial.getText().isEmpty()) textFieldRed(txtEditorial);
            if (txtGenero.getText().isEmpty()) textFieldRed(txtGenero);
            if (txtFranquicia.getText().isEmpty()) textFieldRed(txtFranquicia);
            if (txtTipo.getText().isEmpty()) textFieldRed(txtTipo);
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
        if (!txtFecha.getText().isEmpty()){
            textFieldWhite(txtFecha);
        }
        if (!txtAutor.getText().isEmpty()){
            textFieldWhite(txtAutor);
        }
        if (!txtEditorial.getText().isEmpty()){
            textFieldWhite(txtEditorial);
        }
        if (!txtGenero.getText().isEmpty()){
            textFieldWhite(txtGenero);
        }
        if (!txtFranquicia.getText().isEmpty()){
            textFieldWhite(txtFranquicia);
        }
        if (!txtTipo.getText().isEmpty()){
            textFieldWhite(txtTipo);
        }
    }
}
