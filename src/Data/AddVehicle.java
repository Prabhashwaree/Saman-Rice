package Data;

public class AddVehicle {
    private String number;
    private String weight;
    private String passengers;
    private String detail;

    public AddVehicle() {
    }

    public AddVehicle(String number, String weight, String passengers, String detail) {
        this.setNumber(number);
        this.setWeight(weight);
        this.setPassengers(passengers);
        this.setDetail(detail);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
