package model.data_structures;

public class TablaHashSeparateChaining<K extends Comparable<K>, V> implements TablaSimbolos <K, V>
{
	private class Nodo<K, V>  
	{

		private K key;
		private V value;
		private Nodo<K, V> next;
		public Nodo()
		{

		}


		public Nodo(K k, V value, Nodo siquiente)
		{
			this.key= (K) k;
			this.value= (V) value;
			this.next= siquiente;
		}

	}

	private int n;
	private int m;
	private Nodo<K, V>[] table;

	public TablaHashSeparateChaining(int capacidad)
	{
		this.m = capacidad;
		this.n = 0;
		table = (Nodo<K, V>[]) new Nodo[capacidad];
		for (int i = 0; i < m; i++)
		{
			table[i] = (Nodo<K, V>) new Nodo();
		}
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public boolean contains(K key) 
	{
		boolean r = false;
		int i = hash(key);
		Nodo x = table[i];
		Nodo p = null;
		while (x != null) 
		{
			if (key.equals(x.key))
			{
				r = true;
			}
			p = x;
			x = x.next;
		}
		return r;
	}

	private Nodo[] st = new Nodo[m]; 
	private int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff) % m; 
	}

	public void put(K key, V value)
	{
		if (key == null)
		{
			throw new IllegalArgumentException("called put() with key is null.");
		}

		if (n >= 5 * m)
			resize(2 * m);
		int i = hash(key);
		Nodo x = table[i];
		Nodo p = null;
		while (x != null) 
		{
			if (key.equals(x.key))
			{
				x.value = (Object[]) value;
				return;
			}
			p = x;
			x = x.next;
		}
		if (p == null) 
		{
			table[i] = new Nodo(key, value, null);
			n++;
		} 
		else 
		{
			p.next = new Nodo(key, value, null);
			n++;
		}

	}

	public V get(K key) 
	{
		int i = hash(key);
		Nodo x = table[i];
		while (x != null)
		{
			if (key.equals(x.key))
				return (V) x.value;
			x = x.next;
		}
		return null;
	}

	public V remove(K key)
	{	

		if (get(key)==null)

			return null;
		int i = hash(key);
		Nodo x = table[i];
		Nodo p = null;
		V oldValue = null;
		while (x != null) 
		{
			if (key.equals(x.key))
			{
				oldValue = (V) x.value;
				if (p == null)
				{
					table[i] = x.next;
				} 
				else 
				{
					p.next = x.next;
				}
				n--;
				break;
			}
			p = x;
			x = x.next;
		}

		if (m > 5 && n <= 2 * m)
			resize(m / 2);
		return oldValue;
	}



	private void resize(int capacity)
	{
		TablaHashSeparateChaining<K, V> temp = new TablaHashSeparateChaining<K, V>(capacity);
		for (int i = 0; i < m; i++) 
		{
			Nodo<K, V> x = table[i];
			while (x != null) 
			{
				K k = x.key;
				if (k != null)
					temp.put(k, this.get(k));
				x = x.next;
			}
		}
		this.m = temp.m;
		this.n = temp.n;
		this.table = temp.table;
	}

	public Cola keySet() 
	{
		Cola<K> queue = new Cola<K>();
		int i=0;
		Nodo x= table[i];
		for (int j = 0; i < m; j++)		
		{	
			if (x.key != null)
			{
				queue.enqueue((K) x.key);
			}
		}    
		return queue;
	}

	public Cola valueSet() 
	{
		Cola<V> queue = new Cola<V>();
		int i=0;
		Nodo x= table[i];
		for (int j = 0; i < m; j++)		
		{	
			if (x.value != null)
			{
				queue.enqueue((V) x.value);
			}
		}    
		return queue;
	}



}
