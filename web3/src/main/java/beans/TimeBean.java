package beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeBean {
    private LocalDateTime dateTime;
    private final DateTimeFormatter dateFormat;

    public TimeBean() {
        this.dateTime = LocalDateTime.now();
        this.dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    public String getDateTime() {
        return this.dateTime.format(dateFormat);
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void updateTime(){
        this.dateTime = LocalDateTime.now();
    }
}
