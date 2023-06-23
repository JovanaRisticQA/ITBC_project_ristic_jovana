package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

        /**
         * Base Page Elements
         */
        private WebDriver driver;
        private WebDriverWait wait;
        private Actions action;
        private JavascriptExecutor js;


        /**
         * Base Page Constructors
         */
        public BasePage(WebDriver driver, WebDriverWait wait) {
            this.driver = driver;
            this.wait = wait;
        }

        public BasePage(WebDriver driver, WebDriverWait wait, Actions action) {
            this.driver = driver;
            this.wait = wait;
            this.action = action;
        }

        public BasePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
            this.driver = driver;
            this.wait = wait;
            this.js = js;
        }

        public BasePage(WebDriver driver, WebDriverWait wait, Actions action, JavascriptExecutor js) {
            this.driver = driver;
            this.wait = wait;
            this.js = js;
            this.action = action;
        }


        /**
         * Getters for Base Page Elements
         */
        public WebDriver getDriver() {
            return driver;
        }

        public WebDriverWait getWait() {
            return wait;
        }

        public Actions getAction(){
            return action;
        }

        public JavascriptExecutor getJs() {
            return js;
        }

}
