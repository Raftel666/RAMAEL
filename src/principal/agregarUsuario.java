package principal;

import javax.swing.*;
import java.awt.*;

public class agregarUsuario extends JDialogMethods {
    JLabel lbNombre = new JLabel("Nombre:");
    JLabel lbApellidoPaterno = new JLabel("Apellido Paterno:");
    JLabel lbApellidoMaterno = new JLabel("Apellido Materno:");
    JLabel lbCorreo = new JLabel("Correo electrónico:");
    JLabel lbDireccion = new JLabel("Dirección:");
    JLabel lbTelefono = new JLabel("Telefono:");
    JTextField txtNombre = new JTextField();
    JTextField txtApellidoPaterno = new JTextField();
    JTextField txtApellidoMaterno = new JTextField();
    JTextField txtCorreo = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextField txtTelefono = new JTextField();

    public agregarUsuario(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400,400,"", false, this);
        addLabel(lbNombre, 10,10,100,30, this);
        addTextField(txtNombre, 10, 40, 200,30, "Nombre...", this);
        addLabel(lbApellidoPaterno, 10,70,150,30, this);
        addTextField(txtApellidoPaterno, 10, 100, 200, 30, "Apellido paterno", this);
        addLabel(lbApellidoMaterno, 10, 130, 150, 30, this);
        addTextField(txtApellidoMaterno, 10, 160, 200, 30, "Apellido materno", this);
        this.setVisible(true);
    }
}

