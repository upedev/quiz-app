package com.cheetahlabs.quiz;

import com.cheetahlabs.quiz.configuration.QuizConfiguration;
import com.cheetahlabs.quiz.resources.HomeResource;
import com.cheetahlabs.quiz.resources.TestResource;
import com.cheetahlabs.quiz.resources.UserResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Map;

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
//        environment.jersey().setUrlPattern("/api/*");
        Injector injector = Guice.createInjector(new QuizGuiceModule(quizConfiguration, environment));
        environment.jersey().register(injector.getInstance(UserResource.class));
        environment.jersey().register(injector.getInstance(TestResource.class));
        environment.jersey().register(injector.getInstance(HomeResource.class));
    }

    @Override
    public void initialize(Bootstrap<QuizConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(new ViewBundle<QuizConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(QuizConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
    }
}
