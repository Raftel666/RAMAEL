package principal;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ignacio on 04/12/2017.
 * Clase Abstracta con metodos genericos según las necesidades requeridas.
 * Aporte por Ignacio Castro 5to Semestre en constante actualización.
 *
 * Nota: Prestar atención a cada uno de los parametros que requieren cada uno de los metodos.
 *
 * Propiedad de Dynamite Developers (DynaDevs).
 * Última actualización : 25/12/2017 18:03.
 */
abstract class JFrameMethods extends JFrame implements ActionListener, MouseListener, KeyListener{
    /**
     * Metodo para agregar las propiedades de una ventana.
     * @param icon
     * @param width
     * @param height
     * @param Title
     * @param Resizable
     * @param frame
     */
    public static void addWindowProperty(ImageIcon icon, PanelImagen panelImagen, int width, int height, String Title, boolean Resizable, JFrame frame){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setTitle(Title);
        frame.setLocationRelativeTo(null);
        frame.setResizable(Resizable);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(87,87,87));
        frame.setContentPane(panelImagen);
        if (icon != null)
            frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    /**
     * Metodo para agragar TextField´s al Frame de la ventana.
     * @param TextField
     * @param x
     * @param y
     * @param width
     * @param height
     * @param hint
     * @param frame
     */
    public static void addTextField(JTextField TextField, int x, int y, int width, int height, String hint, JFrame frame) {
        TextField.setBounds(x, y, width, height);
        TextField.setUI(new HintTextFieldUI(hint));
        TextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TextField.addKeyListener((KeyListener) frame);
        frame.add(TextField);
    }

    /**
     *
     * @param PasswordField
     * @param x
     * @param y
     * @param width
     * @param height
     * @param frame
     */
    public static void addPasswordField(JPasswordField PasswordField, int x, int y, int width, int height, JFrame frame){
        PasswordField.setBounds(x, y, width, height);
        PasswordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PasswordField.addKeyListener((KeyListener) frame);
        PasswordField.setEchoChar('•');  //❁❂☢☣❅❄❆☀✦✹✺• Opciones...
        frame.add(PasswordField);
    }

    /**
     * Metodo para agregar JLabel´s al frame de la ventana.
     * @param Label
     * @param x
     * @param y
     * @param width
     * @param height
     * @param frame
     */
    public static void addLabel(JLabel Label, int x, int y, int width, int height, JFrame frame){
        Label.setBounds(x, y, width, height);
        Label.setFont(new Font("Tahoma", Font.PLAIN,25));
        Label.setForeground(Color.black);
        Label.addMouseListener((MouseListener) frame);
        frame.add(Label);
    }

    /**
     * Metodo para agregar JTextArea´s al frame de la ventana.
     * @param TextArea
     * @param x
     * @param y
     * @param width
     * @param height
     * @param frame
     */
    public static void addTextArea(JTextArea TextArea, int x, int y, int width, int height, JFrame frame){
        TextArea.setBounds(x, y, width, height);
        TextArea.setBackground(new Color(87,87,87));
        TextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(TextArea);
    }

    /**
     * Metodo para agregar Jbutton´s al frame de la ventana.
     * @param Button
     * @param x
     * @param y
     * @param width
     * @param height
     * @param frame
     */
    public static void addButton(JButton Button,ImageIcon icon, int x, int y, int width, int height, JFrame frame){
        Button.setBounds(x, y, width, height);
        Button.setIcon(icon);
        Button.setForeground(Color.WHITE);
        Button.setBackground(Color.GRAY);
        Button.addActionListener((ActionListener) frame);
        frame.add(Button);
    }

    /**
     * Metodo para regresar a la normalidad los JComponent´s ya sea cuando se utilise "mouseExited" o se presione <Backspace>
     * del keyPressed.(Examen)
     * @param Label
     * @param TextArea
     */
    public static void Normal_JComponent(JLabel Label, JTextArea TextArea){
        Label.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Label.setForeground(Color.black);
        TextArea.setBackground(new Color(87, 87, 87));
        TextArea.setText("");
    }

