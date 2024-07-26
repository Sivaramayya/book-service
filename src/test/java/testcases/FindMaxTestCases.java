package testcases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxTestCases {

    @Test
    public void testFindMax(){
        assertEquals(4,FindMax.findMax(new int[]{1,3,4,2}));
        assertEquals(-1,FindMax.findMax(new int[]{-12,-1,-3,-4,-2}));
    }
}
