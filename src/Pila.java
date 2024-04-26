public class Pila <T> {

    private Node<T> end;

    private Integer size = 0;

    public Pila() {
        this.end = null;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    public boolean isEmpty(){
        return end==null;
    }


    public void apilar(T dato){
        Node<T> node = new Node<>(dato);
        if(isEmpty()){
            end = node;
        }else{
            node.setNext(end);
            end = node;
        }
    }

    public T desapilar() throws Exception {
        if(isEmpty()){
            throw new Exception(" The pile is busy");
        }
        else{
            T data = end.getData();
            end = end.getNext();
            return data;
        }
    }

    public void numeroPrimos(Pila<Integer> pila,Cola<Integer> cola) throws Exception {
        while(!pila.isEmpty()){
            int elemento = pila.desapilar();
            if(esPrimo(elemento)){
                cola.encolar(elemento);
            }
        }

    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }



}
