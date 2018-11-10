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
    JLabel lblBuscar = new JLabel("Buscar");
    JTextField txtBuscar = new JTextField();
    JButton btnAceptar = new JButton("Aceptar");

    DefaultTableModel Modelo = new DefaultTableModel();
    JTable Tabla = new JTable(Modelo);
    JScrollPane ScrollTabla = new JScrollPane(Tabla);

    public ConsultarPersonal(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 800,600,"Consultar Personal", false, this);
        addLabel(lblBuscar, 200,15,200,30, this);
        addTextField(txtBuscar, 250,35,262,30, "Buscar", this);
        addButton(btnAceptar, null,300,430,155,30,this);
        btnAceptar.addMouseListener(this);
        Tabla.addMouseListener(this);
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
            String Sql = "select * from persona where nombre like '%"+txtBuscar.getText()+"%'";
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
        if (e.getSource() == txtBuscar){
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
