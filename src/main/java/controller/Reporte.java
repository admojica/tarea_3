/* 
    Nombre del programa: Program_3
    Nombre: Andrés David Mojica Ospina
    Fecha: 28-02-2016
    Descripción: Clase que permite realizar el reporte de los factores de la desviación
*/
package controller;

import java.util.LinkedList;
import model.AbrirDatos;

public class Reporte 
{
    String reporte;
    
    // Metodo constructor del reporte
    public Reporte()
    {
        AbrirDatos abrir_datos = new AbrirDatos();
        
        LinkedList estimated = abrir_datos.llenarLista("src/main/java/data/estimated.txt");
        LinkedList plan_added = abrir_datos.llenarLista("src/main/java/data/plan_added.txt");
        LinkedList actual_added = abrir_datos.llenarLista("src/main/java/data/actual_added.txt");
        LinkedList actual_development = abrir_datos.llenarLista("src/main/java/data/actual_development.txt");
        
        reporte = " <table style='width:400px;border:1px solid black;'><tr><td>Beta 0</td><td>Beta 1</td><td>rxy</td><td>r2</td><td>Yk</td></tr>";
        
        Desviacion desviacion_1 = new Desviacion();
        desviacion_1.obtenerDesviacion(estimated, actual_added, 386.0);
        Desviacion desviacion_2 = new Desviacion();
        desviacion_2.obtenerDesviacion(estimated, actual_development, 386.0);
        Desviacion desviacion_3 = new Desviacion();
        desviacion_3.obtenerDesviacion(plan_added, actual_added, 386.0);
        Desviacion desviacion_4 = new Desviacion();
        desviacion_4.obtenerDesviacion(plan_added, actual_development, 386.0);
        
        reporte += desviacion_1.getDesviacion();
        reporte += desviacion_2.getDesviacion();
        reporte += desviacion_3.getDesviacion();
        reporte += desviacion_4.getDesviacion();
        reporte += "</table>";
    }
    
    // Metodo para retornar el resultado del reporte
    public String getReporte()
    {
        return this.reporte;
    }
}
