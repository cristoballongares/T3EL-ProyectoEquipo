/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author todos:D
 */
public class ListaDE {

    private NodoDoble<String> inicio, fin;

    public ListaDE() {
        inicio = fin = null;
    }

    //Metodo para saber cuando la lista esta vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertanEnOrden(String nombre) {
        //Si la lista esta vacia
        NodoDoble<String> aux = new NodoDoble<String>(nombre);
        if (inicio == null) {
            inicio = fin = aux;
            return;
        }
        //Si se inserta al principio
        if (nombre.compareToIgnoreCase(inicio.dato) <= 0) {
            aux.siguiente = inicio;
            inicio.anterior = aux;
            inicio = aux;
            return;//Se hace el return para acabar con la ejecucion del metodo
        }
        //Si se inserta entre dos nodos o tal vez al final :D

        NodoDoble<String> actual = inicio;
        while (actual.siguiente != null && nombre.compareToIgnoreCase(actual.siguiente.dato) > 0) {
            actual = actual.siguiente;
        }
        aux.siguiente = actual.siguiente;
        aux.anterior = actual;
        if (actual.siguiente != null) {
            actual.siguiente.anterior = aux;
        } else {
            fin = aux; //Si estamos en el nodo
        }
        actual.siguiente = aux;
    }

    public void mostrarAscendente() {
        NodoDoble<String> actual = inicio;
        System.out.print("Ascendente: ");
        while (actual != null) {
            System.out.print(actual.dato + "<=>");
            actual = actual.siguiente;
        }
        System.out.print("NULL\n");
    }

    public void mostrarDescendente() {
        NodoDoble<String> actual = fin;
        System.out.print("Descendente: ");
        while (actual != null) {
            System.out.print(actual.dato + "<=>");
            actual = actual.anterior;
        }
        System.out.println("NULL\n");
    }

    public NodoDoble buscar(String nombre) {
        NodoDoble<String> actual = inicio;
        while (actual != null) {
            if (actual.dato.equalsIgnoreCase(nombre)) {
                return actual;
            }
            if (nombre.compareToIgnoreCase(actual.dato) < 0) {
                return null;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean eliminar(String nombre) {
        NodoDoble<String> eliminar = buscar(nombre);
        if (eliminar == null) {
            return false;
        }
        if (inicio == fin && inicio == eliminar) {
            inicio = null;
            fin = null;
        } else if (eliminar == inicio) {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        } else if (eliminar == fin) {
            fin = fin.anterior;
            fin.siguiente = null;
        } else {
            eliminar.anterior.siguiente = eliminar.siguiente;
            eliminar.siguiente.anterior = eliminar.anterior;
        }
        return true;

    }
    
    public ArrayList<String> getNodos(){
        ArrayList<String> personas = new ArrayList();
        if(estaVacia()) return personas; // Si esta vacia, devolvemos nada
        
        NodoDoble<String> aux = inicio;
        while(aux!=fin){
            String nom = aux.dato;
            personas.add(nom);
            aux = aux.siguiente;
        }
        
        return personas;
    }
}
