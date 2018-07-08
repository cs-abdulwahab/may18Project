package com.example.abdul_wahab.may18;

import com.example.abdul_wahab.may18.models.Customer;
import com.example.abdul_wahab.may18.models.Dummy;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ICustomerService {

    @GET("customers")
    Call<List<Customer>> getCustomers();

    @GET("customers")
        //Call<Customer> getCustomerById(@Query("id") Integer id);
    Call<List<Customer>> getCustomerById(@Query("id") Integer id);


    @PUT("posts/{id}")
    Call<Dummy> updateDummy(@Path("id") Integer id, @Body Dummy dummy);


    @PUT("customers/{id}")
    Call<List<Customer>> updateCustomer(@Path("id") Integer id, @Body Customer customer);


    @Multipart
    @POST("customers")
    Call<Customer> addCustomer(@Part MultipartBody.Part image, @Part("name") RequestBody name, @Part("profile_pic") RequestBody profile_pic);

    @Multipart
    @POST("customers")
    Call<Customer> addCustomerwithMap(@Part MultipartBody.Part image, @PartMap() Map<String, RequestBody> partMap);


}
