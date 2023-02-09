package com.umc.pieciesoflife.Retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.umc.pieciesoflife.Interface.QuestionService
import com.umc.pieciesoflife.KakaoLogin.OAuthTokenService
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.reflect.Type

object RetrofitClient {
    private const val URL = "http://3.39.155.109:8080"

    val gson: Gson = GsonBuilder().setLenient().create()
    // retrofit에서 response값이 비어있을 때(Length=0) 발생 : 예시 에러 "End of input at line 1 column 1 path $"
    val nullOnEmptyConverterFactory = object : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            val delegate = retrofit!!.nextResponseBodyConverter<Any>(this,type!!,annotations!!)
            return Converter<ResponseBody, Any>{
                if(it.contentLength() == 0L) return@Converter EmptyResponse()
                delegate.convert(it)
            }
        }
    }
    class EmptyResponse {    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(nullOnEmptyConverterFactory)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    //Interface 클래스 파일들 추가
    //val storyService: StoryService by lazy {retrofit.create(StoryService::class.java)}
    val questionService: QuestionService by lazy {retrofit.create(QuestionService::class.java)}
    val TokenService: OAuthTokenService by lazy {retrofit.create(OAuthTokenService::class.java)}
}