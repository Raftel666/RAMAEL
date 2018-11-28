package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController extends JDialogMethods implements ActionListener {
    private JLabel lbId = new JLabel("Id:");
    private JLabel lbNombre = new JLabel("Nombre:");
    private JLabel lbApellidoPaterno = new JLabel("Apellido Paterno:");
    private JLabel lbApellidoMaterno = new JLabel("Apellido Materno:");
    private JLabel lbCorreo = new JLabel("Correo electrónico:");
    private JLabel lbDireccion = new JLabel("Dirección:");
    private JLabel lbTelefono = new JLabel("Telefono:");

    private JTextField txtId = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtApellidoPaterno = new JTextField();
    private JTextField txtApellidoMaterno = new JTextField();
    private JTextField txtCorreo = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();

    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnConsultar = new JButton("Consultar");
    private JButton btnSalir = new JButton("Salir");
    private JButton btnLimpiar = new JButton("Limpiar");

    public UsuarioController(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,490,"Agregar Usuario", false, this);
        addLabel(lbId, 10,10,100,30, this);
        addLabel(lbNombre, 10,70,100,30, this);
        addLabel(lbApellidoPaterno, 10,130,150,30, this);
        addLabel(lbApellidoMaterno, 10, 190, 150, 30, this);
        addLabel(lbCorreo, 10, 250, 150, 30, this);
        addLabel(lbDireccion, 10, 310, 150, 30, this);
        addLabel(lbTelefono, 10, 370, 150, 30, this);

        addTextField(txtId, 10, 40, 200,30, "id...", this);
        addTextField(txtNombre, 10, 100, 200,30, "Nombre...", this);
        addTextField(txtApellidoPaterno, 10, 160, 200, 30, "Apellido paterno", this);
        addTextField(txtApellidoMaterno, 10, 220, 200, 30, "Apellido materno", this);
        addTextField(txtCorreo, 10, 280, 200, 30, "Correo", this);
        addTextField(txtDireccion, 10, 340, 200, 30, "Dirección", this);
        addTextField(txtTelefono, 10, 400, 200, 30, "Telefono", this);
        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnConsultar, null, 250, 100, 120, 30, this);
        addButton(btnModificar, null, 250, 160, 120, 30, this);
        addButton(btnEliminar, null, 250, 220, 120, 30, this);
        addButton(btnLimpiar, null, 250, 280, 120, 30, this);
        addButton(btnSalir, null, 250, 340, 120, 30, this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            if (txtId.getText().isEmpty()) {
                textFieldRed(txtId);
            }
            if (txtNombre.getText().isEmpty()) {
                textFieldRed(txtNombre);
            }
            if (txtApellidoPaterno.getText().isEmpty()) {
                textFieldRed(txtApellidoPaterno);
            }
            if (txtApellidoMaterno.getText().isEmpty()) {
                textFieldRed(txtApellidoMaterno);
            }
            if (txtCorreo.getText().isEmpty()) {
                textFieldRed(txtCorreo);
            }
            if (txtDireccion.getText().isEmpty()) {
                textFieldRed(txtDireccion);
            }
            if (txtTelefono.getText().isEmpty()) {
                textFieldRed(txtTelefono);
            } else {
                guardar();
                limpiarCampos();
            }
        } else if (e.getSource() == btnModificar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Campo ID no debe de estar vacío");
            } else {
                if (buscar(false) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                    limpiarCampos();
                } else {
                    int opc = JOptionPane.showConfirmDialog(rootPane, "Deseas modificarlo?", "Alerta!", 0, 1);
                    if (opc == 0) {
                        modificar();
                        limpiarCampos();
                    }
                }
            }
        } else if (e.getSource() == btnConsultar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "campo id no debe estar vacio");
            } else {
                if (buscar(true) == false) {
                    JOptionPane.showMessageDialog(rootPane, "dato no existe");
                    limpiarCampos();
                }
            }
        } else if (e.getSource() == btnEliminar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "El campo del id no debe de estar vacio ");
            } else {
                if (buscar(false) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                } else {
                    int opc;
                    opc = JOptionPane.showConfirmDialog(rootPane, "eliminar producto", "Alerta", 0, 1);
                    if (opc == 0) {
                        Eliminar();
                        limpiarCampos();
                    }
                }
            }
        } else if (e.getSource() == btnLimpiar){
            limpiarCampos();
        }
        if (e.getSource() == btnSalir) {
            this.dispose();
        }
    }

    private void guardar() {//guardar cambios
        try {
            PreparedStatement StmGuardar;
            String SQL= "insert into usuarios(idUsuarios, Nombre, ApellidoPaterno, ApellidoMaterno, Direccion, Telefono, Correo) values (?, ?, ?, ?, ?, ?, ?)";
            StmGuardar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmGuardar.setInt(1,Integer.parseInt(txtId.getText()));
            StmGuardar.setString(2,txtNombre.getText());
            StmGuardar.setString(3,txtApellidoPaterno.getText());
            StmGuardar.setString(4,txtApellidoMaterno.getText());
            StmGuardar.setString(5,txtDireccion.getText());
            StmGuardar.setInt(6,Integer.parseInt(txtTelefono.getText()));
            StmGuardar.setString(7,txtCorreo.getText());
            StmGuardar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Datos insertados correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,"Error"+e);
        }
    }

    private void modificar() {
        try {
            PreparedStatement StmModificar;
            String Sql = "update usuarios set Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Direccion = ?, " +
                    "Telefono = ?, Correo = ? where idUsuarios = ?";
            StmModificar = Conex.MiConexion.getConexion().prepareCall(Sql);
            StmModificar.setString(1, txtNombre.getText());
            StmModificar.setString(2, txtApellidoPaterno.getText());
            StmModificar.setString(3, txtApellidoMaterno.getText());
            StmModificar.setString(4, txtDireccion.getText());
            StmModificar.setString(5, txtTelefono.getText());
            StmModificar.setString(6, txtCorreo.getText());
            StmModificar.setInt(7,Integer.parseInt(txtId.getText()));
            StmModificar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente");
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error"+e);
        }
    }

    private boolean buscar(boolean mostrar ) {
        try {
            PreparedStatement buscarStm;
            String SQL =" select*from usuarios where idUsuarios = ?";
            buscarStm= Conex.MiConexion.getConexion().prepareCall(SQL);
            buscarStm.setInt(1,Integer.parseInt(txtId.getText()));
            ResultSet RsBuscar = buscarStm.executeQuery();
            while(RsBuscar.next()){
                if(mostrar){
                    txtNombre.setText(RsBuscar.getObject("nombre").toString());
                    txtApellidoPaterno.setText(RsBuscar.getObject("apellidoPaterno").toString());
                    txtApellidoMaterno.setText(RsBuscar.getObject("apellidoMaterno").toString());
                    txtDireccion.setText(RsBuscar.getObject("direccion").toString());
                    txtTelefono.setText(RsBuscar.getObject("telefono").toString());
                    txtCorreo.setText(RsBuscar.getObject("correo").toString());
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
            String SQL = "delete from usuarios where idUsuarios = ?";
            EliminarStm=Conex.MiConexion.getConexion().prepareCall(SQL);
            EliminarStm.setInt(1,Integer.parseInt(txtId.getText()));
            EliminarStm.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Datos eliminados correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"error"+e);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
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
        if (!txtId.getText().isEmpty()){
            textFieldWhite(txtId);
        }
        if (!txtNombre.getText().isEmpty()){
            textFieldWhite(txtNombre);
        }
        if (!txtApellidoPaterno.getText().isEmpty()){
            textFieldWhite(txtApellidoPaterno);
        }
        if (!txtApellidoMaterno.getText().isEmpty()){
            textFieldWhite(txtApellidoMaterno);
        }
        if (!txtCorreo.getText().isEmpty()){
            textFieldWhite(txtCorreo);
        }
        if (!txtDireccion.getText().isEmpty()){
            textFieldWhite(txtDireccion);
        }
        if (!txtTelefono.getText().isEmpty()){
            textFieldWhite(txtTelefono);
        }
    }
}
