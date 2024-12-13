package RestAssured.POST;

public class BookingDates {

    private String checkin;
    private String checkout;

    public BookingDates() {
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }
}

