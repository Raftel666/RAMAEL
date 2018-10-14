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
        addWindow(null, 400,420,"", false, this);

        addLabel(lbNombre, 10,10,100,30, this);
        addLabel(lbApellidoPaterno, 10,70,150,30, this);
        addLabel(lbApellidoMaterno, 10, 130, 150, 30, this);
        addLabel(lbCorreo, 10, 190, 150, 30, this);
        addLabel(lbDireccion, 10, 250, 150, 30, this);
        addLabel(lbTelefono, 10, 310, 150, 30, this);

        addTextField(txtNombre, 10, 40, 200,30, "Nombre...", this);
        addTextField(txtApellidoPaterno, 10, 100, 200, 30, "Apellido paterno", this);
        addTextField(txtApellidoMaterno, 10, 160, 200, 30, "Apellido materno", this);
        addTextField(txtCorreo, 10, 220, 200, 30, "Correo", this);
        addTextField(txtDireccion, 10, 280, 200, 30, "Dirección", this);
        addTextField(txtTelefono, 10, 340, 200, 30, "Telefono", this);

        this.setVisible(true);
    }
}

