package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaController extends JDialogMethods {
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
    private JButton btnLimpiar = new JButton("Limpiar");


    public PeliculaController(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,430,"Agregar Pelicula", false, this);
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
        addButton(btnLimpiar, null, 250, 280, 120, 30, this);
        addButton(btnSalir, null, 250, 340, 120, 30, this);

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
            if (txtId.getText().isEmpty()) textFieldRed(txtId);
            if (txtTitulo.getText().isEmpty()) textFieldRed(txtTitulo);
            if (txtProductor.getText().isEmpty()) textFieldRed(txtProductor);
            if (txtDuracion.getText().isEmpty()) textFieldRed(txtDuracion);
            if (txtGenero.getText().isEmpty()) textFieldRed(txtGenero);
            if (txtTipo.getText().isEmpty()) textFieldRed(txtTipo);
            else { guardar(); limpiarCampos();}
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
            String SQL= "insert into peliculas(idPeliculas, Titulo, Productor, Duracion, Genero, Tipo) values (?, ?, ?, ?, ?, ?)";
            StmGuardar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmGuardar.setInt(1,Integer.parseInt(txtId.getText()));
            StmGuardar.setString(2,txtTitulo.getText());
            StmGuardar.setString(3,txtProductor.getText());
            StmGuardar.setInt(4,Integer.parseInt(txtDuracion.getText()));
            StmGuardar.setString(5,txtGenero.getText());
            StmGuardar.setString(6,txtTipo.getText());
            StmGuardar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Datos insertados correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,"Error"+e);
        }
    }

    private void modificar() {
        try {
            PreparedStatement StmModificar;
            String Sql = "update peliculas set Titulo = ?, Productor = ?, Duracion = ?, Genero = ?, Tipo = ? where idPeliculas = ?";
            StmModificar = Conex.MiConexion.getConexion().prepareCall(Sql);
            StmModificar.setString(1, txtTitulo.getText());
            StmModificar.setString(2, txtProductor.getText());
            StmModificar.setInt(3, Integer.parseInt(txtDuracion.getText()));
            StmModificar.setString(4, txtGenero.getText());
            StmModificar.setString(5, txtTipo.getText());
            StmModificar.setInt(6, Integer.parseInt(txtId.getText()));
            StmModificar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente");
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error"+e);
        }
    }

    private boolean buscar(boolean mostrar ) {
        try {
            PreparedStatement buscarStm;
            String SQL =" select*from peliculas where idPeliculas = ?";
            buscarStm= Conex.MiConexion.getConexion().prepareCall(SQL);
            buscarStm.setInt(1,Integer.parseInt(txtId.getText()));
            ResultSet RsBuscar = buscarStm.executeQuery();
            while(RsBuscar.next()){
                if(mostrar){
                    txtTitulo.setText(RsBuscar.getObject("titulo").toString());
                    txtProductor.setText(RsBuscar.getObject("productor").toString());
                    txtDuracion.setText(RsBuscar.getObject("duracion").toString());
                    txtGenero.setText(RsBuscar.getObject("genero").toString());
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
            String SQL = "delete from peliculas where idPeliculas = ?";
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
        txtProductor.setText("");
        txtDuracion.setText("");
        txtGenero.setText("");
        txtTipo.setText("");
        txtId.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == txtId){
            if (e.getKeyChar() == e.VK_ENTER){
                txtTitulo.requestFocus();
            }
        } else if (e.getSource() == txtTitulo) {
            if (e.getKeyChar() == e.VK_ENTER){
                txtProductor.requestFocus();
            }
        } else if (e.getSource() == txtProductor) {
            if (e.getKeyChar() == e.VK_ENTER){
                txtDuracion.requestFocus();
            }
        } else if (e.getSource() == txtDuracion) {
            if (e.getKeyChar() == e.VK_ENTER){
                txtGenero.requestFocus();
            }
        } else if (e.getSource() == txtGenero) {
            if (e.getKeyChar() == e.VK_ENTER){
                txtTipo.requestFocus();
            }
        } else if (e.getSource() == txtTipo) {
            if (e.getKeyChar() == e.VK_ENTER){
                btnGuardar.requestFocus();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!txtId.getText().isEmpty()){
            textFieldWhite(txtId);
        }
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
