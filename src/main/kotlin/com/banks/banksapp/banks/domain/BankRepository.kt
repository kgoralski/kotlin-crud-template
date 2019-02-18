package com.banks.banksapp.banks.domain

import org.springframework.data.jpa.repository.JpaRepository

interface BankRepository : JpaRepository<Bank, Int>