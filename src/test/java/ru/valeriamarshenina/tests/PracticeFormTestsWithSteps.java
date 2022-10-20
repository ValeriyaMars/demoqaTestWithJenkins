package ru.valeriamarshenina.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static ru.valeriamarshenina.tests.TestData.*;
import static ru.valeriamarshenina.tests.TestData.studentCurrentAddress;

public class PracticeFormTestsWithSteps extends tests.TestBase {

    @Test
    @Tag("allInputsWithSteps")
    void fillPracticeFormAllInputs() {
        System.setProperty("browser", "chrome");
        System.setProperty("version", "91");
        System.setProperty("browserSize", "500x500");
        System.setProperty("url","automation-practice-form");
        String url = System.getProperty("url");
        String sourceUrl = format("https://demoqa.com/%s", url);

        step("Открываем главную страницу", () -> {
            open(sourceUrl);
        });

        step("Вводим имя", () ->{
            $("#firstName").setValue(studentFirstName);
        });

        step("Вводим фамилию", () ->{
            $("#lastName").setValue(studentLastName);
        });

        step("Вводим email", () ->{
            $("#userEmail").setValue(studentEmail);
        });

        step("Выбираем пол", () ->{
            $(byText("Female")).click();
        });

        step("Вводим номер телефона", () ->{
            $("#userNumber").setValue(studentNumber);
        });

        step("Выбираем дату рождения", () ->{
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("8");
            $(".react-datepicker__year-select").selectOptionByValue("1988");
            $x("//div[contains(@aria-label, \"September 28th, 1988\")]").click();
        });

        step("Выбираем предмет", () ->{
            $("#subjectsInput").setValue("Maths").pressEnter();
        });

        step("Выбираем хобби", () ->{
            $(byText("Reading")).click();
        });

        step("Загружаем фото", () ->{
            $("input#uploadPicture").uploadFromClasspath("img/1.png");
        });

        step("Вводим адрес", () ->{
            $("#currentAddress").setValue(studentCurrentAddress);
        });

        step("Выбираем регион", () ->{
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
        });

        step("Выбираем город", () ->{
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
        });

        step("Нажимаем кнопку Submit", () ->{
            $("#submit").click();
        });

        step("Проверяем имя и фамилию", () ->{
            $(".modal-body").shouldHave(text("Student Name " + studentFirstName + " " + studentLastName));
        });

        step("Проверяем email", () ->{
            $(".modal-body").shouldHave(text("Student Email " + studentEmail));
        });

        step("Проверяем пол", () ->{
            $(".modal-body").shouldHave(text("Gender Female"));
        });

        step("Проверяем номер телефона", () ->{
            $(".modal-body").shouldHave(text("Mobile " + studentNumber));
        });

        step("Проверяем дату рождения", () ->{
            $(".modal-body").shouldHave(text("Date of Birth 28 September,1988"));
        });

        step("Проверяем предмет", () ->{
            $(".modal-body").shouldHave(text("Subjects Maths"));
        });

        step("Проверяем хобби", () ->{
            $(".modal-body").shouldHave(text("Hobbies Reading"));
        });

        step("Проверяем фото", () ->{
            $(".modal-body").shouldHave(text("Picture 1.png"));
        });

        step("Проверяем адрес", () ->{
            $(".modal-body").shouldHave(text("Address " + studentCurrentAddress));
        });

        step("Проверяем регион и город", () ->{
            $(".modal-body").shouldHave(text("State and City NCR Delhi"));
        });
    }
}
