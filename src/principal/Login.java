package principal;

import com.sun.org.apache.xpath.internal.operations.String;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.*;
import java.sql.*;

public class Login extends JFrameMethods implements ActionListener, MouseListener {
    ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagenes/Book2.png"));
    ImageIcon imgUsuario = new ImageIcon(getClass().getResource("/imagenes/Usuario_L.png"));
    JLabel lblUsuario = new JLabel(imgUsuario);
    ImageIcon imgPassword = new ImageIcon(getClass().getResource("/imagenes/Password.png"));
    JLabel lblPassword = new JLabel(imgPassword);
    JTextField txtUsuario = new JTextField();
    JPasswordField txtPassWord = new JPasswordField();
    ImageIcon imgPassLocked = new ImageIcon(getClass().getResource("/imagenes/Password_C.png"));
    JLabel lblLocked = new JLabel(imgPassLocked);
    ImageIcon imgPassUnlocked = new ImageIcon(getClass().getResource("/imagenes/Password_U.png"));
    JButton btnLogin = new JButton("Login");

    public Login(){
        addWindowProperty(imgIcon, null, 600, 300, "Login", false, this);
        addLabel(lblUsuario, 100, 50, 140, 40, this);
        this.add(lblUsuario);
        addLabel(lblPassword, 100, 85, 140, 40, this);
        this.add(lblPassword);
        addLabel(lblLocked, 410, 90, 30, 40, this);
        addTextField(txtUsuario, 200, 60, 200, 20, "Usuario", this);
        addTextField(txtPassWord, 200, 95, 200, 20, "Password", this);
        addButton(btnLogin, null, 240, 150, 140, 40, this);
        this.add(txtUsuario);
        this.add(txtPassWord);
        this.add(btnLogin);
        btnLogin.addActionListener(this);
        lblLocked.addMouseListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin){
            buscarUsuario();
        }
    }

    private void buscarUsuario() {
        try {
            //String CadenaEncryptada = encryptar(new String(txtPassWord.getPassword()));
            PreparedStatement StmBuscar;
            java.lang.String SQL = "select * from usuarios where usuario = ? and password = ?";
            StmBuscar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmBuscar.setString(1, txtUsuario.getText());
           // StmBuscar.setString(2, CadenaEncryptada);
            ResultSet RsBuscar = StmBuscar.executeQuery();
            if (RsBuscar.next()){
                JOptionPane.showMessageDialog(rootPane,"Bienvenido "+RsBuscar.getObject("nombre"));
                this.dispose();
                principal inicio = new principal();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña invalidos");
                limpiarCampos();
                txtUsuario.requestFocus();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error: "+e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == lblLocked) {
            txtPassWord.setEchoChar((char) 0);
            lblLocked.setIcon(imgPassUnlocked);
            lblLocked.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == lblLocked){
            JPasswordField Locked = new JPasswordField();
            txtPassWord.setEchoChar(Locked.getEchoChar());
            lblLocked.setIcon(imgPassUnlocked);
            lblLocked.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == lblLocked){
            lblLocked.setToolTipText("Mostrar Password");
            lblLocked.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == lblLocked){
            lblLocked.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    /**
    private String encryptar(String password) throws NoSuchAlgorithmException{

       MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(password.getBytes(), 0, password.length());
        return new BigInteger(1, Md.digest().toString());
         
    }
     */

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtPassWord.setText("");
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
