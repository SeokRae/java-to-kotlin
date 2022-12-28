package com.example.travelator._10functiontoextentionfunction.v9.kotlin

import java.io.IOException
import java.io.Reader
import java.io.Writer
import java.util.*

/**
 * 확장 함수를 적용할 만한 파라미터가 없기 때문에 generate는 그대로 둔다.
 * 그 외에는 단일식 확장 함수로 변경
 */
@Throws(IOException::class)
fun generate(reader: Reader, writer: Writer) {
    val valuableCustomers = reader.readLines()
        .toValuableCustomers()
        .sortedBy(CustomerData::score) // it을 명시하지 않고, CustomerData::score를 사용하는 이유?

    writer.append("ID\tName\tSpend\n")
    for (customerData in valuableCustomers) {
        writer.appendLine(customerData.outputLine)
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

private fun List<String>.toValuableCustomers() = withoutHeader()
    .map(String::toCustomerData)
    .filter { it.score >= 10 }

private fun List<String>.withoutHeader() = drop(1)

/**
 * 1. 코틀린의 함수를 활용
 * 2. let을 통해 람다식으로 변환
 * 3. return을 convert expression to body로 단일식으로 변환
 */
private fun List<CustomerData>.summarised(): String =
    // 책과는 다르게 sumByDouble을 사용하지 않고 sumOf를 사용하는군
    sumOf { it.spend }
        .let { total -> "\tTOTAL\t${total.toMoneyString()}" }

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
 * 3. convert function to property
 */
private val CustomerData.outputLine: String
    get() = "$id\t$marketingName\t${spend.toMoneyString()}"
