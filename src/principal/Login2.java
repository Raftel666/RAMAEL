package principal;
/**
 * Created by ignacio on 08/10/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class Login2 extends JFrame implements ActionListener, MouseListener, KeyListener{

    //Conexion MiConexion = new Conexion("localhost:3306","bdpuntodeventa","root","");
    private JLabel LblTitulo = new JLabel("Por favor ingrese Usuario y Contraseña"); //mensaje de login
    private JButton BtnLogin = new JButton("Ingresar"); //Boton Login
    private ImageIcon Icon = new ImageIcon(getClass().getResource("/imagenes/entrar.png"));
    private ImageIcon IconPass = new ImageIcon(getClass().getResource("/imagenes/Visible.png"));
    private ImageIcon IconPass2 = new ImageIcon(getClass().getResource("/imagenes/Invisible2.png"));
    private ImageIcon IconUsuario = new ImageIcon(getClass().getResource("/imagenes/Usuario.png"));
    private ImageIcon IconPass3 = new ImageIcon(getClass().getResource("/imagenes/Contraseña.png"));
    private ImageIcon IconDeAcuerdo = new ImageIcon(getClass().getResource("/imagenes/DeAcuerdo.png"));
    private ImageIcon Icon2 = new ImageIcon(getClass().getResource("/imagenes/UserCredentials.png"));
    private ImageIcon Icon3 = new ImageIcon(getClass().getResource("/imagenes/ic_error_outline.png"));//ICONO JOptionPane
    private JLabel Label = new JLabel();//Label para Icono de Vista
    private JLabel Label2 = new JLabel();//Label para Icono de Usuario
    private JLabel Label3= new JLabel();//Label para Icono de Contraseña
    private JLabel Label4 = new JLabel();//Label para Icono del mensaje
    private JLabel LblUsuario = new JLabel("Usuario: ");
    private JLabel LblContra = new JLabel("Contraseña: ");
    private JLabel LblMensajeUs = new JLabel(); //Label para mensaje y mensajes vacios
    private JTextField TxtUsuario = new JTextField(); //Usuario
    private JPasswordField Pass = new JPasswordField(); //Contraseña
    private InputMap Enter = new InputMap(); //Enter
    String Tipo;

    public Login2() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(350, 230);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(87,87,87));
        //Titulo(Mensaje)
        LblTitulo.setBounds(0, 10, 350,40);
        LblTitulo.setForeground(Color.WHITE);
        LblTitulo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        this.add(LblTitulo);
        //Lbl's (Textos)
        LblUsuario.setBounds(30,80,70,20);
        this.add(LblUsuario);
        LblContra.setBounds(30,130,300,20);
        this.add(LblContra);
        //Lbl's (Mensajes) (Vacio)
        LblMensajeUs.setBounds(10, 165, 200, 30);
        this.add(LblMensajeUs);
        //TextField Usuario
        TxtUsuario.setBounds(105,75,200,30);
        TxtUsuario.setUI(new HintTextFieldUI("Usuario", false));
        TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(TxtUsuario);
        //passwordField Contraseña
        Pass.setBounds(105,125,200,30);
        Pass.setEchoChar(('•'));  //❁❂☢☣❅❄❆☀✦✹✺•
        /**
         *
         * Pass.setUI(new HintTextFieldUI("Contraseña"));
         *
         * */
        Pass.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        this.add(Pass);
        //Boton Login
        BtnLogin.setBounds(195,165,105,30);
        BtnLogin.setIcon(Icon);
        BtnLogin.setBackground(Color.DARK_GRAY);
        BtnLogin.setForeground(Color.WHITE);
        this.add(BtnLogin);
        //imagenes (Iconos)
        Label.setBounds(310,135,16,16);
        Label.setIcon(IconPass);
        this.add(Label);
        Label2.setBounds(5,80,20,20);
        Label2.setIcon(IconUsuario);
        this.add(Label2);
        Label3.setBounds(5,130,100,20);
        Label3.setIcon(IconPass3);
        this.add(Label3);
        Label4.setBounds(15,10,35,35);
        Label4.setIcon(Icon2);
        this.add(Label4);
        this.setIconImage(Icon2.getImage());//Cambia el icono de la esquina
        //Accion con la tecla enter
        Enter.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        Enter.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
        BtnLogin.setInputMap(0, Enter);
        //Oyentes (varios)
        Label.addMouseListener(this);
        BtnLogin.addActionListener(this);
        TxtUsuario.addKeyListener(this);
        Pass.addKeyListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//Para Validacion de campos
        JOptionPanePersonalized();
        if (e.getSource()==BtnLogin){
            if (TxtUsuario.getText().isEmpty() && Pass.getPassword().length==0){//Solo si los dos estan vacios
                LblMensajeUs.setText("Tiene campos vacíos");
                LblMensajeUs.setForeground(Color.RED);
                TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                Pass.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                TxtUsuario.setBackground(Color.pink);
                Pass.setBackground(Color.pink);
                TxtUsuario.requestFocus();
            }else if (TxtUsuario.getText().isEmpty()) {//Si el campo usuario esta vacio pone el borde de rojo
                LblMensajeUs.setText("Tiene campos vacíos");
                TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                TxtUsuario.setBackground(Color.pink);
                TxtUsuario.requestFocus();
                LblMensajeUs.setForeground(Color.RED);
            }else if (Pass.getPassword().length==0){//Si el campo de password esta vacio pone el borde de rojo
                LblMensajeUs.setText("Tiene campos vacíos");
                Pass.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                Pass.setBackground(Color.pink);
                Pass.requestFocus();
                LblMensajeUs.setForeground(Color.RED);
            }
        }
    }

    private void limpiarCampos() {//Limpia los campos
        TxtUsuario.setText("");
        Pass.setText("");
        TxtUsuario.requestFocus();
    }
    public void JOptionPanePersonalized(){//JOptionPane Personalizado
        UIManager UI = new UIManager();//Para Modificar el JOpctionPane (Swing UIManager Keys)
        UI.put("OptionPane.background", Color.gray);///////////////////
        UI.put("Panel.background", Color.gray);///////////////////////
        UI.put("Button.background", Color.DARK_GRAY);////////////////
        UI.put("Button.foreground", Color.white);///////////////////
    }

    private static String Encriptar(String Password) throws NoSuchAlgorithmException {
        MessageDigest Md = MessageDigest.getInstance("Md5");
        Md.update(Password.getBytes(),0,Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {//Para destapar Los carateres del password mientras esta presionando la imagen de ver
        if (e.getSource()==Label)
            Label.setIcon(IconPass2);
            Pass.setEchoChar((char)0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {//Vuelve ocultar el texto del password mientras no se presione la imagen de ver
        if (e.getSource()==Label)
            Label.setIcon(IconPass);
            Pass.setEchoChar('•');
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {//Si las casillas no estan vacias pintar borde de blanco

    }

    @Override
    public void keyPressed(KeyEvent e) {//Para que se mueva de casilla en casilla al teclear enter
        if (e.getSource()==TxtUsuario){
            if (e.getKeyChar()== e.VK_ENTER)
                Pass.requestFocus();
        }else if (e.getSource()==Pass){
            if (e.getKeyChar()==e.VK_ENTER)
                BtnLogin.requestFocus();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!TxtUsuario.getText().isEmpty() || !(Pass.getPassword().length ==0)) {
            TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            Pass.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            TxtUsuario.setBackground(Color.WHITE);
            Pass.setBackground(Color.WHITE);
            LblMensajeUs.setText("");
        }
    }
}
