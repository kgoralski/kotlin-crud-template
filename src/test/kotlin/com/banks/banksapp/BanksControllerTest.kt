package com.banks.banksapp

import com.banks.banksapp.banks.BanksController
import com.banks.banksapp.banks.domain.BankService
import com.banks.banksapp.banks.dto.BankDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import java.util.*


class BanksControllerTest {

    private lateinit var mockMvc: MockMvc

    private val mockedService = Mockito.mock(BankService::class.java)

    private fun <T> anyObject(): T {
        return Mockito.anyObject<T>()
    }

    @Before
    fun setup() {
        mockMvc = standaloneSetup(BanksController(mockedService))
                .build()
    }

    @Test
    fun testGetBanks() {
        Mockito.`when`(mockedService.getBanks()).thenReturn(Collections.emptyList())

        val response = mockMvc.perform(get("/banks"))
                .andExpect(status().isOk)
                .andReturn().response

        assertThat(response.contentAsString).isEqualTo("[]")
    }

    @Test
    fun testCreateBank() {
        val dto = BankDto(1, "Santander")
        Mockito.`when`(mockedService.create(anyObject())).thenReturn(dto)

        mockMvc.perform(
                post("/banks").contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\n" +
                                "  \"name\": \"Santander\"\n" +
                                "}"))
                .andExpect(status().isCreated)
    }
}