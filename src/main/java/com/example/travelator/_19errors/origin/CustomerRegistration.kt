package com.example.travelator._19errors.origin

import com.example.travelator._19errors.origin.handlers.RegistrationData

class CustomerRegistration(
    private val customers: Customers,
    private val exclusionList: ExclusionList
) : IRegisterCustomers {

    override fun register(
        data: RegistrationData
    ): Result<Customer, RegistrationProblem> {
        return when {
            exclusionList.exclude(data) -> Failure(Excluded)
            else -> customers.add(data.name, data.email)
                .mapFailure { problem: CustomersProblem ->
                    when (problem) {
                        is DuplicateCustomerProblem ->
                            Duplicate(problem.message)

                        is DatabaseCustomerProblem ->
                            DatabaseProblem(problem.message)
                    }
                }
        }
    }
}