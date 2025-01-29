package az.edu.turing.flightbookingapp.config;

public class MyCustomBean {

    private String message;

    public MyCustomBean() {
        this.message = "Welcome to the Flight Booking App!";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
