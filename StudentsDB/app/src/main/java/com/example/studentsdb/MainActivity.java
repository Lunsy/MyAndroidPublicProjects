package com.example.studentsdb;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import Data.DatabaseHandler;
import Model.Student;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        databaseHandler.addStudent(new Student("ЖШ-13", "Адольф",
                "Путлер", "3.0"));
        databaseHandler.addStudent(new Student("ЖМ-14", "Иосиф",
                "Стулин", "3.5"));
        databaseHandler.addStudent(new Student("АФ-15", "Герсей",
                "Овсид", "3.8"));
        databaseHandler.addStudent(new Student("КЮ-19", "Dany",
                "Smith", "4.0"));
        databaseHandler.addStudent(new Student("АУ-19", "John Wick",
                "BabaYaga", "4.0"));


        List<Student> studentList = databaseHandler.getAllStudents();

        for (Student student : studentList) {
            Log.d("StudentInfo:", "ID " + student.getId() + ", faculty " + student.getFaculty()
                    + ", firstName " + student.getFirstName() + ", lastName " + student.getLastName()
                    + ", averageMark " + student.getAveGrades());

        }
    }
}
