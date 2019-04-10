package Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class TodoData {
    private int id;
    private String desc;
    private boolean Done;
    private Date targetDate ;
    private int days;

    public int getDays() {
        try {
            days = Days.daysBetween(new LocalDate(new SimpleDateFormat("yyyy-MM-dd").parse(getCurrentDate()).getTime()), new LocalDate(this.targetDate.getTime())).getDays();
        }
        catch (ParseException p){
            p.printStackTrace();
        }
        return days;
    }

    public TodoData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TodoData(String desc, boolean isDone, Date date) {
        this.desc = desc;
        this.Done = isDone;
        this.targetDate = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean getDone() {
        return Done;
    }

    public void setDone(boolean done) {
        this.Done = done;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date date) {
        this.targetDate = date;
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

}
