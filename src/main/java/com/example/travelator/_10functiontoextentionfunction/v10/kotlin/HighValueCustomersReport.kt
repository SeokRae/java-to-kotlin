package com.example.travelator._10functiontoextentionfunction.v10.kotlin

import java.io.IOException
import java.io.Reader
import java.io.Writer
import java.util.*

/**
 * 널 가능성이었던 Reader를 널 불가능성으로 변경
 */
@Throws(IOException::class)
fun generate(reader: Reader, writer: Writer) {
    val valuableCustomers = reader.readLines()
        .drop(1)
        .map(String::toCustomerData)
        .filter { it.score >= 10 }
        .sortedBy(CustomerData::score) // it을 명시하지 않고, CustomerData::score를 사용하는 이유?

    writer.append("ID\tName\tSpend\n")
    for (customerData in valuableCustomers) {
        writer.append(customerData.lineFor()).append("\n")
    }
    writer.append(valuableCustomers.summarised())
}

fun String.toCustomerData(): CustomerData =
    split("\t".toRegex()).let { parts ->
        return CustomerData(
            id = parts[0],
            givenName = parts[1],
            familyName = parts[2],
            score = parts[3].toInt(),
            spend = if (parts.size == 4) 0.0 else parts[4].toDouble()
        )
    }

/**
 * 1. convert function to property
 * 2. convert expression to body
 */
private val CustomerData.marketingName: String
    get() = "${familyName.uppercase()}, $givenName"

/**
 * 구체적인 변환 방식을 일반적인 변환 방식으로 변경
 */
private fun Any?.formattedAs(format: String) = String.format(format, this)

/**
 * 1. convert parameter to receiver
 * 2. convert expression to body
 */
private fun Double.toMoneyString(): String = this.formattedAs("%#.2f")

/**
 * 1. convert function to property
 * 2. convert expression to body
 */
private fun CustomerData.lineFor(): String =
    "$id\t$marketingName\t${spend.toMoneyString()}"

/**
 * 1. 코틀린의 함수를 활용
 * 2. let을 통해 람다식으로 변환
 * 3. return을 convert expression to body로 단일식으로 변환
 */
private fun List<CustomerData>.summarised(): String =
    // 책과는 다르게 sumByDouble을 사용하지 않고 sumOf를 사용하는군
    sumOf { it.spend }
        .let { total -> "\tTOTAL\t${total.toMoneyString()}" }
