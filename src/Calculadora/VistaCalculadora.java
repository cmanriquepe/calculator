package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaCalculadora extends JFrame {
    private JTextField display;
    private JButton[] botones;
    private String[] botonesLabels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "C", "CE", "+"
    };
    public VistaCalculadora() {
        initComponents();
    }
    private void initComponents() {
        setTitle("Calculadora Básica");
 
       setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        botones = new JButton[botonesLabels.length];
        for (int i = 0; i < botonesLabels.length; i++) {
            botones[i] = new JButton(botonesLabels[i]);
            botones[i].setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(botones[i]);
        }
        add(panel, BorderLayout.CENTER);
    }
    public void setController(ActionListener controller) {
        for (JButton btn : botones) {

            btn.addActionListener(controller);
        }
    }
    public void updateDisplay(String text) {
        display.setText(text);
    }
    public String getDisplayText() {
        return display.getText();
    }
 }