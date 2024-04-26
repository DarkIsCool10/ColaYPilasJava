public class Cola<T> {

    public Node<T> start;
    public Node<T> end;
    public int amount;
    public int size;

    public Cola() {
        this.start = null;
        this.end = null;
        this.amount = amount;
        this.size = 0;
    }

    //Encolar
    public void encolar(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            start = end = newNode;
        } else {
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }

    //Desencolar
    // Método para eliminar el elemento del inicio de la cola y devolverlo
    public T desencolar() {
        T dataDelete = null;
        if (!isEmpty()) {
            dataDelete = start.data;
            start = start.next;
            if (start == null) {
                end = null;
            }
        }
        size--;
        return dataDelete;
    }

    // Método para obtener el elemento del frente de la cola
    public T obtenerFrente() {
        if (!isEmpty()) {
            return start.data;
        } else {
            throw new IllegalStateException("La cola esta vacia, no se puede obtener cola");
        }
    }

    //Metodo que diga si dos colas son iguales

    // Método para validar si dos colas son iguales
    public boolean sonIguales(Cola<T> Cola) {
        // Verificar si las colas tienen el mismo tamaño
        if (this.size != Cola.getSize()) {
            return false;
        }
        // Iterar sobre ambas colas para comparar sus elementos
        Node<T> actual1 = this.start;
        Node<T> actual2 = Cola.start;
        while (actual1 != null && actual2 != null) {
            // Comparar los elementos de los nodos actuales
            if (!actual1.data.equals(actual2.data)) {
                return false;
            }
            actual1 = actual1.next;
            actual2 = actual2.next;
        }
        // Si se llega al final de ambas colas y no se encontraron diferencias, las colas son iguales
        return true;
    }

    // Método para clonar la cola
    public Cola<T> clonarCola() {
        Cola<T> colaNueva = new Cola<>();
        // Iterar sobre la cola actual y agregar los elementos a la nueva cola
        Node<T> actual = start;
        while (actual != null){
            colaNueva.encolar(actual.data);
            actual = actual.next;
        }
        return colaNueva;
    }

    public void eliminarHombres(){
        Cola<Persona> colaAuxiliar = new Cola<>(); // Crear una cola auxiliar para almacenar temporalmente las personas que no cumplen las condiciones
        while (!isEmpty()) {
            Persona persona = (Persona) desencolar(); // Desencolar una persona de la cola original
            // Verificar si es hombre y su edad está entre 30 y 50 años
            if (!persona.getSexo().equals("Masculino") || persona.getEdad() < 30 || persona.getEdad() > 50) {
                colaAuxiliar.encolar(persona); // Si no cumple las condiciones, encolarla en la cola auxiliar
            }
            // Si cumple las condiciones, simplemente no se encola y se elimina de la cola original
        }
        // Una vez que se procesan todas las personas en la cola original, reemplazarla con la cola auxiliar
        while (!colaAuxiliar.isEmpty()) {
            encolar((T) colaAuxiliar.desencolar()); // Encolar las personas que no fueron eliminadas de la cola original
        }
    }

    public void invertirColaPersonas() throws Exception {
        Pila<Persona> pilaAuxiliar = new Pila<>();

        // Paso 1: Desapilar los elementos de la cola y apilarlos en la pila auxiliar
        while (!isEmpty()) {
            pilaAuxiliar.apilar((Persona) desencolar());
        }

        // Paso 2: Encolar los elementos de la pila auxiliar en la cola (en orden inverso)
        while (!pilaAuxiliar.isEmpty()) {
            encolar((T) pilaAuxiliar.desapilar());
        }
    }

    // Método para verificar si la cola está llena
    public boolean isFull() {
        return size == amount;
    }

    //Metodo para varificar que la cola esta vacia
    public boolean isEmpty() {
        return start == null;
    }

    public Node<T> getFirst() {
        return start;
    }

    public void setFirst(Node<T> start) {
        this.start = start;
    }

    public Node<T> getLast() {
        return end;
    }

    public void setLast(Node<T> end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //================= Metodos personas ==================//








}
