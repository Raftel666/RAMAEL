package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalController extends JDialogMethods {
    JLabel lbId = new JLabel("Id:");
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbApellidoPaterno = new JLabel("Apellido Paterno:");
    JLabel lbApellidoMaterno = new JLabel("Apellido Materno:");
    JLabel lbCorreo = new JLabel("Correo electrónico:");
    JLabel lbPassword = new JLabel("Password:");
    JLabel lbDireccion = new JLabel("Dirección:");
    JLabel lbTelefono = new JLabel("Telefono:");
    JLabel lbPuesto = new JLabel("Puesto:");
    JTextField txtId = new JTextField();
    JTextField txtNombre = new JTextField();
    JTextField txtApellidoPaterno = new JTextField();
    JTextField txtApellidoMaterno = new JTextField();
    JTextField txtCorreo = new JTextField();
    JTextField txtPassword = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextField txtTelefono = new JTextField();
    JTextField txtPuesto = new JTextField();
    JButton btnGuardar = new JButton("Guardar");
    JButton btnSalir = new JButton("Salir");
    JButton btnModificar = new JButton("Modificar");
    JButton btnConsultar = new JButton("Consultar");
    JButton btnEliminar = new JButton("Eliminar");

    public PersonalController(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,600,"Agregar personal", false, this);

        addLabel(lbId, 10,10,100,30, this);
        addLabel(lbNombre, 10,70,100,30, this);
        addLabel(lbApellidoPaterno, 10,130,150,30, this);
        addLabel(lbApellidoMaterno, 10, 190, 150, 30, this);
        addLabel(lbCorreo, 10, 250, 150, 30, this);
        addLabel(lbPassword, 10, 310, 150, 30, this);
        addLabel(lbDireccion, 10, 370, 150, 30, this);
        addLabel(lbTelefono, 10, 430, 150, 30, this);
        addLabel(lbPuesto, 10, 490, 150, 30, this);
        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnModificar, null, 250, 100, 120, 30, this);
        addButton(btnConsultar, null, 250, 160, 120, 30, this);
        addButton(btnEliminar, null, 250, 220, 120, 30, this);
        addButton(btnSalir, null, 250, 280, 120, 30, this);

        addTextField(txtId, 10, 40, 200,30, "Id...", this);
        addTextField(txtNombre, 10, 100, 200,30, "Nombre...", this);
        addTextField(txtApellidoPaterno, 10, 160, 200, 30, "Apellido paterno...", this);
        addTextField(txtApellidoMaterno, 10, 220, 200, 30, "Apellido materno...", this);
        addTextField(txtCorreo, 10, 280, 200, 30, "Correo...", this);
        addTextField(txtPassword, 10, 340, 200,30, "Password...", this);
        addTextField(txtDireccion, 10, 400, 200, 30, "Dirección...", this);
        addTextField(txtTelefono, 10, 460, 200, 30, "Telefono...", this);
        addTextField(txtPuesto, 10, 520, 200, 30, "Puesto...", this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
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
            }
            if (txtPuesto.getText().isEmpty()) {
                textFieldRed(txtPuesto);
            } else {
                guardar();
                limpiarCampos();
            }
        } else if(e.getSource()==btnConsultar){
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
        }
        if (e.getSource() == btnSalir){
            this.dispose();
        }
    }

    private void modificar() {
        try {
            PreparedStatement StmModificar;
            String Sql = "update personal set Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Direccion = ?, " +
                    "Telefono = ?, Puesto = ?, Correro = ?, Password = ? where idPersonal = ?";
            StmModificar = Conex.MiConexion.getConexion().prepareCall(Sql);
            StmModificar.setString(1, txtNombre.getText());
            StmModificar.setString(2, txtApellidoPaterno.getText());
            StmModificar.setString(3, txtApellidoMaterno.getText());
            StmModificar.setString(4, txtDireccion.getText());
            StmModificar.setInt(5, Integer.parseInt(txtTelefono.getText()));
            StmModificar.setString(6, txtPuesto.getText());
            StmModificar.setString(7, txtCorreo.getText());
            StmModificar.setString(8, txtPassword.getText());

            StmModificar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error" + e);
        }
    }

    private void Eliminar() {
        try {
            PreparedStatement EliminarStm;
            String SQL = "delete from personal where idPersonal = ?";
            EliminarStm=Conex.MiConexion.getConexion().prepareCall(SQL);
            EliminarStm.setInt(1,Integer.parseInt(txtId.getText()));
            EliminarStm.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Dato eliminado correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"Error "+e);
        }
    }

    private boolean buscar(boolean mostrar) {
        try {
            PreparedStatement buscarStm;
            String SQL =" select*from personal where idPersonal = ?";
            buscarStm= Conex.MiConexion.getConexion().prepareCall(SQL);
            buscarStm.setInt(1,Integer.parseInt(txtId.getText()));
            ResultSet RsBuscar = buscarStm.executeQuery();
            while(RsBuscar.next()){
                if(mostrar==true){
                    txtNombre.setText(RsBuscar.getObject("nombre").toString());
                    txtApellidoPaterno.setText(RsBuscar.getObject("apellidoPaterno").toString());
                    txtApellidoMaterno.setText(RsBuscar.getObject("apellidoMaterno").toString());
                    txtDireccion.setText(RsBuscar.getObject("direccion").toString());
                    txtTelefono.setText(RsBuscar.getObject("telefono").toString());
                    txtPuesto.setText(RsBuscar.getObject("puesto").toString());
                    txtCorreo.setText(RsBuscar.getObject("correro").toString());
                    txtPassword.setText(RsBuscar.getObject("password").toString());
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Error"+ e);
            return false;
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtPuesto.setText("");
        txtCorreo.setText("");
        txtPassword.setText("");
    }

    private void guardar() {
        try {
            PreparedStatement StmGuardar;
            String SQL= "insert into personal(idPersonal, Nombre, ApellidoPaterno, ApellidoMaterno, Direccion, Telefono, Puesto, Correro, Password) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            StmGuardar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmGuardar.setInt(1,Integer.parseInt(txtId.getText()));
            StmGuardar.setString(2,txtNombre.getText());
            StmGuardar.setString(3,txtApellidoPaterno.getText());
            StmGuardar.setString(4,txtApellidoMaterno.getText());
            StmGuardar.setString(5,txtDireccion.getText());
            StmGuardar.setInt(6,Integer.parseInt(txtTelefono.getText()));
            StmGuardar.setString(7,txtCorreo.getText());
            StmGuardar.setString(8,txtPassword.getText());
            StmGuardar.setString(9,txtPuesto.getText());

            StmGuardar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane,"Datos insertados correctamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane,"Error "+e);
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
        if (!txtNombre.getText().isEmpty()){
            textFieldWhite(txtNombre);
        }
        if (!txtApellidoPaterno.getText().isEmpty()){
            textFieldWhite(txtApellidoPaterno);
        }
        if (!txtApellidoMaterno.getText().isEmpty()){
            textFieldWhite(txtApellidoMaterno);
        }
        if (!txtDireccion.getText().isEmpty()){
            textFieldWhite(txtDireccion);
        }
        if (!txtTelefono.getText().isEmpty()){
            textFieldWhite(txtTelefono);
        }
        if (!txtPuesto.getText().isEmpty()){
            textFieldWhite(txtPuesto);
        }
        if (!txtCorreo.getText().isEmpty()){
            textFieldWhite(txtCorreo);
        }
        if (!txtPassword.getText().isEmpty()){
            textFieldWhite(txtPassword);
        }
    }
}
