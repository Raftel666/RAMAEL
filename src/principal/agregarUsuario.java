package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class agregarUsuario extends JDialogMethods implements ActionListener {
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




    public agregarUsuario(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,600,"Agregar Usuario", false, this);

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
        addButton(btnSalir, null, 250, 280, 120, 30, this);

        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar){
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
