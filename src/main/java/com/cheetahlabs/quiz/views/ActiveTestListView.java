package com.cheetahlabs.quiz.views;

import com.cheetahlabs.quiz.entities.Test;
import io.dropwizard.views.View;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActiveTestListView extends View {

    List<Test> activeTests;
    List<Test> upcomingTests;

    public ActiveTestListView(String templateName) {
        super(templateName);
    }

    public boolean hasActiveTest() {
        return !(this.activeTests.size() == 0);
    }

    public boolean hasUpcomingTest() {
        return !(this.upcomingTests.size() == 0);
    }
}
