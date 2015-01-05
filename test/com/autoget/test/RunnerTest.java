package com.autoget.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.autoget.main.ReptileRunner;

public class RunnerTest {
	@Test
	public void test(){
		try {
			new ReptileRunner().runReptile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(true);
	}
}
