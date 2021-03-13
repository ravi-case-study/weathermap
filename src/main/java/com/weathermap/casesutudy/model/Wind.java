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
        "speed",
        "deg"
})
public class Wind implements Serializable {

    private final static long serialVersionUID = 6443081580381700296L;
    @JsonProperty("speed")
    private double speed;
    @JsonProperty("deg")
    private int deg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("speed")
    public double getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Wind withSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    @JsonProperty("deg")
    public int getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Wind withDeg(int deg) {
        this.deg = deg;
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

    public Wind withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("speed", speed).append("deg", deg).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(speed).append(deg).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Wind) == false) {
            return false;
        }
        Wind rhs = ((Wind) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(speed, rhs.speed).append(deg, rhs.deg).isEquals();
    }

}
