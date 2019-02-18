package com.banks.banksapp.banks

import com.banks.banksapp.banks.domain.BankService
import com.banks.banksapp.banks.dto.BankDto
import com.banks.banksapp.banks.dto.toEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/banks")
class BanksController(private val service: BankService) {

    @GetMapping(produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
    fun getBanks(): List<BankDto> {
        return service.getBanks()
    }

    @GetMapping("/{id}", produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
    fun getBank(@PathVariable id: Int): ResponseEntity<BankDto> {
        return service.getBank(id).map { ResponseEntity.ok(it) }
                .orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping
    fun deleteAll(): ResponseEntity<String> {
        service.deleteAll()
        return ResponseEntity("All banks deleted!", HttpStatus.NO_CONTENT)
    }

    @PostMapping(produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)], consumes = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
    fun createBank(@RequestBody bankDto: BankDto): ResponseEntity<BankDto> {
        return ResponseEntity(service.create(bankDto), HttpStatus.CREATED)
    }
}