package com.example.travelator._10functiontoextentionfunction.v1.kotlin;

import org.junit.jupiter.api.Test;

import java.io.*;

class HighValueCustomersReportTest {
	
	@Test
	void testCase1() throws IOException {
		HighValueCustomersReport.generate(
			new BufferedReader(new InputStreamReader(System.in))
			, new BufferedWriter(new OutputStreamWriter(System.out))
		);
	}
}