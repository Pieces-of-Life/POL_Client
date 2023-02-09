package com.umc.pieciesoflife.Interface


import com.umc.pieciesoflife.UserDto.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    // user 정보 조회
    @GET("user/info")
    fun getUserInfo(
        @Header("Bearer") accessToken: String
    ): Call<User>
}