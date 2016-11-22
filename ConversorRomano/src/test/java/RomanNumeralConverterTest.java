/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import practica.RomanNumeralConverter;

/**
 *
 * @author Aileen
 */
public class RomanNumeralConverterTest {
     public RomanNumeralConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDeberiaDevolver1SiPasoI() {       
         elaborarPrueba("I",1);    
    }
    

     @Test
     public void testDeberiaDevolver2SiPasoII(){       
        elaborarPrueba("II",2);     
     }
     
     public void testDeberiaDevolver7SiPasoVII(){
        elaborarPrueba("VII",7);
     }
    
     
    @Test 
     public void testDeberiaDevolver8SiPasoVIII(){
        elaborarPrueba("VIII",8);
     }
     
    @Test
     public void testDeberiaDevolver4SiPasoIV(){
         elaborarPrueba("IV",4);
     }
     
    @Test
     public void testDeberiaDevolver6SiPasoVI(){
         elaborarPrueba("VI", 6);
     }
    
    @Test
    public void testDeberiaDevolver10SiPasoX(){
        elaborarPrueba("X", 10);
    }
    @Test
    public void testDeberiaDevolver50SiPasoL(){
        elaborarPrueba("L", 50);
    }
    @Test
    public void testDeberiaDevolver100SiPasoC(){
        elaborarPrueba("C", 100);
    }
    @Test
    public void testDeberiaDevolver500SiPasoD(){
        elaborarPrueba("D", 500);
    }
    @Test
    public void testDeberiaDevolver1000SiPasoM(){
        elaborarPrueba("M", 1000);
    }
    
    @Test
    public void testDeberiaDevolver999SiPasoCMXCIX(){
        elaborarPrueba("CMXCIX", 999);
    }
    
    @Test
    public void testDeberiaDevolver39SiPasoXXXIX(){
        elaborarPrueba("XXXIX", 39);
    }
    
    //Pruebas de la regla que no puede repetir mas de 4 veces un símbolo
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoIIII(){      
        try {
       	 RomanNumeralConverter.convert("IIII");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoXXXX(){      
        try {
       	 RomanNumeralConverter.convert("XXXX");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoCCCC(){      
        try {
       	 RomanNumeralConverter.convert("CCCC");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoMMMM(){      
        try {
       	 RomanNumeralConverter.convert("MMMM");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoIIIIXIV(){      
        try {
       	 RomanNumeralConverter.convert("IIIIXIV");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    //Pruebas de la regla que no se puede restar un símbolo de dos pesos menores
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoIL(){      
        try {
       	 RomanNumeralConverter.convert("IL");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoXD(){      
        try {
       	 RomanNumeralConverter.convert("XD");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoXMIL(){      
        try {
       	 RomanNumeralConverter.convert("XMIL");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    //prueba para verificar que no se ingrese un símbolo diferente al alfabeto
    
    @Test 
    public void testDeberiaBotarExcepcionSiPasoABC(){      
        try {
       	 RomanNumeralConverter.convert("ABC");
            fail();
    
        } catch (IllegalArgumentException e) {
        }   
         catch (Exception e){   
            e.printStackTrace();
            fail();
                 } 
    }
    
    //prueba que verifica que es compatible con mayusculas y minusculas
    
    @Test
    public void testDeberiaDevolver49SiPasoXLIX(){
        elaborarPrueba("XliX", 49);
    }
    
    @Test
    public void testDeberiaDevolver800SiPasoDCCC(){
        elaborarPrueba("dccc", 800);
    }
    
    //prueba para verificar que los espacios no los tiene en cuenta
    
    @Test
    public void testDeberiaDevolver99SiPasoXCIX(){
        elaborarPrueba("X C IX", 99);
    }
    
    @Test
    public void testDeberiaDevolver400SiPasoCD(){
        elaborarPrueba("C                                           D", 400);
    }
    
     public void elaborarPrueba(String entrada, int esperado){
         int salida = RomanNumeralConverter.convert(entrada);
         assertEquals(esperado, salida);     
     }
     
}
