package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrameMethods {

    private JLabel LblTitulo = new JLabel("Por favor ingrese Correo y Contraseña"); //mensaje de login
    private JButton BtnLogin = new JButton("Ingresar"); //Boton Login
    private ImageIcon Icon = new ImageIcon(getClass().getResource("/imagenes/entrar.png"));
    private ImageIcon IconPass = new ImageIcon(getClass().getResource("/imagenes/Visible.png"));
    private ImageIcon IconPass2 = new ImageIcon(getClass().getResource("/imagenes/Invisible2.png"));
    private ImageIcon IconUsuario = new ImageIcon(getClass().getResource("/imagenes/Usuario.png"));
    private ImageIcon IconPass3 = new ImageIcon(getClass().getResource("/imagenes/Contraseña.png"));
    private ImageIcon Icon2 = new ImageIcon(getClass().getResource("/imagenes/UserCredentials.png"));
    private JLabel Label = new JLabel();//Label para Icono de Vista
    private JLabel Label2 = new JLabel();//Label para Icono de Usuario
    private JLabel Label3= new JLabel();//Label para Icono de Contraseña
    private JLabel Label4 = new JLabel();//Label para Icono del mensaje
    private JLabel LblCorreo = new JLabel("Correo: ");
    private JLabel LblPassword = new JLabel("Contraseña: ");
    private JLabel LblMensajeUs = new JLabel(); //Label para mensaje y mensajes vacios
    private JTextField txtEmail = new JTextField(); //Usuario
    private JPasswordField txtPass = new JPasswordField(); //Contraseña
    // private InputMap Enter = new InputMap(); //Enter

    public Login(){
        addWindowProperty(Icon2, null, 350, 230, "Login", false, this);
        addTypeLabel(LblTitulo, Color.WHITE, 80, 10, 350,40, this);
        addTypeLabel(LblCorreo, Color.BLACK, 30,80,70,20, this);
        addTypeLabel(LblPassword, Color.BLACK, 30,130,300,20, this);
        addTextField(txtEmail, 105,75,200,30, "Correo electrónico", this);
        addPasswordField(txtPass, 105,125,200,30, this);
        addButton(BtnLogin, Icon, 195,165,105,30, this);
        addImageLabel(Label, 310,135,16,16, IconPass, this);
        addImageLabel(Label2, 5,80,20,20, IconUsuario, this);
        addImageLabel(Label3, 5,130,100,20, IconPass3, this);
        addImageLabel(Label4,15,10,35,35, Icon2, this );
    }

    private void searchUser() {
        try {
            String CadenaEncryptada = encryptar(new String(txtPass.getPassword()));
            PreparedStatement StmBuscar;
            String SQL = "select * from personal where Correo = ? and Password = ?";
            StmBuscar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmBuscar.setString(1, txtEmail.getText());
            StmBuscar.setString(2, CadenaEncryptada);
            ResultSet RsBuscar = StmBuscar.executeQuery();
            if (RsBuscar.next()){
                JOptionPane.showMessageDialog(rootPane,"Bienvenido "+RsBuscar.getObject("nombre"));
                this.dispose();
                Pincipal inicio = new Pincipal();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña invalidos");
                cleanFields();
                txtEmail.requestFocus();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error: "+e);
        }
    }

    private void cleanFields() {
        txtEmail.setText("");
        txtPass.setText("");
    }

    private void  messageRed(){
        LblMensajeUs.setBounds(10, 165, 200, 30);
        LblMensajeUs.setForeground(Color.RED);
        LblMensajeUs.setText("Tiene campos vacíos");
        this.add(LblMensajeUs);
    }

    private static String encryptar(String Password) throws NoSuchAlgorithmException {
        MessageDigest Md = MessageDigest.getInstance("Md5");
        Md.update(Password.getBytes(),0,Password.length());
        return new BigInteger(1,Md.digest()).toString(16);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BtnLogin){
            if (txtEmail.getText().isEmpty()){
                validateTextFieldRED(txtEmail);
                messageRed();
            }
            if (txtPass.getPassword().length == 0){
                validatePassWordFieldRED(txtPass);
                messageRed();
            }
            if (!(txtEmail.getText().isEmpty()) && txtPass.getPassword().length !=0 ){
                searchUser();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==Label) {
            Label.setIcon(IconPass2);
            txtPass.setEchoChar((char) 0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource()==Label) {
            Label.setIcon(IconPass);
            txtPass.setEchoChar('•');
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!(txtEmail.getText().isEmpty())){
            validateTextFieldWhite(txtEmail);
            LblMensajeUs.setText("");
        }
        if (txtPass.getPassword().length != 0){
            validatePassWordFieldWhite(txtPass);
            LblMensajeUs.setText("");
        }
    }
}
