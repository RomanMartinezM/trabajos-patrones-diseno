package modelo_salud;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo_salud.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-29T15:05:09")
@StaticMetamodel(Antropometricos.class)
public class Antropometricos_ { 

    public static volatile SingularAttribute<Antropometricos, Date> fecha;
    public static volatile SingularAttribute<Antropometricos, Integer> cintura;
    public static volatile SingularAttribute<Antropometricos, Integer> idAntro;
    public static volatile SingularAttribute<Antropometricos, Integer> peso;
    public static volatile SingularAttribute<Antropometricos, Usuario> idUsu;
    public static volatile SingularAttribute<Antropometricos, Integer> cadera;

}