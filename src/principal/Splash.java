package principal;


import com.sun.awt.AWTUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Splash extends JFrame implements MouseListener, MouseMotionListener {
    ImageIcon iconoFondo = new ImageIcon(getClass().getResource("/imagenes/Conteo.gif"));
    JLabel lblFondo = new JLabel(iconoFondo);
    int x, y;

    public Splash(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(iconoFondo.getIconWidth(), iconoFondo.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        AWTUtilities.setWindowOpaque(this, false);
        lblFondo.addMouseListener(this);
        lblFondo.addMouseMotionListener(this);
        this.add(lblFondo);
        Conex.MiConexion.getConexion();
        this.setVisible(true);
        dormirSplash();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == lblFondo){
            x = e.getX();
            y = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lblFondo){
            lblFondo.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == lblFondo){
            this.setLocation(this.getLocation().x+e.getX()-x, this.getLocation().y+e.getY()-y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private void dormirSplash() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex){
            JOptionPane.showMessageDialog(rootPane, "Error:"+ex);
        } finally {
            this.dispose();
<<<<<<< Updated upstream
            Login ven = new Login();
=======
            Principal ven = new Principal();
>>>>>>> Stashed changes
        }
    }
}
