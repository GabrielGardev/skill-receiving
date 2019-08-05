package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "competition_type")
public class CompetitionType extends BaseEntityWithName {
    public CompetitionType() {
    }
}
