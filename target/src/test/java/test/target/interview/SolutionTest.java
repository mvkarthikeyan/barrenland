package test.target.interview;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testCase1() {
        int array[][] = new int[400][600];
        Solution.applyBarrenArea(array, "0 292 399 307");
        List<Integer> answer  =  Solution.findFarmingAreas(array);

        assertEquals(  2 , answer.size());
        assertEquals(answer.get(0) ,116800);
        assertEquals(answer.get(1) ,116800);

    }

    @org.junit.jupiter.api.Test
    void testCase2() {
        int array[][] = new int[400][600];
        Solution.applyBarrenArea(array, "48 192 351 207");
        Solution.applyBarrenArea(array, "48 392 351 407");
        Solution.applyBarrenArea(array, "120 52 135 547");
        Solution.applyBarrenArea(array, "260 52 275 547");

        List<Integer> answer  =  Solution.findFarmingAreas(array);

        assertEquals(  2 , answer.size());
        assertEquals(answer.get(0) ,22816);
        assertEquals(answer.get(1) ,192608);

    }
}