    /**
     * Metodo para cambiar las caracteristicas de los JComponent´s ya sea cuando se utilise "mouseEntered" o se presione <Enter>
     * del keyPressed.(Examen)
     * @param Label
     * @param TextArea
     * @param string
     */
    public static void Altered_JComponent(JLabel Label, JTextArea TextArea, String string){
        Label.setFont(new Font("Tahoma", Font.PLAIN,30));
        Label.setForeground(Color.RED);
        TextArea.setBackground(Color.white);
        TextArea.setText(string);
    }
    //<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>

    /**
     * Metodo para agregar UN MenuBar al frame de la pantalla.
     * @param MenuBar
     * @param Background
     * @param BorderColor
     * @param frame
     */
    public static void addMenuBar(JMenuBar MenuBar, Color Background, Color BorderColor, JFrame frame){
        MenuBar.setBackground(Background);
        MenuBar.setBorder(BorderFactory.createLineBorder(BorderColor));
        frame.setJMenuBar(MenuBar);
    }

    /**
     * Metodo para agregar Menus (JMenu) al frame de la pantalla
     * @param MenuBar
     * @param Menu
     * @param ColorForegroud
     */
    public static void addMenu(JMenuBar MenuBar, JMenu Menu, Color ColorForegroud){
        MenuBar.add(Menu);
        Menu.setForeground(ColorForegroud);
    }

    /**
     * Metodo para agregar JMenuitem del menu Jmenu
     * @param Menu
     * @param MenuItem
     * @param imageIcon
     * @param frame
     */
    public static void addMenuItem(JMenu Menu, JMenuItem MenuItem, ImageIcon imageIcon, JFrame frame){
        Menu.add(MenuItem);
        MenuItem.setBackground(Color.DARK_GRAY);
        MenuItem.setForeground(Color.WHITE);
        if (!(imageIcon == null))
            MenuItem.setIcon(imageIcon);
        MenuItem.addActionListener((ActionListener) frame);
    }

    /**
     * @param radio
     * @param x
     * @param y
     * @param width
     * @param height
     * @param group
     * @param frame
     */
    public static void addRadioButton(JRadioButton radio, int x, int y, int width, int height, ButtonGroup group, JFrame frame) {
        radio.setBounds(x, y, width, height);
        radio.addActionListener((ActionListener) frame);
        group.add(radio);
        frame.add(radio);
    }
    /**
     *
     * @param comboBox
     * @param x
     * @param y
     * @param width
     * @param height
     * @param frame
     */
    public static void addComboBox(JComboBox comboBox, int x, int y, int width, int height, JFrame frame) {
        comboBox.setBounds(x, y, width, height);
        comboBox.addMouseListener((MouseListener) frame);
        comboBox.addActionListener((ActionListener) frame);
        frame.add(comboBox);
    }

    /**
     * Metodo para calcular la fecha actual del equipo
     * @return
     */
     public static String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    /**
     *
     * @param TextField Es el unico parametro que se pide para que se vuelva rojo si estan vacio
     */
    public static void validateTextFieldRED(JTextField TextField){
            TextField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            TextField.setBackground(Color.pink);
            TextField.requestFocus();
    }
    /**
     *
     * @param TextField
     */
    public static void validateTextFieldWhite(JTextField TextField){
        TextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TextField.setBackground(Color.white);
    }
    /**
     *
     * @param SP
     * @param Table
     * @param x
     * @param y
     * @param width
     * @param height
     * @param ColorHeader
     * @param frame
     */
    public static void addTable(ScrollPane SP, JTable Table, int x, int y, int width, int height, Color ColorHeader, JFrame frame){
        SP.setBounds(x, y, width, height);
        JTableHeader EncabezadoTabla = Table.getTableHeader();
        EncabezadoTabla.setBackground(ColorHeader);
        Table.addMouseListener((MouseListener) frame);
        frame.add(SP);
    }

    /**
     *
     * @param Label
     * @param x
     * @param y
     * @param width
     * @param height
     * @param imageIcon
     * @param frame
     */
    public static void addImageLabel(JLabel Label, int x, int y, int width, int height, ImageIcon imageIcon, JFrame frame){
        Label.setBounds(x, y, width, height);
        Label.setIcon(imageIcon);
        Label.addMouseListener((MouseListener) frame);
        frame.add(Label);
    }
}
