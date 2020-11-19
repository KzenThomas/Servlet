import static org.junit.Assert.*;

import org.junit.Test;

import maven.GoldNuggetCalc;

public class TestGoldNuggetCalc {
	
	GoldNuggetCalc goldnc = new GoldNuggetCalc();
	
	@Test
	public void testInhoud() throws Exception {
		
		assertTrue(0  < goldnc.vatberekenen(20, 110));
		assertTrue(50000  > goldnc.vatberekenen(20, 110));
		
	}
	@Test
	public void testInhoud2() throws Exception {
		
		assertTrue(0  < goldnc.goldnuggetspervat(19));
		assertTrue(200  > goldnc.goldnuggetspervat(19));
		
	}

}
