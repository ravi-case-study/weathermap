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
        "cod",
        "message",
        "cnt",
        "list",
        "city"
})
public class ForecastResponse implements Serializable {

    private final static long serialVersionUID = 712513900941322923L;
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private int message;
    @JsonProperty("cnt")
    private int cnt;
    @JsonProperty("list")
    private java.util.List<com.weathermap.casesutudy.model.List> list = null;
    @JsonProperty("city")
    private City city;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    public ForecastResponse withCod(String cod) {
        this.cod = cod;
        return this;
    }

    @JsonProperty("message")
    public int getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(int message) {
        this.message = message;
    }

    public ForecastResponse withMessage(int message) {
        this.message = message;
        return this;
    }

    @JsonProperty("cnt")
    public int getCnt() {
        return cnt;
    }

    @JsonProperty("cnt")
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ForecastResponse withCnt(int cnt) {
        this.cnt = cnt;
        return this;
    }

    @JsonProperty("list")
    public java.util.List<com.weathermap.casesutudy.model.List> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<com.weathermap.casesutudy.model.List> list) {
        this.list = list;
    }

    public ForecastResponse withList(java.util.List<com.weathermap.casesutudy.model.List> list) {
        this.list = list;
        return this;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    public ForecastResponse withCity(City city) {
        this.city = city;
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

    public ForecastResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cod", cod).append("message", message).append("cnt", cnt).append("list", list).append("city", city).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(city).append(cnt).append(cod).append(additionalProperties).append(message).append(list).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForecastResponse) == false) {
            return false;
        }
        ForecastResponse rhs = ((ForecastResponse) other);
        return new EqualsBuilder().append(city, rhs.city).append(cnt, rhs.cnt).append(cod, rhs.cod).append(additionalProperties, rhs.additionalProperties).append(message, rhs.message).append(list, rhs.list).isEquals();
    }

}
