package com.cheetahlabs.quiz.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SubmitRequestDTO {
    @JsonProperty("test_id")
    private int testId;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("response_map")
    private Map<String, String> responseMap;
}
