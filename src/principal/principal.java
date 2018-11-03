package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class principal extends JFrameMethods {
    ImageIcon ImFondo = new ImageIcon(getClass().getResource("/imagenes/fondoLibro.jpg"));
    PanelImagen PanelI = new PanelImagen(ImFondo);
    private JMenuBar BarraDeMenu = new JMenuBar();

    private JMenu MenuUsuario = new JMenu("Usuario");
    private JMenuItem MenuUsuarioAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuUsuarioConsultar = new JMenuItem("Consultar");
    private JMenuItem MenuUsuarioModificar = new JMenuItem("Modificar");
    private JMenuItem MenuUsuarioEliminar = new JMenuItem("Eliminar");

    private JMenu MenuPersonal = new JMenu("Personal");
    private JMenuItem MenuPersonalAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuPersonalConsultar = new JMenuItem("Consultar");
    private JMenuItem MenuPersonalModificar = new JMenuItem("Modificar");
    private JMenuItem MenuPersonalEliminar = new JMenuItem("Eliminar");


    private JMenu MenuPelicula = new JMenu("Peliculas");
    private JMenuItem MenuPeliculaAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuPeliculaConsultar = new JMenuItem("Consultar");
    private JMenuItem MenuPeliculaModificar = new JMenuItem("Modificar");
    private JMenuItem MenuPeliculaEliminar  = new JMenuItem("Eliminar");


    private JMenu MenuLibros = new JMenu("Libros");
    private JMenuItem MenuLibrosAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuLibrosConsultar = new JMenuItem("Consultar");
    private JMenuItem MenuLibroModificar = new JMenuItem("Modificar");
    private JMenuItem MenuLibroEliminar  = new JMenuItem("Eliminar");

    private JMenu MenuComics = new JMenu("Cómics");
    private JMenuItem MenuComicsAgregar = new JMenuItem("Agregar");
    private JMenuItem MenuComicsConsultar = new JMenuItem("Consultar");
    private JMenuItem MenuComicsModificar = new JMenuItem("Modificar");
    private JMenuItem MenuComicsEliminar  = new JMenuItem("Eliminar");


    public principal() {
        addWindowProperty(null, 800, 600, "Principal", false, this);
        //Agregar Menu
       addMenuBar(BarraDeMenu, Color.darkGray, Color.BLACK, this);

        addMenu(BarraDeMenu, MenuUsuario, Color.white);
        addMenuItem(MenuUsuario, MenuUsuarioAgregar, null, this);
        addMenuItem(MenuUsuario, MenuUsuarioConsultar, null, this);
        addMenuItem(MenuUsuario, MenuUsuarioModificar, null, this);
        addMenuItem(MenuUsuario, MenuUsuarioEliminar, null, this);

        addMenu(BarraDeMenu, MenuPersonal, Color.white);
        addMenuItem(MenuPersonal, MenuPersonalAgregar, null, this);
        addMenuItem(MenuPersonal, MenuPersonalConsultar, null, this);
        addMenuItem(MenuPersonal, MenuPersonalModificar, null, this);
        addMenuItem(MenuPersonal, MenuPersonalEliminar, null, this);

        addMenu(BarraDeMenu, MenuPelicula, Color.white);
        addMenuItem(MenuPelicula, MenuPeliculaAgregar, null, this);
        addMenuItem(MenuPelicula, MenuPeliculaConsultar, null, this);
        addMenuItem(MenuPelicula, MenuPeliculaModificar, null, this);
        addMenuItem(MenuPelicula, MenuPeliculaEliminar, null, this);

        addMenu(BarraDeMenu, MenuLibros, Color.white);
        addMenuItem(MenuLibros, MenuLibrosAgregar, null, this);
        addMenuItem(MenuLibros, MenuLibrosConsultar, null, this);
        addMenuItem(MenuLibros, MenuLibroModificar, null, this);
        addMenuItem(MenuLibros, MenuLibroEliminar, null, this);
        addMenu(BarraDeMenu, MenuComics, Color.white);
        addMenuItem(MenuComics, MenuComicsAgregar, null, this);
        addMenuItem(MenuComics, MenuComicsConsultar, null, this);
        addMenuItem(MenuComics, MenuComicsModificar, null, this);
        addMenuItem(MenuComics, MenuComicsEliminar, null, this);
        this.add(PanelI);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MenuUsuarioAgregar) {
            agregarUsuario agregar = new agregarUsuario(this, true);
        } else if (e.getSource() == MenuPersonalAgregar) {
            agregarPersonal agregar = new agregarPersonal(this, true);
        } else if (e.getSource() == MenuPeliculaAgregar) {
            agregarPelicula agregar = new agregarPelicula(this, true);
        } else if (e.getSource() == MenuLibrosAgregar) {
            agregarLibro agregar = new agregarLibro(this, true);
        } else if (e.getSource() == MenuComicsAgregar) {
            agregarComic agregar = new agregarComic(this, true);
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
