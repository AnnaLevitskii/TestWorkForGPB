package com.ui;

import com.core.listeners.RetryAnalyzer;
import com.core.models.dto.AuthRequestDTO;
import com.ui.pages.LoginPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static com.core.utils.Constants.PASSWORD;
import static com.core.utils.Constants.USER_NAME;

public class LoginTest extends TestBase {
    @Severity(SeverityLevel.CRITICAL)
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void login(){
        AuthRequestDTO auth = AuthRequestDTO.builder().username(USER_NAME).password(PASSWORD).build();
        new LoginPage(driver).navigateToLoginPage().logIn(auth).assertContactPage();
    }
}
