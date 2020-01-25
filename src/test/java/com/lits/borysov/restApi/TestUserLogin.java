package com.lits.borysov.restApi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUserLogin {


    @Test
    public void testUserLogin() throws IOException {

        //Send POST for login user
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\n\"email\": \"andriu.test.post.1@gmail.com\",\n\"password\": \"192837465\"\n}");
        Request request = new Request.Builder()
                .url("https://europe-west2-search-app-263e2.cloudfunctions.net/webapp/api/auth/login")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();

        //Get response and set to model
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        UserModel user = objectMapper.readValue(response.body().string(), UserModel.class);

        System.out.println(user.getR().getAccess_token());
    }
}
