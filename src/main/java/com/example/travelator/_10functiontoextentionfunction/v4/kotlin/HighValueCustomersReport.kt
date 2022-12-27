package com.example.travelator._10functiontoextentionfunction.v4.kotlin

import java.io.BufferedReader
import java.io.IOException
import java.io.Reader
import java.io.Writer
import java.util.*

object HighValueCustomersReport {
    @JvmStatic
    @Throws(IOException::class)
    fun generate(reader: Reader?, writer: Writer) {
        val valuableCustomers = BufferedReader(reader).lines()
            .skip(1)
            .map { line: String -> customerDataFrom(line) }
            .filter { (_, _, _, score): CustomerData -> score >= 10 }
            .sorted(Comparator.comparing { (_, _, _, score) -> score })
            .toList()
        writer.append("ID\tName\tSpend\n")
        for (customerData in valuableCustomers) {
            writer.append(lineFor(customerData)).append("\n")
        }
        writer.append(summaryFor(valuableCustomers))
    }

    @JvmStatic
    private fun customerDataFrom(line: String): CustomerData {
        val parts = line.split("\t".toRegex()).toTypedArray()
        val spend: Double = if (parts.size == 4) 0.0 else parts[4].toDouble()
        return CustomerData(
            parts[0],
            parts[1],
            parts[2],
            parts[3].toInt(),
            spend
        )
    }

    private fun summaryFor(valuableCustomers: List<CustomerData>): String {
        val total = valuableCustomers.stream()
            .mapToDouble({ (_, _, _, _, spend) -> spend })
            .sum()
        return "\tTOTAL\t" + formatMoney(total)
    }

    /**
     * 1. convert function to property
     * 2. convert expression to body
     */
    private fun lineFor(customerData: CustomerData): String =
        "${customerData.id}\t${customerData.marketingName}\t${formatMoney(customerData.spend)}"

    private fun formatMoney(money: Double): String {
        return String.format("%#.2f", money)
    }

    /**
     * 1. convert function to property
     * 2. convert expression to body
     */
    private val CustomerData.marketingName: String
        get() = "${familyName.uppercase()}, $givenName"
}