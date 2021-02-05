package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.JuegosUsuario;
import modelo.Tipos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-20T19:00:14")
@StaticMetamodel(Palabras.class)
public class Palabras_ { 

    public static volatile SingularAttribute<Palabras, Tipos> tipo;
    public static volatile SingularAttribute<Palabras, String> palabra;
    public static volatile ListAttribute<Palabras, JuegosUsuario> juegosUsuarioList;
    public static volatile SingularAttribute<Palabras, Integer> nivel;
    public static volatile SingularAttribute<Palabras, Integer> idPalabra;

}