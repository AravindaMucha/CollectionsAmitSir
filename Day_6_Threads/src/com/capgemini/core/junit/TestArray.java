package com.capgemini.core.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArray {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void testArraySize() {
		SortingArray array = new SortingArray();
		array.arraySort(null);
		
	}
	
	@Test
	public void testArraySize1() {
		SortingArray array = new SortingArray();
		int a[] = {1, 4, 2, 6, 3};
		int b[] = array.arraySort(a);
		int res[] = {1, 2, 3, 4, 6};
		assertArrayEquals(res, b);
	}
	

}
