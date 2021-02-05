/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans_adm;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author lithium
 */
@Named(value = "ejemplo")
@RequestScoped
public class Ejemplo implements Serializable{

    private String usuario="";
    private String password="";
    private String mensaje="";

    
    /**
     * Creates a new instance of Ejemplo
     */
    public Ejemplo() {
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }
   
    public void amensaje() {
        this.mensaje = "Acceso concedido";
    }
    public String validarLogin() {      
        if (usuario.equals("admin") && password.equals("admin")) {
          return "inicio";
        } else {
          return "index";
        }
  }
}
