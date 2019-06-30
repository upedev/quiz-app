package com.cheetahlabs.quiz;

import com.cheetahlabs.quiz.configuration.QuizConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class QuizApplication extends Application<QuizConfiguration> {
    public static void main( String[] args ) throws Exception {
        new QuizApplication().run(args);
    }

    @Override
    public String getName() {
        return "Quiz-App";
    }

    @Override
    public void run(QuizConfiguration quizConfiguration, Environment environment) {

    }
}
