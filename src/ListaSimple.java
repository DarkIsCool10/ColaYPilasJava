import java.util.ArrayList;
import java.util.List;

public class ListaSimple<T> {
    public Node<T> first;
    public Node<T> last;
    private int size;

    public ListaSimple() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isPair(int numero){
        return numero % 2 == 0;
    }

    public int getSize(){
        return size;
    }


    //Eliminar dado el valor de un nodo
    public T remove(T dato){
        Node<T> nodo = first;
        Node<T> previo = null;
        Node<T> siguiente = null;
        boolean encontrado = false;

        //buscar el nodo previo
        while(nodo!=null) {
            if( nodo.getData() == dato ) {
                encontrado = true;
                break;
            }
            previo = nodo;
            nodo = nodo.getNext();
        }

        if(encontrado) {
            siguiente = nodo.getNext();
            if( previo==null ) {
                first = siguiente;
            }else {
                previo.setNext(siguiente);
            }

            if(siguiente==null) {
                last = previo;
            }else {
                nodo.setNext(null);
            }

            nodo = null;
            size--;
            return dato;
        }
        throw new RuntimeException("El elemento no existe");
    }

    public void addAtStart(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        size++;
    }

    public void addAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    //Obtener el valor de un Nodo
    public T getNodeValue(int indice) {
        Node<T> nodoTemporal = null;
        int contador = 0;
        if(validIndex(indice)){
            nodoTemporal = first;
            while (contador < indice) {
                nodoTemporal = nodoTemporal.getNext();
                contador++;
            }
        }if(nodoTemporal != null)
            return nodoTemporal.getData();
        else
            return null;
    }

    //Verificar si indice es valido
    private boolean validIndex(int indice) {
        if( indice >= 0 && indice < size ) {
            return true;
        }
        throw new IndexOutOfBoundsException("Not valid index");
    }

    /**
     * Returns a list containing the data of nodes at odd positions (1-based indexing).
     *
     * @return A list containing the data of nodes at odd positions.
     */
    public List<T> getOddPositionNumbers() {
        List<T> oddNumbers = new ArrayList<>();
        int position = 1;
        Node<T> current = first;
        while (current != null) {
            if (position % 2 != 0) {
                oddNumbers.add(current.getData());
            }
            position++;
            current = current.getNext();
        }
        return oddNumbers;
    }

    /**
     * Imprime en consola la lista enlazada
     */
    public void printList() {
        Node<T> aux = first;
        while(aux!=null) {
            System.out.print( aux.getData()+"\t" );
            aux = aux.getNext();
        }
        System.out.println();
    }

    // Método para invertir la lista utilizando una pila
    public void invertirLista() {
        //Instancia una pila vacia donde se guardaran los datos de la lista temporalmente
        Pila<T> pila = new Pila<>();

        // Llenar la pila con los elementos de la lista original
        Node<T> current = first;
        while (current != null) {
            pila.apilar(current.getData());
            current = current.getNext();
        }

        // Vaciar la pila para construir la lista invertida
        first = null;
        while (!pila.isEmpty()) {
            T data = null;
            try {
                data = pila.desapilar();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            addAtEnd(data);
        }
    }
}
