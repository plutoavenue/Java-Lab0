
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestVariant10 {

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, Variant10.TaskSpecialReturn p2) {
        assertEquals(new Variant10().integerNumbersTask(p1).a, p2.a);
        assertEquals(new Variant10().integerNumbersTask(p1).b, p2.b);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{{356, new Variant10.TaskSpecialReturn(6, 5)},
                {401, new Variant10.TaskSpecialReturn(1, 0)},
                {550, new Variant10.TaskSpecialReturn(0, 5)},
                {127, new Variant10.TaskSpecialReturn(7, 2)},
                {105, new Variant10.TaskSpecialReturn(5, 0)}};
    }

    /////////////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void boolTest(int p1, int p2) {
        assertTrue(new Variant10().booleanTask(p1, p2));
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{22, 947}, {-207, 630}, {31, 12}, {18, -71}, {2, 1}};
    }
    //////////////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(Variant10.TaskSpecialReturn input, Variant10.TaskSpecialReturn output) {
        assertTrue(new Variant10().ifTask(input.a, input.b).equals(output));
    }

    @DataProvider
    Object[][] ifProvider() {
        Variant10.TaskSpecialReturn input1 = new Variant10.TaskSpecialReturn(75, 200);
        Variant10.TaskSpecialReturn output1 = new Variant10.TaskSpecialReturn(275, 275);

        Variant10.TaskSpecialReturn input2 = new Variant10.TaskSpecialReturn(20, 20);
        Variant10.TaskSpecialReturn output2 = new Variant10.TaskSpecialReturn(0, 0);

        Variant10.TaskSpecialReturn input3 = new Variant10.TaskSpecialReturn(-52, 90);
        Variant10.TaskSpecialReturn output3 = new Variant10.TaskSpecialReturn(38, 38);

        Variant10.TaskSpecialReturn input4 = new Variant10.TaskSpecialReturn(-9, -9);
        Variant10.TaskSpecialReturn output4 = new Variant10.TaskSpecialReturn(0, 0);

        return new Object[][]{{input1, output1}, {input2, output2}, {input3, output3}, {input4, output4}};
    }


    //////////////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(char p1, int p2, char p3) {
        assertEquals(new Variant10().switchTask(p1, p2), p3);
    }

    @DataProvider
    Object[][] switchProvider() {
        return new Object[][]{{'С', 0, 'С'}, {'В', 1, 'С'}, {'В', 0, 'В'}, {'С', 1, 'З'}, {'С', -1, 'В'}};
    }

    ////////////////////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int p1, double p2) {
        assertEquals(new Variant10().forTask(p1), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{1, 1}, {2, 1.5}, {4, 2.083333333333333}, {8, 2.7178571428571425}};
    }

    ////////////////////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, int p2) {
        assertEquals(new Variant10().whileTask(p1), p2);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{4, 1}, {15, 4}, {16, 5}, {1, 0}};
    }

    ///////////////////////////////////////////////////////////////

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int input, int[] inputArr, Variant10.TaskSpecialReturn output) {
        assertTrue(new Variant10().minMaxTask(input, inputArr).equals(output));
    }

    @DataProvider
    Object[][] minMaxProvider() {
        Variant10.TaskSpecialReturn output1 = new Variant10.TaskSpecialReturn(0, 3);
        Variant10.TaskSpecialReturn output2 = new Variant10.TaskSpecialReturn(8, 5);
        Variant10.TaskSpecialReturn output3 = new Variant10.TaskSpecialReturn(3, 0);
        Variant10.TaskSpecialReturn output4 = new Variant10.TaskSpecialReturn(0, 0);
        Variant10.TaskSpecialReturn output5 = new Variant10.TaskSpecialReturn(0, 1);

        int[] arr1 = new int[]{2, 3, 2, 5, 2};
        int[] arr2 = new int[]{6, 6, 11, 9, 11, 25, 25, 7, 0};
        int[] arr3 = new int[]{51, 51, -3, -9, 3, 0, 2};
        int[] arr4 = new int[]{1, 1, 1, 1, 1};
        int[] arr5 = new int[]{4, 7, 7, 7, 5};

        return new Object[][]{{5, arr1, output1}, {9, arr2, output2}, {7, arr3, output3}, {5, arr4, output4},
                {5, arr5, output5}};
    }
    //////////////////////////////////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] inputArr, Variant10.ArrayClass output) {
        assertTrue(new Variant10().arrayTask(inputArr).equals(output));
    }

    @DataProvider
    Object[][] arrayProvider() {
        Variant10.ArrayClass output1 = new Variant10.ArrayClass(4, new int[]{2, 4, 4, 6}, 4, new int[]{5, 7, 1, 3});
        Variant10.ArrayClass output2 = new Variant10.ArrayClass(5, new int[]{2, -4, 6, 10, 8}, 3, new int[]{-3, -5, -1});
        Variant10.ArrayClass output3 = new Variant10.ArrayClass(4, new int[]{2, 8, 6, 10}, 1, new int[]{3});
        Variant10.ArrayClass output4 = new Variant10.ArrayClass(4, new int[]{2, 4, 6, 8}, 0, new int[]{});

        int[] arr1 = new int[]{2, 3, 4, 1, 7, 4, 5, 6};
        int[] arr2 = new int[]{-1, 2, -4, -5, 6, -3, 10, 8};
        int[] arr3 = new int[]{2, 8, 3, 6, 10};
        int[] arr4 = new int[]{2, 4, 6, 8};

        return new Object[][]{{arr1, output1}, {arr2, output2}, {arr3, output3}, {arr4, output4}};
    }
    ///////////////////////////////////////////////////////

    @Test(dataProvider = "twoDimensionArrayProvider")
    public void twoDimensionArrayTest(int[][] matrix, int n, int m, int[][] output) {
        for (int i=0; i< output.length; i++){
            assertEquals((new Variant10().twoDimensionArrayTask(matrix, n, m))[i], output[i]);
        }
   //    assertEquals(new Variant10().twoDimensionArrayTask(matrix, n, m), output);
    }

    @DataProvider
    public Object[][] twoDimensionArrayProvider() {
        int[][] input1 = new int[][] {{2, 3, 6, 9, -9},
                                    {34, 98, -9, 2, -1},
                                    {-4, 2, 1, 6, -1},
                                    {-98, 8, 1, 5, -3}};

        int[][] output1 = new int[][] {{2, 34, -4, -98},
                                        {6, -9, 1, 1},
                                        {-9, -1, -1, -3}};


        int[][] input2 = new int[][] {{-2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, -9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[][] output2 = new int[][] {{-2, -4, -34, -98},
                {-6, -1, -9, -1},
                {9, -1, -1, -3 }};


        int[][] input3 = new int[][]{{-2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, 9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[][] output3 = new int[][] {{-2, -4, -34, -98},
                {-6, -1, 9, -1},
                {9, -1, -1, -3} };


        int[][] input4 = new int[][]{{2, 3, -6, 9, 9},
                {-4, 2, -1, 6, -1},
                {-34, 98, 9, 2, -1},
                {-98, 8, -1, 5, -3}};

        int[][] output4 = new int[][] {{2, -4, -34, -98},
                {-6, -1, 9, -1},
                {9, -1, -1, -3}};

        return new Object[][]{{input1, 5, 4, output1}, {input2, 5, 4, output2},
                {input3, 5, 4, output3}, {input4, 5, 4, output4}};
    }

}
