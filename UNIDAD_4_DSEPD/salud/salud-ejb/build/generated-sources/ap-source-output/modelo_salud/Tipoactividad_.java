package modelo_salud;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo_salud.Actividadusuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-29T15:05:09")
@StaticMetamodel(Tipoactividad.class)
public class Tipoactividad_ { 

    public static volatile SingularAttribute<Tipoactividad, String> descripcion;
    public static volatile SingularAttribute<Tipoactividad, BigInteger> factorh;
    public static volatile SingularAttribute<Tipoactividad, BigInteger> factorm;
    public static volatile SingularAttribute<Tipoactividad, Integer> idTipoA;
    public static volatile ListAttribute<Tipoactividad, Actividadusuario> actividadusuarioList;

}