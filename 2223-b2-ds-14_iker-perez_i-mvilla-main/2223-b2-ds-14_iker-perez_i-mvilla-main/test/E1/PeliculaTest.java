package E1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliculaTest {

    private Pelicula peli , peli2 ;
    private EQUIPOS c1, c2, c3, c4, c5, c6, c7, c8;
    private EQUIPOA r1, r2, r3, r4;



    @Before
    public void setUp() {

        peli = new Pelicula("Alcarras", 300000);
        peli2 = new Pelicula("Alcarras2", 300000);

        c1 = new EQUIPOS("Josep", "Abad", "00900001A", 623885758, "spain", 40, PUESTOS.ESPECIALISTAS, EspecialidadT.ERIESGO, 0,100);
        c2 = new EQUIPOS("Ainet", "Jounou", "00008001A", 642885758, "england", 200, PUESTOS.INTERPRETES, EspecialidadT.IPRINCIPAL, 0,90);
        c3 = new EQUIPOS("Xenia", "Roset", "00600001A", 627885758, "portugal", 200, PUESTOS.INTERPRETES, EspecialidadT.ISECUNDARIO, 0,50);
        c4 = new EQUIPOS("Cristina", "Puig", "08000001A", 922885758, "france", 20, PUESTOS.DOBLADORES,null, 0,20);
        c5 = new EQUIPOS("Carla", "Simon", "00020001A", 627785758, "italy", 100, PUESTOS.DIRECTORES, EspecialidadT.DEXPERIMENTADO, 7,500);
        c6 = new EQUIPOS("Maria", "Zamora", "00060001A", 622335758, "france", 90, PUESTOS.PRODUCTORES, null, 0,100);
        c7 = new EQUIPOS("Andrea", "Koch", "00004001A", 622885888, "spain", 60, PUESTOS.MUSICO, null, 0,200);
        c8 = new EQUIPOS("Arnau", "Vilaro", "03000001A", 622895758, "england", 70, PUESTOS.GUIONISTA, EspecialidadT.GORIGINAL, 0,300);


        r1 = new EQUIPOA("Carla", "Simon", "00020001A", 627785758, "italy", 100, PUESTOS.DIRECTORES, EspecialidadT.DEXPERIMENTADO, 0.05);
        r2 = new EQUIPOA("Maria", "Zamora", "00060001A", 622335758, "france", 90, PUESTOS.PRODUCTORES, null, 0.02);
        r3 = new EQUIPOA("Andrea", "Koch", "00004001A", 622885888, "spain", 60, PUESTOS.MUSICO, null, 0.04);
        r4 = new EQUIPOA("Arnau", "Vilaro", "03000001A", 622895758, "england", 70, PUESTOS.GUIONISTA, EspecialidadT.GORIGINAL, 0.05);


        peli.agregarEquipo(c1);
        peli.agregarEquipo(c2);
        peli.agregarEquipo(c3);
        peli.agregarEquipo(c4);
        peli.agregarEquipo(c5);
        peli.agregarEquipo(c6);
        peli.agregarEquipo(c7);
        peli.agregarEquipo(c8);


        peli2.agregarEquipo(r1);
        peli2.agregarEquipo(r2);
        peli2.agregarEquipo(r3);
        peli2.agregarEquipo(r4);

    }


    @Test
    public void testSalario() {
        assertEquals(5000, c1.getSalario());
        assertEquals(54000, c2.getSalario());
        assertEquals(10000, c3.getSalario());
        assertEquals(400, c4.getSalario());
        assertEquals(57000, c5.getSalario());
        assertEquals(9000, c6.getSalario());
        assertEquals(12000, c7.getSalario());
        assertEquals(25000, c8.getSalario());
    }



    // TEST DE COMPROBACION SALARIO TOTAL DE LA PRODUCTORA
    @Test
    public void testAllSalario() {
        assertEquals(172400, peli.sumasalarios());
    }


    // TEST TO STRING
    @Test
    public void testToString() {
        Collection<? super EHUMANO> HSP = peli.equipoPelicula();
        HashSet<String> HSS = new HashSet();
        for (Object o : HSP) {
            HSS.add(o.toString());
        }
        assertTrue(HSS.contains(c1.toString()) && HSS.contains(c1.toString()) && HSS.contains(c2.toString()));
    }


    @Test
    public void testprintSalaries(){
        System.out.println(peli.printSalaries());
    }

    @Test
    public void testprintRoyalties(){
        System.out.println(peli2.printRoyalties());
    }


    //COMPRUEBO QUE SE ESTEN CALCULANDO BIEN LOS PORCENTAJES SOBRE LA RECAUDACION DE LA PELI
   @Test
    public void testPorcentaje() {
        assertEquals(15000,r1.getComision(),0.1);
        assertEquals(6000, r2.getComision(), 0.1);
        assertEquals(12000, r3.getComision(), 0.1);
       assertEquals(15000, r4.getComision(), 0.1);

   }

    @Test (expected = IllegalArgumentException.class)
    public void illegalTlf(){
        c1.setTelefono(24);
        c2.setTelefono(1999999999);
    }


    @Test
    public void gettersAndSetters(){
        assertEquals(EspecialidadT.ERIESGO, c1.getEspecialidad());
        c1.setEspecialidad(EspecialidadT.IPRINCIPAL);
        assertEquals(EspecialidadT.IPRINCIPAL, c1.getEspecialidad());
        r2.setPuesto(PUESTOS.MUSICO);
        assertEquals(PUESTOS.MUSICO, r2.getPuesto());
        r3.setSalario(4987);
        assertEquals(4987,r3.getSalario());

    }

}
