package com.banks.banksapp.banks.dto

import com.banks.banksapp.banks.domain.Bank


data class BankDto(
        val id: Int,
        val name: String
)

fun toDto(from: Bank): BankDto {
    return BankDto(from.id, from.name)
}

fun toEntity(from: BankDto): Bank {
    return Bank(from.id, from.name)
}

fun toDtos(from: List<Bank>): List<BankDto> {
    return from.map(::toDto)
}