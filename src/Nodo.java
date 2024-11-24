import java.util.ArrayList;
import java.util.Arrays;

public class Nodo {
    private int[][] estado;
    private ArrayList<Nodo> hijos;
    private Nodo Padre;
    private int funcionHeuristica;


    public Nodo(int[][] estado) {
        this.estado = estado;
        this.hijos = new ArrayList<Nodo>();
        Padre = null;
        funcionHeuristica = 0;  
    }

    public int[][] getEstado() {
        return estado;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public Nodo getPadre() {
        return Padre;
    }

    public int getFuncionHeuristica() {
        return funcionHeuristica;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }
    public void agregarHijo(Nodo a){
        this.hijos.add(a);
    }

    public void setPadre(Nodo padre) {
        Padre = padre;
    }

    public void setFuncionHeuristica(int funcionHeuristica) {
        this.funcionHeuristica = funcionHeuristica;
    }

    @Override
    public String toString() {
        String s="Padre: f=: " +funcionHeuristica +"\n";
        for(int i=0;i< estado.length;i++){
            for (int j=0;j<estado[i].length;j++){
                s+="["+estado[i][j]+"]";
            }
            s+="\n";
        }
        return s + imprimirHijos();
    }

    public String imprimirHijos(){
        String s="hijos: \n";
        for(int i=0;i< hijos.size();i++){
            for(int j=0;j< hijos.get(i).estado.length;j++){
                for (int k=0;k<hijos.get(i).estado[j].length;k++){
                    s+="["+hijos.get(i).estado[j][k]+"]";
                }
                s+="\n";
            }

            s+="funcion:  " + hijos.get(i).funcionHeuristica +"\n";

        }
        return s;
    }
}
