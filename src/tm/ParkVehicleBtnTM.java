package tm;

public class ParkVehicleBtnTM extends OnDeliveryTM {
    private String number;
    private String type;
    private String slot;
    private String time;
    private String date;

    public ParkVehicleBtnTM() {
    }

    public ParkVehicleBtnTM(String number, String type, String slot, String time, String date) {
        this.setNumber(number);
        this.setType(type);
        this.setSlot(slot);
        this.setTime(time);
        this.setDate(date);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
