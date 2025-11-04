/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Programa;

import Clases.ListaDE;
import javax.swing.JOptionPane;

/**
 *
 * @author equipo
 */
public class UsoListaDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaDE listita = new ListaDE();
        int opcion = 0;
        String elemento;
        boolean eliminado;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                        + "1. Agregar un Nombre\n"
                        + "2. Buscar un Nombre\n"
                        + "3. Mostrar la Lista en Orden Ascendente\n"
                        + "4. Mostrar la lista en Orden Descendente\n"
                        + "5. Eliminar un Nodo\n"
                        + "6. Salir\n"
                        + "¿Que deseas hacer?", "Menu de Opcion",
                        JOptionPane.INFORMATION_MESSAGE));
                switch (opcion) {
                    case 1:
                        elemento = JOptionPane.showInputDialog(null,
                                "Ingresa el Nombre", "Agregando Nombre", JOptionPane.INFORMATION_MESSAGE);
                        listita.insertanEnOrden(elemento);
                        break;
                    case 2:
                        elemento = (JOptionPane.showInputDialog(null,
                                "Ingresa el Nombre a Buscar", "Buscando Nombre", JOptionPane.INFORMATION_MESSAGE));
                        if (!listita.estaVacia()) {
                            if (listita.buscar(elemento) != null) {
                                JOptionPane.showMessageDialog(null, "El elemento " + elemento + " fue encontrado");
                            } else {
                                JOptionPane.showMessageDialog(null, "El elemento " + elemento + " no esta en la lista");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos para buscar",
                                    "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!listita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "Lista en forma Ascendente:\n " + listita.getAscendente(),
                                        "Mostrar lista", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos que mostrar",
                                    "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if (!listita.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "Lista en forma Descendente:\n " + listita.getDescendente(),
                                        "Mostrar lista", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay nodos que mostrar",
                                    "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if (!listita.estaVacia()) {
                            elemento = JOptionPane.showInputDialog(null,
                                    "Ingresa el Nombre", "Eliminando Nombre", JOptionPane.INFORMATION_MESSAGE);
                            eliminado = listita.eliminar(elemento);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(null, "El elemento eliminado es " + elemento,
                                        "Eliminando Nodo", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "El elemento " + elemento + " no se encuentra en la lista.",
                                        "Nodo no encontrado", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Aun no hay nodos",
                                    "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada",
                                "Fin :D", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La Opcion no esta en el Menu",
                                "Incorrecto D:", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        } while (opcion != 6);
    }

}
