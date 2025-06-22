package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
SoftAssert softAssert = new SoftAssert();

    @Test
    public void studentRegFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.SPORTS);

        Student student = new Student("Vasiliev", "Vasja", "abc@gmail.com", Gender.FEMALE, "08967834567", "13 Oct 1997", "Maths,Physics,Chemistry", hobbies, "", "street 1", StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1] );
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
//        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
//        System.out.println("Test failed!!!");
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
    }

    @Test
    public void studentRegFormPositiveTestValidateSoftAssert(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.SPORTS);

        Student student = new Student("Vasiliev", "Vasja", "abc@gmail.com", Gender.FEMALE, "08967834567", "13 Oct 1997", "Maths,Physics,Chemistry", hobbies, "", "street 1", StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1] );
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
        System.out.println("Test failed!!!");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[last()]")).getText().contains(student.getLastName()));
        System.out.println("=========================================================");
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
        System.out.println("=========================================================");
        softAssert.assertAll();
    }




}
