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
    private String nombre_tipo;
    private int intentos;
    private int intentos_totales;
    private boolean hayintentos;
    private String mensaje;
    private String mensaje_usuario;
    private Integer nivel_seleccionado;
    private Integer idtipo_seleccionado;
    private String []palabras_obtenidas;
    private String palabra_elegida;
    
    private List<Tipos> ltipos = new ArrayList<>();
    private List<Palabras> lpalabras = new ArrayList<>();
    private List<Usuario> lusuarios = new ArrayList<>();
    private List<JuegosUsuario> lju = new ArrayList<>();
    private List<JuegosUsuario> hist_jugador = new ArrayList<>();
             
    private List<JuegosUsuario> lista_jugador;
   // private List<Tipos> ListTipos;
   // private List<Palabras> ListPalab;

    public List<Tipos> getLtipos() {
        return ltipos;
    }

    public void setLtipos(List<Tipos> ltipos) {
        this.ltipos = ltipos;
    }

    public List<Palabras> getLpalabras() {
        return lpalabras;
    }

    public void setLpalabras(List<Palabras> lpalabras) {
        this.lpalabras = lpalabras;
    }

    public List<Usuario> getLusuarios() {
        return lusuarios;
    }

    public void setLusuarios(List<Usuario> lusuarios) {
        this.lusuarios = lusuarios;
    }

    public List<JuegosUsuario> getLju() {
        return lju;
    }

    public void setLju(List<JuegosUsuario> lju) {
        this.lju = lju;
    }

    public List<JuegosUsuario> getHist_jugador() {
        return hist_jugador;
    }

    public void setHist_jugador(List<JuegosUsuario> hist_jugador) {
        this.hist_jugador = hist_jugador;
    }
    
    
    
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
    
    public List<JuegosUsuario> ver_historial_jugador(){
        lista_jugador = new ArrayList();
        Integer id_usu = 0;
        for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if (usuarios_ln.listaUsuarios().get(i).getNombre().equals(nombre_usuario)) { //si el usuario ya esta registrado
                id_usu = usuarios_ln.listaUsuarios().get(i).getIdUsuario();
                break;
         
            }
        }
        
        for (int i = 0; i < juegosUsuario_ln.listaJuegosUsuario().size(); i++) {
            if (juegosUsuario_ln.listaJuegosUsuario().get(i).getIdusuario().getIdUsuario() == id_usu) { //si el usuario ya esta registrado
                if (juegosUsuario_ln.listaJuegosUsuario().get(i).getIntentosr() != 0) {
                     lista_jugador.add(juegosUsuario_ln.listaJuegosUsuario().get(i));
                }
            }
        }
        
        return lista_jugador;
    }
    
    public void guardar_tipo(ActionEvent e){
        boolean tipo_existe = false;
        for (int i = 0; i < tipo_p.lista_t().size(); i++) {
            if (tipo_p.lista_t().get(i).getDescripcion().equals(nombre_tipo)) {
                tipo_existe = true;
                break;
            }
        }
        if (tipo_existe == true) {
            mensaje_usuario = "ESTE TIPO DE PALABRA YA EXISTE";
        }else{
            tipos.setDescripcion(nombre_tipo);
            tipo_p.guardar(tipos);
            tipos = new Tipos();
            nombre_tipo = "";
            mensaje_usuario = "";
            ltipos = lista_t();
        }
    }
    
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
            ltipos = lista_t();
            lpalabras = lista_p();
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
            lusuarios = lista_u();
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
        lpalabras = lista_p();
        lusuarios = lista_u();
        lju = lista_ju();
    }
    public void insertar_datos_ju(){
        juegosusuario.setIdpalabra(obtener_palabra_juego());
        juegosusuario.setIdusuario(obtener_usuario_juego()); 
        juegosusuario.setIntentost(intentos_totales);
        juegosusuario.setIntentosr(intentos);
        juegosusuario.setFechaHora(obtenerFecha());
        juegosUsuario_ln.agregar(juegosusuario);
        juegosusuario = new JuegosUsuario();
    }
    
    /**
     * Creates a new instance of Ahorcado
     */
    public Ahorcado() {
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
        nombre_tipo = "";
        intentos = 0;
        intentos_totales = 0;
        posiciones = new ArrayList();       
        ida = new String("");
        guiones = "";
        palabra = "";       
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
    }
  
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
                    ltipos = lista_t();
                    lpalabras = lista_p();
                    lusuarios = lista_u();
                    lju = lista_ju();
                    hist_jugador = ver_historial_jugador();
                usuarioExiste = true;
                break;
            }
        }
        
        if (usuarioExiste == true) {
            return "menu_jugador.xhtml"; 
        }else{
            return "agregar_usuario.xhtml";
        }
    }
    public String porcentaje_efectividad(Integer intentosR, Integer intentosT){
        Integer intentos_erroneos = intentosT-intentosR;
       // int a = 100-intentos_erroneos;
        //int b = intentosT*100;
        double porcentaje_efec = (double)(100-intentos_erroneos)/(intentosT*100);
        double result = porcentaje_efec * 100;
        return result + "%";
       // return "intentosT= " + intentosT + ", intentos erroneos= " + intentos_erroneos + ", intentosRestantes= " + intentosR + ", a= " + a + ", b=" + b + ", %efectividad= " + porcentaje_efec + "%";
    }
    public Usuario obtener_usuario_juego(){
        Usuario usu = null;
        for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if (usuarios_ln.listaUsuarios().get(i).getNombre().equals(nombre_usuario)) { //si el usuario ya esta registrado
                usu = usuarios_ln.listaUsuarios().get(i);
                break;
            }
        }
       return usu;
    }
    public Palabras obtener_palabra_juego(){
        Palabras pal = null;
        for (int i = 0; i < palabras_ln.listaPalabras().size(); i++) {
            if (palabras_ln.listaPalabras().get(i).getPalabra().equals(palabra)) {
                pal = palabras_ln.listaPalabras().get(i);
                break;
            }
        }
        return pal;
    }

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
      
        intentos_totales = intentos;
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
                        insertar_datos_ju();
                        hist_jugador = ver_historial_jugador();
                    }
                    if (!letras_descubiertas.contains('_')) {
                         hayintentos = true;
                         mensaje = "¡JUEGO TERMINADO!";
                         insertar_datos_ju();
                         hist_jugador = ver_historial_jugador();
                    }    
        }
    }
   
    public void reiniciar(){
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
        intentos_totales = 0;
        posiciones = new ArrayList();
        
        ida = new String("");
        guiones = "";
        palabra = "";
        letrasabecedario = new ArrayList();
        for (int i = 0; i < abecedario.length(); i++) {
            letrasabecedario.add(abecedario.charAt(i));
        }
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

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
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
/*
    public List<Tipos> getListTipos() {
        return ListTipos;
    }

    public void setListTipos(List<Tipos> ListTipos) {
        this.ListTipos = ListTipos;
    }

    public List<Palabras> getListPalab() {
        return ListPalab;
    }

    public void setListPalab(List<Palabras> ListPalab) {
        this.ListPalab = ListPalab;
    }
*/    
    
    
}
