package Calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCalculadora implements ActionListener {
    private ModeloCalculadora modelo;
    private VistaCalculadora vista;
    private String actualInput;
    
    public ControladorCalculadora(ModeloCalculadora modelo, VistaCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.actualInput = "";
        vista.setController(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = ((javax.swing.JButton) e.getSource()).getText();
        
        try {
            if (comando.matches("[0-9]")) {
                if (modelo.isIniciarNuevoNumero()) {
                    actualInput = comando;
                    modelo.setIniciarNuevoNumero(false);
                } else {
                    actualInput += comando;
                }
                vista.updateDisplay(actualInput);
            } else if (comando.equals("C")) {  
                if (!actualInput.isEmpty()) {
                    actualInput = actualInput.substring(0, actualInput.length() - 1);
                    vista.updateDisplay(actualInput);
                }
            } else if (comando.equals("CE")) { // Limpiar toda la pantalla
                actualInput = "";
                modelo.limpiar();
                vista.updateDisplay("");
            } else if (comando.matches("[+\\-*/]")) {
                // Procesar el número actual
                double inputNumero = actualInput.isEmpty() ? 0 : Double.parseDouble(actualInput);
                modelo.procesarInput(inputNumero);
                modelo.setOperador(comando);
                actualInput = "";
                vista.updateDisplay(String.valueOf(modelo.getResultado()));
            }
        } catch (ArithmeticException ex) {
            vista.updateDisplay("Error: " + ex.getMessage());
            actualInput = "";
            modelo.limpiar();
        }
    }
 }