package com.example.cachorros

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCachorro {

    @POST("cachorros")
    fun post(@Body cachorro: Cachorro):Call<Cachorro>
}