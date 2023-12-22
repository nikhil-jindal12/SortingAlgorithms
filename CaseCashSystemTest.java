import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * JUnit testing class for the CaseCash system
 */
public class CaseCashSystemTest {
    
    @Test(timeout = 1000)
    public void testRunSimulation() {
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs = Arrays.asList("INIT, Tammy, 210",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "SORT, name",
                "SORT, balance",
                "TRANSFER, Kim, Tammy, 100",
                "SORT, name",
                "SORT, balance");
        List<String> expected = Arrays.asList("true", "true", "true", "[Kim, Quyen, Tammy]", "[Tammy, Kim, Quyen]", "true", "[Kim, Quyen, Tammy]", "[Kim, Tammy, Quyen]");
        assertEquals(expected, system.runSimulation(inputs));
    }

    @Test(timeout = 1000)
    public void testRunSimulation2() {
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs = Arrays.asList("INIT, Tammy, 210",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 50",
                "GET, Quyen",
                "INIT, Quyen, 400",
                "INIT, Robert, 1400",
                "SORT, name",
                "INIT, Jasmine, 200",
                "SORT, name",
                "SORT, balance",
                "TRANSFER, Kim, Tammy, 90",
                "SORT, name",
                "SORT, balance");

        List<String> expected = Arrays.asList("true", "true", "true", "true", "350", "false", "true", "[Kim, Quyen, Robert, Tammy]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "[Jasmine, Tammy, Kim, Quyen, Robert]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "[Jasmine, Kim, Tammy, Quyen, Robert]");
        assertEquals(expected, system.runSimulation(inputs));
    }

    @Test(timeout = 1000)
    public void testRunSimulation3() {
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs = Arrays.asList("INIT, Tammy, 210",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 50",
                "GET, Quyen",
                "INIT, Quyen, 400",
                "INIT, Robert, 1400",
                "SORT, name",
                "INIT, Jasmine, 200",
                "SORT, name",
                "SORT, balance",
                "TRANSFER, Kim, Tammy, 90",
                "SORT, name",
                "SORT, balance",
                "WITHDRAWAL, Tammy, 750",
                "WITHDRAWAL, Tammy, 20",
                "DEPOSIT, Kim, 1000",
                "WITHDRAWAL, Kim, 245");

        List<String> expected = Arrays.asList("true", "true", "true", "true", "350", "false", "true", "[Kim, Quyen, Robert, Tammy]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "[Jasmine, Tammy, Kim, Quyen, Robert]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "[Jasmine, Kim, Tammy, Quyen, Robert]", "false", "true", "true", "true");
        assertEquals(expected, system.runSimulation(inputs));
    }

    @Test(timeout = 1000)
    public void testRunSimulationNoSort(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 210",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 50",
                "GET, Quyen",
                "INIT, Quyen, 400",
                "INIT, Robert, 1400",
                "INIT, Jasmine, 200",
                "TRANSFER, Kim, Tammy, 90",
                "WITHDRAWAL, Tammy, 750",
                "WITHDRAWAL, Tammy, 20",
                "DEPOSIT, Kim, 1000",
                "WITHDRAWAL, Kim, 245");

