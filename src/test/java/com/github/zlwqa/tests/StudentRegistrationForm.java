package com.github.zlwqa.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm extends TestBase {


    @Test
    void fillStudentRegistrationForm() {
        registrationsPage.openPage();

        registrationsPage
                .typeFirstName("Vasilii")
                .typeLastName("Shalunov")
                .typeEmail("asdori95@gmail.com")
                .typeNumberPhone("9277779131")
                .choiceGender("Male");

        registrationsPage.calendar.setDate("29", "July", "1997");

        registrationsPage
                .setValueSubject("computer science")
                .choiceHobbies("Reading");

        //Загрузка фотографии пользователя
        $("#uploadPicture").uploadFile(new File("src/test/resources/z.jpg"));


        registrationsPage
                .typeCurrentAddress("st. 22 Party Congress, 42, Samara, Samara region, 443066")
                .choiceState("haryana")
                .choiceCity("panipat")
                .clickOnSubmit()
                .checkModalFormTitle()
                .checkResultsValue("Student Name", "Vasilii Shalunov")
                .checkResultsValue("Student Email", "asdori95@gmail.com")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9277779131")
                .checkResultsValue("Date of Birth", "29 July,1997")
                .checkResultsValue("Subjects", "Computer Science")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "z.jpg")
                .checkResultsValue("Address", "st. 22 Party Congress, 42, Samara, Samara region, 443066")
                .checkResultsValue("State and City", "Haryana Panipat");
    }
}