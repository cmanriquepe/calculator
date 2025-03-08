package Calculadora;

 public class ModeloCalculadora {
    private double resultado;
    private String operador;
    private boolean iniciarNuevoNumero;
    public ModeloCalculadora() {
        resultado = 0;
        operador = "";
        iniciarNuevoNumero = true;
    }
    public double getResultado() {
        return resultado;
    }
    public void setOperador(String op) {
        operador = op;

    }
    public void procesarInput(double input) {
        if (operador.equals("")) {
            resultado = input;
        } else {
            switch (operador) {
                case "+":
                    resultado += input;
                    break;
                case "-":
                    resultado-= input;
                    break;
                case "*":
                    resultado *= input;
                    break;
                case "/":
                    if (input != 0) {
                        resultado /= input;
                    } else {
                        throw new ArithmeticException("División por cero");
                    }
                    break;
            }
            operador = "";
        }
        iniciarNuevoNumero = true;
    }
    public boolean isIniciarNuevoNumero() {
        return iniciarNuevoNumero;
    }
    public void setIniciarNuevoNumero(boolean iniciarNuevoNumero) {
        this.iniciarNuevoNumero = iniciarNuevoNumero;
    }
    public void limpiar() {
        resultado = 0;
        operador = "";
        iniciarNuevoNumero = true;
    }
 }