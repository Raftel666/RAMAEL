package principal;

import java.awt.*;
import java.awt.event.*;

public class ConsultarPersonal extends JDialogMethods implements ActionListener, KeyListener, MouseListener {

    public static String CadenaCodigo; //Variable compartida todo mundo la conoce


    public ConsultarPersonal(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 800,600,"Consultar Personal", false, this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
