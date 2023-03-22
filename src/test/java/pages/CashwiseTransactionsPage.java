package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CashwiseTransactionsPage {

    public  CashwiseTransactionsPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }





    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath = "(//input[@name='email'])[2]")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "(//button[.='Sign in'])[2]")
    public WebElement signInButton;

   @FindBy(xpath = "(//li)[3]")
    public WebElement reportsButton;

   @FindBy(xpath = "(//div//a)[8]")
    public WebElement transactionsButton;

   @FindBy(xpath = "//button[2]")
   public WebElement addExpensesButton;

   @FindBy(xpath = "(//input)[6]")
   public WebElement paymentDate;

   @FindBy(name = "name_of_payment" )
   public  WebElement expensesTitle;

   @FindBy(id = "mui-component-select-category_id")
   public WebElement expensesCategory;

   @FindBy(xpath = "//ul/li")
   public List<WebElement> listOfCategories;

   @FindBy(xpath = "((//div[@class='css-1jp37qf'])[3]//div)[3]")
   public WebElement paymentMethod;

   @FindBy(xpath = "//div[@id = 'menu-type_of_pay']//ul/li")
   public List <WebElement> listOfPaymentMethod;

   @FindBy(xpath = "((//div[@class='css-1jp37qf'])[4]//div)[3]")
   public WebElement paymentInvoice;

   @FindBy(name = "amount_of_money")
   public WebElement amountOfMoney;

   @FindBy(xpath = "//div[@class='css-1qvwkju']/button[2]")
   public WebElement payButton;

   @FindBy(xpath = "//div[@id='menu-bank_account']//ul/li")
   public List<WebElement> listOfInvoices;


   @FindBy(xpath = "(//div[@class='css-1lqlqnj'][1]//div)[3]")
    public WebElement allStatusesButton;

   @FindBy(xpath = "//div[@id='menu-status']//ul/li")
   public List <WebElement> listOfStatuses;

   @FindBy(xpath = "((//div[@class='css-1lqlqnj'])[2]//div)[2]")
    public WebElement paymentTypeButton;

   @FindBy(xpath = "//div[@id='menu-typeOfPay']//ul/li")
   public List <WebElement> listOfPaymentType;

  @FindBy(xpath = "//tbody/tr")
    public List <WebElement> results;







}
