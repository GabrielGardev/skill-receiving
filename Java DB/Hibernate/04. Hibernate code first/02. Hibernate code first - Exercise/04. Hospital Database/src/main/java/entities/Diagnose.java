package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends Patient {
    private String name;
    private String comment;

    public Diagnose(){

    }

    public Diagnose(String name, String comment){
        this.name = name;
        this.comment = comment;
    }

    @Column(name = "diagnose_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "diagnose_comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
