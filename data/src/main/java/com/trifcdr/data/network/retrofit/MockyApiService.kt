package com.trifcdr.data.network.retrofit

import com.trifcdr.data.network.models.FlightData
import com.trifcdr.data.network.models.ProposalData
import com.trifcdr.data.network.models.TicketsData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by trifcdr.
 */
interface MockyApiService {

    @GET("/v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    fun getProposals() : Call<ProposalData>

    @GET("/v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    fun getFlights() : Call<FlightData>

    @GET("/v3/c0464573-5a13-45c9-89f8-717436748b69")
    fun getAllTickets() : Call<TicketsData>



    companion object {
        private var mockyApiService: MockyApiService? = null

        fun getInstance() : MockyApiService {
            if(mockyApiService == null){
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                mockyApiService = retrofit.create(MockyApiService::class.java)
            }
            return mockyApiService!!
        }
    }
}