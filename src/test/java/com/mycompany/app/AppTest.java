package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testStringFound() {
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        assertTrue(new App().search(temp, temp, 3, arr, "c"));
    }

    public void testStringNotFound() {
        ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        assertFalse(new App().search(temp, temp, 3, arr, "t"));
    }

    public void testCommonIntegerTrue1() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2123, 321, 4, 7, 0, -15));
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertTrue(new App().search(arr1, arr2, 3, temp, "c"));
    }

    public void testCommonIntegerTrue2() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2123, 321, 4, 7, 0, -15));
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertTrue(new App().search(arr1, arr2, 2, temp, "c"));
    }

    public void testCommonIntegerFalse() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2123, 321, 4, 7, 0, -15));
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertFalse(new App().search(arr1, arr2, 4, temp, "c"));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();
        assertFalse(new App().search(array1, array1, 1, array2, "a"));
    }

    public void testNull() {
        assertFalse(new App().search(null, null, 1, null, null));
    }
}
