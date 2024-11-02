package com.ekkatech.firebase.chat.activities.fcm;

import com.ekkatech.firebase.chat.activities.fcmmodels.MyResponse;
import com.ekkatech.firebase.chat.activities.fcmmodels.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization: key=BGEMVUKmNoQM26dcHPB_F2HGVymP6QSZ9M2t81iJuMRHeX9uDhoLpY5wlFKZEY4Ar_wLbyFUc1XwZi6Wl_JXTuA"
            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
