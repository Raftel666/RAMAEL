package principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ConsultarPersonal extends JDialogMethods implements ActionListener, KeyListener, MouseListener {

    public static String CadenaCodigo; //Variable compartida todo mundo la conoce
    private JButton btnConsultar = new JButton("Consultar");
    private JButton btnSalir = new JButton("Salir");
    private JLabel lblid = new JLabel("Nombre");
    private JTextField txtConsultar = new JTextField();
    DefaultTableModel Modelo = new DefaultTableModel(); //1
    JTable JTabla = new JTable(Modelo); //2
    JScrollPane ScrollTabla = new JScrollPane(JTabla); //3

    public ConsultarPersonal(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 800,600,"Consultar personal", false, this);
        addButton(btnConsultar, null, 550, 35, 120, 30, this);
        addButton(btnSalir, null, 550, 70, 120, 30, this);
        addTextField(txtConsultar, 220, 35, 300, 30, null, this);
        addLabel(lblid,150,35,140,40,this);
        ScrollTabla.setBounds(60,120,670,400);
        this.add(ScrollTabla);

        txtConsultar.addKeyListener(this);
        inicializarTabla();
        llenarTablaPersonal();

        this.setVisible(true);

    }

    private void inicializarTabla() {
        Modelo.addColumn("idPersonal");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("ApellidoPaterno");
        Modelo.addColumn("ApellidoMaterno");
        Modelo.addColumn("Direccion");
        Modelo.addColumn("Telefono");
        Modelo.addColumn("Puesto");
        Modelo.addColumn("Correo");
        Modelo.addColumn("Password");

    }

    private void llenarTablaPersonal() {
        try {
            PreparedStatement buscarStm;
            String SQL = "select * from personal order by idPersonal desc";
            buscarStm = Conex.MiConexion.getConexion().prepareCall(SQL);
            ResultSet RsBuscar = buscarStm.executeQuery();
            ResultSetMetaData RsMD = RsBuscar.getMetaData();
            int numeroDeColumnas = RsMD.getColumnCount();
            while (RsBuscar.next()){
                Object Fila[] = new Object[numeroDeColumnas];
                for (int i = 0; i < Fila.length; i++){
                    Fila[i] = RsBuscar.getObject(i+1);
                }
                Modelo.addRow(Fila);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"Error: "+e);
        }
    }

    private void LimpiarTabla(){
        Modelo.setRowCount(0);
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

    private void buscarFrase() {
        try {
            PreparedStatement BuscarStm;
            String Sql = "select * from personal where nombre like '%"+txtConsultar.getText()+"%'";
            BuscarStm = Conex.MiConexion.getConexion().prepareCall(Sql);
            ResultSet RsBuscar = BuscarStm.executeQuery();
            ResultSetMetaData RsMD = RsBuscar.getMetaData();
            int numeroDeColumnas = RsMD.getColumnCount();
            LimpiarTabla();
            while (RsBuscar.next()){
                Object Fila[] = new Object[numeroDeColumnas];
                for (int i = 0; i < Fila.length; i++){
                    Fila[i] = RsBuscar.getObject(i+1);
                }
                Modelo.addRow(Fila);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"Error: "+e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtConsultar){
            buscarFrase();
        }
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
