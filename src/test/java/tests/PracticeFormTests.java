package tests;

import dto.Student;
import manager.AppManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student("Vasiliev", "Vasja", "abc@gmail.com", "male", "08967834567", "13 Oct 1997", "Maths,Physics,Chemistry", "sport", "", "street 1", "NCR", "Delhi" );
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
    }




}
