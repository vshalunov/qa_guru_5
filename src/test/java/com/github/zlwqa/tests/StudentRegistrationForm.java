package com.github.zlwqa.tests;

import org.junit.jupiter.api.Test;

import static com.github.zlwqa.tests.TestData.studentNameResultField;
import static com.github.zlwqa.tests.TestData.*;


public class StudentRegistrationForm extends TestBase {


    @Test
    void fillStudentRegistrationForm() {
        registrationsPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeNumberPhone(numberPhone)
                .choiceGender(gender);
        registrationsPage.calendar.setDate(day, month, year);
        registrationsPage
                .setValueSubject(subject)
                .choiceHobbies(hobbie);
        registrationsPage.selectPicture.uploadFile(pictureName);
        registrationsPage
                .typeCurrentAddress(address)
                .choiceState(state)
                .choiceCity(city)
                .clickOnSubmit()
                .checkModalFormTitle()
                .checkResultsValue(studentNameResultField, firstName + " " + lastName)
                .checkResultsValue(studentEmailResultField, email)
                .checkResultsValue(genderResultField, gender)
                .checkResultsValue(mobileResultField, numberPhone)
                .checkResultsValue(dateOfBirthResultField, day + " " + month + "," + year)
                .checkResultsValue(subjectsResultField, subject)
                .checkResultsValue(hobbiesResultField, hobbie)
                .checkResultsValue(pictureResultField, pictureName)
                .checkResultsValue(addressResultField, address)
                .checkResultsValue(stateAndCityResultField, state + " " + city);
    }
}