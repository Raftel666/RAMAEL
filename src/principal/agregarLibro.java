package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class agregarLibro extends JDialogMethods {
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbEditorial = new JLabel("Editorial:");
    JLabel lbPaginas = new JLabel("No. Paginas:");
    JLabel lbGenero = new JLabel("Genero:");
    JLabel lbTipo = new JLabel("Tipo:");
    JTextField txtTitulo = new JTextField();
    JTextField txtAutor = new JTextField();
    JTextField txtEditorial = new JTextField();
    JTextField txtPaginas = new JTextField();
    JTextField txtGenero = new JTextField();
    JTextField txtTipo = new JTextField();
    JButton btnGuardar = new JButton("Guardar");
    JButton btnSalir = new JButton("Salir");

    public agregarLibro(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,420,"Agregar Libro", false, this);

        addLabel(lbTitulo, 10,10,100,30, this);
        addLabel(lbAutor, 10,70,150,30, this);
        addLabel(lbEditorial, 10, 130, 150, 30, this);
        addLabel(lbPaginas, 10, 190, 150, 30, this);
        addLabel(lbGenero, 10, 250, 150, 30, this);
        addLabel(lbTipo, 10, 310, 150, 30, this);
        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnSalir, null, 250, 100, 120, 30, this);

        addTextField(txtTitulo, 10, 40, 200,30, "Titulo...", this);
        addTextField(txtAutor, 10, 100, 200, 30, "Autor...", this);
        addTextField(txtEditorial, 10, 160, 200, 30, "Editorial...", this);
        addTextField(txtPaginas, 10, 220, 200, 30, "Paginas...", this);
        addTextField(txtGenero, 10, 280, 200, 30, "Genero...", this);
        addTextField(txtTipo, 10, 340, 200, 30, "Tipo...", this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar){
            if (txtTitulo.getText().isEmpty()) textFieldRed(txtTitulo);
            if (txtAutor.getText().isEmpty()) textFieldRed(txtAutor);
            if (txtEditorial.getText().isEmpty()) textFieldRed(txtEditorial);
            if (txtPaginas.getText().isEmpty()) textFieldRed(txtPaginas);
            if (txtGenero.getText().isEmpty()) textFieldRed(txtGenero);
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
        if (!txtAutor.getText().isEmpty()){
            textFieldWhite(txtAutor);
        }
        if (!txtEditorial.getText().isEmpty()){
            textFieldWhite(txtEditorial);
        }
        if (!txtPaginas.getText().isEmpty()){
            textFieldWhite(txtPaginas);
        }
        if (!txtGenero.getText().isEmpty()){
            textFieldWhite(txtGenero);
        }
        if (!txtTipo.getText().isEmpty()){
            textFieldWhite(txtTipo);
        }
    }
}
