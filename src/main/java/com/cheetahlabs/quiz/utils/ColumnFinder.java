package com.cheetahlabs.quiz.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColumnFinder {
    public static boolean findColumn(String column, ResultSet resultSet) {
        try {
            resultSet.findColumn(column);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
