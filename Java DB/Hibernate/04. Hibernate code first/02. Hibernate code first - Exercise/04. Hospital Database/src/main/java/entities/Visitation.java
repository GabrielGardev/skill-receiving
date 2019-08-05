package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation extends Patient{
    private Date date;
    private String comment;

    public Visitation() {
    }

    public Visitation(Date date, String comment) {
        this.date = date;
        this.comment = comment;
    }

    @Column(name = "visitation_date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "visitation_comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
