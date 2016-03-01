/* 
    Nombre del programa: Program_3
    Nombre: Andrés David Mojica Ospina
    Fecha: 28-02-2016
    Descripción: Permite obtener los valores para la desviación estándar de dos listas
*/
package controller;

import java.text.DecimalFormat;
import java.util.LinkedList;

public final class Desviacion 
{
    // Metodo constructor
    public Desviacion(LinkedList lista_a, LinkedList lista_b, Double estimated_LOC)
    {
        Double tamano_lista = (double) lista_a.size();
        
        LinkedList lista_cuadrado_a = potenciaCuadrado(lista_a);
        LinkedList lista_cuadrado_b = potenciaCuadrado(lista_b);
        LinkedList lista_multiplicacion = multiplicacion(lista_a, lista_b);
        
        Double sumatoria_a = sumatoria(lista_a);
        Double sumatoria_b = sumatoria(lista_b);
        
        Double sumatoria_cuadrado_a = sumatoria(lista_cuadrado_a);
        Double sumatoria_cuadrado_b = sumatoria(lista_cuadrado_b);
        Double sumatoria_multiplicacion = sumatoria(lista_multiplicacion);
        
        // Beta_1
        Double numerador_beta_1 = ((sumatoria_multiplicacion) - (tamano_lista * (sumatoria_a/tamano_lista) * (sumatoria_b/tamano_lista)));
        Double denominador_beta_1 = ((sumatoria_cuadrado_a) - (tamano_lista * Math.pow(sumatoria_a/tamano_lista, 2)));
        Double beta_1 = numerador_beta_1 / denominador_beta_1;
        
        // r_x_y
        Double numerador_rxy = (tamano_lista * sumatoria_multiplicacion) - (sumatoria_a * sumatoria_b);
        Double denominador_rxy = Math.sqrt( ((tamano_lista * sumatoria_cuadrado_a) - Math.pow(sumatoria_a , 2)) * ((tamano_lista * sumatoria_cuadrado_b) - Math.pow(sumatoria_b , 2)) );
        Double rxy = numerador_rxy / denominador_rxy;
        
        // r cuadrado
        Double r_cuadrado = Math.pow(rxy, 2);
        
        // Beta_0
        Double beta_0 = (sumatoria_b / tamano_lista) - (beta_1 * sumatoria_a/tamano_lista);
        
        // Yk
        Double Yk = beta_0 + (beta_1 * estimated_LOC);
        
        DecimalFormat formato = new DecimalFormat("##0.0000");
        
        System.out.println( formato.format(beta_0) + " | " + formato.format(beta_1) + " | " + formato.format(rxy) + " | " + formato.format(r_cuadrado) + " | " + formato.format(Yk));
    }
    
    // Metodo para obtener la potencia al cuadrado
    public LinkedList potenciaCuadrado(LinkedList lista)
    {
        LinkedList lista_cuadrado = new LinkedList();
        for(int i = 0; i < lista.size(); i++)
        {
            lista_cuadrado.add( Math.pow( (Double) lista.get(i), 2));
        }
        return lista_cuadrado;
    }
    
    // Metodo para obtener la multiplicación de los dos factores de la desviación estándar
    public LinkedList multiplicacion(LinkedList lista_a, LinkedList lista_b)
    {
        LinkedList lista_multiplicada = new LinkedList();
        for(int i = 0; i < lista_a.size(); i++)
        {
            lista_multiplicada.add( (Double) lista_a.get(i) * (Double) lista_b.get(i) );
        }
        return lista_multiplicada;
    }
    
    // Metodo para sumar la lista
    public Double sumatoria(LinkedList lista)
    {
        Double suma = 0.0;
        for(int i = 0; i < lista.size(); i++)
        {
            suma += (Double) lista.get(i);
        }
        return suma;
    }
    
}
