package com.example.crypsis.send;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface FileUploadInterface {
    @POST("/test")
    Call<RegisterUser> createTask(@Body RegisterUser registerUser);
    @POST("/addUser/")
    Call<InviteTeamMember> invite(@Body InviteTeamMember inviteTeamMember);
    @POST("/customers/phonenumber")
    Call<AddCustomerPhoneNumber> addPhone(@Body AddCustomerPhoneNumber addCustomerPhoneNumber);

    @Multipart
    @POST("/customers/")
    Call<ResponseBody> upload(@Part("description") RequestBody description,
                              @Part("firstName") String firstName,
                              @Part("lastName") String lastName,
                              @Part("phoneNumber") String phoneNumber,
                              @Part("email") String email,
                              @Part ("picture") MultipartBody.Part file,
                              @Part("subscribed") boolean subscribed
                              );

    @POST("/cannedMessages")
    Call<CannedResponses> addCannedResponse(@Body CannedResponses cannedResponses);

    @POST("/awayMessages")
    Call<AwayMessagesClass> addAwayMessage(@Body AwayMessagesClass awayMessagesClass);
}
