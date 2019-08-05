package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntityWithName{
    private CompetitionType type;

    public Competition() {
    }

    public Competition(CompetitionType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "commpetition_type", referencedColumnName = "id")
    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }
}
