package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Palabras;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-29T20:10:38")
@StaticMetamodel(JuegosUsuario.class)
public class JuegosUsuario_ { 

    public static volatile SingularAttribute<JuegosUsuario, Integer> intentosr;
    public static volatile SingularAttribute<JuegosUsuario, Integer> idJuegousu;
    public static volatile SingularAttribute<JuegosUsuario, Date> fechaHora;
    public static volatile SingularAttribute<JuegosUsuario, Palabras> idpalabra;
    public static volatile SingularAttribute<JuegosUsuario, Integer> intentost;
    public static volatile SingularAttribute<JuegosUsuario, Usuario> idusuario;

}