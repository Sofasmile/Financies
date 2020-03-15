package project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer discountRate;

    private Double nvp;

    public Price() {
    }

    public Price(Integer discountRate, Double nvp) {
        this.discountRate = discountRate;
        this.nvp = nvp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public Double getNvp() {
        return nvp;
    }

    public void setNvp(Double nvp) {
        this.nvp = nvp;
    }
}
