package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class agregarPersonal extends JDialogMethods {
    JLabel lbId = new JLabel("Id:");
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbApellidoPaterno = new JLabel("Apellido Paterno:");
    JLabel lbApellidoMaterno = new JLabel("Apellido Materno:");
    JLabel lbCorreo = new JLabel("Correo electrónico:");
    JLabel lbDireccion = new JLabel("Dirección:");
    JLabel lbTelefono = new JLabel("Telefono:");
    JLabel lbPuesto = new JLabel("Puesto:");
    JTextField txtId = new JTextField();
    JTextField txtNombre = new JTextField();
    JTextField txtApellidoPaterno = new JTextField();
    JTextField txtApellidoMaterno = new JTextField();
    JTextField txtCorreo = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextField txtTelefono = new JTextField();
    JTextField txtPuesto = new JTextField();
    JButton btnGuardar = new JButton("Guardar");
    JButton btnSalir = new JButton("Salir");
    JButton btnModificar = new JButton("Modificar");
    JButton btnConsultar = new JButton("Consultar");
    JButton btnEliminar = new JButton("Eliminar");

    public agregarPersonal(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,530,"Agregar personal", false, this);

        addLabel(lbId, 10,10,100,30, this);
        addLabel(lbNombre, 10,70,100,30, this);
        addLabel(lbApellidoPaterno, 10,130,150,30, this);
        addLabel(lbApellidoMaterno, 10, 190, 150, 30, this);
        addLabel(lbCorreo, 10, 250, 150, 30, this);
        addLabel(lbDireccion, 10, 310, 150, 30, this);
        addLabel(lbTelefono, 10, 370, 150, 30, this);
        addLabel(lbPuesto, 10, 430, 150, 30, this);
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
        addTextField(txtDireccion, 10, 340, 200, 30, "Dirección...", this);
        addTextField(txtTelefono, 10, 400, 200, 30, "Telefono...", this);
        addTextField(txtPuesto, 10, 460, 200, 30, "Puesto...", this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            if (txtNombre.getText().isEmpty()){
                textFieldRed(txtNombre);
            }
            if (txtApellidoPaterno.getText().isEmpty()){
                textFieldRed(txtApellidoPaterno);
            }
            if (txtApellidoMaterno.getText().isEmpty()){
                textFieldRed(txtApellidoMaterno);
            }
            if (txtCorreo.getText().isEmpty()){
                textFieldRed(txtCorreo);
            }
            if (txtDireccion.getText().isEmpty()){
                textFieldRed(txtDireccion);
            }
            if (txtTelefono.getText().isEmpty()){
                textFieldRed(txtTelefono);
            }
            if (txtPuesto.getText().isEmpty()){
                textFieldRed(txtPuesto);
            }
        }
        if (e.getSource() == btnSalir){
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
        if (!txtPuesto.getText().isEmpty()){
            textFieldWhite(txtPuesto);
        }
    }
}
