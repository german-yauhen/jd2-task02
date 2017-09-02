package by.htp.hermanovich.pojo;

import javax.persistence.*;

/**
 * This class describes an entity of country object.
 * The entities of this class are used by Hibernate framework.
 * The fields of the class annotated according to the corresponding columns
 * in the database table.
 * Created by Hermanovich Yauheni on 02.09.2017.
 */
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "country_name", unique = true)
    private String countryName;

    @Column(name = "country_code_alpha2", unique = true)
    private String countryCode;

    public Country() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != null ? !id.equals(country.id) : country.id != null) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        return countryCode != null ? countryCode.equals(country.countryCode) : country.countryCode == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return countryName + " [" + countryCode + "]";
    }
}