import java.util.ArrayList;
import java.util.Arrays;

public class Resolucion {

    public static void main(String[] args) {
        long ini =System.nanoTime();
        int[][] inicio = {{1,2,3},
                          {7,8,4},
                          {6,5,0}};

        int[][] solucion = {{1,2,3},
                            {8,0,4},
                            {7,6,5}};
        Nodo inicial = new Nodo(inicio);
        buscarSolucion(inicial,solucion);
        long termino = System.nanoTime();
        System.out.println("tiempo ejecucion: " +(termino-ini));
    }

    public static void buscarSolucion(Nodo inicio,int[][] solucion) {
        ArrayList<Nodo> expandidos = new ArrayList<Nodo>();
        ArrayList<Nodo> visitados = new ArrayList<Nodo>();
        expandidos.add(inicio);
        Nodo revisar = null;
        int eliminar = 0;
        int cont=0;
        while(expandidos.size()!=0){
            ArrayList<Nodo> hijos = new ArrayList<Nodo>();
            System.out.println(cont);
            for(int i=0;i< expandidos.size();i++){
                if(i==0){
                    revisar = expandidos.get(0);
                } else if (revisar.getFuncionHeuristica() > expandidos.get(i).getFuncionHeuristica()) {
                    revisar = expandidos.get(i);
                    eliminar = i;
                }
            }
            if(Arrays.deepEquals(revisar.getEstado(),solucion)){
                visitados.add(revisar);
                System.out.println("se llego a la solucion");
                break;
            }
            expandidos.remove(eliminar);
            visitados.add(revisar);
            //imprimirEstados(revisar.getEstado());
            int[] pCero =ubicarPosicionCero(revisar.getEstado());
            int temp=0;
            Nodo hijo;
            switch (pCero[0]){
                case 0:
                    switch (pCero[1]){
                        case 0:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][1];
                            hijo.getEstado()[0][1] = 0;
                            hijo.getEstado()[0][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][0];
                            hijo.getEstado()[1][0] = 0;
                            hijo.getEstado()[0][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                        case 1:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][0];
                            hijo.getEstado()[0][0] = 0;
                            hijo.getEstado()[0][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][2];
                            hijo.getEstado()[0][2] = 0;
                            hijo.getEstado()[0][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][1];
                            hijo.getEstado()[1][1] = 0;
                            hijo.getEstado()[0][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                        case 2:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][1];
                            hijo.getEstado()[0][1] = 0;
                            hijo.getEstado()[0][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][2];
                            hijo.getEstado()[1][2] = 0;
                            hijo.getEstado()[0][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                    }
                    break;
                case 1:
                    switch (pCero[1]){
                        case 0:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][0];
                            hijo.getEstado()[0][0] = 0;
                            hijo.getEstado()[1][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[2][0];
                            hijo.getEstado()[2][0] = 0;
                            hijo.getEstado()[1][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][1];
                            hijo.getEstado()[1][1] = 0;
                            hijo.getEstado()[1][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                        case 1:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][1];
                            hijo.getEstado()[0][1] = 0;
                            hijo.getEstado()[1][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][2];
                            hijo.getEstado()[1][2] = 0;
                            hijo.getEstado()[1][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[2][1];
                            hijo.getEstado()[2][1] = 0;
                            hijo.getEstado()[1][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][0];
                            hijo.getEstado()[1][0] = 0;
                            hijo.getEstado()[1][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                        case 2:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[0][2];
                            hijo.getEstado()[0][2] = 0;
                            hijo.getEstado()[1][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][1];
                            hijo.getEstado()[1][1] = 0;
                            hijo.getEstado()[1][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][1];
                            hijo.getEstado()[1][1] = 0;
                            hijo.getEstado()[1][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                    }
                    break;
                case 2:
                    switch (pCero[1]){
                        case 0:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][0];
                            hijo.getEstado()[1][0] = 0;
                            hijo.getEstado()[2][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[2][1];
                            hijo.getEstado()[2][1] = 0;
                            hijo.getEstado()[2][0] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                        case 1:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[2][0];
                            hijo.getEstado()[2][0] = 0;
                            hijo.getEstado()[2][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][1];
                            hijo.getEstado()[1][1] = 0;
                            hijo.getEstado()[2][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[2][2];
                            hijo.getEstado()[2][2] = 0;
                            hijo.getEstado()[2][1] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                        case 2:
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[2][1];
                            hijo.getEstado()[2][1] = 0;
                            hijo.getEstado()[2][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            hijo = new Nodo(clon(revisar.getEstado()));
                            temp=hijo.getEstado()[1][2];
                            hijo.getEstado()[1][2] = 0;
                            hijo.getEstado()[2][2] = temp;
                            hijo.setPadre(revisar);
                            hijo.setFuncionHeuristica(funcionHeuristica(hijo.getEstado(),cont,solucion));
                            if(!estaVisitado(visitados,hijo)) {
                                expandidos.add(hijo);
                                revisar.agregarHijo(hijo);
                            }
                            break;
                    }
                    break;
            }


            /*if(pCero[0]!=0){
                Nodo hijo = new Nodo(revisar.getEstado());
                int arriba = hijo.getEstado()[pCero[0]][pCero[1]];
            }

             */
            cont++;
        }

        System.out.println("nodos visitados");
        imprimir(visitados);
    }
    public static int[][] clon(int[][] a){
        int[][] b = new int[a.length][];
        for(int i=0;i< a.length;i++){
            b[i]=a[i].clone();
        }
        return b;
    }
    private static void imprimir(ArrayList<Nodo> expandidos) {
        for (Nodo v:expandidos) {
            System.out.println(v.toString());
        }
    }
    private static int funcionHeuristica(int[][] estado, int cont, int[][] solucion) {
        int contIgual=0;
        for(int i=0;i< estado.length;i++){
            for (int j=0;j<estado[i].length;j++){
                if(estado[i][j] != solucion[i][j]){
                    contIgual++;
                }
            }
        }

        return contIgual;
    }

    private static int[] ubicarPosicionCero(int[][] estado) {
        int[] posicion = new int[2];
        for(int i=0;i< estado.length;i++){
            for (int j=0;j<estado[i].length;j++){
                if(estado[i][j] == 0){
                    posicion[0]=i;
                    posicion[1]=j;
                }
            }
        }
        //System.out.println("la posicion del espacio es: "+posicion[0]+", "+posicion[1]);
        return posicion;
    }

    public static void imprimirEstados(int[][] estado){
        for(int i=0;i< estado.length;i++){
            for (int j=0;j<estado[i].length;j++){
                System.out.print("["+estado[i][j]+"]");
            }
            System.out.println("");
        }
    }

    private static boolean estaVisitado(ArrayList<Nodo> visitados,Nodo hijo) {
        for (Nodo v : visitados) {
            if (Arrays.deepEquals(v.getEstado(),hijo.getEstado())) {
                return true;
            }
        }
        return false;
    }
}
