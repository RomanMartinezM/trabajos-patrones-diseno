/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans_adm;

import accesodatos.TiposFacade;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import log_neg.JuegosUsuario_ln;
import log_neg.Tipo_p;
import log_neg.Usuarios_ln;
import log_neg.palabras_ln;
import modelo.JuegosUsuario;
import modelo.Palabras;
import modelo.Tipos;
import modelo.Usuario;

/**
 *
 * @author lithium
 */
@Named(value = "ahorcado")
@ApplicationScoped
public class Ahorcado implements Serializable{

    @EJB
    private JuegosUsuario_ln juegosUsuario_ln;
    
    @EJB
    private Usuarios_ln usuarios_ln;
    
    @EJB
    private Tipo_p tipo_p;
    
    @EJB
    private palabras_ln palabras_ln;
    
    
    private Palabras palabras; 
    private Tipos tipos;
    private Usuario usuarios;
    private JuegosUsuario juegosusuario;
    private Integer Niveles[] = {1,2,3,4};
    private String tipos_persona[] = {"n","a","j","d","m"}; 
    //private ArrayList<Integer> Niveles;// = new ArrayList();
    //private ArrayList<String> tipos_persona;// = new ArrayList();
    
    private ArrayList<Character> letras;
    private ArrayList<Character> letras_aux;
    private ArrayList<String> posiciones;
    private ArrayList<Character> letrasabecedario;
    private ArrayList<Character> letras_descubiertas;
    private String palabra = "";//"ABRACADABRA";    
    private String ida;
    private String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String guiones = "";//"___________";
    private String nombre_usuario;
    private String nombre_palabra;
    private int intentos;
    private boolean hayintentos;
    private String mensaje;
    private String mensaje_usuario;
    private Integer nivel_seleccionado;
    private Integer idtipo_seleccionado;
    private String []palabras_obtenidas;
    private String palabra_elegida;
    
    public Palabras getPalabras() {
        return palabras;
    }

