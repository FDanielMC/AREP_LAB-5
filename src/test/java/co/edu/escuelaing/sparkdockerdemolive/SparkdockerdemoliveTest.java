/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.sparkdockerdemolive;

import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author moren
 */
public class SparkdockerdemoliveTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SparkdockerdemoliveTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SparkdockerdemoliveTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testPalindrome() throws Exception {
        String[] strings = new String[]{"hola", "anilina", "12345654321"};
        String[] expectedResults = new String[]{"false", "true", "true"};
        String result1 = Sparkdockerdemolive.palindrome(strings[0]);
        String result2 = Sparkdockerdemolive.palindrome(strings[1]);
        String result3 = Sparkdockerdemolive.palindrome(strings[2]);
        assertEquals(expectedResults[0], result1);
        assertEquals(expectedResults[1], result2);
        assertEquals(expectedResults[1], result3);
    }

    public void testCompute() throws Exception {
        String[] queries = new String[]{"sin(90)", "cos(0)", "pal(123454321)", "vem(3,4)"};
        String[] expectedResults = new String[]{"1.0", "1.0", "true", "5.0"};
        assertEquals(expectedResults[0], Sparkdockerdemolive.calcule(queries[0]));
        assertEquals(expectedResults[1], Sparkdockerdemolive.calcule(queries[1]));
        assertEquals(expectedResults[2], Sparkdockerdemolive.calcule(queries[2]));
        assertEquals(expectedResults[3], Sparkdockerdemolive.calcule(queries[3]));
    }

    public void testMathMethods() throws Exception {
        double[] array = new double[]{90, 0};
        double[] expectedResults = new double[]{Math.sin(Math.toRadians(90)), Math.cos(Math.toRadians(0))};
        assertEquals(expectedResults[0], Sparkdockerdemolive.mathMethods(array[0], "sin"));
        assertEquals(expectedResults[1], Sparkdockerdemolive.mathMethods(array[1], "cos"));
    }

    public void testVectorMagnitude() {
        double[][] arrays = new double[][]{{5, 12}, {3, 4}, {7, 24}};
        double[] expectedResults = new double[]{13.0, 5.0, 25.0};
        for (int i = 0; i < arrays.length; i++) {
            double result = Sparkdockerdemolive.vectorMagnitude(arrays[i]);
            double expected = expectedResults[i];
            assertEquals(expected, result);
        }
    }

    public void testDoubleArrayParams() {
        String[] paramsStrings = new String[]{"1,2,3", "4.5,6.78", "10"};
        double[][] expectedResults = new double[][]{{1, 2, 3}, {4.5, 6.78}, {10}};
        for (int i = 0; i < paramsStrings.length; i++) {
            double[] result = Sparkdockerdemolive.doubleArrayParams(paramsStrings[i]);
            double[] expected = expectedResults[i];
            assertTrue(Arrays.equals(expected, result));
        }
    }
}
