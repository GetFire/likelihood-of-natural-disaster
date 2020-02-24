package myproject.likelihoodofnaturaldisaster.controller;

import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface NutCalbackTest extends Callback<GeocodingResponse> {

    @Override
    default void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    default void onResponse(Call<GeocodingResponse> ignore, Response<GeocodingResponse> response) {
        this.onResponse(response);
    }

    void onResponse(Response<GeocodingResponse> response);

}
