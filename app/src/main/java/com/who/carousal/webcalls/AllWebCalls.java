package com.who.carousal.webcalls;




import com.who.carousal.model.CovidResponse;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


/**
 * Created by ZGUser2 on 18-Aug-16.
 */
public interface AllWebCalls {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("/5T5nSi527N4F7luB/arcgis/rest/services/COVID19_hist_cases_adm0_v5_view/FeatureServer/0/query")
    Call<ResponseBody> getCovidStatus(@QueryMap HashMap<String, String> params);
}
