package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

import java.lang.reflect.Type;

public class SessionHelper extends HelperBase{
    public SessionHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(String user, String password) {
        type(By.name("username"), user);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("span.user-info"));
    }

    public void registration(String user, String email) {
        click(By.cssSelector("#login-box > div > div.toolbar.center > a"));
        type(By.name("username"), user);
        type(By.name("email"), email);
        click(By.cssSelector("input[type='submit']"));
    }

    public void submitRegistration (String user, String password1, String password2) {
        type(By.name("realname"), user);
        type(By.name("password"), password1);
        type(By.name("password_confirm"), password2);
        click(By.cssSelector("button[type='submit']"));
    }
}