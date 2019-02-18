package com.banks.banksapp.banks.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BanksConfiguration {

    @Bean
    fun bankService(bankRepository: BankRepository): BankService {
        return BankService(bankRepository)
    }
}