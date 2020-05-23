package com.cbt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(css = "div[href='#']")
    public WebElement OptionsSubtitle;

    @FindBy(css = ".pagination.pagination-centered label:nth-of-type(2)")
    public WebElement pageNumber;

    public int pageNumber(){
        return Integer.parseInt(pageNumber.getText().substring(3, pageNumber.getText().lastIndexOf(" ")));
    }

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement viewPerPage;

    @FindBy(css = ".dib:nth-of-type(3)")
    public WebElement records;

    public int records(){
        return Integer.parseInt(records.getText().substring(9, records.getText().lastIndexOf(" ")));
    }

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "(//thead//th//button[1])[1]")
    public List<WebElement> selectAllCalendarEventsCheckbox;

    @FindBy(xpath = "//tbody//input[@type='checkbox']")
    public List<WebElement> eachCalendarEventsCheckbox;

    @FindBy(xpath = "//td[.='Testers meeting']")
    public WebElement testersMeeting;

    @FindBy(xpath = "//label[.='Title']")
    public WebElement title;

    @FindBy(xpath = "//label[.='Description']")
    public WebElement description;

    @FindBy(xpath = "//label[.='Start']")
    public WebElement start;

    @FindBy(xpath = "//label[.='End']")
    public WebElement end;

    @FindBy(xpath = "//label[.='All-day event']")
    public WebElement allDayEvent;

    @FindBy(xpath = "//label[.='Organizer']")
    public WebElement organizer;

    @FindBy(xpath = "//label[.='Guests']")
    public WebElement guests;

    @FindBy(xpath = "//label[.='Recurrence']")
    public WebElement recurrence;

    @FindBy(xpath = "//label[.='Call via Hangout']")
    public WebElement callViaHangouts;






}
