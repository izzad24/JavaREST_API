package com.upskill.helloworld.models;


/**
 * Booking
 */
public class Booking {

    private int id;
    private int price;
    private String bookingDate;
    private String checkIn;
    private String checkOut;
    private String createAt;
    private String updateAt;
    private boolean confirmed;


    public boolean isConfirmed() {
        return this.confirmed;
    }

    public boolean getConfirmed() {
        return this.confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

}