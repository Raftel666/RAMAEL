package principal;

import javax.swing.*;
import java.awt.*;

abstract class JDialogMethods extends JDialog {

    public JDialogMethods(Frame owner, boolean modal) {
        super(owner, modal);
    }

    public static void addWindow(ImageIcon icon, int width, int height, String Title, boolean Resizable, JDialog dialog){
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(width, height);
        dialog.setLocationRelativeTo(null);
        dialog.setTitle(Title);
        dialog.setResizable(Resizable);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(new Color(87,87,87));
    }

    public static void addLabel(JLabel Label, int x, int y, int width, int height, JDialog dialog){
        Label.setBounds(x, y, width, height);
        Label.setFont(new Font("Tahoma", Font.PLAIN,15));
        Label.setForeground(Color.black);
        dialog.add(Label);
    }

    public static void addTextField(JTextField TextField, int x, int y, int width, int height, String hint, JDialog dialog){
        TextField.setBounds(x, y, width, height);
        TextField.setUI(new HintTextFieldUI(hint));
        TextField.setBorder(BorderFactory.createLineBorder(Color.black));
        /**TextField.addKeyListener((KeyListener) dialog);*/
        dialog.add(TextField);
    }
}
