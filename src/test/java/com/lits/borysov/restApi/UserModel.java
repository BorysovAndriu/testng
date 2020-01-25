package com.lits.borysov.restApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserModel {
    UserData r;

    @Data
    class UserData {
        @JsonProperty("access_token")
        private String access_token;

        @JsonProperty("scope")
        private String scope;

        @JsonProperty("expires_in")
        private String expires_in;

        @JsonProperty("token_type")
        private String token_type;
    }
}

