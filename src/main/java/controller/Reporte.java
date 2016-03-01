/* 
    Nombre del programa: Program_3
    Nombre: Andrés David Mojica Ospina
    Fecha: 28-02-2016
    Descripción: Clase que permite realizar el reporte
*/
package controller;

import java.util.LinkedList;
import model.AbrirDatos;

/**
 *
 * @author David
 */
public class Reporte 
{
    public Reporte()
    {
        AbrirDatos abrir_datos = new AbrirDatos();
        
        LinkedList estimated = abrir_datos.llenarLista("src/main/java/data/estimated.txt");
        LinkedList plan_added = abrir_datos.llenarLista("src/main/java/data/plan_added.txt");
        LinkedList actual_added = abrir_datos.llenarLista("src/main/java/data/actual_added.txt");
        LinkedList actual_development = abrir_datos.llenarLista("src/main/java/data/actual_development.txt");
        
        System.out.println("  Beta 0  | Beta 1 |  rxy  |   r2   |   Yk");
        
        Desviacion desviacion_1 = new Desviacion(estimated, actual_added, 386.0);
        Desviacion desviacion_2 = new Desviacion(estimated, actual_development, 386.0);
        Desviacion desviacion_3 = new Desviacion(plan_added, actual_added, 386.0);
        Desviacion desviacion_4 = new Desviacion(plan_added, actual_development, 386.0);
        
    }    
}
