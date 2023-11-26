import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithmsTesting {
    
    // create an instance of CaseCashSystem for the tests to run on
    CaseCashSystem cashSystem = new CaseCashSystem();

    @Test
    public void testBalanceSort() {
        
        // Test Case #1
        String[] in = {"INIT, Tammy, 200",
                       "SORT, balance"};
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            input.add(i, in[i]);
        }

        List<String> output = new ArrayList<>();
        String[] out = {"true", 
                        "[Tammy]"};
        for (int i = 0; i < 2; i++) {
            output.add(i, out[i]);
        }
        assertEquals("one", output, cashSystem.runSimulation(input));
        

        // Test Case #2
        String[] ins = {"INIT, Quyen, 400", 
                        "INIT, Kim, 300", 
                        "SORT, balance", 
                        };
        List<String> inputs1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputs1.add(i, ins[i]);
        }
        
        String[] out1 = {"true",
                       "true",
                       "[Tammy, Kim, Quyen]"
                        };
        List<String> outputs1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            outputs1.add(i, out1[i]);
        }

        assertEquals("many", outputs1, cashSystem.runSimulation(inputs1));

        // Test Case #3
        List<String> inputs2 = new ArrayList<>();
        String[] ins2 = {"INIT, John, 250",
                         "INIT, Mike, 450",
                         "INIT, Tom, 600",
                         "SORT, balance"
                        };
        for (int i = 0; i < 4; i++) {
            inputs2.add(i, ins2[i]);
        }

        List<String> outputs2 = new ArrayList<>();
        String[] out2 = {"true",
                         "true",
                         "true",
                         "[Tammy, John, Kim, Quyen, Mike, Tom]"
                        };
        for (int i = 0; i < 4; i++) {
            outputs2.add(i, out2[i]);
        }

        assertEquals("many", outputs2, cashSystem.runSimulation(inputs2));

    }

    @Test
    public void testNameSort() {
        
        // Test Case #1
        String[] in = {"INIT, Tammy, 200",
                       "SORT, name"};
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            input.add(i, in[i]);
        }

        List<String> output = new ArrayList<>();
        String[] out = {"true", 
                        "[Tammy]"};
        for (int i = 0; i < 2; i++) {
            output.add(i, out[i]);
        }
        assertEquals("one", output, cashSystem.runSimulation(input));
        

        // Test Case #2
        String[] ins = {"INIT, Quyen, 400", 
                        "INIT, Kim, 300", 
                        "SORT, name", 
                        };
        List<String> inputs1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputs1.add(i, ins[i]);
        }
        
        String[] out1 = {"true",
                       "true",
                       "[Kim, Quyen, Tammy]"
                        };
        List<String> outputs1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            outputs1.add(i, out1[i]);
        }

        assertEquals("many", outputs1, cashSystem.runSimulation(inputs1));

        // Test Case #3
        List<String> inputs2 = new ArrayList<>();
        String[] ins2 = {"INIT, John, 250",
                         "INIT, Mike, 450",
                         "INIT, Tom, 600",
                         "SORT, name"
                        };
        for (int i = 0; i < 4; i++) {
            inputs2.add(i, ins2[i]);
        }

        List<String> outputs2 = new ArrayList<>();
        String[] out2 = {"true",
                         "true",
                         "true",
                         "[John, Kim, Mike, Quyen, Tammy, Tom]"
                        };
        for (int i = 0; i < 4; i++) {
            outputs2.add(i, out2[i]);
        }

        assertEquals("many", outputs2, cashSystem.runSimulation(inputs2));

    }
}
