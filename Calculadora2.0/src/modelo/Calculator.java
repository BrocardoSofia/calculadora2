/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sofia
 */
public class Calculator {
    //---------------------------------------------- ATRIBUTOS
    private char operation;
    private String num1;
    private String num2;
    private boolean error;//si esto termina como true es necesario resetear los atributos
    
    //---------------------------------------------- METODOS
    public Calculator()
    {
        //inicializo todos los atributos
        resetAtributs();
    }
    
    public void resetAtributs()
    {
        //esta funcion inicializa o resetea los atributos
        this.operation = ' ';//operacion lo seteo como un espacio vacia
        
        //num 1 y num2 los seteo en 0 por si no me agrega uno de los dos numero el usuario
        this.num1 = "0";
        this.num2 = "0";
        error = false;//el error lo inicio en false
    }
    
    public void setOperation(char operation)
    {
        this.operation = operation;
    }
    
    public void setNum1(String num1)
    {
        if(!num1.isEmpty())//si el String que le paso por parametro no esta vacio lo seteo
            this.num1 = num1;
    }
    
    public void setNum2(String num2)
    {
        if(!num2.isEmpty())//si el String que le paso por parametro no esta vacio lo seteo
            this.num2 = num2;
    }
    
    public String calculate() //funcion para calcular con los atributos que tenga la calculadora
    {
        String result = "";
        if(operation != ' ')//si la operacion no tiene un espacio vacio
        {
            //paso Strings a doubles
            double number1 = (double)Double.parseDouble(num1);
            double number2 = (double)Double.parseDouble(num2);
            
            //segun la operacion que sea va a llamar a su respectiva funcion
            switch(operation)
            {
                case '+':
                    result = ""+add(number1,number2);
                    break;
                    
                case '-':
                    result = ""+subtract(number1,number2);
                    break;
                    
                case '*':
                    result = ""+multiply(number1,number2);
                    break;
                    
                case '/':
                    result = divide(number1,number2);
                    break;
            }
            
            if(!error)
                this.num1 = result;//reinicio el numero 1 como resultado por si quiero seguir haciendo operaciones
            else
                this.num1 = "0";//si hay error reinicio el numero 1
            this.num2 = "0";//reinicio el numero 2 siempre
            this.operation = ' '; //reinicio la operacion siempre
        }
        
        return result;
    }
    
    public boolean getError()
    {
        return error;//devuelve si hay un error
    }
    
    private String divide(double number1, double number2)
    {
        String result = "";
        
        if(number2 == 0)//no se puede dividir por cero
        {
            result = "ERROR: no se puede dividir por 0";
            error = true;
        }
        else
            result = ""+(number1/number2);
        
        return result;
    }
    
    private double multiply(double number1, double number2)
    {
        return (number1 * number2);
    }
    
    
    private double add(double number1, double number2)
    {
        return number1 + number2;
    }
    
    
    private double subtract(double number1, double number2)
    {
        return number1 - number2;
    }
}
