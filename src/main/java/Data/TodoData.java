package Data;

import java.util.Date;

public class TodoData {
    private int id;
    private String desc;
    private boolean Done;
    private Date targetDate ;

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
}
