package com.banks.banksapp.banks.domain

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "banks")
data class Bank(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @NotEmpty
        @Column(name = "name")
        val name: String
)