        List<String> expected = Arrays.asList("true", "true", "true", "true", "350", "false", "true", "true","true", "false", "true", "true", "true");
        assertEquals(expected, system.runSimulation(inputs));

    }

    @Test(timeout = 1000)
    public void testRunSimulationNoNameSort(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 210",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 50",
                "GET, Quyen",
                "INIT, Quyen, 400",
                "INIT, Robert, 1400",
                "SORT, name",
                "INIT, Jasmine, 200", // j200 r1400 q350 t200
                "SORT, balance",
                "TRANSFER, Kim, Tammy, 90",
                "SORT, balance",
                "WITHDRAWAL, Tammy, 750",
                "WITHDRAWAL, Tammy, 20",
                "DEPOSIT, Kim, 1000",
                "WITHDRAWAL, Kim, 245",
                "SORT, balance");

        List<String> expected = Arrays.asList("true", "true", "true", "true", "350", "false", "true", "[Kim, Quyen, Robert, Tammy]", "true", "[Jasmine, Tammy, Kim, Quyen, Robert]", "true","[Jasmine, Kim, Tammy, Quyen, Robert]", "false", "true", "true", "true", "[Jasmine, Tammy, Quyen, Kim, Robert]");

        assertEquals(expected, system.runSimulation(inputs));

    }

    @Test(timeout = 1000)
    public void testRunSimulationNoBalanceSort(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 210",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 50",
                "GET, Quyen",
                "INIT, Quyen, 400",
                "INIT, Robert, 1400",
                "SORT, name",
                "INIT, Jasmine, 200",
                "SORT, name",
                "TRANSFER, Kim, Tammy, 90",
                "SORT, name",
                "WITHDRAWAL, Tammy, 750",
                "WITHDRAWAL, Tammy, 20",
                "DEPOSIT, Kim, 1000",
                "WITHDRAWAL, Kim, 245",
                "SORT, name");

        List<String> expected = Arrays.asList("true", "true", "true", "true", "350", "false", "true", "[Kim, Quyen, Robert, Tammy]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "false", "true", "true", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]");
        assertEquals(expected, system.runSimulation(inputs));

    }

    @Test(timeout = 1000)
    public void testRunSimulation5(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "GET, Kim",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 50",
                "TRANSFER, Quyen, Kim, 5",
                "GET, Quyen",
                "INIT, Quyen, 400",
                "INIT, Robert, 1400",
                "SORT, name",
                "INIT, Jasmine, 200",
                "SORT, name",
                "SORT, balance",
                "TRANSFER, Kim, Tammy, 100",
                "GET, Kim",
                "SORT, name",
                "GET, Robert",
                "SORT, balance",
                "WITHDRAWAL, Tammy, 750",
                "TRANSFER, Quyen, Tammy, 50",
                "GET, Robert",
                "WITHDRAWAL, Tammy, 20",
                "DEPOSIT, Kim, 1000",
                "GET, Kim",
                "WITHDRAWAL, Kim, 245",
                "GET, Kim",
                "SORT, name",
                "SORT, balance",
                "INIT, Fiona, 2500",
                "SORT, balance");

        List<String> expected = Arrays.asList("true", "true", "300", "true", "true", "true", "345", "false", "true", "[Kim, Quyen, Robert, Tammy]", "true", "[Jasmine, Kim, Quyen, Robert, Tammy]", "[Jasmine, Tammy, Kim, Quyen, Robert]", "true", "205", "[Jasmine, Kim, Quyen, Robert, Tammy]", "1400", "[Jasmine, Kim, Tammy, Quyen, Robert]", "false", "true", "1400", "true", "true", "1205", "true", "960", "[Jasmine, Kim, Quyen, Robert, Tammy]", "[Jasmine, Quyen, Tammy, Kim, Robert]", "true", "[Jasmine, Quyen, Tammy, Kim, Robert, Fiona]");
        assertEquals(expected, system.runSimulation(inputs));

    }

    @Test(timeout = 1000)
    public void testNameSortZeroOne(){
        CaseCashSystem caseCashSystem = new CaseCashSystem();

        // No elements
        List<String> actual = caseCashSystem.sortName();


        assertEquals(0, actual.size());

        // One element
        caseCashSystem.init("C", 100);
        actual = caseCashSystem.sortName();

        assertEquals("C", actual.get(0));
        assertEquals(1, actual.size());

    }

    @Test(timeout = 1000)
    public void testNameSortMany(){
        CaseCashSystem caseCashSystem = new CaseCashSystem();

        // Many elements
        caseCashSystem.init("C", 100);
        caseCashSystem.init("B", 100);
        caseCashSystem.init("F", 100);
        caseCashSystem.init("D", 100);
        caseCashSystem.init("E", 100);
        caseCashSystem.init("A", 100);

        List<String> actual = caseCashSystem.sortName();

        List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F");

        for(int i = 0; i < actual.size(); i++){
            assertEquals(actual.get(i), expected.get(i));
        }
    }

    @Test(timeout = 1000)
    public void testNameSortMany2(){
        CaseCashSystem caseCashSystem = new CaseCashSystem();

        // Many elements
        caseCashSystem.init("C", 100);
        caseCashSystem.init("B", 100);
        caseCashSystem.init("F", 100);
        caseCashSystem.init("D", 100);
        caseCashSystem.init("E", 100);
        caseCashSystem.init("A", 100);
        caseCashSystem.init("Beatrice", 125);
        caseCashSystem.init("Fiona", 50);
        caseCashSystem.init("Danny", 275);
        caseCashSystem.init("Evren", 25);
        caseCashSystem.init("Ava", 500);

        List<String> actual = caseCashSystem.sortName();

        List<String> expected = Arrays.asList("A", "Ava", "B", "Beatrice", "C", "D", "Danny", "E", "Evren", "F", "Fiona");

        for(int i = 0; i < actual.size(); i++){
            assertEquals(actual.get(i), expected.get(i));
        }

    }

    @Test(timeout = 1000)
    public void testBalanceSortFew(){
        CaseCashSystem caseCashSystem = new CaseCashSystem();

        // No elements
        List<String> actual = caseCashSystem.sortBalance();

        assertEquals(0, actual.size());

        // One element
        caseCashSystem.init("C", 100);
        actual = caseCashSystem.sortBalance();
        assertEquals(1, actual.size());
        assertEquals("C", actual.get(0));
    }

    @Test(timeout = 1000)
    public void testBalanceSortMany(){
        CaseCashSystem caseCashSystem = new CaseCashSystem();

        // One element
        caseCashSystem.init("C", 100);

        // Many
        caseCashSystem.init("B", 100);
        caseCashSystem.init("F", 125);
        caseCashSystem.init("D", 900);
        caseCashSystem.init("E", 145);
        caseCashSystem.init("A", 30);

        List<String> actual  = caseCashSystem.sortBalance();

        List<String> expected = Arrays.asList("A", "B", "C", "F", "E", "D");

        for(int i = 0; i < actual.size(); i++){
            assertEquals(actual.get(i), expected.get(i));
        }


    }

    @Test(timeout = 1000)
    public void testBalanceSortMany2(){
        CaseCashSystem caseCashSystem = new CaseCashSystem();

        // One element
        caseCashSystem.init("C", 100);

        // Many
        caseCashSystem.init("B", 100);
        caseCashSystem.init("F", 125);
        caseCashSystem.init("D", 900);
        caseCashSystem.init("E", 145);
        caseCashSystem.init("A", 30);

        // Even more elements!
        caseCashSystem.init("Beatrice", 130);
        caseCashSystem.init("Fiona", 50);
        caseCashSystem.init("Danny", 275);
        caseCashSystem.init("Evren", 25);
        caseCashSystem.init("Ava", 500);

        List<String> actual  = caseCashSystem.sortBalance();

        List<String> expected  = Arrays.asList("Evren","A","Fiona", "B", "C", "F", "Beatrice", "E", "Danny", "Ava","D");

        for(int i = 0; i < actual.size(); i++){
            assertEquals(actual.get(i), expected.get(i));
        }


    }

    @Test(timeout = 1000)
    public void testConstructor(){
        /* 1 point */
        CaseCashSystem caseCashSystem = new CaseCashSystem();

    }

    @Test(timeout = 1000)
    public void testInitGet(){
        /* 2 points */
        CaseCashSystem caseCashSystem = new CaseCashSystem();
        assertTrue(caseCashSystem.init("B", 100));
        assertTrue(caseCashSystem.init("F", 125));
        assertFalse(caseCashSystem.init("F", 900));
        assertTrue(caseCashSystem.init("P", 125));

        assertEquals(100, caseCashSystem.getBalance("B"));
        assertEquals(125, caseCashSystem.getBalance("F"));
        assertEquals(125, caseCashSystem.getBalance("P"));

    }

    @Test(timeout = 1000)
    public void testTransfer(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "TRANSFER, Quyen, Kim, 50");

        List<String> expected = Arrays.asList("true", "true", "true", "true");
        assertEquals(expected, system.runSimulation(inputs));

    }

    @Test(timeout = 1000)
    public void testTransferTooMuch(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "TRANSFER, Quyen, Kim, 500");

        List<String> expected = Arrays.asList("true", "true", "true", "false");
        assertEquals(expected, system.runSimulation(inputs));
    }

    @Test(timeout = 1000)
    public void testTransferAll(){
        CaseCashSystem system = new CaseCashSystem();

        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "TRANSFER, Quyen, Kim, 500",
                "TRANSFER, Quyen, Kim, 400");

        List<String> expected = Arrays.asList("true", "true", "true", "false","true");
        assertEquals(expected, system.runSimulation(inputs));
        assertEquals(0, system.getBalance("Quyen"));
        assertEquals(700, system.getBalance("Kim"));

    }

    @Test(timeout = 1000)
    public void testTransferZero(){
        CaseCashSystem system = new CaseCashSystem();

        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "TRANSFER, Quyen, Kim, 0",
                "TRANSFER, Quyen, Kim, 400");

        List<String> expected = Arrays.asList("true", "true", "true", "true","true");
        assertEquals(expected, system.runSimulation(inputs));
        assertEquals(0, system.getBalance("Quyen"));
        assertEquals(700, system.getBalance("Kim"));

    }

    @Test(timeout = 1000)
    public void testWithdrawZero(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 0");

        List<String> expected = Arrays.asList("true", "true", "true", "true");
        assertEquals(expected, system.runSimulation(inputs));
        assertEquals(400,system.getBalance("Quyen"));
        assertEquals(300,system.getBalance("Kim"));
    }

    @Test(timeout = 1000)
    public void testWithdrawTooMuch(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "WITHDRAWAL, Quyen, 0",
                "WITHDRAWAL, Quyen, 500");

        List<String> expected = Arrays.asList("true", "true", "true", "true", "false");
        assertEquals(expected, system.runSimulation(inputs));
        assertEquals(400,system.getBalance("Quyen"));
        assertEquals(300,system.getBalance("Kim"));
    }

    @Test(timeout = 1000)
    public void testDepositZero(){
        CaseCashSystem system = new CaseCashSystem();
        List<String> inputs  = Arrays.asList("INIT, Tammy, 200",
                "INIT, Kim, 300",
                "INIT, Quyen, 400",
                "DEPOSIT, Kim, 0");

        List<String> expected = Arrays.asList("true", "true", "true", "true");
        assertEquals(expected, system.runSimulation(inputs));
        assertEquals(400,system.getBalance("Quyen"));
        assertEquals(300,system.getBalance("Kim"));
        assertEquals(200,system.getBalance("Tammy"));
    }
}

