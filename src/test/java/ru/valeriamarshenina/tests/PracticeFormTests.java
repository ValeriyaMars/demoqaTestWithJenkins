package ru.valeriamarshenina.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static ru.valeriamarshenina.tests.TestData.*;

public class PracticeFormTests extends tests.TestBase {

    @Test
    @Tag("allInputs")
    void fillPracticeFormAllInputs() {
        System.setProperty("browser", "chrome");
        System.setProperty("version", "91");
        System.setProperty("browserSize", "500x500");
        System.setProperty("url","automation-practice-form");
        String url = System.getProperty("url");
        String sourceUrl = format("https://demoqa.com/%s", url);

        open(sourceUrl);
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#userEmail").setValue(studentEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $x("//div[contains(@aria-label, \"September 28th, 1988\")]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("input#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").scrollTo().setValue(studentCurrentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();

        $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + studentLastName));
        $(".modal-body").shouldHave(text("Student Email " + studentEmail));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        $(".modal-body").shouldHave(text("Date of Birth 28 September,1988"));
        $(".modal-body").shouldHave(text("Subjects Maths"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("Picture 1.png"));
        $(".modal-body").shouldHave(text("Address " + studentCurrentAddress));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));
    }

    @Test
    @Tag("withoutNotRequiredInputs")
    void fillPracticeFormMaleWithoutEmail() {

        System.setProperty("browser", "chrome");
        System.setProperty("version", "91");
        System.setProperty("browserSize", "500x500");
        System.setProperty("url","automation-practice-form");
        String url = System.getProperty("url");
        String sourceUrl = format("https://demoqa.com/%s", url);

        open(sourceUrl);
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $(byText("Female")).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $x("//div[contains(@aria-label, \"September 28th, 1988\")]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("input#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").scrollTo().setValue(studentCurrentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();

        $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + studentLastName));
        $(".modal-body").shouldHave(text("Student Email"));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        $(".modal-body").shouldHave(text("Date of Birth 28 September,1988"));
        $(".modal-body").shouldHave(text("Subjects Maths"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("Picture 1.png"));
        $(".modal-body").shouldHave(text("Address " + studentCurrentAddress));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));
    }

    @Test
    @Tag("withoutNotRequiredInputs")
    void fillPracticeFormMaleWithoutSubjects() {
        System.setProperty("browser", "chrome");
        System.setProperty("version", "91");
        System.setProperty("browserSize", "500x500");
        System.setProperty("url","automation-practice-form");
        String url = System.getProperty("url");
        String sourceUrl = format("https://demoqa.com/%s", url);

        open(sourceUrl);
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#userEmail").setValue(studentEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $x("//div[contains(@aria-label, \"September 28th, 1988\")]").click();
        $(byText("Reading")).click();
        $("input#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").scrollTo().setValue(studentCurrentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").scrollTo().click();

        $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + studentLastName));
        $(".modal-body").shouldHave(text("Student Email " + studentEmail));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        $(".modal-body").shouldHave(text("Date of Birth 28 September,1988"));
        $(".modal-body").shouldHave(text("Subjects"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("Picture 1.png"));
        $(".modal-body").shouldHave(text("Address " + studentCurrentAddress));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));
    }

    @Test
    @Tag("withoutNotRequiredInputs")
    void fillPracticeFormMaleWithoutCurrentAddress() {
        System.setProperty("browser", "chrome");
        System.setProperty("version", "91");
        System.setProperty("browserSize", "500x500");
        System.setProperty("url","automation-practice-form");
        String url = System.getProperty("url");
        String sourceUrl = format("https://demoqa.com/%s", url);

        open(sourceUrl);
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#userEmail").setValue(studentEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $x("//div[contains(@aria-label, \"September 28th, 1988\")]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("input#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + studentLastName));
        $(".modal-body").shouldHave(text("Student Email " + studentEmail));
        $(".modal-body").shouldHave(text("Gender Female"));
        $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        $(".modal-body").shouldHave(text("Date of Birth 28 September,1988"));
        $(".modal-body").shouldHave(text("Subjects Maths"));
        $(".modal-body").shouldHave(text("Hobbies Reading"));
        $(".modal-body").shouldHave(text("Picture 1.png"));
        $(".modal-body").shouldHave(text("Address"));
        $(".modal-body").shouldHave(text("State and City NCR Delhi"));
    }
}
