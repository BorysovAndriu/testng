package com.lits.borysov.restApi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class TestCurrencyRate {

    @Test
    public void testCurrencyRate() throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://bank.gov.ua/NBU_Exchange/exchange?date=20.01.2020&json")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        List<BankModel> banks = objectMapper.readValue(response.body().string(),
                new TypeReference<List<BankModel>>(){});

        banks.stream()
                .map(BankModel::getAmount)
                .filter(a -> a == 24.2527)
                .forEach(System.out::println);
    }
}
