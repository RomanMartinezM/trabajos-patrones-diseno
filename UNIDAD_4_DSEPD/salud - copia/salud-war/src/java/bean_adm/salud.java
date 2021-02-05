/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean_adm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    private String id_usuario;
    private String password; 
    private String mensaje="";
    private String fecha_reg_antro;
    private String fecha_nac;
    private int intentos_aut;
    

    
    public salud() {
          id_usuario="";
          password=""; 
          password=""; 
          fecha_reg_antro="";
          fecha_nac="";
          intentos_aut=0;
          usuarios = new Usuario();
          tipoactividad = new Tipoactividad();
          antropometricos = new Antropometricos();
          actividadusuario = new Actividadusuario();
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
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
        usuarios.setFechanac(colocarFecha(fecha_nac));
// usuarios.setFechanac(obtenerFecha());
        usuarios_ln.registrar(usuarios);
             amensaje(usuarios.getIdUsuario());
        usuarios = new Usuario();
   
        mensaje="";
    }
    public void registrar_tipoActividad(ActionEvent e){ 
       tipoActividad_ln.registrar(tipoactividad);
       tipoactividad = new Tipoactividad();
    }
   
    
   public void registrar_antropometricos(ActionEvent e){
        antropometricos.setFecha(colocarFecha(fecha_reg_antro));
        antropometricos.setIdUsu(usuarios);
        antropometricos_ln.registrar(antropometricos);
        antropometricos = new Antropometricos();
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
        String fechaR="";
        Date fechaRegistro = null; 
 
        fechaR = formatoFecha.format(calendario.getTime());
        
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
    
    public void amensaje(int numeroUsuario) {
        this.mensaje = "Su numero de usuario es: " + numeroUsuario;
    }
    
    public String buscar_usuario(){
        boolean usuarioExiste = false;
        for (int i = 0; i < usuarios_ln.listaUsuarios().size(); i++) {
            if (usuarios_ln.listaUsuarios().get(i).getNombre().equals(id_usuario)
                && usuarios_ln.listaUsuarios().get(i).getPassword().equals(password)) { //si el usuario ya esta registrado
                usuarioExiste = true;
                break;
            }
        }
        if (usuarioExiste == true) {
            return "antropometricas"; 
        }else{
            intentos_aut++;
            return "login";
            //return "usuarios";
        }
    }
    
    public boolean supera_intentos(){
        boolean quedan_intentos=false;
        if(intentos_aut > 3){
           quedan_intentos=true;
        }
        return quedan_intentos;
    }
    
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
