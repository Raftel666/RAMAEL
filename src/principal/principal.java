package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class principal extends JFrameMethods{
    private JMenuBar BarraDeMenu = new JMenuBar();
    private JMenu MenuUsuario = new JMenu("Usuario");
    private JMenuItem MenuUsuarioAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuUsuarioConsultar = new JMenuItem("Consultar");


    public principal() {
        addWindowProperty(null, 800, 600, "Principal", false, this);
        //Agregar Menu
        addMenuBar(BarraDeMenu, Color.darkGray, Color.BLACK, this);
        addMenu(BarraDeMenu, MenuUsuario, Color.white);
        addMenuItem(MenuUsuario, MenuUsuarioAgregar, null, this);
        addMenuItem(MenuUsuario, MenuUsuarioConsultar, null, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== MenuUsuarioAgregar) {
            agregarUsuario agregar = new agregarUsuario(this, true);
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
