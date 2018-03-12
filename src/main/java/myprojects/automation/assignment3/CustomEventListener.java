package myprojects.automation.assignment3;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

@Slf4j
public class CustomEventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("Before navigate to: {}", url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("After navigate to: {}", url);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("Before click on: {}", element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        log.info("After click on: {}", element);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Before find element: {}", element);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("After find element: {}", element);
    }
}
