/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositelibro;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author lithium
 */
public class Libro extends ComponenteLibro {
    ArrayList<ComponenteLibro> libroComponentes=new ArrayList();
    private String titulo;
    private String tema;
    private String subtema;
    private int pagina;

    public Libro(String titulo, String tema) {
        this.titulo = titulo;
        this.tema = tema;
    }

    
     @Override
    public void listar() {
        System.out.printf("%-22s%-25s\n"," ","~~~~~~~~ LIBRO ~~~~~~~~"+"\n"+"Páginas totales "+getPagina());
        System.out.printf("%-22s%-25s\n"," ",titulo);
        System.out.printf("%-15s%-35s%-10s%-18s%-35s\n","Titulo","Tema","Subtema"," Pagina","Disponible");
       
        Iterator p = libroComponentes.iterator();
        while(p.hasNext()){
            ComponenteLibro pl= (ComponenteLibro) p.next();
            pl.listar();
        }
    }
    
    public int getPagina(){
        Iterator<ComponenteLibro> it = libroComponentes.iterator();
        int tot = 0;
        while (it.hasNext()) {
            ComponenteLibro next = it.next();
            tot += next.getPagina();
        }
        return tot;
    }
    
    public void add (ComponenteLibro libroComponente){
        //if(menuComponentes.indexOf(menuComponente)!= 1)
           // System.out.print("Ya fue agregado al menú");
        libroComponentes.add(libroComponente);
    }
    
    public void remove (ComponenteLibro libroComponente){
        //if(menuComponentes.indexOf(menuComponente)!= -1)
        libroComponentes.remove(libroComponente);
    }
    
    public ComponenteLibro getHijo(int i){
        return (ComponenteLibro)libroComponentes.get(i);
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
    
    public boolean esHijo(){
        return false;
    }
    
}
