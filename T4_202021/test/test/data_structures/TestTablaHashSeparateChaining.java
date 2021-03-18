package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import model.data_structures.TablaHashSeparateChaining;

public class TestTablaHashSeparateChaining 
{	
	private TablaHashSeparateChaining tablaSeparateChaining;
	private static final int INIT_CAPACITY = 4;
	
	public void setUp1() {
		tablaSeparateChaining= new TablaHashSeparateChaining(4);
		tablaSeparateChaining.put(1, "X");
		tablaSeparateChaining.put(2, "Z");
		tablaSeparateChaining.put(3,"Y");
		tablaSeparateChaining.put(4,"W" );

	}

	private void testTablaHashLinearProbing() 
	{
		setUp1();
		assertNotNull("Se debe haber creado una tabla de tamaño "+INIT_CAPACITY, tablaSeparateChaining);
	}

	public void testSize() 
	{
		setUp1();
		assertEquals("El numero esperado no fue devuelto", INIT_CAPACITY, tablaSeparateChaining.size());
	}
	public void testContains() {


		setUp1();
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaSeparateChaining.contains(1));
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaSeparateChaining.contains(2));
		
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaSeparateChaining.contains(3));
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaSeparateChaining.contains(4));
	}
	
	public void testGet() 
	{
		setUp1();
		assertEquals("Lo que se esperaba  no fue devuelto","X", tablaSeparateChaining.get(1));
		assertEquals("Lo que se esperaba  no fue devuelto","Z", tablaSeparateChaining.get(2));
		assertEquals("Lo que se esperaba  no fue devuelto","Y", tablaSeparateChaining.get(3));
		assertEquals("Lo que se esperaba  fue devuelto","W", tablaSeparateChaining.get(4));
	}

	public void testEliminar() 
	{
		setUp1();
		tablaSeparateChaining.remove(1);
		assertFalse("No fue eliminado", tablaSeparateChaining.contains(1));
	}
}
