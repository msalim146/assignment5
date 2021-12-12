/*
 * Class: CMSC203  
 * Instructor: Ahmed Tarek
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Salim Musah
 */
import static org.junit.Assert.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestSTUDENT {
	private double[][] dataSet5 = {{1.65,4.5,2.36,7.45,3.44,6.23},{2.22,-3.24,-1.66,-5.48,3.46},{4.23,2.29,5.29},{2.76,3.76,4.29,5.48,3.43},{3.38,3.65,3.76},{2.46,3.34,2.38,8.26,5.34}};
	private double[][] dataSet6 = {{1253.65,4.50,2154.36,7532.45,3388.44},{2876.22,-3.24,1954.66},{4896.23,2.29,5499.29},{2256.76,3.76,4286.29,5438.48,3794.43},{3184.38,3654.65,3455.76,6387.23,4265.77,4592.45},{2657.46,3265.34,2256.38,8935.26,5287.34,6598.23}};
	private double[][] dataSet7 = {{12536.54,45665.05,21543.66,75324.57,33884.48,65982.39},{28762.21,35762.42,19546.63},{48962.34,28552.95,23863.66,54992.97},{22567.63,36237.64,42862.95,54384.86,37944.37},{31843.86,36546.57,34557.68,63872.39,42657.70,45924.51},{26574.65,32653.46,22563.87,89352.68,52873.49}};

	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSet5 = dataSet6 = dataSet7 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		  assertEquals(85.03,TwoDimRaggedArrayUtility.getTotal(dataSet5),.001);
	       assertEquals(99878.82,TwoDimRaggedArrayUtility.getTotal(dataSet6),.001);
	       assertEquals(1168798.18,TwoDimRaggedArrayUtility.getTotal(dataSet7),.001);
	       	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(3.149259259,TwoDimRaggedArrayUtility.getAverage(dataSet5),.001);
		assertEquals(3567.100714,TwoDimRaggedArrayUtility.getAverage(dataSet6),.001);
		assertEquals(40303.38586,TwoDimRaggedArrayUtility.getAverage(dataSet7),.001);
		
		//fail("Not yet implemented");
	}	
	
	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(-4.7,TwoDimRaggedArrayUtility.getRowTotal(dataSet5,1),.001);
		assertEquals(4827.64,TwoDimRaggedArrayUtility.getRowTotal(dataSet6,1),.001);
		assertEquals(14333.4,TwoDimRaggedArrayUtility.getRowTotal(dataSet6,0),.001);
		assertEquals(193997.45,TwoDimRaggedArrayUtility.getRowTotal(dataSet7,3),.001);
		assertEquals(84071.26,TwoDimRaggedArrayUtility.getRowTotal(dataSet7,1),.001);
		
		//fail("Not yet implemented");
	}
		
	


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(16.7,TwoDimRaggedArrayUtility.getColumnTotal(dataSet5,0),.001);
		assertEquals(19606.74,TwoDimRaggedArrayUtility.getColumnTotal(dataSet6,2),.001);
		assertEquals(215418.09,TwoDimRaggedArrayUtility.getColumnTotal(dataSet7,1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(8.26,TwoDimRaggedArrayUtility.getHighestInArray(dataSet5),.001);
		assertEquals(8935.26,TwoDimRaggedArrayUtility.getHighestInArray(dataSet6),.001);
		assertEquals(89352.68,TwoDimRaggedArrayUtility.getHighestInArray(dataSet7),.001);
	
		//fail("Not yet implemented");
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet7, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(12536.54, array[0][0],.001);
		assertEquals(45665.05, array[0][1],.001);
		assertEquals(21543.66, array[0][2],.001);
		assertEquals(28762.21, array[1][0],.001);
		assertEquals(35762.42, array[1][1],.001);
		assertEquals(48962.34, array[2][0],.001);
		assertEquals(28552.95, array[2][1],.001);
		assertEquals(22567.63, array[3][0],.001);
		assertEquals(36237.64, array[3][1],.001);
		assertEquals(42862.95, array[3][2],.001);
		assertEquals(54384.86, array[3][3],.001);		
		
	}
	
	public void testReadFile() {
		double[][] array=null;
		try {
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("12536.54 45665.05 21543.66\n" +
					"28762.21 35762.42\n" +
					"48962.34 28552.95\n" +
					"22567.63 36237.64 42862.95 54384.86");
			inFile.close();
			array = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(12536.54, array[0][0],.001);
			assertEquals(45665.05, array[0][1],.001);
			assertEquals(21543.66, array[0][2],.001);
			assertEquals(28762.21, array[1][0],.001);
			assertEquals(35762.42, array[1][1],.001);
			assertEquals(48962.34, array[2][0],.001);
			assertEquals(28552.95, array[2][1],.001);
			assertEquals(22567.63, array[3][0],.001);
			assertEquals(36237.64, array[3][1],.001);
			assertEquals(42862.95, array[3][2],.001);
			assertEquals(54384.86, array[3][3],.001);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[1][3],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[2][4 ],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
	}
	
	

}