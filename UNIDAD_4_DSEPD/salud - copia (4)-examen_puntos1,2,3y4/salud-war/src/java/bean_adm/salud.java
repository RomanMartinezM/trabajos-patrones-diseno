/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean_adm;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import log_neg.ActividadUsuario_ln;
import log_neg.Antropometricos_ln;
import log_neg.TipoActividad_ln;
import log_neg.Usuarios_ln;
import modelo_salud.Actividadusuario;
import modelo_salud.Antropometricos;
import modelo_salud.Tipoactividad;
import modelo_salud.Usuario;

/**
 *
 * @author lithium
 */
@Named(value = "salud")
@ApplicationScoped
public class salud {

    @EJB
    private ActividadUsuario_ln actividadUsuario_ln;

    @EJB
    private Antropometricos_ln antropometricos_ln;

   
    @EJB
    private TipoActividad_ln tipoActividad_ln;

    @EJB
    private Usuarios_ln usuarios_ln;
    
    

    private Tipoactividad tipoactividad;
    private Usuario usuarios;
    private Antropometricos antropometricos;
    private Actividadusuario actividadusuario;
    private Usuario usuario_logeado;
    private Antropometricos antropometricos_ulogeado;
    private Actividadusuario actividadusuario_logeado;
    
    private int id_usuario;
    private String password; 
    private String mensaje;
    private String fecha_reg_antro;
    private String fecha_nac;
    private int intentos_aut;
    private int edad;
   // private double estatura;
   // private double peso;
   // private double cintura;
   // private double cadera;
    private char sexo;
    
    private String nombre_persona;
    private String fecha_n;
    private double actividad;
    private String imc;
    private String icc;
    private double kilocalorias;
    //private boolean is_registrado;
    private boolean antropo_existe;
    private String nombre_u;
    
    private int an;
    private int ed;
    private int idantropometricos;
    private double factor;
    private String mensaje_existe_u;
    private String mensaje_antro_existe;
    private String mensaje_antro_regis;
    private String fecha_reg_ant;
    private boolean usu_reg;
    private String as;
    private int ultimo;
    private String user;
    private int idu;
    private int edadac;
    private int a;
    
    public salud() {
          
          as="";
          mensaje="";
          id_usuario=0;
          password=""; 
          password=""; 
          fecha_reg_antro="";
          fecha_nac="";
          intentos_aut=0;
          antropo_existe=false;
          usu_reg=true;
          imc = " ";
          icc = " ";
          edadac = 0;
          
          kilocalorias=0.0;
          nombre_u ="";
           
          an =0;
          ed=0;
          factor = 0.0;
          mensaje_existe_u="";
          mensaje_antro_existe="";
          mensaje_antro_regis="";
          fecha_reg_ant="";
          
          edad = 0;
          /*
          estatura=0.0;
          peso=0.0;
          cintura=0.0;
          cadera=0.0;
          */
          sexo=' ';

          nombre_persona="";
          fecha_n="";
          actividad=0;
          idantropometricos=0;
    
          
          usuarios = new Usuario();
          tipoactividad = new Tipoactividad();
          antropometricos = new Antropometricos();
          actividadusuario = new Actividadusuario();
          usuario_logeado = new Usuario();
          antropometricos_ulogeado = new Antropometricos();
          actividadusuario_logeado = new Actividadusuario();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public int getEdadac() {
        return edadac;
    }

    public void setEdadac(int edadac) {
        this.edadac = edadac;
    }
    
    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
    }
    
    public String getAs() {
        return as;
    }

    public void setAs(String as) {
        this.as = as;
    }
    
    public boolean isUsu_reg() {
        return usu_reg;
    }

    public void setUsu_reg(boolean usu_reg) {
        this.usu_reg = usu_reg;
    }

    
    public String getFecha_reg_ant() {
        return fecha_reg_ant;
    }

    public void setFecha_reg_ant(String fecha_reg_ant) {
        this.fecha_reg_ant = fecha_reg_ant;
    }
    
    
    public String getMensaje_antro_regis() {
        return mensaje_antro_regis;
    }

