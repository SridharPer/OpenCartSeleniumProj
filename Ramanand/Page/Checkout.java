package Page;

public class Checkout {
	
	
	
	public void addAppleCinemaToCart(String size, String checkBx, String txt, String color, String txtArea, String uploadFilePath, String date, String time, String dateTime, String qty) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(baseurl);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
       js.executeScript("window.scrollBy(0,600)", "");
	
       try {
    	   Thread.sleep(1000);
       } catch (InterruptedException e) {
    	   e.printStackTrace();
       }

	       
		WebElement AppleCinemaSpec = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/form/div/div[2]/div[1]/h4/a"));
		
		AppleCinemaSpec.click();
		System.out.println("Apple Cinema Spec Page");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		js.executeScript("window.scrollBy(0,200)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
		// Radio
		if(size.equals("Small")) {
			driver.findElement(By.xpath("//*[@id='input-option-value-5']")).click();
		}
		else if (size.equals("Medium")) {
			driver.findElement(By.xpath("//*[@id='input-option-value-6']")).click();			
		}
		else {
			driver.findElement(By.xpath("//*[@id='input-option-value-7']")).click();						
		}
		
		// CheckBox
		if (checkBx.equals("10")) {
			driver.findElement(By.xpath("//*[@id='input-option-value-8']")).click();
		}
		else if (checkBx.equals("20")) {
			driver.findElement(By.xpath("//*[@id='input-option-value-9']")).click();			
		} 
		else if(checkBx.equals("30")){
			driver.findElement(By.xpath("//*[@id='input-option-value-10']")).click();			
		}
		else {
			driver.findElement(By.xpath("//*[@id='input-option-value-11']")).click();						
		}
		
		// Text
		driver.findElement(By.xpath("//*[@id='input-option-208']")).sendKeys(txt);
		
		// DropDown Color
		Select colSelect = new Select(driver.findElement(By.xpath("//*[@id=\"input-option-217\"]")));
		colSelect.selectByValue(color);
		
		// Text Area
		driver.findElement(By.xpath("//*[@id='input-option-209']")).sendKeys(txtArea);
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		js.executeScript("window.scrollBy(550,850)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		// Upload File
		WebElement uploadElement = driver.findElement(By.xpath("//*[@id='button-upload-222']"));
//		uploadElement.click();
		uploadElement.sendKeys(uploadFilePath);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Date
		driver.findElement(By.xpath("//*[@id='input-option-219']")).clear();
		driver.findElement(By.xpath("//*[@id='input-option-219']")).sendKeys(date);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='input-option-219']")).submit();
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Time
		driver.findElement(By.xpath("//*[@id='input-option-221']")).clear();
		driver.findElement(By.xpath("//*[@id='input-option-221']")).sendKeys(time);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='input-option-221']")).submit();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Date And Time
		driver.findElement(By.xpath("//*[@id='input-option-220']")).clear();
		driver.findElement(By.xpath("//*[@id='input-option-220']")).sendKeys(dateTime);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='input-option-220']")).submit();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Quantity
		driver.findElement(By.xpath("//*[@id='input-quantity']")).clear();
		driver.findElement(By.xpath("//*[@id='input-quantity']")).sendKeys(qty);
		
		// Click Add to Cart
		driver.findElement(By.xpath("//*[@id='button-cart']")).click();
		
	
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/form/div/button[1]")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		js.executeScript("window.scrollBy(-300)", "");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='wishlist-total']")).click();
		
		
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div/a")).click();
		
		
		
		
	}

	
	// Checkout 	
	

	public void FirstCheckout(String fName, String lName, String address1, String city, String postCode, String country, String state) {
        driver.findElement(By.xpath("//*[@id='top']/div/div[2]/ul/li[5]/a")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        driver.findElement(By.xpath("//*[@id='input-shipping-firstname']")).sendKeys(fName);
        driver.findElement(By.xpath("//*[@id='input-shipping-lastname']")).sendKeys(lName);
        driver.findElement(By.xpath("//*[@id='input-shipping-address-1']")).sendKeys(address1);
        driver.findElement(By.xpath("//*[@id='input-shipping-city']")).sendKeys(city);
        driver.findElement(By.xpath("//*[@id='input-shipping-postcode']")).sendKeys(postCode);
        
        WebElement cntry = driver.findElement(By.xpath("//*[@id='input-shipping-country']"));
        Select countrySelect = new Select(cntry);
        countrySelect.selectByVisibleText(country);
   
        WebElement stateElement = driver.findElement(By.xpath("//*[@id='input-shipping-zone']"));
        Select stateSelect = new Select(stateElement);
        stateSelect.selectByVisibleText(state);
        
        driver.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
        
        
	}
	
	

	public void existingAddress() {
		driver.findElement(By.xpath("//*[@id='input-shipping-existing']")).click();
	}
	
	public void newAddress(String fName, String lName, String address1, String city, String postCode, String country, String state) {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  driver.findElement(By.xpath("//*[@id=\"input-shipping-new\"]")).click();
	        js.executeScript("window.scrollBy(0,400)", "");
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        driver.findElement(By.xpath("//*[@id='input-shipping-firstname']")).sendKeys(fName);
	        driver.findElement(By.xpath("//*[@id='input-shipping-lastname']")).sendKeys(lName);
	        driver.findElement(By.xpath("//*[@id='input-shipping-address-1']")).sendKeys(address1);
	        driver.findElement(By.xpath("//*[@id='input-shipping-city']")).sendKeys(city);
	        driver.findElement(By.xpath("//*[@id='input-shipping-postcode']")).sendKeys(postCode);
	        
	        WebElement cntry = driver.findElement(By.xpath("//*[@id='input-shipping-country']"));
	        Select countrySelect = new Select(cntry);
	        countrySelect.selectByVisibleText(country);
	   
	        WebElement stateElement = driver.findElement(By.xpath("//*[@id='input-shipping-zone']"));
	        Select stateSelect = new Select(stateElement);
	        stateSelect.selectByVisibleText(state);
	        
	        driver.findElement(By.xpath("//*[@id='button-shipping-address']")).click();
	        

	}
	
	
	
}
