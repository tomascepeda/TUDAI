package E2;

import java.util.ArrayList;

/*

CORRECIONES EN BASE A LA DEVOLUCION:

Si el arbol esta vacio tanto el constructor como si quiero eliminar un elemento retorna una excepcion 

contructor() complejidad no es correcta, tenes un for recorriendo toda la lista y el metodo add tiene su complejidad tambien

getElementAtLevel(object) la complejidad no es correcta, mismo razonamiento que getFrontera, si el peor de los casos me dan el ultimo nivel tengo que recorrer todo.

Tener en cuenta: pusiste "Complejidad O(n) siendo n la posicion del elemento a agregar // en el peor caso el elemento debera ser agregado al final de la estructura" esto es sinonimo de la altura

getLongestBranch imprime al reves

Detales:

Faltan metodos: 0

Metodos que no andan: 0

Complejidades mal calculadas: 2

Casos elementos: 1

imrpime al reves
*/

public class Tree {

	private Integer valor;
	private Tree izquierda;
	private Tree derecha;

	public Tree() {
		this.valor = null;
		this.izquierda = null;
		this.derecha = null;
	}

	public Tree(int valor) {
		this.valor = valor;
		this.izquierda = null;
		this.derecha = null;
	}

	// Complejidad O(n*h) siendo n la cantidad de elementos en el arreglo y h la altura del arbol
	// en el peor caso el elemento es el ultimo del arreglo y debera ser agregado al final de la estructura del arbol
	public Tree(int[] valores) {
		if (valores.length < 0)
			return;
		this.valor = valores[0];
		for (int i = 1; i < valores.length; i++) {
			add(valores[i]); 
		}
	}

	// Complejidad O(h) siendo h la altura del arbol
	// en el peor caso el elemento debera ser agregado al final de la estructura
	public void add(int newValue) {

		if (this.isEmpty()) {
			this.valor = newValue;
			return;
		}

		if (newValue < this.valor) {
			if (this.izquierda == null)
				this.izquierda = new Tree(newValue);
			else
				this.izquierda.add(newValue);
		} else {
			if (this.derecha == null)
				this.derecha = new Tree(newValue);
			else
				this.derecha.add(newValue);
		}
	}

	// Complejidad O(n) siendo n la cantidad de valores del arbol
	public int getHeight() {

		if (this.isEmpty())
			return 0;

		int alturaIzq = 0;
		int alturaDer = 0;

		if (this.izquierda != null)
			alturaIzq = this.izquierda.getHeight() + 1;
		
		if (this.derecha != null)
			alturaDer = this.derecha.getHeight() + 1;
		
		int mayor = Math.max(alturaIzq, alturaDer);

		return mayor;
	}

	// Complejidad O(1)
	public Integer getRoot() {
		return valor;
	}

	// Complejidad O(n) siendo n la posicion del elemento a buscar
	// en el peor caso el elemento es una hoja
	public boolean hasElem(int o) {

		boolean has = false;

		if (this.isEmpty())
			return has;

		if (this.getRoot() == o)
			return true;

		if (o < this.getRoot() && this.izquierda != null)
			has = this.izquierda.hasElem(o);

		if (o > this.getRoot() && this.derecha != null)
			has = this.derecha.hasElem(o);

		return has;
	}

	// Complejidad O(1)
	public boolean isEmpty() {
		return valor == null;
	}

