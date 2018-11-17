package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Principal extends JFrameMethods {
    ImageIcon ImFondo = new ImageIcon(getClass().getResource("/imagenes/bg.jpg"));
    ImageIcon IconWin = new ImageIcon(getClass().getResource("/imagenes/book.png"));
    PanelImagen ImagenFondo = new PanelImagen(ImFondo);
    private JMenuBar BarraDeMenu = new JMenuBar();

    private JMenu MenuUsuario = new JMenu("Usuario");
    private JMenuItem MenuUsuarioAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuUsuarioConsultar = new JMenuItem("Consultar");

    private JMenu MenuPersonal = new JMenu("Personal");
    private JMenuItem MenuPersonalAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuPersonalConsultar = new JMenuItem("Consultar");


    private JMenu MenuPelicula = new JMenu("Peliculas");
    private JMenuItem MenuPeliculaAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuPeliculaConsultar = new JMenuItem("Consultar");


    private JMenu MenuLibros = new JMenu("Libros");
    private JMenuItem MenuLibrosAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuLibrosConsultar = new JMenuItem("Consultar");

    private JMenu MenuComics = new JMenu("Cómics");
    private JMenuItem MenuComicsAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuComicsConsultar = new JMenuItem("Consultar");


    public Principal() {
        addWindowProperty(IconWin, ImagenFondo, 1000, 600, "Principal", false, this);
        //Agregar Menu
        addMenuBar(BarraDeMenu, Color.darkGray, Color.BLACK, this);

        addMenu(BarraDeMenu, MenuUsuario, Color.white);
        addMenuItem(MenuUsuario, MenuUsuarioAgregar, null, this);
        addMenuItem(MenuUsuario, MenuUsuarioConsultar, null, this);

        addMenu(BarraDeMenu, MenuPersonal, Color.white);
        addMenuItem(MenuPersonal, MenuPersonalAgregar, null, this);
        addMenuItem(MenuPersonal, MenuPersonalConsultar, null, this);

        addMenu(BarraDeMenu, MenuPelicula, Color.white);
        addMenuItem(MenuPelicula, MenuPeliculaAgregar, null, this);
        addMenuItem(MenuPelicula, MenuPeliculaConsultar, null, this);

        addMenu(BarraDeMenu, MenuLibros, Color.white);
        addMenuItem(MenuLibros, MenuLibrosAgregar, null, this);
        addMenuItem(MenuLibros, MenuLibrosConsultar, null, this);

        addMenu(BarraDeMenu, MenuComics, Color.white);
        addMenuItem(MenuComics, MenuComicsAgregar, null, this);
        addMenuItem(MenuComics, MenuComicsConsultar, null, this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MenuUsuarioAgregar) {
            UsuarioController add = new UsuarioController(this, true);
        } else if (e.getSource() == MenuUsuarioConsultar) {
            ConsultarUsuario add = new ConsultarUsuario(this, true);
        } else if (e.getSource() == MenuPersonalAgregar) {
            PersonalController add = new PersonalController(this, true);
        } else if (e.getSource() == MenuPeliculaAgregar) {
            PeliculaController add = new PeliculaController(this, true);
        } else if (e.getSource() == MenuLibrosAgregar) {
            LibroController add = new LibroController(this, true);
        } else if (e.getSource() == MenuComicsAgregar) {
            ComicController add = new ComicController(this, true);
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
