package test.data_structures;

import model.data_structures.TablaHashLinearProbing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import junit.framework.TestCase;
import org.junit.Test;
public class TestTablaHashLinearProbing 
{
	private static final int INIT_CAPACITY = 4;
	private TablaHashLinearProbing tablaLinearProbing;

	public void setUp1() {
		tablaLinearProbing= new TablaHashLinearProbing(INIT_CAPACITY);
		tablaLinearProbing.put(1, "X");
		tablaLinearProbing.put(2, "Z");
		tablaLinearProbing.put(3,"Y");
		tablaLinearProbing.put(4,"W" );

	}

	private void testTablaHashLinearProbing() 
	{
		setUp1();
		assertNotNull("Se debe haber creado una tabla de tamaño "+INIT_CAPACITY, tablaLinearProbing);
	}

	public void testSize() 
	{
		setUp1();
		assertEquals("El numero esperado no fue devuelto", INIT_CAPACITY, tablaLinearProbing.size());
	}
	public void testContains() {


		setUp1();
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaLinearProbing.contains(1));
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaLinearProbing.contains(2));
		
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaLinearProbing.contains(3));
		assertEquals("Lo que se esperaba no fue devuelto",true, tablaLinearProbing.contains(4));
	}
	
	public void testGet() 
	{
		setUp1();
		assertEquals("Lo que se esperaba  no fue devuelto","X", tablaLinearProbing.get(1));
		assertEquals("Lo que se esperaba  no fue devuelto","Z", tablaLinearProbing.get(2));
		assertEquals("Lo que se esperaba  no fue devuelto","Y", tablaLinearProbing.get(3));
		assertEquals("Lo que se esperaba  fue devuelto","W", tablaLinearProbing.get(4));
	}

	public void testEliminar() 
	{
		setUp1();
		tablaLinearProbing.remove(1);
		assertFalse("No fue eliminado", tablaLinearProbing.contains(1));
	}



}
