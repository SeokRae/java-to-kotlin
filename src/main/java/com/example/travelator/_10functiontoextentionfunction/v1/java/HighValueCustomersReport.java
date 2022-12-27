package com.example.travelator._10functiontoextentionfunction.v1.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Comparator;
import java.util.List;

public class HighValueCustomersReport {
	
	private HighValueCustomersReport() {
	}
	
	public static void generate(Reader reader, Writer writer) throws IOException {
		List<CustomerData> valuableCustomers = new BufferedReader(reader).lines()
			.skip(1)
			.map(HighValueCustomersReport::customerDataFrom)
			.filter(customerData -> customerData.getScore() >= 10)
			.sorted(Comparator.comparing(CustomerData::getScore))
			.toList();
		
		writer.append("ID\tName\tSpend\n");
		for (CustomerData customerData : valuableCustomers) {
			writer.append(lineFor(customerData)).append("\n");
		}
		writer.append(summaryFor(valuableCustomers));
	}
	
	private static String summaryFor(List<CustomerData> valuableCustomers) {
		double total = valuableCustomers.stream()
			.mapToDouble(CustomerData::getSpend)
			.sum();
		return "\tTOTAL\t" + formatMoney(total);
	}
	
	private static String lineFor(CustomerData customerData) {
		return customerData.getId() + "\t" + marketingNameFor(customerData)
			+ "\t" + formatMoney(customerData.getSpend());
	}
	
	private static String formatMoney(double money) {
		return String.format("%#.2f", money);
	}
	
	private static String marketingNameFor(CustomerData customerData) {
		return customerData.getFamilyName().toUpperCase() + ", " + customerData.getGivenName();
	}
	
	private static CustomerData customerDataFrom(String line) {
		var parts = line.split("\t");
		double spend = parts.length == 4 ? 0 : Double.parseDouble(parts[4]);
		return new CustomerData(
			parts[0],
			parts[1],
			parts[2],
			Integer.parseInt(parts[3]),
			spend
		);
	}
}
