package com.weathermap.casesutudy.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "coord",
        "country",
        "population",
        "timezone",
        "sunrise",
        "sunset"
})
public class City implements Serializable {

    private final static long serialVersionUID = 7108570978418837780L;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("country")
    private String country;
    @JsonProperty("population")
    private int population;
    @JsonProperty("timezone")
    private int timezone;
    @JsonProperty("sunrise")
    private int sunrise;
    @JsonProperty("sunset")
    private int sunset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public City withId(int id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public City withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public City withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public City withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("population")
    public int getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(int population) {
        this.population = population;
    }

    public City withPopulation(int population) {
        this.population = population;
        return this;
    }

    @JsonProperty("timezone")
    public int getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public City withTimezone(int timezone) {
        this.timezone = timezone;
        return this;
    }

    @JsonProperty("sunrise")
    public int getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public City withSunrise(int sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    @JsonProperty("sunset")
    public int getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public City withSunset(int sunset) {
        this.sunset = sunset;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public City withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("coord", coord).append("country", country).append("population", population).append("timezone", timezone).append("sunrise", sunrise).append("sunset", sunset).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(coord).append(sunrise).append(timezone).append(sunset).append(name).append(id).append(additionalProperties).append(population).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof City) == false) {
            return false;
        }
        City rhs = ((City) other);
        return new EqualsBuilder().append(country, rhs.country).append(coord, rhs.coord).append(sunrise, rhs.sunrise).append(timezone, rhs.timezone).append(sunset, rhs.sunset).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(population, rhs.population).isEquals();
    }

}
