package com.lits.borysov.assignment.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookModel {

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("author")
    private String author;

    @JsonProperty("publishDate")
    private String publishDate;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("objectID")
    private String objectID;

    @JsonProperty("_highlightResult")
    private HighlightResult highlightResult;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class HighlightResult{
        @JsonProperty("author")
        private Information author;

        @JsonProperty("isbn")
        private Information isbn;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Information{
            @JsonProperty("value")
            private String value;

            @JsonProperty("matchLevel")
            private String matchLevel;

            @JsonProperty("matchedWords")
            private ArrayList matchedWords;
        }
    }
}

