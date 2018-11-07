package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class consultarUsuario extends JDialogMethods implements ActionListener {
    private JButton btnConsultar = new JButton("Consultar");
    private JButton btnSalir = new JButton("Salir");

    public consultarUsuario(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 800,620,"Consultar Usuario", false, this);
        addButton(btnConsultar, null, 250, 40, 120, 30, this);
        addButton(btnSalir, null, 250, 100, 120, 30, this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

    }
}
