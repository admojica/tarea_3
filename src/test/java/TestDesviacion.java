/* 
    Nombre del programa: Program_3
    Nombre: Andrés David Mojica Ospina
    Fecha: 29-02-2016
    Descripción: Clase que permite probar los metodos del programa 3
*/
import controller.Desviacion;
import java.util.LinkedList;
import model.AbrirDatos;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDesviacion
{
    
    //private Desviacion desviacion = new Desviacion();
    private final AbrirDatos abrir_datos = new AbrirDatos();
    private final Desviacion desviacion = new Desviacion();
    
    LinkedList lista_prueba_1;
    LinkedList lista_prueba_2;
    LinkedList prueba_multiplicacion;
    LinkedList prueba_cuadrado;
    Double prueba_sumatoria;
    
    @Before
    public void setUp() 
    {
        lista_prueba_1 = abrir_datos.llenarLista("src/main/java/data/estimated.txt");
        lista_prueba_2 = abrir_datos.llenarLista("src/main/java/data/actual_added.txt");
        prueba_cuadrado = desviacion.potenciaCuadrado(lista_prueba_1);
        prueba_multiplicacion = desviacion.multiplicacion(lista_prueba_1, lista_prueba_2);
        prueba_sumatoria = desviacion.sumatoria(lista_prueba_1);
    }
    
    @Test
    public void testAbrirDatos()
    {
        assertNotNull(lista_prueba_1);
        assertNotNull(lista_prueba_2);
    }
    
    @Test
    public void testDesviacion()
    {
        assertEquals(16900.0, prueba_cuadrado.get(0));
        assertEquals(454350.0, prueba_multiplicacion.get(1));
        assertEquals(3828.0, prueba_sumatoria, 0);        
    }
    
    @Test
    public void testReporte()
    {
        assertTrue("  Beta 0  | Beta 1 |  rxy  |   r2   |   Yk\n" +
        "-22,5525 | 1,7279 | 0,9545 | 0,9111 | 644,4294\n" +
        "-4,0389 | 0,1681 | 0,9333 | 0,8711 | 60,8580\n" +
        "-23,9239 | 1,4310 | 0,9631 | 0,9276 | 528,4294\n" +
        "-4,6037 | 0,1402 | 0,9480 | 0,8988 | 49,4994", true);
    }
    
}
