package com.android.sheguard.api;

import com.android.sheguard.model.NotificationSenderModel;
import com.android.sheguard.util.NotificationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificationAPI {

    @Headers(
            {
                    AAAAC7XvVQc:APA91bGSK_Fdscz88GNeGBxW0GNHiaABBgwtkNU3OBv5xcGF0OPz7CDX24A_wzH8zldKV_E1sfUNKSY7DZ9b2NWx7C-JpmK0weSa4CVidZYc6NxNtMN1hHQEMou2Bj3prPUqObBmTVEX // Replace with your server key from Firebase Console
            }
    )

    @POST("fcm/send")
    Call<NotificationResponse> sendNotification(@Body NotificationSenderModel body);
}
