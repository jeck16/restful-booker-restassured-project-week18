package com.restful.booker.crudtest;

import com.restful.booker.bookerinfo.BookingSteps;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BookingCRUDTest extends TestBase {
    static String firstname = "Prime" + TestUtils.getRandomValue();
    static String lastname = "Testing" + TestUtils.getRandomValue();
    static int totalprice = 400;
    static boolean depositpaid = true;
    static String additionalneeds = "abcd";
    static String username = "admin";
    static String password = "password123";
    static String checkin = "2023-04-11";
    static String checkout = "2023-03-14";
    static int id;
    static String token;

    @Steps
    BookingSteps bookingSteps;

    @Title("This will create a new token")
    @Test
    public void Test01() {
        ValidatableResponse response = bookingSteps.createToken(username, password);
        token = response.extract().path("token");
    }
    @Title("This will create a new booking")
    @Test
    public void Test02() {
        ValidatableResponse response = bookingSteps.createBooking(firstname, lastname, totalprice, depositpaid, checkin, checkout, additionalneeds);
        id = response.extract().path("bookingid");
    }

    @Title("Verify if the booking was added to the application")
    @Test
    public void Test03() {
        ValidatableResponse bookingMap = bookingSteps.getBookingByFirstName(id);
        String bookingId = bookingMap.extract().path("firstname");
        Assert.assertTrue(bookingId.contains(firstname));
    }

    @Title("Update the booking information and verify the updated information")
    @Test
    public void Test04() {
        bookingSteps.updatBooking(id,token);
    }

    @Title("Delete the booking and verify if the booking is deleted")
    @Test
    public void Test05() {
        bookingSteps.deleteBooking(id,token);
        bookingSteps.getStudentById(id,token);
    }
}
