/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositelibro;

/**
 *
 * @author lithium
 */
public class ElementoLibro extends ComponenteLibro {
    private String titulo;
    private String tema;
    private String subtema;
    private int pagina;
    private boolean disponible;

    public ElementoLibro(String titulo, String tema, String subtema, int pagina, boolean disponible) {
        this.titulo = titulo;
        this.tema = tema;
        this.subtema = subtema;
        this.pagina = pagina;
        this.disponible= disponible;
    }
    
    //@Override
    public void listar() {
        System.out.printf("%-15s%-35s%-12s%-20s%-35s\n",titulo,tema,subtema,pagina,disponible);
    } 
    
    public String getTitulo(){
        return titulo;
    }
    public String getTema(){
        return tema;
    }
    public String getSubtema(){
        return subtema;
    }
    public int getPagina(){
        return pagina;
    }
    public boolean isDisponible(){
        return disponible;
    }
     public boolean esHijo(){
        return true;
    }
     public void print(){
        System.out.print(" "+getTitulo());
        if(isDisponible()){
            System.out.print("(v)");
        }
        System.out.println(", "+getPagina());
        System.out.println("      --"+getSubtema());
    }
    
}
