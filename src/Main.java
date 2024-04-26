public class Main {
    public static void main(String[] args) throws Exception {

        /*
        Pila<Integer> pilaAux = new Pila<>();
        Cola<Integer> cola = new Cola<>();

        pilaAux.apilar(1);
        pilaAux.apilar(2);
        pilaAux.apilar(3);
        pilaAux.apilar(4);
        pilaAux.apilar(5);
        pilaAux.apilar(6);
        pilaAux.apilar(7);
        pilaAux.apilar(8);
        pilaAux.apilar(9);
        pilaAux.apilar(10);

        pilaAux.numeroPrimos(pilaAux,cola);
        printCola(cola);

        ListaSimple<Integer> listaAux = new ListaSimple<>();

        listaAux.addAtStart(10);
        listaAux.addAtStart(20);
        listaAux.addAtStart(12);
        listaAux.addAtStart(78);
        listaAux.addAtStart(40);


        listaAux.printList();
        listaAux.invertirLista();
        System.out.println("\n");
        listaAux.printList();
        */

        //eliminarElementos(pilaAux, 2, 4);
        //printPila(pilaAux);

        //========================== Metodos de persona ===================================//

        Cola<Persona> personas = new Cola<>();

        personas.encolar(new Persona("Valeria",20,"Femenino"));
        personas.encolar(new Persona("Camilo",30,"Masculino"));
        personas.encolar(new Persona("Andres",45,"Masculino"));
        personas.encolar(new Persona("Santiago",15,"Masculino"));
        personas.encolar(new Persona("Milena",45,"Femenino"));
        personas.encolar(new Persona("Juan",32,"Masculino"));
        personas.encolar(new Persona("Florez",29,"Masculino"));

        personas.invertirColaPersonas();
        //personas.eliminarHombres();
        printCola(personas);

        int numero = 48;
        System.out.println(convertirBinerio(numero) + "\n");

        String cadena1 = "(6-7)/4]";
        String cadena2 = "[(1+2)*4]+5";

        System.out.println("La cadena \"" + cadena1 + "\" está balanceada? " + estaBalanceado(cadena1));
        System.out.println("La cadena \"" + cadena2 + "\" está balanceada? " + estaBalanceado(cadena2));


        // Ejemplo de uso de la cola con dos pilas
        Cola2Pilas<Integer> cola = new Cola2Pilas<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        System.out.println("Elemento desencolado: " + cola.dequeue()); // Output: 1
        cola.enqueue(4);
        System.out.println("Elemento desencolado: " + cola.dequeue()); // Output: 2
        System.out.println("Elemento desencolado: " + cola.dequeue()); // Output: 3
        System.out.println("Elemento desencolado: " + cola.dequeue()); // Output: 4

    }



    public static boolean estaBalanceado(String cadena) throws Exception {
        Pila<Character> pila = new Pila<>();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.apilar(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                // Verificar si la pila está vacía o si el carácter de cierre no coincide con el de apertura correspondiente
                if (pila.isEmpty() || !esPar(caracter, pila.desapilar())) {
                    return false;
                }
            }
        }

        // Si la pila está vacía al final, los paréntesis están balanceados
        return pila.isEmpty();
    }

    // Método auxiliar para verificar si un carácter de cierre coincide con su par de apertura correspondiente
    private static boolean esPar(char cierre, char apertura) {
        return (cierre == ')' && apertura == '(') ||
                (cierre == ']' && apertura == '[') ||
                (cierre == '}' && apertura == '{');
    }


    public static int convertirBinerio(int num) throws Exception {
        Pila<Integer> pila = new Pila<>();

        while (num > 0) {
            pila.apilar(num % 2);
            num /= 2;
        }

        while (!pila.isEmpty()) {
            System.out.print(pila.desapilar());
        }
        return num;
    }

    private static <T> void eliminarElementos(Pila<T> p, int nivelInf, int nivelSup) throws Exception {
        Pila<T> pilaAux = new Pila<>();
       int nivelActual= 1;

       while(!p.isEmpty() && nivelActual < nivelInf){
           pilaAux.apilar(p.desapilar());
           nivelActual++;
        }

        while((!p.isEmpty() && nivelActual <= nivelSup) && !p.isEmpty() && nivelActual>= nivelInf  ){
            p.desapilar();
            nivelActual++;
        }
        while(!p.isEmpty() && nivelActual > nivelSup){
            pilaAux.apilar(p.desapilar());
        }
        while(!pilaAux.isEmpty()){

            p.apilar(pilaAux.desapilar());
        }

    }

    public static <T> void printPila(Pila<T> pila) throws Exception {
        Pila<T> aux = pila;
        while(!aux.isEmpty()){
            System.out.println(aux.desapilar());
        }
    }

    public static <T> void printCola(Cola<T> cola) throws Exception {
        Cola<T> aux = cola;
        while(!aux.isEmpty()){
            System.out.println(aux.desencolar());
        }
    }

}


