package com.restful.booker.model;

public class BookingPojo {
    private String firstname;
    private String lastname;
    private int totalPrice;
    private boolean depositPaid;
    private String additionalNeeds;
    private String username;
    private String password;
    private BookingDates bookingdates;

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalprice) {
        this.totalPrice = totalprice;
    }

    public boolean getDepositpaid() {
        return depositPaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositPaid = depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalNeeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalNeeds = additionalneeds;
    }

    public static class BookingDates {
        private String checkin;
        private String checkout;

        public String getChecking() {
            return checkin;
        }

        public void setCheckin(String checkin) {
            this.checkin = checkin;
        }

        public String getCheckout() {
            return checkout;
        }

        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }
    }

    public static BookingPojo getAuthPojo(String username, String password){
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername(username);
        bookingPojo.getPassword(password);
        return bookingPojo;
    }

    public static BookingPojo getBookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid,String checkin, String checkout, String additionalneeds) {
        BookingPojo.BookingDates date = new BookingPojo.BookingDates();
        date.setCheckin(checkin);
        date.setCheckout(checkout);
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalPrice(totalprice);
        bookingPojo.setDepositpaid(depositpaid);
        bookingPojo.setAdditionalneeds(additionalneeds);
        bookingPojo.setBookingdates(date);
        return bookingPojo;
    }

}
