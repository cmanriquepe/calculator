package Calculadora;

 import javax.swing.SwingUtilities;

 public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        ModeloCalculadora modelo = new ModeloCalculadora();
        VistaCalculadora vista = new VistaCalculadora();
        new ControladorCalculadora(modelo, vista);
        vista.setVisible(true); 
        });
    }
 }
