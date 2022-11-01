package Tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.CartPage;
import Page.LoginPage;
import Page.Navigation;
import Page.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CartTest {
	CartPage cart;
	Navigation nav;
	WebDriver driver;
	Utility util;
	LoginPage loginPage;

    
    @Test(priority = 1)
    public void LogIn() throws InterruptedException{
  	  try {
		util.takeSS("Before Login");
	} catch (IOException e) {
		e.printStackTrace();
	}
  	  	loginPage.login("ramanant75@gmail.com", "ramu123");
  	  try {
		util.takeSS("After Login");
	} catch (IOException e) {
		e.printStackTrace();
	}
  	  
    }
        
    
  @Test(priority = 2)
  public void homePage() {
	  nav.HomePage();
	  try {
		util.takeSS("Home Page");
	} catch (IOException e) {
		e.printStackTrace();
	}
  
  }

  @Test(priority = 3)
  public void addToCartUsingIcon() {
	  ArrayList<String> path = new ArrayList<String>();
	  path.add("//*[@id=\"content\"]/div[2]/div[1]/form/div/div[2]/div[2]/button[1]");
	  path.add("//*[@id=\"content\"]/div[2]/div[2]/form/div/div[2]/div[2]/button[1]");
	  cart.addToCartUsingIcon(path);
	  try {
		util.takeSS("After adding to cart");
	} catch (IOException e) {
		e.printStackTrace();
	}

  }
  
  @Test(priority = 4)
  public void viewCart1() {
	  nav.viewCart();
	  try {
		util.takeSS("View Cart1");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  @Test(priority = 5)
  public void ContinueShopping() {
	  nav.continueShopping();
	  try {
		util.takeSS("After clicking Coninue shopping");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  @Test(priority = 6)
  public void AddToCartAfterViewing1() {
	  String color = "Blue";
	  String qty = "2";
	  String item = "Canon EOS 5D";
	  
	  cart.addItemToCartAfterViewing(item, qty, color);
	  try {
		util.takeSS("After adding to Cart from item spec page");
	} catch (IOException e) {
		e.printStackTrace();
	}

  }
  
  
  
  @Test(priority = 7)
  public void AddToCartAfterViewing2() {
	  String qty = "1";
	  String item = "iPhone";
	  
	  cart.addItemToCartAfterViewing(item, qty, null);
	  try {
		  util.takeSS("After adding to Cart from item spec page");
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  
  }
  
  
  
  @Test(priority = 8)
  public void AddToCartAfterViewing3() {
	  String qty = "1";
	  String item = "MacBook";
	  
	  cart.addItemToCartAfterViewing(item, qty, null);
	  try {
		  util.takeSS("After adding to Cart from item spec page");
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  
  }
  
  
  @Test(priority = 9)
  public void viewCart2() {
	  nav.viewCart();
	  try {
		util.takeSS("View Cart2");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  @Test(priority = 10)
  public void RemoveFromCart() {
	  cart.removeItem();
	  try {
		util.takeSS("After removing item from cart");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
 
  
  @Test(priority = 11)
  public void viewItem() {
	  nav.viewItems();
	  try {
		util.takeSS("View items");
	} catch (IOException e) {
				e.printStackTrace();
	}
  }
  
  @Test(priority = 12)
  public void CheckoutPage() {
	  nav.goToCheckOutPage();
	  try {
		util.takeSS("Checkout page");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  cart = new CartPage(driver);
	  nav = new Navigation(driver);
	  util = new Utility(driver);
	  loginPage = new LoginPage(driver);
	  

  }

  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(5000);
	  cart.closeBrowser();
  }

}
