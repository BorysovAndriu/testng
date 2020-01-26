package com.lits.borysov.assignment.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserModel {
    UserData r;

    @Data
    public static class UserData {
        @JsonProperty("access_token")
        private String access_token;

        @JsonProperty("scope")
        private String scope;

        @JsonProperty("expires_in")
        private String expires_in;

        @JsonProperty("token_type")
        private String token_type;
    }

    @Data
    public static class UserInfoModel {

        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("id")
        private String id;
    }
}

