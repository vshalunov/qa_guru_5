package com.github.zlwqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.zlwqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    //locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private final String MODAL_FORM_TITLE_AFTER_SUBMIT = "Thanks for submitting the form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberPhoneInput = $("#userNumber"),
            resultsTable = $(".table-responsive"),
            genderRadio = $("#genterWrapper"),
            hobbiesRadio = $("#hobbiesWrapper"),
            subjectAutoInput = $("#subjectsInput"),
            currentAddressInput = $("#currentAddress"),
            stateChoiceDropDown = $("#react-select-3-input"),
            cityChoiceDropDown = $("#react-select-4-input"),
            submitButton = $("#submit"),
            modalForm = $("#example-modal-sizes-title-lg");

    public CalendarComponent calendar = new CalendarComponent();

    //actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationsPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationsPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationsPage typeEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationsPage typeNumberPhone(String numberPhone) {
        numberPhoneInput.setValue(numberPhone);

        return this;
    }

    public RegistrationsPage choiceGender(String gender) {
        genderRadio.$(byText(gender)).click();

        return this;
    }

    public RegistrationsPage choiceHobbies(String hobbie) {
        hobbiesRadio.$(byText(hobbie)).click();

        return this;
    }

    public RegistrationsPage setValueSubject(String subject) {
        subjectAutoInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationsPage typeCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationsPage choiceState(String nameState) {
        stateChoiceDropDown.setValue(nameState).pressEnter();

        return this;
    }

    public RegistrationsPage choiceCity(String nameCity) {
        cityChoiceDropDown.setValue(nameCity).pressEnter();

        return this;
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public void checkModalFormTitle() {
        modalForm.shouldHave(text(MODAL_FORM_TITLE_AFTER_SUBMIT));
    }

    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

}