    public void setPalabras(Palabras palabras) {
        this.palabras = palabras;
    }
    public List<Palabras> lista_p(){
        return palabras_ln.listaPalabras();
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }
    public List<Tipos> lista_t(){
        return tipo_p.lista_t();
    } 

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }
    public List<Usuario> lista_u(){
        return usuarios_ln.listaUsuarios();
    }

    public JuegosUsuario getJuegosusuario() {
        return juegosusuario;
    }

    public void setJuegosusuario(JuegosUsuario juegosusuario) {
        this.juegosusuario = juegosusuario;
    }
     
    public List<JuegosUsuario> lista_ju(){
        return juegosUsuario_ln.listaJuegosUsuario();
    }
    
    /*
    public ArrayList<Integer> get_niveles(){      
        for (int i = 0; i < palabras_ln.listaPalabras().size(); i++) {
            if (!Niveles.contains(palabras_ln.listaPalabras().get(i).getNivel())) {
                Niveles.add(palabras_ln.listaPalabras().get(i).getNivel());
            }
        }
        return Niveles;
    }
    */
    
    public void guarda_p(ActionEvent e){
        boolean palabra_existe = false;
        for (int i = 0; i < palabras_ln.listaPalabras().size(); i++) {
            if (palabras_ln.listaPalabras().get(i).getPalabra().equals(nombre_palabra)) {
                palabra_existe = true;
                break;
            }
        }
        if (palabra_existe == true) {
            mensaje_usuario = "ESTA PALABRA YA EXISTE";
        }else{
            palabras.setPalabra(nombre_palabra);
            palabras.setTipo(tipos);
            palabras_ln.guardar(palabras);
            palabras = new Palabras();
            nombre_palabra = "";
            mensaje_usuario = "";
        }
    }
    public void registrar_usuario(ActionEvent e){    
        boolean usuario_existe = false;
        for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if (usuarios_ln.listaUsuarios().get(i).getNombre().equals(nombre_usuario)) { //si el usuario ya esta registrado   
                usuario_existe = true;
                break;           
            }
        }
        if (usuario_existe == true) {
            mensaje_usuario = "ESTE USUARIO YA EXISTE";
        }else{
            usuarios.setNombre(nombre_usuario);
            usuarios.setFechaRegistro(obtenerFecha());
            usuarios_ln.registrar(usuarios);
            usuarios = new Usuario();
            nombre_usuario = "";
            mensaje_usuario = "";
        }
        /*
        usuarios.setFechaRegistro(obtenerFecha());
        usuarios_ln.registrar(usuarios);
        usuarios = new Usuario();
        */
    }
    
    public void agregar_ju(ActionEvent e){
        juegosusuario.setIdpalabra(palabras);
        juegosusuario.setIdusuario(usuarios); 
        juegosusuario.setFechaHora(obtenerFecha());
        juegosUsuario_ln.agregar(juegosusuario);
        juegosusuario = new JuegosUsuario();
    }
    
    /**
     * Creates a new instance of Ahorcado
     */
    public Ahorcado() {
       // Niveles = new ArrayList();
       // tipos_persona = new ArrayList();
        
        palabras = new Palabras();
        tipos = new Tipos();
        usuarios = new Usuario();
        juegosusuario = new JuegosUsuario();
        
        idtipo_seleccionado = 0;
        nivel_seleccionado = 0;
        mensaje_usuario = "";
        mensaje="";
        hayintentos = false;
        nombre_usuario = "";
        nombre_palabra = "";
        intentos = 0;
        posiciones = new ArrayList();
        
        ida = new String("");
        guiones = "";
        palabra = "";
        /*
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
        
        letras_aux = new ArrayList(); 
        for (int i = 0; i < palabra.length(); i++) {
            letras_aux.add(palabra.charAt(i));
        }
        */
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
        /*
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            letras_descubiertas.add(guiones.charAt(i));
        }
        */
    }
    /*
    public ArrayList<String> get_tipos_persona(){
        tipos_persona.add("n");
        tipos_persona.add("a");
        tipos_persona.add("j");
        tipos_persona.add("d");
        tipos_persona.add("m");
        
        return tipos_persona;
    }
    */

    public String getMensaje_usuario() {
        return mensaje_usuario;
    }

    public void setMensaje_usuario(String mensaje_usuario) {
        this.mensaje_usuario = mensaje_usuario;
    }
    
    
    public Integer[] getNiveles() {
        return Niveles;
    }

    public void setNiveles(Integer[] Niveles) {
        this.Niveles = Niveles;
    }

    public String[] getTipos_persona() {
        return tipos_persona;
    }

    public void setTipos_persona(String[] tipos_persona) {
        this.tipos_persona = tipos_persona;
    }

    public Integer getNivel_seleccionado() {
        return nivel_seleccionado;
    }

    public void setNivel_seleccionado(Integer nivel_seleccionado) {
        this.nivel_seleccionado = nivel_seleccionado;
    }

    public Integer getIdtipo_seleccionado() {
        return idtipo_seleccionado;
    }

    public void setIdtipo_seleccionado(Integer idtipo_seleccionado) {
        this.idtipo_seleccionado = idtipo_seleccionado;
    }
    
    
    public String descripcion_tpersona(String tipo_persona){
        String descripcion = "";
        if (tipo_persona.equals("n")) {
            descripcion = "Niño";
        }
        if (tipo_persona.equals("a")) {
            descripcion = "Adolescente";
        }
        if (tipo_persona.equals("j")) {
            descripcion = "Joven";
        }
        if (tipo_persona.equals("d")) {
            descripcion = "Adulto";
        }
        if (tipo_persona.equals("m")) {
            descripcion = "Adulto Mayor";
        }
        return descripcion;
    }
    /*
    public ArrayList<Integer> get_niveles(){      
        for (int i = 0; i < 4; i++) {
             Niveles.add(i+1);
        }
        return Niveles;
    }
    */
    public String nombre_nivel(Integer Nivel){
        String nombre_nivel = ""; 
            if (Nivel == 1) {
                nombre_nivel = "Facil";
            }
            if (Nivel == 2) {
                nombre_nivel = "Medio";
            }
            
            if (Nivel == 3) {
                nombre_nivel = "Dificil";
            }
            if (Nivel == 4) {
                nombre_nivel = "Muy Dificil";
            }
        return nombre_nivel;
    }
    
    public String buscar_usuario(){
        boolean usuarioExiste = false;
        for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if (usuarios_ln.listaUsuarios().get(i).getNombre().equals(nombre_usuario)) { //si el usuario ya esta registrado
                usuarioExiste = true;
                break;
            }
        }
        if (usuarioExiste == true) {
            return "seleccion.xhtml"; 
        }else{
            return "agregar_usuario.xhtml";
        }
    }
    /*
    public void registrar_usu_nuevo(String nombre_usu, ActionEvent e){
         for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if (usuarios_ln.listaUsuarios().get(i).getNombre().equals(nombre_usu)) { //si el usuario ya esta registrado   
                mensaje_usuario = "Este usuario ya existe";
            }else{
                registrar_usuario(e);
            }
        }
    }
    */
    public Date obtenerFecha(){
        Calendar calendario = Calendar.getInstance();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaR="";
        Date fechaRegistro = null; 
 
        fechaR = formatoFecha.format(calendario.getTime());
        
        try {
            fechaRegistro = formatoFecha.parse(fechaR);
        } catch (ParseException ex) {
            Logger.getLogger(Ahorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaRegistro;
    }
    
    public void obtener_palabras(){
        ArrayList<String>listaPal = new ArrayList<String>();
        List<Palabras> listaPalabras = palabras_ln.listaPalabras();
        for (Palabras p : listaPalabras) {
            if (p.getTipo().getIdTipos() == idtipo_seleccionado && p.getNivel().equals(nivel_seleccionado)) {
                listaPal.add(p.getPalabra());
            }
        }
        palabras_obtenidas = new String[listaPal.size()];
        for (int i = 0; i < listaPal.size(); i++) {
            palabras_obtenidas[i] = listaPal.get(i);
        }
        Random oran = new Random();
        palabra = palabras_obtenidas[oran.nextInt(palabras_obtenidas.length)];
        
        ////
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
        
        letras_aux = new ArrayList(); 
        for (int i = 0; i < palabra.length(); i++) {
            letras_aux.add(palabra.charAt(i));
        }
        
        for (int i = 0; i < palabra.length(); i++) {
            guiones += "_";
        }
        
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            letras_descubiertas.add(guiones.charAt(i));
        }    
        
    }
    
    public void visualizar(ActionEvent e){
        ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
        posiciones.add(ida);       
    }
    
    public void actualizar(ActionEvent e){
        ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
        Character ka = ida.charAt(0); //del ID, solo se obtiene la letra 
        int pos = -1;
        String posicion = "";
        //posiciones.add(ida);
        
        for (int i = 0; i < palabra.length(); i++) {
            if ((pos = letras.indexOf(ka))!= -1) {// se compara si la posicion de la letra es diferente de -1 y si es así, eso significa que se encontró la letra
            //"pos = letras.indexOf(ka)" regresa la posición de la letra a la que se le dió click
                letras.set(pos, '_');
                posicion = ka.toString()+pos;
                posiciones.add(posicion);
                //letras_descubiertas.set(pos,ka);
            }
        }
        
    }
    
    public void actualizar_letras(ActionEvent e){
        if (intentos > 0) {
                ida = e.getComponent().getId();  //"getComponent()" permite saber el componente que realizo el evento. Y de ese componente se obtiene el ID,que es el nombre que se llego a formar por 2 valores: el valor de la letra a la que se le dió click y la posición de la letra
                Character ka = ida.charAt(0); //del ID, solo se obtiene la letra 
                //int pos = -1;
               // for (int i = 0; i < palabra.length(); i++) {
                    if ((palabra.indexOf(ka))!= -1) {// se compara si la posicion de la letra es diferente de -1 y si es así, eso significa que se encontró la letra                
                        for (int j = 0; j < letras_aux.size(); j++) {
                            if (letras_aux.get(j).equals(ka)) {
                                 letras_descubiertas.set(j,ka);
                            }
                        }
                        letrasabecedario.remove(ka);
                    }else{
                        intentos--;
                    }
              //}
              
                    if (intentos == 0) {
                        hayintentos = true;
                        mensaje = "YA NO QUEDAN MÁS INTENTOS";
                    }
                    if (!letras_descubiertas.contains('_')) {
                         hayintentos = true;
                         mensaje = "¡JUEGO TERMINADO!";
                    }    
        }
    }
   
    public void reiniciar(){
         // Niveles = new ArrayList();
       // tipos_persona = new ArrayList();
        palabras = new Palabras();
        tipos = new Tipos();
        usuarios = new Usuario();
        juegosusuario = new JuegosUsuario();
        
        idtipo_seleccionado = 0;
        nivel_seleccionado = 0;
        mensaje_usuario = "";
        mensaje="";
        hayintentos = false;
        nombre_usuario = "";
        nombre_palabra = "";
        intentos = 0;
        posiciones = new ArrayList();
        
        ida = new String("");
        guiones = "";
        palabra = "";
        /*
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
        
        letras_aux = new ArrayList(); 
        for (int i = 0; i < palabra.length(); i++) {
            letras_aux.add(palabra.charAt(i));
        }
        */
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
        /*
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            letras_descubiertas.add(guiones.charAt(i));
        }
        */
        /////////////////
        /*
        mensaje="";
        hayintentos = false;
        nombre_usuario = "";
        intentos = 0;
        posiciones = new ArrayList();
        
        ida = new String("");
        letras = new ArrayList();         
        for (int i = 0; i < palabra.length(); i++) {
            letras.add(palabra.charAt(i));
        } 
        
        letras_aux = new ArrayList(); 
        for (int i = 0; i < palabra.length(); i++) {
            letras_aux.add(palabra.charAt(i));
        }
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
        
        letras_descubiertas = new ArrayList();
        for (int i = 0; i < guiones.length(); i++) {
            letras_descubiertas.add(guiones.charAt(i));
        }
        */
    }

    
    public String getIda() {
        return ida;
    }

    public void setIda(String ida) {
        this.ida = ida;
    }

    public ArrayList<Character> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }    
    //EJERCICIO A HACER: MOSTRAR EL VALOR DE "metadato.index" en "juego.xhtml"
    
    //EJERCICIO 2: PONER EL NOMBRE DEL PARTICIPANTE, EL NUMERO DE INTENTOS TOTALES, LOS INTENTOS REALIZADOS Y LOS INTENTOS RESTANTES

    public ArrayList<String> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<String> posiciones) {
        this.posiciones = posiciones;
    }

    public ArrayList<Character> getLetrasabecedario() {
        return letrasabecedario;
    }

    public void setLetrasabecedario(ArrayList<Character> letrasabecedario) {
        this.letrasabecedario = letrasabecedario;
    }

    public ArrayList<Character> getLetras_descubiertas() {
        return letras_descubiertas;
    }

    public void setLetras_descubiertas(ArrayList<Character> letras_descubiertas) {
        this.letras_descubiertas = letras_descubiertas;
    }

    public ArrayList<Character> getLetras_aux() {
        return letras_aux;
    }

    public void setLetras_aux(ArrayList<Character> letras_aux) {
        this.letras_aux = letras_aux;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_palabra() {
        return nombre_palabra;
    }

    public void setNombre_palabra(String nombre_palabra) {
        this.nombre_palabra = nombre_palabra;
    }
    
    
    
    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean isHayintentos() {
        return hayintentos;
    }

    public void setHayintentos(boolean hayintentos) {
        this.hayintentos = hayintentos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
