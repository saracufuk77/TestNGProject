package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class PersonalDetailsPage extends BaseClass {

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement employeeId;

    @FindBy(css="#pdMainContainer h1")
    public WebElement personalDetailsHeader;

    public PersonalDetailsPage(){
        PageFactory.initElements(driver,this);
    }
}
