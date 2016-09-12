package v1.forestapp.com.forestapp;

import android.content.Context;

import java.util.ArrayList;

import v1.forestapp.com.forestapp.DAL.DataBaseManager;
import v1.forestapp.com.forestapp.DTO.ArbolDTO;

/**
 * Created by Admin_Sena on 22/08/2016.
 */
public class LlenarArbolesDB {

    DataBaseManager manager;

    public void FillGrid(Context cnt)
    {

        manager = new DataBaseManager(cnt);
        ArrayList<ArbolDTO> Listado = manager.getListaArboles();
        if (Listado.size()==0) {

            ArbolDTO a = new ArbolDTO();
            a.setImagen(R.drawable.arbolachote);
            a.setNombreComun("Achote");
            a.setNombreCientifico("Bixa Orellana");
            a.setReino("Plantae");
            a.setFilo("Magnoliophyta");
            a.setClase("Magnoliopsida");
            a.setFruto("Onoto");
            a.setFlor("Onoto");
            a.setDescripcion("Desde tiempos pasados esta planta medicinal fue usada para la elaboración de colorantes, así mismo fue usada como especie dentro de la preparación de ciertos platos.\n" +
                    "Los nombres comunes utilizados son: Achiote, acote, achihuete, saca achote, urcu, annato.");
            manager.InsertarArboles(a);

            ArbolDTO b = new ArbolDTO();
            b.setImagen(R.drawable.arbolmango);
            b.setNombreComun("Mango");
            b.setNombreCientifico("Mangifera Indica");
            b.setReino("Plantae");
            b.setFilo("Magnoliophyta");
            b.setClase("Magnoliopsida");
            b.setFruto("Mango");
            b.setFlor("Panículas");
            b.setDescripcion("El árbol del mango suele alcanzar un gran tamaño y altura (puede superar los 30 m.), sobre todo si tiene que competir por la luz con árboles más grandes, como lo sería en una plantación de cocoteros). En las zonas de climas templado puede cultivarse aunque no suele alcanzar una gran altura, por las incidencias climáticas que le resultan adversas.");
            manager.InsertarArboles(b);

            ArbolDTO c = new ArbolDTO();
            c.setImagen(R.drawable.arbolmamon);
            c.setNombreComun("Mamon");
            c.setNombreCientifico("Melicoccus bijugatus");
            c.setReino("Plantae");
            c.setFilo("Magnoliophyta");
            c.setClase("Magnoliopsida");
            c.setFruto("Drupa redonda");
            c.setFlor("Panículas pequeñas florecillas");
            c.setDescripcion("El Melicoccus bijugatus es un árbol de buen porte, alcanzando los 30 m de altura. Sus hojas presentan alternancia helicoidal, de 8 a 12 cm de longitud los superiores y 3 a 6 cm las inferiores, pinnadas, con 4 a 6 folíolos opuestos de unos 5 a 10 cm de longitud cada uno. A comienzos de la estación húmeda produce panículas de pequeñas florecillas blancas o verdes, muy fragantes. Es hermafrodita; produce flores masculinas, femeninas y, ocasionalmente, con ambos sexos. Todo el año es temporada, en especial de marzo a agosto. Es sensible a las sequías y heladas, por lo que se cultiva raramente fuera de su hábitat natural, donde se da de manera silvestre.");
            manager.InsertarArboles(c);

            ArbolDTO d = new ArbolDTO();
            d.setImagen(R.drawable.arbolorejero);
            d.setNombreComun("Orejero");
            d.setNombreCientifico("Enterolobium cyclocarpum");
            d.setReino("Plantae");
            d.setFilo("Fanerogama Magnoliophyta");
            d.setClase("Magnoliopsida");
            d.setFruto("Semilla vaina");
            d.setFlor("Flor actinomorficas");
            d.setDescripcion("El Enterolobium cyclocarpum es una especie de árbol perteneciente al orden de los Fabales e integrante de la familia Fabaceae. Es un árbol nativo de América, de regiones tropicales y templadas cálidas. Constituye en una de las dos especies conocidas como \"oreja de elefante\" en varios países latinoamericanos, árbol de Guanacaste en Honduras y Costa Rica, huanacaxtle en México, corotú en Panamá y otras partes, y carocaro en Venezuela. Es una especie maderable y a veces se usa como árbol de ornato. Es el árbol nacional de Costa Rica desde el 31 agosto de 1959, donde se le identifica además como símbolo de la provincia de Guanacaste.");
            manager.InsertarArboles(d);

            ArbolDTO e = new ArbolDTO();
            e.setImagen(R.drawable.arboluvitablanca);
            e.setNombreComun("Uvita o cordia dentata");
            e.setNombreCientifico("Cordia alba");
            e.setReino("Plantae");
            e.setFilo("Magnoliophyta");
            e.setClase("Magnoliopsida");
            e.setFruto("Uvita blanca");
            e.setFlor("Flor amarilla o blanca");
            e.setDescripcion("La Uvita o Cordia alba es un árbol caducifolio del género Cordia en la familia de Boraginaceae. La especie es nativa de América Central. Poseen este nombre por que poseen pequeños dientes en el borde de sus hojas las cuales son una continuación de los nervios secundarios. Se le da el uso como fuente de alimento, y debido a la calidad de su madera puede ser posible la fabricación de muchos objetos. Tiene presencia en muchos países de Centroamérica y algunos países de Sudaméricanos, especialmente en terrenos secos o recientemente inundados. Es muy popular en la ciudad de Barranquilla, Colombia.");
            manager.InsertarArboles(e);

            ArbolDTO f = new ArbolDTO();
            f.setImagen(R.drawable.primavera);
            f.setNombreComun("Primavera");
            f.setNombreCientifico("Bougainvillea glabra");
            f.setReino("Plantae");
            f.setFilo("Magnoliophyta");
            f.setClase("Magnoliopsida");
            f.setFruto("No contiene");
            f.setFlor("Flor rosada");
            f.setDescripcion("Tiene hojas verdes brillantes, ligeramente pilosas o glabras, y de brácteas color magenta, las hojas caducifolias (hojas caedizas).Es una planta perenne, trepadora, leñosa, que alcanza hasta 10 m de altura. Sus Flores son muy pequeñas, blancas, en grupos con brácteas coloridas papilosas. Se dispone de variedades de sola o doble flor. El tronco leñoso tiende a enroscarse, y las delgadas ramas tienen afiladas espinas y hojas verde oscuras. Es muy buena para setos, arcos, o arbusto en la tierra, y en macetas. Es ideal para bonsái.");
            manager.InsertarArboles(f);

            ArbolDTO g = new ArbolDTO();
            g.setImagen(R.drawable.palmabotella);
            g.setNombreComun("Palma Botella");
            g.setNombreCientifico("Hyophorbe lagenicaulis");
            g.setReino("Plantae");
            g.setFilo("Magnoliophyta");
            g.setClase("Liliopsida");
            g.setFruto("No especificado");
            g.setFlor("No especificado");
            g.setDescripcion("Es una especie que tiene una gran tronco hinchado (a veces extrañamente). Es un mito que el tronco es un medio por el cual la planta almacena el agua. Sólo tiene cuatro a seis hojas abiertas al mismo tiempo. Las flores surgen de debajo del capitel. Las palmas de botella son muy sensibles al frío y mueren a los 0 ° C. o menos si lo soportan en un tiempo apreciable. Pueden sobrevivir a una helada breve, pero podrían tener daños en el follaje. Sólo el sur de la Florida ofrece un lugar seguro en los EE.UU. para crecer esta especie.");
            manager.InsertarArboles(g);
        }
    }
}