	// Complejidad O(h) siendo h la altura del arbol
	// en el peor caso el elemento esta en final de la rama mas larga
	public boolean delete(int valor) {

		boolean deleted = false;

		if (this.isEmpty())
			return deleted;

		if (this.getRoot() == valor) {

			if (this.izquierda != null) {

				if (this.izquierda.derecha == null && this.izquierda.izquierda != null) {
					this.valor = this.izquierda.getRoot();
					this.izquierda = this.izquierda.izquierda;
				}

				else if (this.izquierda.derecha == null && this.izquierda.izquierda == null) {
					this.valor = this.izquierda.getRoot();
					this.izquierda = null;
				}

				else
					this.valor = this.izquierda.extractPredecessor(this);

			} else if (this.derecha != null) {

				if (this.derecha.izquierda == null && this.derecha.derecha != null) {
					this.valor = this.derecha.getRoot();
					this.derecha = this.derecha.derecha;
				}

				else if (this.derecha.izquierda == null && this.derecha.derecha == null) {
					this.valor = this.derecha.getRoot();
					this.derecha = null;
				}

				else
					this.valor = this.derecha.extractSucesor(this);

			} else
				this.valor = null;

			return true;
		}

		if (this.getRoot() > valor && this.izquierda != null)
			deleted = this.izquierda.delete(valor, this); // voy a eliminar desde mi rama izquierda

		if (!deleted && (this.getRoot() < valor) && this.derecha != null)
			deleted = this.derecha.delete(valor, this); // voy a eliminar desde mi rama derecha

		return deleted;
	}

	// Complejidad O(h) siendo h la altura del arbol
	// en el peor caso el elemento esta en final de la rama mas larga
	private boolean delete(int valor, Tree padre) {

		boolean deleted = false;

		if (this.getRoot() == valor) { // encontre el que quiero borrar

			if (this.izquierda == null && this.derecha == null) { // es una hoja
				if (padre.getRoot() > valor)
					padre.izquierda = null;
				else
					padre.derecha = null;
				return true;
			}

			if (this.izquierda != null && this.derecha == null) { // solo tiene menores
				if (padre.getRoot() > valor)
					padre.izquierda = this.izquierda;
				else
					padre.derecha = this.izquierda;
				return true;
			}

			if (this.izquierda == null && this.derecha != null) { // solo tiene mayores
				if (padre.getRoot() > valor)
					padre.izquierda = this.derecha;
				else
					padre.derecha = this.derecha;
				return true;
			}

			if (this.izquierda != null && this.derecha != null) { // tiene sus 2 hijos

				if (this.izquierda.derecha == null && this.izquierda.izquierda != null) {
					this.valor = this.izquierda.getRoot();
					this.izquierda = this.izquierda.izquierda;
				}

				else if (this.izquierda.derecha == null && this.izquierda.izquierda == null) {
					this.valor = this.izquierda.getRoot();
					this.izquierda = null;
				}

				else
					this.valor = this.izquierda.extractPredecessor(this); // saco el menor mas cercano y lo seteo pisando mi valor (mantiene orden)
				return true;
			}
		}

		if ((this.getRoot() > valor) && (this.izquierda != null))
			deleted = this.izquierda.delete(valor, this); // sigo avanzando en los menores

		if (!deleted && (this.getRoot() < valor) && (this.derecha != null))
			deleted = this.derecha.delete(valor, this); // sigo avanzando en los mayores

		return deleted;
	}

	// Complejidad O(h) siendo h la altura del arbol
	// en el peor caso el elemento esta en final de la rama mas larga
	private int extractSucesor(Tree padre) {

		int sucesor = 0;

		if (this.izquierda == null) { // estoy en el mas chico
			sucesor = this.getRoot();
			if (this.derecha != null) { // borro el sub-arbol de la estructura
				padre.izquierda = this.derecha;
			} else
				padre.izquierda = null;
		} else
			sucesor = this.izquierda.extractSucesor(this); // sigo avanzando en los menores

		return sucesor;
	}

	// Complejidad O(h) siendo h la altura del arbol
	// en el peor caso el elemento esta en final de la rama mas larga
	private int extractPredecessor(Tree padre) {

		int predecessor = 0;

		if (this.derecha == null) { // estoy en el mas grande
			predecessor = this.getRoot();
			if (this.izquierda != null) { // borro el sub-arbol de la estructura
				padre.derecha = this.izquierda;
			} else
				padre.derecha = null;
		} else
			predecessor = this.derecha.extractPredecessor(this); // sigo avanzando en los mayores

		return predecessor;
	}

