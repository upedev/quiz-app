package com.cheetahlabs.quiz.entities;

import com.cheetahlabs.quiz.models.TestDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@JsonInclude(NON_NULL)
@Getter
public class Test {
    private String id;
    private String name;
    private String description;
    private TestDTO dump;
    private String duration;
    private Date startTime;
    private Date endTime;

    public String getEndTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTime = dateFormat.format(this.endTime);
        return endTime;
    }

    public String getStartTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTime = dateFormat.format(this.startTime);
        return endTime;
    }

}
