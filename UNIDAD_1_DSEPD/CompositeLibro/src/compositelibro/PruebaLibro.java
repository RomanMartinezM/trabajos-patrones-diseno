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
public class PruebaLibro {
    public static void main(String[] args) {
       
         ComponenteLibro librosDrama = new Libro("----- Libros de Drama ---", "COMPLETO");
         ComponenteLibro d1 = new ElementoLibro ("El retrato de Dorian Gray","Novela","Drama",150,false);
         ComponenteLibro d2 = new ElementoLibro ("El hombre invisible","Novela","Drama",500,true);
         
         ComponenteLibro librosRomance = new Libro("--- Libros de Romance ---", "COMPLETO");
         ComponenteLibro r1 = new ElementoLibro ("Romeo y Julieta","Novela","Romance",250,false);
         ComponenteLibro r2 = new ElementoLibro ("Hamlet","Novela","Romance",500,true);
         
         librosDrama.add(d1);
         librosDrama.add(d2);
         librosDrama.listar();
         
         librosDrama.remove(d1);
         librosDrama.listar();
         librosDrama.getPagina();
         
         librosRomance.add(r1);
         librosRomance.add(r2);
         librosRomance.listar();
    }
    
}
