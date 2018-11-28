package principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ConsultarPelicula extends JDialogMethods implements ActionListener, KeyListener, MouseListener{

    public static String CadenaCodigo;
    private JButton btnConsultar = new JButton("Consultar");
    private JButton btnSalir = new JButton("Salir");
    private JLabel lblid = new JLabel("Nombre");
    private JTextField txtConsultar = new JTextField();
    DefaultTableModel Modelo = new DefaultTableModel();
    JTable JTabla = new JTable(Modelo);
    JScrollPane ScrollTabla = new JScrollPane(JTabla);

    public ConsultarPelicula(Frame owner, boolean modal) {
        super(owner,modal);
        addWindow(null, 800,600,"Consultar Peliculas", false, this);
        addButton(btnConsultar, null, 550, 35, 120, 30, this);
        addButton(btnSalir, null, 550, 80, 120, 30, this);
        addTextField(txtConsultar, 220, 35, 300, 30, null, this);
        addLabel(lblid,150,35,140,40,this);
        ScrollTabla.setBounds(60,120,670,400);
        this.add(ScrollTabla);
        txtConsultar.addKeyListener(this);
        inicializarTabla();
        llenarTablaPeliculas();

        this.setVisible(true);
    }

    private void limpiarTabla(){
        Modelo.setRowCount(0);
    }

    private void inicializarTabla() {
        Modelo.addColumn("idPeliculas");
        Modelo.addColumn("Titulo");
        Modelo.addColumn("Productor");
        Modelo.addColumn("Duración");
        Modelo.addColumn("Genero");
        Modelo.addColumn("Tipo");
    }

    private void llenarTablaPeliculas() {
        try {
            PreparedStatement buscarStm;
            String SQL = "select * from peliculas order by idPeliculas asc";
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

    private void buscarFrase() {
        try {
            PreparedStatement BuscarStm;
            String Sql = "select * from peliculas where Titulo like '%"+txtConsultar.getText()+"%'";
            BuscarStm = Conex.MiConexion.getConexion().prepareCall(Sql);
            ResultSet RsBuscar = BuscarStm.executeQuery();
            ResultSetMetaData RsMD = RsBuscar.getMetaData();
            int numeroDeColumnas = RsMD.getColumnCount();
            limpiarTabla();
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSalir){
            this.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtConsultar) {
            buscarFrase();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == JTabla){
            int FilaSeleccionada = JTabla.getSelectedRow();
            Object Codigo = Modelo.getValueAt(FilaSeleccionada, 0);
            CadenaCodigo = Codigo.toString();
        }else if(e.getSource() == btnConsultar) {
            this.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
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

