package com.imholynx.dynamiciconsexample.data.api;

import com.imholynx.dynamiciconsexample.data.entity.IconResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestApi {

    @GET("icon")
    Observable<IconResponse> getIcon();
}
