package tm;

public class OnDeliveryTM {
    private String numbers;
    private String types;
    private String names;
    private String times;
    private String dates;

    public OnDeliveryTM() {
    }

    public OnDeliveryTM(String numbers, String types, String names, String times, String dates) {
        this.setNumbers(numbers);
        this.setTypes(types);
        this.setNames(names);
        this.setTimes(times);
        this.setDates(dates);
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
}
