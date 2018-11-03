package principal;

import com.sun.deploy.panel.JavaPanel;
import java.awt.*;
import javax.swing.*;
public class PanelImagen extends JPanel {
    ImageIcon ImagenFondo;


    public PanelImagen(ImageIcon ImagenFondo) {
        this.ImagenFondo = ImagenFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension tam = this.getSize();
        g.drawImage(ImagenFondo.getImage(),0,0,tam.width,tam.height,null);
    }


}
