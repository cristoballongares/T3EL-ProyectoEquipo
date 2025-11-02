package Programa;

import Clases.ListaDE;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelPersonas extends JPanel {

    private final int x0 = 30;  // margen de inicio (coordenada x para primer nombre)
    private final int y0 = 30; // altura base (coordenada y para todos los nombres)
    private int actualy=30;
    private final int altoRect = 30;
    private final int espacio = 50; // tam de las flechitas
    private ListaDE personas;
    private int actualx = x0;
    private boolean descendete = false;

    public PanelPersonas(ListaDE lista) {
        this.personas = lista;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800,350));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // borramos lo que habia antes:)
        Graphics2D g2d = (Graphics2D) g; // para que se vea mas bonito
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // suavizar lineas
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // suavizar texto

        // Obtenemos las personas de la lista DE
        // PERO, el orden de esta depende si se eligio mostrar de forma ascendente o descendente
        ArrayList<String> nodos = (this.descendete?personas.getDescendente():personas.getNodos());
        System.out.println(nodos.size()); // solo para comprobar que todo funcione bien
        
        // lo ocuparemos para saber cuanto ocupa en PIXELES el nombre
        FontMetrics fm = g2d.getFontMetrics();
        
        actualx = x0;
        
        // Colocamos los nombres
        for (int i = 0; i < nodos.size(); i++) {
            
            String nombre = nodos.get(i);
            
            // Medimos el ancho de este, las unidades son en pixeles
            int ancho = fm.stringWidth(nombre);
            // agregamos margen
            int margen = 20;
            // ancho total que ocupara el nombre (ancho + margen)
            int anchoT = ancho+margen;
            
            // dibujamos el rectangulo y adentro el nombre
                // Empezamos por el borde
                g2d.setColor(Color.BLUE); // color del borde
                g2d.setStroke(new BasicStroke(2)); // ancho del borde
                //                g2d.drawRect(actualx, y0, anchoT, altoRect);
                //                g2d.setColor(Color.GRAY); // Escoger color para rellenar
                //                g2d.fillRect(actualx, y0, anchoT, altoRect);  // Rellenar con color
                g2d.drawRoundRect(actualx, y0, anchoT, altoRect, 10, 10); // dibujamos el BORDE
                
                // Texto dentro del rectangulo
                g2d.setColor(Color.BLACK); // color del nombre
                int posXTexto = actualx + (margen)/2; // pos en x del texto
                int posYTexto = y0 + (altoRect+fm.getAscent())/2-5; // pos en y del texto
                g2d.drawString(nombre, posXTexto, posYTexto); // Lo ponemos
            
            // Punteros
            // nodos.szie() = 1
            // nodos.size() = 5
                if(i<nodos.size()-1){
                    int inicioX = actualx + anchoT;
                    int finX = inicioX + espacio-10;
                    int posY = y0 + altoRect / 2 - 8;
                    int posYAbajo = y0 + altoRect / 2 + 8;

                    // ref i
                    // drawLine(x1,y1,x2,y2)
                    g2d.drawLine(inicioX, posY, finX, posY);
                    // diagoanles
                    g2d.drawLine(finX - 5, posY - 5, finX, posY);
                    g2d.drawLine(finX - 5, posY + 5, finX, posY);
                    
                    // ref d
                    g2d.drawLine(finX + 10, posYAbajo, inicioX + 9, posYAbajo);

                    // diagonales — apuntan al punto de inicio (inicioX + 8)
                    g2d.drawLine(inicioX + 9, posYAbajo, inicioX + 13, posYAbajo - 5);
                    g2d.drawLine(inicioX + 9, posYAbajo, inicioX + 13, posYAbajo + 5);
                }
               
            // Aumentamos la posicion de x para el proximo nombre
            actualx += anchoT+espacio;
        }

        if (nodos.isEmpty()) {
            g2d.setColor(Color.GRAY);
            g2d.drawString("(lista vacia)", x0, y0 + altoRect / 2);
        }
    }
    
    public void setDescendente(boolean f){
        this.descendete = f;
        repaint();
    }
    

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(actualx-espacio+20,150);
    }

}
