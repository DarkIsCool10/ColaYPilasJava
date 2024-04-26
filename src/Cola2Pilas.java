import java.util.EmptyStackException;

public class Cola2Pilas<T> {
    private Pila<T> pilaEntrada; // Pila para encolar elementos
    private Pila<T> pilaSalida; // Pila para desencolar elementos

    // Constructor para crear una cola con dos pilas vacías
    public Cola2Pilas() {
        this.pilaEntrada = new Pila<>();
        this.pilaSalida = new Pila<>();
    }

    // Método para encolar un elemento en la cola
    public void enqueue(T elemento) {
        pilaEntrada.apilar(elemento);
    }

    // Método para desencolar un elemento de la cola
    public T dequeue() throws EmptyStackException, Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Si la pila de salida está vacía, mover elementos de la pila de entrada a la pila de salida
        if (pilaSalida.isEmpty()) {
            while (!pilaEntrada.isEmpty()) {
                pilaSalida.apilar(pilaEntrada.desapilar());
            }
        }
        return pilaSalida.desapilar();
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return pilaEntrada.isEmpty() && pilaSalida.isEmpty();
    }
}