package aed;

import java.lang.Math;
import java.util.*;

public class ArbolAVL<T extends Comparable<T>>{
    private NodoAVL raiz;
    
    private class NodoAVL {
        NodoAVL izq;
        NodoAVL der;
        NodoAVL padre;
        T clave;
        T dato;

        public NodoAVL(T c, T d) {
            dato = d;
            clave = c;
            izq = null;
            der = null;
            padre = null;
        }
    }
    
    private int altura(NodoAVL nodo){
        if (nodo == null){
            return 0;
        }else{
            return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        }
    }

    private int factorBalanceo(NodoAVL nodo){
        return (altura(nodo.der) - altura(nodo.izq));
    }

    public void insertar(ArbolAVL<T> arbol, T c, T d){
        if (arbol.raiz == null){
            NodoAVL nodo = new NodoAVL(c, d);
            arbol.raiz = nodo;
        }
        else{
            insertAuxAVL(arbol.raiz, c, d);
        }
    } 

    private void insertAuxAVL(NodoAVL nodo, T c, T d) {
        NodoAVL nodoNuevo = new NodoAVL(c, d); //Nota: el rebalanceo se invoca para todos los nodos de la rama desde p hasta la raíz.
        if (nodo.clave.compareTo(c) > 0){
            if (nodo.izq == null){
                nodo.izq = nodoNuevo;
                nodoNuevo.padre = nodo;
            }
            else{
                insertAuxAVL(nodo.izq, c, d);
            }
        }
        else if (nodo.clave.compareTo(c) < 0){
            if (nodo.der == null){
                nodo.der = nodoNuevo;
                nodoNuevo.padre = nodo;
            }
            else{
                insertAuxAVL(nodo.der, c, d);
            }
        
        }
        rebalancear(nodo);
    }
    
    private void rebalancear(NodoAVL nodo){
        int  fbd = factorBalanceo(nodo);
        if (fbd < -1 && factorBalanceo(nodo.izq) <= 0){ // II
            rotacionDerecha(nodo);
        }
        if (fbd > 1 && factorBalanceo(nodo.der) >= 0){ // DD
            rotacionIzquierda(nodo);
        }
        if (fbd < -1 && factorBalanceo(nodo.izq) > 0){ // DI
            rotacionIzquierdaDerecha(nodo);
        }
        if (fbd > 1 && factorBalanceo(nodo.der) < 0){ // ID
            rotacionDerechaIzquierda(nodo);
        }
    }

    private void rotacionDerecha(NodoAVL nodo){
        NodoAVL nodoIzq = nodo.izq;
        if (nodoIzq != null){ // debe ser necesariamente distinto a nulo el nodo izquierdo al que voy a rotar.
            nodo.izq = nodoIzq.der;
            nodoIzq.der = nodo;
            nodoIzq.padre = nodo.padre;
            nodo.padre.izq = nodoIzq;
            nodo.padre = nodoIzq;
        }
    }

    private void rotacionIzquierda(NodoAVL nodo){
        NodoAVL nodoDer = nodo.der;
        if (nodoDer != null){ // debe ser necesariamente distinto a nulo el nodo derecho al que voy a rotar.
            nodo.der = nodoDer.izq;
            nodoDer.izq = nodo;
            nodoDer.padre = nodo.padre;
            nodo.padre.der = nodoDer;
            nodo.padre = nodoDer;
        }
    }

    private void rotacionDerechaIzquierda(NodoAVL nodo){
        NodoAVL nodoRD = nodo.der;
        NodoAVL nodoIzq = nodoRD.izq;
        if (nodoIzq != null){ // debe ser necesariamente distinto a nulo el nodo izquierdo al que voy a rotar.
            nodoRD.izq = nodoIzq.der;
            nodoIzq.der = nodoRD;
            nodoIzq.padre = nodoRD.padre;
            nodoRD.padre.der = nodoIzq;
            nodoRD.padre = nodoIzq;
        }
        rotacionIzquierda(nodo);
    }

    private void rotacionIzquierdaDerecha(NodoAVL nodo){
        NodoAVL nodoRI = nodo.izq;
        NodoAVL nodoDer = nodoRI.der;
        if (nodoDer != null){ // debe ser necesariamente distinto a nulo el nodo derecho al que voy a rotar.
            nodoRI.der = nodoDer.izq;
            nodoDer.izq = nodoRI;
            nodoDer.padre = nodoRI.padre;
            nodoRI.padre.izq = nodoDer;
            nodoRI.padre = nodoDer;
        }
        rotacionDerecha(nodo);
    }


    public void eliminar(T elem) { // Hay que ver la forma de una vez que llego a el nodo que voy a eliminar, una vez eliminado, comenzar a rebalancear el arbol desde ese nodo hasta el padre en esa unica rama.
                                   //Para cada nodo con factor de balanceo ±2 hay que hacer una rotación simple o doble.
        if (raiz.clave == elem){
           raiz = null; 
        } else{
            eliminarAux(raiz, elem);
        }
    }
    
    private void eliminarAux(NodoAVL nodo, T elem) {
        if (elem.compareTo(nodo.clave) < 0) {
            eliminarAux(nodo.izq, elem);
        } 
        else if (elem.compareTo(nodo.clave) > 0) {
            eliminarAux(nodo.der, elem);
        } 
        else {   
            if (nodo.izq == null && nodo.der == null){
                nodo = null;
            }
            else if (nodo.der == null) {
                nodo.izq.padre = nodo.padre;
                nodo = nodo.izq;
            } 
            else{
                NodoAVL nodoSuc = min(nodo.der);
                nodo.clave = nodoSuc.clave;
                nodo.dato = nodoSuc.dato;
                eliminarMin(nodo.der);
            } 
        }
        rebalancear(nodo);
    }
    
    private NodoAVL min(NodoAVL nodo) {
        while (nodo.izq != null){
            nodo = nodo.izq;
        } 
        return nodo;
    }
    
    private void eliminarMin(NodoAVL nodo) {
        if (nodo.izq == null){
            nodo = nodo.der;
        } 
        else{
            eliminarMin(nodo.izq);
        }
    }

    public T buscarPosic(ArbolAVL arbol, T id){
        NodoAVL nodo = arbol.raiz;
        return buscarPosicAux(nodo, id);
    }

    private T buscarPosicAux(NodoAVL nodo, T id){
        if (nodo.clave.compareTo(id) == 0){
            return nodo.dato;
        }
        else if (nodo.clave.compareTo(id) > 0){
            return buscarPosicAux(nodo.izq, id);
        }
        else{
            return buscarPosicAux(nodo.der, id);
        }
    }

    public void modificarValor(ArbolAVL arbol, T id, T posicion){
        modificarValorAux(arbol.raiz, id, posicion);
    }

    private void modificarValorAux(NodoAVL nodo, T id, T posicion){
        if (nodo.clave == id){
            nodo.dato = posicion;
        }
        else if (nodo.clave.compareTo(id) > 0){
            modificarValorAux(nodo.izq, id, posicion);
        }
        else{
            modificarValorAux(nodo.der, id, posicion);
        }
    }
}
    