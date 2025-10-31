/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author salva
 */
public class NodoDoble<T> {
    public T dato;
    NodoDoble <T> siguiente, anterior;
    public NodoDoble(T el) {
        dato = el;
    }
    
    @Override
    public String toString() {
        return "" + dato + "";
    }
}
