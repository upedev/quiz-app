package com.cheetahlabs.quiz.views;

import com.cheetahlabs.quiz.models.TestDTO;
import io.dropwizard.views.View;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestView extends View {

    TestDTO test;
    public TestView(String templateName) {
        super(templateName);
    }
}
