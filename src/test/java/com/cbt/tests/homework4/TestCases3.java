package com.cbt.tests.homework4;

import com.cbt.pages.CalendarEventsPage;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.LoginPage;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases3 extends TestBase {

    /*
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Verify that page subtitle "Options" is displayed
     */

   @Test
    public void verifyOptionsIsDisplayed(){

       extentLogger = report.createTest("Verify Options is Displayed");

       extentLogger.info("Username: " + ConfigurationReader.get("storemanager_username"));
       extentLogger.info("Password: " + ConfigurationReader.get("storemanager_password"));
       new LoginPage().login("Store Manager");

       extentLogger.info("Navigate to Activities -- Calendar Events");
       new DashboardPage().navigateToModule("Activities", "Calendar Events");

       extentLogger.info("Verify that page subtitle \"Options\" is displayed");
       BrowserUtils.verifyElementDisplayed(new CalendarEventsPage().OptionsSubtitle);

       extentLogger.pass("Options Subtitle Test");
   }

   /*
   1.Go to “https://qa1.vytrack.com/"
   2.Login as a store manager
   3.Navigate to “Activities -> Calendar Events”
   4.Verify that page number is equals to "1"
    */

   @Test
    public void verifyPageNumber(){

       extentLogger = report.createTest("Calendar Events Page Number Verification");

       extentLogger.info("Username: " + ConfigurationReader.get("storemanager_username"));
       extentLogger.info("Password: " + ConfigurationReader.get("storemanager_password"));
       new LoginPage().login("store maNager");

       DashboardPage dashboardPage = new DashboardPage();

       extentLogger.info("Navigate to Activities -- Calendar Events");
       dashboardPage.navigateToModule("Activities", "Calendar Events");

       BrowserUtils.waitFor(5);

       extentLogger.info("Verify that page number is equals to \"1\"");
       Assert.assertTrue(new CalendarEventsPage().pageNumber()==1);

       extentLogger.pass("Page Number Test");

   }

   /*
   1.Go to “https://qa1.vytrack.com/"
   2.Login as a store manager
   3.Navigate to “Activities -> Calendar Events”
   4.Verify that view per page number is equals to "25"
    */

    @Test
    public void test3(){

        extentLogger = report.createTest("View per Page Verification");

        extentLogger.info("Username: " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Password: " + ConfigurationReader.get("storemanager_password"));
        new LoginPage().login("storemanager");

        extentLogger.info("Navigate to Activities -- Calendar Events");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);

        extentLogger.info("Verify that view per page number is equals to \"25\"");
        Assert.assertTrue(Integer.parseInt(new CalendarEventsPage().viewPerPage.getText())==25);

        extentLogger.pass("View per Page Test");

    }

    /*
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Verify that number of calendar events (rows in the table) is equals to number of records
     */

    @Test
    public void verifyRecordsNumberIsEqualToRowNumber(){

        extentLogger = report.createTest("Number of Records Verification");

        extentLogger.info("Username: " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Password: " + ConfigurationReader.get("storemanager_password"));
        new LoginPage().login("storemanager");

        extentLogger.info("Navigate to Activities -- Calendar Events");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(5);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
        System.out.println(calendarEventsPage.tableRows.size());
        Assert.assertEquals(calendarEventsPage.records(), calendarEventsPage.tableRows.size());

        extentLogger.pass("Records and Number of <tr> Match Test");

    }

    /*
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Click on the top checkbox to select all
    5.Verify that all calendar events were selected
     */

    @Test
    public void verifyAllCalendarEventsAreSelected(){

        extentLogger = report.createTest("All Calendar Events Are Selected Verification");

        extentLogger.info("Username: " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Password: " + ConfigurationReader.get("storemanager_password"));
        new LoginPage().login("storemanager");

        extentLogger.info("Navigate to Activities -- Calendar Events");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(5);

        extentLogger.info("Click on the top checkbox to select all");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//        BrowserUtils.selectCheckBox(calendarEventsPage.selectAllCalendarEventsCheckbox, true);
//        actions.click(calendarEventsPage.selectAllCalendarEventsCheckbox.get(0)).perform();
        calendarEventsPage.selectAllCalendarEventsCheckbox.get(0).click();

        extentLogger.info("Verify that all calendar events were selected");

        for (WebElement eachCalendarEventsCheckbox : calendarEventsPage.eachCalendarEventsCheckbox) {

            Assert.assertTrue(eachCalendarEventsCheckbox.isSelected());
        }

        BrowserUtils.waitFor(2);
        extentLogger.pass("All Calendar Events Are Selected Test");

    }

    /*
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Select “Testers meeting”
    5.Verify that following data is displayed:
     */

    @Test
    public void test6(){

        extentLogger = report.createTest("Data Verification");

        extentLogger.info("Username: " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Password: " + ConfigurationReader.get("storemanager_password"));
        new LoginPage().login("storemanager");

        extentLogger.info("Navigate to Activities -- Calendar Events");
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(5);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Select \"Testers meeting\"");
        calendarEventsPage.testersMeeting.click();

        extentLogger.info("Verify that \"Title\" is displayed");
        Assert.assertTrue(calendarEventsPage.title.isDisplayed());

        extentLogger.info("Verify that \"Description\" is displayed");
        Assert.assertTrue(calendarEventsPage.description.isDisplayed());

        extentLogger.info("Verify that \"Start\" is displayed");
        Assert.assertTrue(calendarEventsPage.start.isDisplayed());

        extentLogger.info("Verify that \"End\" is displayed");
        Assert.assertTrue(calendarEventsPage.end.isDisplayed());

        extentLogger.info("Verify that \"All-Day Event\" is displayed");
        Assert.assertTrue(calendarEventsPage.allDayEvent.isDisplayed());

        extentLogger.info("Verify that \"Organizer\" is displayed");
        Assert.assertTrue(calendarEventsPage.organizer.isDisplayed());

        extentLogger.info("Verify that \"Guests\" is displayed");
        Assert.assertTrue(calendarEventsPage.guests.isDisplayed());

        extentLogger.info("Verify that \"Recurrence\" is displayed");
        Assert.assertTrue(calendarEventsPage.recurrence.isDisplayed());

        extentLogger.info("Verify that \"Call Via Hangout\" is displayed");
        Assert.assertTrue(calendarEventsPage.callViaHangouts.isDisplayed());

        extentLogger.pass("Data Test");

    }



}
