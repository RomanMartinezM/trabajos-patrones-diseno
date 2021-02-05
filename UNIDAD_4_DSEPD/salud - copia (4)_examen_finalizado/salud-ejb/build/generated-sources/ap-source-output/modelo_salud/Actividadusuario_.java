package modelo_salud;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo_salud.Tipoactividad;
import modelo_salud.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-29T10:35:04")
@StaticMetamodel(Actividadusuario.class)
public class Actividadusuario_ { 

    public static volatile SingularAttribute<Actividadusuario, String> descripcion;
    public static volatile SingularAttribute<Actividadusuario, Date> fecha1;
    public static volatile SingularAttribute<Actividadusuario, Date> fecha2;
    public static volatile SingularAttribute<Actividadusuario, Usuario> idUsuar;
    public static volatile SingularAttribute<Actividadusuario, Tipoactividad> ta;
    public static volatile SingularAttribute<Actividadusuario, Integer> idActusu;

}