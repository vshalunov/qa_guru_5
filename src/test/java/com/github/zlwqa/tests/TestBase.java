package com.github.zlwqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.zlwqa.pages.RegistrationsPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

    }
}
