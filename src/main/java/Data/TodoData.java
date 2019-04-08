package Data;

import java.util.Date;

public class TodoData {
    private String desc;
    private boolean isDone;
    private Date date;

    public TodoData() {
    }

    public TodoData(String desc, boolean isDone, Date date) {
        this.desc = desc;
        this.isDone = isDone;
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
