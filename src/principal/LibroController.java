package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroController extends JDialogMethods {
    JLabel lbId = new JLabel("ISBN:");
    JLabel lbTitulo = new JLabel("Titulo:");
    JLabel lbAutor = new JLabel("Autor:");
    JLabel lbEditorial = new JLabel("Editorial:");
    JLabel lbPaginas = new JLabel("No. Paginas:");
    JLabel lbGenero = new JLabel("Genero:");
    JLabel lbTipo = new JLabel("Tipo:");

    JTextField txtId = new JTextField();
    JTextField txtTitulo = new JTextField();
    JTextField txtAutor = new JTextField();
    JTextField txtEditorial = new JTextField();
    JTextField txtPaginas = new JTextField();
    JTextField txtGenero = new JTextField();
    JTextField txtTipo = new JTextField();

    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnSalir = new JButton("Salir");
    private JButton btnModificar = new JButton("Modificar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnConsultar = new JButton("Consultar");
    private JButton btnLimpiar = new JButton("Limpiar");

    public LibroController(Frame owner, boolean modal) {
        super(owner, modal);
        addWindow(null, 400, 480, "Agregar Libro", false, this);

        addLabel(lbId, 10, 10, 100, 30, this);
        addLabel(lbTitulo, 10, 70, 100, 30, this);
        addLabel(lbAutor, 10, 130, 150, 30, this);
        addLabel(lbEditorial, 10, 190, 150, 30, this);
        addLabel(lbPaginas, 10, 250, 150, 30, this);
        addLabel(lbGenero, 10, 310, 150, 30, this);
        addLabel(lbTipo, 10, 370, 150, 30, this);

        addButton(btnGuardar, null, 250, 40, 120, 30, this);
        addButton(btnConsultar, null, 250, 100, 120, 30, this);
        addButton(btnModificar, null, 250, 160, 120, 30, this);
        addButton(btnEliminar, null, 250, 220, 120, 30, this);
        addButton(btnLimpiar, null, 250, 280, 120, 30, this);
        addButton(btnSalir, null, 250, 340, 120, 30, this);

        addTextField(txtId, 10, 40, 200, 30, "ISBN...", this);
        addTextField(txtTitulo, 10, 100, 200, 30, "Titulo...", this);
        addTextField(txtAutor, 10, 160, 200, 30, "Autor...", this);
        addTextField(txtEditorial, 10, 220, 200, 30, "Editorial...", this);
        addTextField(txtPaginas, 10, 280, 200, 30, "Paginas...", this);
        addTextField(txtGenero, 10, 340, 200, 30, "Genero...", this);
        addTextField(txtTipo, 10, 400, 200, 30, "Tipo...", this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            if (txtId.getText().isEmpty()) textFieldRed(txtId);
            if (txtTitulo.getText().isEmpty()) textFieldRed(txtTitulo);
            if (txtAutor.getText().isEmpty()) textFieldRed(txtAutor);
            if (txtEditorial.getText().isEmpty()) textFieldRed(txtEditorial);
            if (txtPaginas.getText().isEmpty()) textFieldRed(txtPaginas);
            if (txtGenero.getText().isEmpty()) textFieldRed(txtGenero);
            if (txtTipo.getText().isEmpty()) textFieldRed(txtTipo);
            else {
                guardar();
                limpiarCampos();
            }
        } else if (e.getSource() == btnModificar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Campo ID no debe de estar vacío");
            } else {
                if (buscar(false) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                    limpiarCampos();
                } else {
                    int opc = JOptionPane.showConfirmDialog(rootPane, "¿Deseas modificarlo?", "Alerta!", 0, 1);
                    if (opc == 0) {
                        modificar();
                        limpiarCampos();
                    }
                }
            }
        } else if (e.getSource() == btnConsultar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Campo id no debe estar vacio");
            } else {
                if (buscar(true) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                    limpiarCampos();
                }
            }
        } else if (e.getSource() == btnEliminar) {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "El campo del id no debe de estar vacio");
            } else {
                if (buscar(false) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Dato no existe");
                } else {
                    int opc;
                    opc = JOptionPane.showConfirmDialog(rootPane, "Eliminar producto", "Alerta", 0, 1);
                    if (opc == 0) {
                        Eliminar();
                        limpiarCampos();
                    }
                }
            }
        } else if (e.getSource() == btnLimpiar) {
            limpiarCampos();
        }
        if (e.getSource() == btnSalir) {
            this.dispose();
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtPaginas.setText("");
        txtGenero.setText("");
        txtTipo.setText("");
        txtId.requestFocus();
    }

    private void guardar() {
        try {
            PreparedStatement StmGuardar;
            String SQL = "insert into libros(ISBN, Titulo, Autor, Editorial, NoPaginas, Genero, tipo) values (?, ?, ?, ?, ?, ?, ?)";
            StmGuardar = Conex.MiConexion.getConexion().prepareCall(SQL);
            StmGuardar.setInt(1, Integer.parseInt(txtId.getText()));
            StmGuardar.setString(2, txtTitulo.getText());
            StmGuardar.setString(3, txtAutor.getText());
            StmGuardar.setString(4, txtEditorial.getText());
            StmGuardar.setInt(5, Integer.parseInt(txtPaginas.getText()));
            StmGuardar.setString(6, txtGenero.getText());
            StmGuardar.setString(7, txtTipo.getText());
            StmGuardar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos insertados correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Error" + e);
        }
    }

    private void modificar() {
        try {
            PreparedStatement StmModificar;
            String Sql = "update libros set Titulo = ?, Autor = ?, Editorial = ?, NoPaginas = ?, Genero = ?, tipo = ? where ISBN = ?";
            StmModificar = Conex.MiConexion.getConexion().prepareCall(Sql);
            StmModificar.setString(1, txtTitulo.getText());
            StmModificar.setString(2, txtAutor.getText());
            StmModificar.setString(3, txtEditorial.getText());
            StmModificar.setInt(4, Integer.parseInt(txtPaginas.getText()));
            StmModificar.setString(5, txtGenero.getText());
            StmModificar.setString(6, txtTipo.getText());
            StmModificar.setInt(7, Integer.parseInt(txtId.getText()));
            StmModificar.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error" + e);
        }
    }

    private boolean buscar(boolean mostrar) {
        try {
            PreparedStatement buscarStm;
            String SQL = " select*from libros where ISBN = ?";
            buscarStm = Conex.MiConexion.getConexion().prepareCall(SQL);
            buscarStm.setInt(1, Integer.parseInt(txtId.getText()));
            ResultSet RsBuscar = buscarStm.executeQuery();
            while (RsBuscar.next()) {
                if (mostrar) {
                    txtTitulo.setText(RsBuscar.getObject("titulo").toString());
                    txtAutor.setText(RsBuscar.getObject("autor").toString());
                    txtEditorial.setText(RsBuscar.getObject("editorial").toString());
                    txtPaginas.setText(RsBuscar.getObject("nopaginas").toString());
                    txtGenero.setText(RsBuscar.getObject("genero").toString());
                    txtTipo.setText(RsBuscar.getObject("tipo").toString());
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error" + e);
            return false;
        }
    }

    private void Eliminar() {
        try {
            PreparedStatement EliminarStm;
            String SQL = "delete from libros where ISBN = ?";
            EliminarStm = Conex.MiConexion.getConexion().prepareCall(SQL);
            EliminarStm.setInt(1, Integer.parseInt(txtId.getText()));
            EliminarStm.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Datos eliminados correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error" + e);
        }
    }

    private boolean validaCampoEntero(String Cadena, int longitud) {
        if (Cadena.matches("[0-9,.]+") && Cadena.length() < longitud + 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes de teclear solo números y no \ndebe de " +
                    "estar vacio el campo \ny la longitud no debe de ser mayor a" + longitud, "Alerta!!!", 0);
            return false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == txtId) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoEntero(txtId.getText(), 11) == true) {
                    txtTitulo.requestFocus();
                } else
                    txtId.setText("");
            }
        } else if (e.getSource() == txtTitulo) {
            if (e.getKeyChar() == e.VK_ENTER) {
                txtAutor.requestFocus();
            }
        } else if (e.getSource() == txtAutor) {
            if (e.getKeyChar() == e.VK_ENTER) {
                txtEditorial.requestFocus();
            }
        } else if (e.getSource() == txtEditorial) {
            if (e.getKeyChar() == e.VK_ENTER) {
                txtPaginas.requestFocus();
            }
        } else if (e.getSource() == txtPaginas) {
            if (e.getKeyChar() == e.VK_ENTER) {
                if (validaCampoEntero(txtPaginas.getText(), 11) == true) {
                    txtGenero.requestFocus();
                } else
                    txtPaginas.setText("");
            }
        } else if (e.getSource() == txtGenero) {
            if (e.getKeyChar() == e.VK_ENTER) {
                txtTipo.requestFocus();
            }
        } else if (e.getSource() == txtTipo) {
            if (e.getKeyChar() == e.VK_ENTER) {
                btnGuardar.requestFocus();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!txtId.getText().isEmpty()) textFieldWhite(txtId);
        if (!txtTitulo.getText().isEmpty()) textFieldWhite(txtTitulo);
        if (!txtAutor.getText().isEmpty()) textFieldWhite(txtAutor);
        if (!txtEditorial.getText().isEmpty()) textFieldWhite(txtEditorial);
        if (!txtPaginas.getText().isEmpty()) textFieldWhite(txtPaginas);
        if (!txtGenero.getText().isEmpty()) textFieldWhite(txtGenero);
        if (!txtTipo.getText().isEmpty()) textFieldWhite(txtTipo);
    }

}