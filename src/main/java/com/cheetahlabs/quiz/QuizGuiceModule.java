package com.cheetahlabs.quiz;

import com.cheetahlabs.quiz.configuration.QuizConfiguration;
import com.cheetahlabs.quiz.dao.*;
import com.cheetahlabs.quiz.views.ActiveTestListView;
import com.google.inject.AbstractModule;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import lombok.AllArgsConstructor;
import org.skife.jdbi.v2.DBI;

@AllArgsConstructor
public class QuizGuiceModule extends AbstractModule {

    QuizConfiguration quizConfiguration;
    Environment environment;

    @Override
    protected void configure() {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, quizConfiguration.getQuizDb(), "mysql");

        bind(UserDao.class).toInstance(jdbi.onDemand(UserDao.class));
        bind(QuestionDao.class).toInstance(jdbi.onDemand(QuestionDao.class));
        bind(ExamDao.class).toInstance(jdbi.onDemand(ExamDao.class));
        bind(SectionDao.class).toInstance(jdbi.onDemand(SectionDao.class));
        bind(TestDao.class).toInstance(jdbi.onDemand(TestDao.class));
        bind(ActiveTestListView.class).toInstance(new ActiveTestListView("activeTest.mustache"));

    }
}
