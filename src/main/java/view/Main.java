/* 
    Nombre del programa: Program_3
    Nombre: Andrés David Mojica Ospina
    Fecha: 28-02-2016
    Descripción: Es la clase principal de ejecución del programa
*/
package view;

import controller.Reporte;

import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main 
{
    // Metodo de set-up
    public static void main(String[] args) 
    {
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/", (req, res) -> "Hello World");
        Reporte reporte = new Reporte();        
    }   
}
