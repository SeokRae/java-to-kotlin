package com.example.travelator._10functiontoextentionfunction.v7.kotlin

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
        // let. 을 통해 람다로 호출
        line.split("\t".toRegex()).let { parts ->
            return CustomerData(
                parts[0],
                parts[1],
                parts[2],
                parts[3].toInt(),
                // 인라이닝을 통해 단일식의 기반을 마련
                spend = if (parts.size == 4) 0.0 else parts[4].toDouble()
            )
        }
    }

    private fun summaryFor(valuableCustomers: List<CustomerData>): String {
        val total = valuableCustomers.stream()
            .mapToDouble({ (_, _, _, _, spend) -> spend })
            .sum()
        return "\tTOTAL\t" + total.toMoneyString()
    }

    /**
     * 1. convert function to property
     * 2. convert expression to body
     */
    private fun lineFor(customerData: CustomerData): String =
        "${customerData.id}\t${customerData.marketingName}\t${customerData.spend.toMoneyString()}"

    /**
     * 1. convert parameter to receiver
     * 2. convert expression to body
     */
    private fun Double.toMoneyString(): String = this.formattedAs("%#.2f")

    /**
     * 구체적인 변환 방식을 일반적인 변환 방식으로 변경
     */
    private fun Any?.formattedAs(format: String) = String.format(format, this)

    /**
     * 1. convert function to property
     * 2. convert expression to body
     */
    private val CustomerData.marketingName: String
        get() = "${familyName.uppercase()}, $givenName"
}