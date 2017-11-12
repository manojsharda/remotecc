package com.wcg.remotecc.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.wcg.remotecc.utils.Constants;

/**
 * Unit tests for Grid
 */
public class GridTest {

	@Test
	public void GetANewGridWithDefaultSizeNoSizeGiven() {
		Grid newGrid = new Grid();
		assertNotNull(newGrid);
		assertEquals(Constants.GRID_DEFAULT_SIZE, newGrid.getSize());
	}

	@Test
	public void GetANewGridWithGivenSize() {
		Position size = new Position(7, 7);
		Grid newGrid = new Grid(size);
		assertNotNull(newGrid);
		assertEquals(size, newGrid.getSize());
	}

}