    public void setMensaje_antro_regis(String mensaje_antro_regis) {
        this.mensaje_antro_regis = mensaje_antro_regis;
    }

    
    public String getMensaje_existe_u() {
        return mensaje_existe_u;
    }

    public void setMensaje_existe_u(String mensaje_existe_u) {
        this.mensaje_existe_u = mensaje_existe_u;
    }

    
    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
    
    public int getIdantropometricos() {
        return idantropometricos;
    }

    public void setIdantropometricos(int idantropometricos) {
        this.idantropometricos = idantropometricos;
    }

    
    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getEd() {
        return ed;
    }

    public void setEd(int ed) {
        this.ed = ed;
    }
    
    

    public Actividadusuario getActividadusuario_logeado() {
        return actividadusuario_logeado;
    }

    public void setActividadusuario_logeado(Actividadusuario actividadusuario_logeado) {
        this.actividadusuario_logeado = actividadusuario_logeado;
    }
    

    public Antropometricos getAntropometricos_ulogeado() {
        return antropometricos_ulogeado;
    }

    public void setAntropometricos_ulogeado(Antropometricos antropometricos_ulogeado) {
        this.antropometricos_ulogeado = antropometricos_ulogeado;
    }

    
    public Usuario getUsuario_logeado() {
        return usuario_logeado;
    }

    public void setUsuario_logeado(Usuario usuario_logeado) {
        this.usuario_logeado = usuario_logeado;
    }
    
    

    public String getNombre_u() {
        return nombre_u;
    }

    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getIcc() {
        return icc;
    }

    public void setIcc(String icc) {
        this.icc = icc;
    }

    
    
    public double getKilocalorias() {
        return kilocalorias;
    }

    public void setKilocalorias(double kilocalorias) {
        this.kilocalorias = kilocalorias;
    }
    
    
    
    //----------------IMC-ICC

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
/*
    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getCadera() {
        return cadera;
    }

    public void setCadera(double cadera) {
        this.cadera = cadera;
    }

    */
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    //---------------kilocalorias------------

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getFecha_n() {
        return fecha_n;
    }

    public void setFecha_n(String fecha_n) {
        this.fecha_n = fecha_n;
    }
    
    

    public double getActividad() {
        return actividad;
    }

    public void setActividad(double actividad) {
        this.actividad = actividad;
    }
    
    
    //----------------------------------

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha_reg_antro() {
        return fecha_reg_antro;
    }

