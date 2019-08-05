package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;

@Entity(name = "teams")
public class Team extends BaseEntityWithName {
    private Blob logo;
    private String initials;
    private Color PrimaryKitColor;
    private Color SecondaryKitColor;
    private Town town;
    private BigDecimal budget;

    public Team() {
    }

    public Team(String name, Blob logo, String initials, Color primaryKitColor, Color secondaryKitColor, Town town, BigDecimal budget) {
        super(name);
        this.logo = logo;
        this.initials = initials;
        PrimaryKitColor = primaryKitColor;
        SecondaryKitColor = secondaryKitColor;
        this.town = town;
        this.budget = budget;
    }

    public Blob getLogo() {
        return logo;
    }

    public void setLogo(Blob logo) {
        this.logo = logo;
    }

    @Column(length = 3)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @ManyToOne
    @JoinColumn(name = "primary_kit_color", referencedColumnName = "id")
    public Color getPrimaryKitColor() {
        return PrimaryKitColor;
    }


    public void setPrimaryKitColor(Color primaryKitColor) {
        PrimaryKitColor = primaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color",
    referencedColumnName = "id")
    public Color getSecondaryKitColor() {
        return SecondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        SecondaryKitColor = secondaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "town_id",
    referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
