import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.lab6.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.lab6.StudentBursier;

import java.util.List;

public class AplicatieCuBursaTest {
    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);

        Assertions.assertEquals("ISM141/1", sortata.get(0).getFormatieDeStudiu());

        for (int i = 0; i < sortata.size() - 1; i++) {
            String g1 = sortata.get(i).getFormatieDeStudiu();
            String g2 = sortata.get(i+1).getFormatieDeStudiu();
            Assertions.assertTrue(g1.compareTo(g2) <= 0);
        }
    }
}