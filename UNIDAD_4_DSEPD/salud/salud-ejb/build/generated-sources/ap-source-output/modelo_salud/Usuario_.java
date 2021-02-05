package modelo_salud;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo_salud.Actividadusuario;
import modelo_salud.Antropometricos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-29T15:05:09")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, Date> fechanac;
    public static volatile SingularAttribute<Usuario, Integer> estatura;
    public static volatile ListAttribute<Usuario, Antropometricos> antropometricosList;
    public static volatile ListAttribute<Usuario, Actividadusuario> actividadusuarioList;
    public static volatile SingularAttribute<Usuario, String> sexo;
    public static volatile SingularAttribute<Usuario, String> nombre;

}