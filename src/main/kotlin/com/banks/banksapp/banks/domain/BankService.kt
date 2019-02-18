package com.banks.banksapp.banks.domain

import com.banks.banksapp.banks.dto.BankDto
import com.banks.banksapp.banks.dto.toDto
import com.banks.banksapp.banks.dto.toDtos
import com.banks.banksapp.banks.dto.toEntity
import java.util.*

class BankService(private val repository: BankRepository) {

    fun getBanks(): List<BankDto> {
        return toDtos(repository.findAll())
    }



    fun getBank(id: Int): Optional<BankDto> {
        return repository.findById(id).flatMap { Optional.of(toDto(it)) }
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun create(bankDto: BankDto): BankDto {
        return toDto(repository.save(toEntity(bankDto)))
    }
}