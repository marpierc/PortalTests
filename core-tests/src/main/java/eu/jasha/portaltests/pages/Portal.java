/*
 * Copyright 2012 Jasha Joachimsthal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.jasha.portaltests.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Web interface to the portal
 */
@Component
public class Portal extends WebDriverPage {

    @Autowired
    public Portal(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void go(String url) {
        get(url);
    }

    public void pressNewAccountButton() {
        final WebElement newAccountButton = findElement(By.id("createNewAccountButton"));
        newAccountButton.click();
    }

    public WebElement getNewAccountForm() {
        return findElement(By.id("newAccountForm"));
    }

    public WebElement getLoginForm() {
        return findElement(By.id("loginForm"));
    }
	 
	 public WebElement getOpenIdLoginForm() {
		  return findElement(By.id("openIdForm"));
	 }

    public WebElement getEmptyPageBox() {
        return findElement(By.id("emptyPageMessageWrapper"));
    }

	 public void login(String username, String password) {
		  final WebElement loginForm=getLoginForm();
		  loginForm.findElement(By.id("usernameField")).sendKeys(username);
		  loginForm.findElement(By.id("passwordField")).sendKeys(password);
		  loginForm.submit();
	 }
	 
	 public void openIdLogin(String openIdUrl) {
		  final WebElement openIdLogin=getOpenIdLoginForm();
		  openIdLogin.findElement(By.id("openid_identifier")).sendKeys(openIdUrl);
		  openIdLogin.submit();
	 }

	 public void logout() {
		  final WebElement logoutLink=findElement(By.linkText("Logout"));
		  logoutLink.click();
	 }

	 public void clickLink(WebElement linkToClick) {
		  //TODO Should make sure this is clickable.
		  linkToClick.click();
	 }

	 public WebElement findElement(By by) {
		  //A little stupid workaround to slow down the execution.  Maybe there is a better way to do this.
		  try {Thread.sleep(1000);} catch (Exception ex) { System.err.println(ex.getMessage());}
		  return super.findElement(by);
	 }
}
