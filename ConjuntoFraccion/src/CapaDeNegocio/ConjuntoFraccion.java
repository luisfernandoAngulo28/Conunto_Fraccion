/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author ferna
 */
public class ConjuntoFraccion {

    VectorNBits VN;
    VectorNBits VD;
    int cant;

    public ConjuntoFraccion() {
        this.VN = new VectorNBits(20, 7);//100,9
        this.VD = new VectorNBits(20, 7);
        this.cant = 0;
        // System.out.println(VN.toString());
        //System.out.println(VD.toString());

    }

    public void insertar(int numerador, int denominador) {//>=0 <10
        if (numerador >= 1 && numerador < 10 && denominador >= 1 && denominador < 10) {
            if (!pertenece(numerador, denominador)) {
                int cantidadElementos = VN.cantidad();
                if (cant < cantidadElementos) {
                    cant++;
                    VN.insertar(numerador, cant);
                    VD.insertar(denominador, cant);
                    
                    // System.out.println(VN.toString());
                    //System.out.println(VD.toString());
                }

            }
        }

    }

    public boolean pertenece(int numerador, int denominador) {
        
        numerador = Math.abs(numerador);
        for (int i = 0; i <= cant; i++) {
            if (numerador == VN.sacar(i + 1) && denominador == VD.sacar(i + 1)) {
                return true;
            }
        }
        return false;

    }

    public String toString() {
        String salida = "C={";
        for (int i = 0; i < cant; i++) {
            salida = salida + VN.sacar(i + 1) + "/" + VD.sacar(i + 1) + ",";
        }
        salida = salida.substring(0, salida.length() - 1);
        return salida + "}";
    }

    public static void main(String[] args) {
        ConjuntoFraccion C = new ConjuntoFraccion();
        C.insertar(1, 2);
        C.insertar(3, 2);
        C.insertar(5, 2);
        System.out.println(C.toString());
    }

}
