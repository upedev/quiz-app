package com.cheetahlabs.quiz.views;

import com.cheetahlabs.quiz.entities.Result;
import io.dropwizard.views.View;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubmitView extends View {
    List<Result> topRanker;
    Result userResult;
    public SubmitView(String templateName) {
        super(templateName);
    }
}
