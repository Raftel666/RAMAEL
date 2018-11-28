package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ComicController extends JDialogMethods {
    JLabel lbId = new JLabel("Id:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbFecha = new JLabel("Fecha:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbEditorial = new JLabel("Editorial:");
    JLabel lbGenero = new JLabel("Genero:");
    JLabel lbFranquicia = new JLabel("Franquicia:");
    JLabel lbEjemplar = new JLabel("Ejemplares:");
    JLabel lbTipo = new JLabel("Tipo:");

    JTextField txtId = new JTextField();
    JTextField txtTitulo = new JTextField();
    JTextField txtFecha= new JTextField();
    JTextField txtAutor = new JTextField();
    JTextField txtEditorial = new JTextField();
    JTextField txtGenero = new JTextField();
    JTextField txtFranquicia = new JTextField();
    JTextField txtEjemplar = new JTextField();
    JTextField txtTipo = new JTextField();

    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnSalir = new JButton("Salir");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnConsultar = new JButton("Consultar");
    private JButton btnLimpiar = new JButton("Limpiar");
    //YOlo Manolo

    public ComicController(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,610,"Agregar Comic-Manga", false, this);

        addLabel(lbId, 10,10,100,30, this);
        addLabel(lbTitulo, 10,70,100,30, this);
        addLabel(lbFecha, 10,130,150,30, this);
        addLabel(lbAutor, 10, 190, 150, 30, this);
        addLabel(lbEditorial, 10, 250, 150, 30, this);
        addLabel(lbGenero, 10, 310, 150, 30, this);
        addLabel(lbFranquicia, 10, 370, 150, 30, this);
        addLabel(lbEjemplar, 10, 430, 150, 30, this);
        addLabel(lbTipo, 10, 490, 150, 30, this);

        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnConsultar, null, 250, 100, 120, 30, this);
        addButton(btnModificar, null, 250, 160, 120, 30, this);
        addButton(btnEliminar, null, 250, 220, 120, 30, this);
        addButton(btnLimpiar, null, 250, 280, 120, 30, this);
        addButton(btnSalir, null, 250, 340, 120, 30, this);

        addTextField(txtId, 10, 40, 200,30, "Id...", this);
        addTextField(txtTitulo, 10, 100, 200,30, "Titulo...", this);
        addTextField(txtFecha, 10, 160, 200, 30, "Fecha...", this);
        addTextField(txtAutor, 10, 220, 200, 30, "Autor...", this);
        addTextField(txtEditorial, 10, 280, 200, 30, "Editorial...", this);
        addTextField(txtGenero, 10, 340, 200, 30, "Genero...", this);
        addTextField(txtFranquicia, 10, 400, 200, 30, "Franquicia...", this);
        addTextField(txtEjemplar, 10, 460, 200, 30, "Ejemplares...", this);
        addTextField(txtTipo, 10, 520, 200, 30, "Tipo...", this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar){
            if (txtId.getText().isEmpty()) textFieldRed(txtId);
            if (txtTitulo.getText().isEmpty()) textFieldRed(txtTitulo);
            if (txtFecha.getText().isEmpty()) textFieldRed(txtFecha);
            if (txtAutor.getText().isEmpty()) textFieldRed(txtAutor);
            if (txtEditorial.getText().isEmpty()) textFieldRed(txtEditorial);
            if (txtGenero.getText().isEmpty()) textFieldRed(txtGenero);
            if (txtFranquicia.getText().isEmpty()) textFieldRed(txtFranquicia);
            if (txtEjemplar.getText().isEmpty()) textFieldRed(txtEjemplar);
            if (txtTipo.getText().isEmpty()) textFieldRed(txtTipo);
            } else if (e.getSource() == btnModificar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Campo ID no debe de estar vacío");
            } else {
                if (buscar(false) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                    limpiarCampos();
                } else {
                    int opc = JOptionPane.showConfirmDialog(rootPane, "¿Deseas modificarlo?", "Alerta!", 0, 1);
                    if (opc == 0) {
                        modificar();
                        limpiarCampos();
                    }
                }
            }
        } else if (e.getSource() == btnConsultar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Campo id no debe estar vacio");
            } else {
                if (buscar(true) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                    limpiarCampos();
                }
            }
        } else if (e.getSource() == btnEliminar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "El campo del id no debe de estar vacio");
            } else {
                if (buscar(false) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                } else {
                    int opc;
                    opc = JOptionPane.showConfirmDialog(rootPane, "Eliminar producto", "Alerta", 0, 1);
                    if (opc == 0) {
                        Eliminar();
                        limpiarCampos();
                    }
                }
            }
        } else if (e.getSource() == btnLimpiar){
            limpiarCampos();
        }
        if(e.getSource()==btnSalir){
            this.dispose();
        }
    }

    private void guardar() {
        try {
            PreparedStatement StmGuardar;
            String SQL= "insert into comics(idComics, Titulo, Fecha, Autor, Editorial, Genero, Franquicia, NoEjemplares, Tipo) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            StmGuardar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmGuardar.setInt(1,Integer.parseInt(txtId.getText()));
            StmGuardar.setString(2,txtTitulo.getText());
            //StmGuardar.setDate(3, );
            StmGuardar.setString(4,txtAutor.getText());
            StmGuardar.setString(5,txtEditorial.getText());
            StmGuardar.setString(6,txtGenero.getText());
            StmGuardar.setString(7,txtFranquicia.getText());
            StmGuardar.setInt(8,Integer.parseInt(txtEjemplar.getText()));
            StmGuardar.setString(9,txtTipo.getText());
            StmGuardar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Datos insertados correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,"Error"+e);
        }
    }

    private void modificar() {
        try {
            PreparedStatement StmModificar;
            String Sql = "update comics set Titulo = ?, Fecha = ?, Autor = ?, Editorial = ?, Genero = ?, Franquicia = ?, NoEjemplares = ?, Tipo = ? where idComics = ?";
            StmModificar = Conex.MiConexion.getConexion().prepareCall(Sql);
            StmModificar.setString(1, txtTitulo.getText());
            //StmModificar.setTimestamp(2,);
            StmModificar.setString(3, txtAutor.getText());
            StmModificar.setString(4, txtEditorial.getText());
            StmModificar.setString(5, txtGenero.getText());
            StmModificar.setString(6, txtFranquicia.getText());
            StmModificar.setInt(7, Integer.parseInt(txtEjemplar.getText()));
            StmModificar.setString(8, txtTipo.getText());
            StmModificar.setInt(9, Integer.parseInt(txtId.getText()));
            StmModificar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente");
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error"+e);
        }
    }

    private boolean buscar(boolean mostrar ) {
        try {
            PreparedStatement buscarStm;
            String SQL =" select*from comics where idComics = ?";
            buscarStm= Conex.MiConexion.getConexion().prepareCall(SQL);
            buscarStm.setInt(1,Integer.parseInt(txtId.getText()));
            ResultSet RsBuscar = buscarStm.executeQuery();
            while(RsBuscar.next()){
                if(mostrar){
                    txtTitulo.setText(RsBuscar.getObject("titulo").toString());
                    txtFecha.setText(RsBuscar.getObject("fecha").toString());
                    txtAutor.setText(RsBuscar.getObject("autor").toString());
                    txtEditorial.setText(RsBuscar.getObject("editorial").toString());
                    txtGenero.setText(RsBuscar.getObject("genero").toString());
                    txtFranquicia.setText(RsBuscar.getObject("franquicia").toString());
                    txtEjemplar.setText(RsBuscar.getObject("noejemplares").toString());
                    txtTipo.setText(RsBuscar.getObject("tipo").toString());
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Error"+ e);
            return false;
        }
    }

    private void Eliminar() {
        try {
            PreparedStatement EliminarStm;
            String SQL = "delete from comics where idComics= ?";
            EliminarStm=Conex.MiConexion.getConexion().prepareCall(SQL);
            EliminarStm.setInt(1,Integer.parseInt(txtId.getText()));
            EliminarStm.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Datos eliminados correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"Error"+e);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTitulo.setText("");
        txtFecha.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtGenero.setText("");
        txtFranquicia.setText("");
        txtEjemplar.setText("");
        txtTipo.setText("");
        txtId.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!txtId.getText().isEmpty()) textFieldWhite(txtId);
        if (!txtTitulo.getText().isEmpty()) textFieldWhite(txtTitulo);
        if (!txtFecha.getText().isEmpty()) textFieldWhite(txtFecha);
        if (!txtAutor.getText().isEmpty()) textFieldWhite(txtAutor);
        if (!txtEditorial.getText().isEmpty()) textFieldWhite(txtEditorial);
        if (!txtGenero.getText().isEmpty()) textFieldWhite(txtGenero);
        if (!txtFranquicia.getText().isEmpty()) textFieldWhite(txtFranquicia);
        if (!txtEjemplar.getText().isEmpty()) textFieldWhite(txtEjemplar);
        if (!txtTipo.getText().isEmpty()) textFieldWhite(txtTipo);
    }
}

