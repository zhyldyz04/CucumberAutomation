package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CashwiseInvoicePagePdf {


        public CashwiseInvoicePagePdf(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//div[@id='panel1a-header']/div/li")
        public WebElement SalesButton;

        @FindBy (xpath = "(//div[@id='panel1a-content']//a)[3]")
        public WebElement InvoiceButton;

        @FindBy (xpath = "(//button[@type='button'])[8]")
        public WebElement ThreeDotsBurgerMenu;

        @FindBy (xpath = "(//ul[@role='menu'])[1]/li[1]")
        public WebElement ShowPDFVersion;

        @FindBy (xpath = "(//button[@type='button'])[1]")
        public WebElement downloadPDF;

    }