	// Complejidad O(n) siendo n la cantidad de elementos de la estructura
	public ArrayList<Integer> getLongestBranch() {

		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		if (this.isEmpty())
			return lista1;
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		
		lista1.add(this.getRoot());
		lista2.add(this.getRoot());

		if (this.izquierda != null)
			lista1.addAll(izquierda.getLongestBranch());

		if (this.derecha != null)
			lista2.addAll(derecha.getLongestBranch());

		if (lista1.size() > lista2.size())
			return lista1;
		else
			return lista2;
	}

	// Complejidad O(n) siendo n la cantidad de elementos de la estructura
	public ArrayList<Integer> getFrontera() {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		if (this.isEmpty())
			return lista;

		if (this.izquierda == null && this.derecha == null)
			lista.add(this.getRoot());

		if (this.izquierda != null)
			lista.addAll(izquierda.getFrontera());

		if (this.derecha != null)
			lista.addAll(derecha.getFrontera());

		return lista;
	}

	// Complejidad O(h) siendo h la altura del arbol
	public Integer getMaxElem() {

		if (this.isEmpty())
			return null;

		if (this.derecha == null)
			return this.getRoot();
		else
			return this.derecha.getMaxElem();
	}

	// Complejidad O(n) siendo n la cantidad de elementos del arbol
	// en el peor de los casos me dan el ultimo nivel y tengo que recorrer todo
	public ArrayList<Integer> getElementAtLevel(int nivel) {

		if (nivel < 0 || nivel > this.getHeight() || this.isEmpty())
			return new ArrayList<Integer>();

		ArrayList<Integer> lista = new ArrayList<Integer>();

		if (nivel == 0) {
			lista.add(this.getRoot());
			return lista;
		}

		if (this.izquierda != null)
			lista.addAll(izquierda.getElementAtLevel(nivel, 1));

		if (this.derecha != null)
			lista.addAll(derecha.getElementAtLevel(nivel, 1));

		return lista;
	}

	// Complejidad O(n) siendo n la cantidad de elementos del arbol
	// en el peor de los casos me dan el ultimo nivel y tengo que recorrer todo
	private ArrayList<Integer> getElementAtLevel(int nivel, int currentlvl) {
		ArrayList<Integer> lista = new ArrayList<Integer>();

		if (this.isEmpty())
			return lista;

		if (nivel == currentlvl) {
			lista.add(this.getRoot());
			return lista;
		}

		if (this.izquierda != null)
			lista.addAll(izquierda.getElementAtLevel(nivel, currentlvl + 1));

		if (this.derecha != null)
			lista.addAll(derecha.getElementAtLevel(nivel, currentlvl + 1));

		return lista;
	}

	// prints

	// Complejidad O(n) siendo n la cantidad de elementos de la estructura
	public void printPreOrder() {
		if (this != null)
			System.out.print("[" + this.valor + "]");
		else
			return;

		if (this.izquierda != null)
			this.izquierda.printPreOrder();
		else
			System.out.print("-");

		if (this.derecha != null)
			this.derecha.printPreOrder();
		else
			System.out.print("-");
	}

	// Complejidad O(n) siendo n la cantidad de elementos de la estructura
	public void printInOrder() {

		if (this.izquierda != null)
			this.izquierda.printInOrder();
		else
			System.out.print("-");

		if (this != null)
			System.out.print("[" + this.valor + "]");
		else
			return;

		if (this.derecha != null)
			this.derecha.printInOrder();
		else
			System.out.print("-");
	}

	// Complejidad O(n) siendo n la cantidad de elementos de la estructura
	public void printPosOrder() {
		if (this.izquierda != null)
			this.izquierda.printPosOrder();
		else
			System.out.print("-");

		if (this.derecha != null)
			this.derecha.printPosOrder();
		else
			System.out.print("-");

		if (this != null)
			System.out.print("[" + this.valor + "]");
		else
			return;
	}

}