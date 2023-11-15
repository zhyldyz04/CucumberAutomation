package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CashwiseInvoicesPage {


    public CashwiseInvoicesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "(//button[.='Sign in'])[2]")
    public WebElement signInButton;

    @FindBy(xpath = "//li[.='Sales']")
    public WebElement salesButton;

    @FindBy(xpath = "//div[@id='panel1a-content']//a[3]")
    public WebElement invoicesTab;

   @FindBy(id = "mui-component-select-status")
    public WebElement statusButton;

   @FindBy(xpath = "//div[@id='menu-status']//ul/li")
    public List <WebElement> statusList;

   @FindBy(xpath = "(//div[@class='css-tkojfy']/span)[1]")
    public WebElement widget;






   }