    public void setFecha_reg_antro(String fecha_reg_antro) {
        this.fecha_reg_antro = fecha_reg_antro;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
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

    public Tipoactividad getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(Tipoactividad tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

   
    public List<Tipoactividad> lista_tipoact(){
        return tipoActividad_ln.listaTipoactividad();
    }

    public Antropometricos getAntropometricos() {
        return antropometricos;
    }

    public void setAntropometricos(Antropometricos antropometricos) {
        this.antropometricos = antropometricos;
    }
    
    public List<Antropometricos> lista_antro(){
        return antropometricos_ln.listaAntropometricos();
    }
    public Usuario u1timo_usuario() {
        int indice = usuarios_ln.listaUsuarios().size() - 1;
        Usuario u = usuarios_ln.listaUsuarios().get(indice);
        return u;
    }
    public List<Antropometricos> lista_antro_por_idusuario(){
        List<Antropometricos> ua = new ArrayList<>();
        for (Antropometricos a : antropometricos_ln.listaAntropometricos()) {
            if (idu == a.getIdUsu().getIdUsuario()) {
                ua.add(a);
            }
        }
        return ua;
        
        /*
        List<Antropometricos>listaAntro_IDusu = new ArrayList<Antropometricos>();
        for (int i = 0; i < antropometricos_ln.listaAntropometricos().size(); i++) {
            if (( antropometricos_ln.listaAntropometricos().get(i).getIdUsu().getIdUsuario())== idu){//usuario_logeado.getIdUsuario()){//u1timo_usuario().getIdUsuario()){//id_usuario) { //si el usuario ya esta registrado
                //antropometricos_ulogeado = antropometricos_ln.listaAntropometricos().get(i);    
                //break;
                listaAntro_IDusu.add(antropometricos_ln.listaAntropometricos().get(i));
            }
        }
        return listaAntro_IDusu;
        */
    }
    public Antropometricos obtener_antros_user() {
        
        Antropometricos an = new Antropometricos();
        for (Antropometricos ant : lista_antro_por_idusuario()) {
            if (a == ant.getIdAntro()) {//if (a == ant.getIdAntro()) {
                an = ant;
            }
        }
        return an;
        
        /*
        Antropometricos an = new Antropometricos();
        for (Antropometricos ant : lista_antro_por_idusuario()) {
            if (antropometricos_ulogeado.getIdAntro() == ant.getIdAntro()) {
                an = ant;
            }
        }
        return an;
        */
    }

    public Actividadusuario getActividadusuario() {
        return actividadusuario;
    }

    public void setActividadusuario(Actividadusuario actividadusuario) {
        this.actividadusuario = actividadusuario;
    }
    public List<Actividadusuario> lista_ActUsuario(){
        return actividadUsuario_ln.listaActividadUsuario();
    }
    
    public void registrar_usuario(ActionEvent e){
      //  usuarios.setFechanac(colocarFecha(fecha_nac));
// usuarios.setFechanac(obtenerFecha());
        if(existe_usuario()==true){
            mensaje_existe_u="Este usuario ya se encuentra registrado";
            mensaje="";
        }else{
             if(obtener_edad()>20){
                usuarios_ln.registrar(usuarios);  
                //amensaje();
                usuarios = new Usuario();
                usu_reg=false;
                mensaje="Registro realizado";
                mensaje_existe_u="";
                ultimo = this.u1timo_usuario().getIdUsuario();
            }else{
                 mensaje="Debe tener mas de 20 años";
                 mensaje_existe_u="";
            }
        }
       
  
    }
    
    public void registrar_tipoActividad(ActionEvent e){ 
       tipoActividad_ln.registrar(tipoactividad);
       tipoactividad = new Tipoactividad();
    }
    public boolean existe_usuario() {
        boolean existe = false;
        for (Usuario users : usuarios_ln.listaUsuarios()) {
            if (usuarios.getNombre().equals(users.getNombre()) && usuarios.getFechanac().equals(users.getFechanac())
                && usuarios.getEstatura().equals(users.getEstatura()) && usuarios.getSexo().equals(users.getSexo())
                && usuarios.getPassword().equals(users.getPassword())) {
                existe = true;
                break;
            }
        }
        return existe;
    }
   public boolean es_fecha_registrada(Date fechare){
       boolean is_regis=false;
        for (int i = 0; i < lista_antro_por_idusuario().size(); i++) {
            if (( lista_antro_por_idusuario().get(i).getFecha()).equals(fechare)) {//fecha_reg_ant //si el usuario ya esta registrado
                //antropometricos_ulogeado = antropometricos_ln.listaAntropometricos().get(i);   
                is_regis=true;
                break;
            }
        }
        return is_regis;
   }
    
   public void registrar_antropometricos(ActionEvent e){
        if(es_fecha_registrada(obtenerFecha())==true){
            mensaje_antro_existe="Ya ha registrado sus datos antropometricos en esta fecha";
            mensaje_antro_regis ="";
        }else{
             antropometricos.setFecha(obtenerFecha());
             antropometricos.setIdUsu(u1timo_usuario());
             antropometricos_ln.registrar(antropometricos);
             antropometricos = new Antropometricos();
             mensaje_antro_regis = "Datos antropometricos registrados";
             mensaje_antro_existe="";
        }
       
    }
   
   public void registrar_actusuario(ActionEvent e){
       actividadusuario.setIdUsuar(usuarios);
       actividadusuario.setTa(tipoactividad);
       //fechas
       actividadUsuario_ln.registrar(actividadusuario);
       actividadusuario = new Actividadusuario();
   }
   public Date obtenerFecha(){
        Calendar calendario = Calendar.getInstance();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        //String fechaR="";
        Date fechaRegistro = null; 
 
        String fechaR = formatoFecha.format(calendario.getTime());
        
        try {
            fechaRegistro = formatoFecha.parse(fechaR);
        } catch (ParseException ex) {
           
        }
        return fechaRegistro;
    }
   
      public Date colocarFecha(String fecharegistro){
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaRegistro = null; 
 
        try {
            fechaRegistro = formatoFecha.parse(fecharegistro);
        } catch (ParseException ex) {
           
        }
        return fechaRegistro;
    }
    
    public void amensaje() {
        mensaje = "Registro realizado ";
    }
    
    public String buscar_usuario(){
        boolean usuarioExiste = false;
        for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if ((usuarios_ln.listaUsuarios().get(i).getNombre()).equals(nombre_persona)
                && usuarios_ln.listaUsuarios().get(i).getPassword().equals(password)) { //si el usuario ya esta registrado
                //nombre_u = usuarios_ln.listaUsuarios().get(i).getNombre();
                usuario_logeado = usuarios_ln.listaUsuarios().get(i);
                //user = usuarios_ln.listaUsuarios().get(i).getNombre();//u.getNombre();
                user = usuarios_ln.listaUsuarios().get(i).getNombre();
                usuarioExiste = true;
                break;
            }
        }
        if (usuarioExiste == true) {
           // buscar_datos_antro(id_usuario); 
           // buscar_datos_actusu(id_usuario);
            mostrar();
            lista_antro_por_idusuario();
            calcular_edad(usuario_logeado.getFechanac());
            return "imc_icc";//"indicadores_salud";//"imc_icc"; 
        }else{
            intentos_aut++;
            return "login";
            //return "usuarios";
        }
    }
    
    public boolean supera_intentos(){
        boolean quedan_intentos=false;
        if(intentos_aut > 3){
           mensaje="Hizo demasiados intentos erróneos";
           quedan_intentos=true;
        }
        return quedan_intentos;
    }
     public Usuario mostrar() {
        Usuario us = new Usuario();
        for (Usuario u : usuarios_ln.listaUsuarios()) {
            if (nombre_persona.equals(u.getNombre()) && password.equals(u.getPassword())) {
                us = u;
                idu = u.getIdUsuario();
            }
        }
        return us;
    }
    public void calculadatos(ActionEvent a) {
        double imcc, iccc, h, m;
       // h = (10 * obtener_antros_user().getPeso()) + (6.25 * mostrar().getEstatura()) - (5 * edadac) + 5;
       // m = (10 * obtener_antros_user().getPeso()) + (6.25 * mostrar().getEstatura()) - (5 * edadac) - 161;
        edadac = calcular_edad(mostrar().getFechanac());
        imcc = (obtener_antros_user().getPeso() / Math.pow(mostrar().getEstatura(), 2)) * 10000;
        iccc = obtener_antros_user().getCintura() / obtener_antros_user().getCadera();
        //fach = h;
        //facm = m;
        if (imcc <= 18.5) {
            imc = "Peso Bajo " + imcc;
        }
        if (imcc >= 18.5 && imcc <= 24.9) {
            imc = "Peso Normal " + imcc;
        }
        if (imcc >= 25 && imcc <= 29.9) {
            imc = "Sobre peso " + imcc;
        }
        if (imcc >= 30) {
            imc = "Obesidad " + imcc;
        }
        if (mostrar().getSexo().equals("m") && iccc <= 0.95) {
            icc = "Bajo " + iccc;
        }
        if (mostrar().getSexo().equals("f") && iccc <= 0.80) {
            icc = "Bajo " + iccc;
        }
        if (mostrar().getSexo().equals("m") && iccc >= 0.95 && iccc <= 1) {
            icc = "Medio " + iccc;
        }
        if (mostrar().getSexo().equals("f") && iccc >= 0.80 && iccc <= 85) {
            icc = "Medio " + iccc;
        }
        if (mostrar().getSexo().equals("m") && iccc >= 1) {
            icc = "Alto " + iccc;
        }
        if (mostrar().getSexo().equals("f") && iccc >= 0.85) {
            icc = "Alto " + iccc;
        }

    }
    /*
    public double calcular_imc(){
       peso = antropometricos_ulogeado.getPeso();
       estatura = usuario_logeado.getEstatura();
       imc = peso/Math.pow(estatura,2);
       return imc;
    }
    
    public double calcular_icc(){
       cintura = antropometricos_ulogeado.getCintura();
       cadera = antropometricos_ulogeado.getCadera();
       icc = cintura/cadera;
       return icc;
    }
    */
    public int obtener_edad(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        as = sdf.format(usuarios.getFechanac());

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(as, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return periodo.getYears();
    }
    public int calcular_edad(Date fechanacimiento){
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaNac = new GregorianCalendar(fechanacimiento.getYear(),fechanacimiento.getMonth(),fechanacimiento.getDay());
        //calculo de las diferencias
        //an = fechaActual.get(Calendar.YEAR);
        //ed = fechaNac.get(Calendar.YEAR);
        int anios=0;
        if(fechaNac.get(Calendar.YEAR)<20){
             anios = fechaActual.get(Calendar.YEAR)-(2000+fechaNac.get(Calendar.YEAR));
        }else{
             anios = fechaActual.get(Calendar.YEAR)-(1900+fechaNac.get(Calendar.YEAR));
        }
       
        int meses = fechaActual.get(Calendar.MONTH)-fechaNac.get(Calendar.MONTH);
        int dias = fechaActual.get(Calendar.DAY_OF_MONTH)-fechaNac.get(Calendar.DAY_OF_MONTH);
        //comprobar si el dia de su cumpleaños es posterior a la fecha actual, para restar 1 a la diferencia de años
        //pues aun no ha sido su cumpleaños
        if (meses < 0 || meses==0 && dias < 0 ) { //aun no es el mes de su cumpleaños o es el mes pero aun no ha llegado el dia
            anios--; 
        }
        edad = anios;
        return edad;
    }
    /*
    public double calcular_kilocalorias(){//(BigInteger factoActividad){
       peso = antropometricos_ulogeado.getPeso();
       estatura = usuario_logeado.getEstatura();
       //BigInteger factorAct = factoActividad;
       //factor = factorA
      // edad = calcular_edad(fechaNac);
       double tmb= (10*peso)+(6.25*estatura)-(5*edad)+5;
       kilocalorias=tmb*factor;
       return kilocalorias;
    }
    */
    public void buscar_datos_antro(int idusuario){
        for (int i = 0; i < antropometricos_ln.listaAntropometricos().size(); i++) {
            if (( antropometricos_ln.listaAntropometricos().get(i).getIdUsu().getIdUsuario())== idusuario) { //si el usuario ya esta registrado
                antropometricos_ulogeado = antropometricos_ln.listaAntropometricos().get(i);  
                a = antropometricos_ln.listaAntropometricos().get(i).getIdAntro();  
                break;
            }
        }
    }
    public void buscar_da_por_idantro(){
       // idantropometricos = id_antropometrico;
        for (int i = 0; i < antropometricos_ln.listaAntropometricos().size(); i++) {//antropometricos_ln.listaAntropometricos().size(); i++) {
            if ((antropometricos_ln.listaAntropometricos().get(i).getIdAntro())==(idantropometricos)) { //si el usuario ya esta registrado
                antropometricos_ulogeado = antropometricos_ln.listaAntropometricos().get(i);  
                break;
            }
        }
    }
    public void buscar_datos_actusu(int id_usuario){
         for (int i = 0; i < actividadUsuario_ln.listaActividadUsuario().size(); i++) {
             if ((actividadUsuario_ln.listaActividadUsuario().get(i).getIdUsuar().getIdUsuario()) == id_usuario) {
                 actividadusuario_logeado = actividadUsuario_ln.listaActividadUsuario().get(i);                 
             }
         }
    }
    public double seleccionar_factor(Tipoactividad tac, char sexo){
        //boolean es_mujer = true;
        factor=tac.getFactorm().doubleValue();
     
        if(sexo == 'm'){
            factor = tac.getFactorh().doubleValue();
        }
        return factor;
        
    }
    public boolean is_hombre(char sexo){
        boolean es_hombre = true;
        if(sexo == 'm'){
            es_hombre = false;
        }
        return es_hombre;
    }
    
  

    
    /*
    public int calcular_edad(Date fechaNacimiento){
        Object edad = obtenerFecha()- fechaNacimiento;
    }
    */
   /*
    public String validarLogin() {      
        if (usuario.equals("admin") && password.equals("admin")) {
          return "antropometricas";
        } else {
          return "usuarios";
        }
    }
    */
    
}
