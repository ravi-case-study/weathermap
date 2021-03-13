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
        "temp",
        "feels_like",
        "temp_min",
        "temp_max",
        "pressure",
        "sea_level",
        "grnd_level",
        "humidity",
        "temp_kf"
})
public class Main implements Serializable {

    private final static long serialVersionUID = 8918315635103292889L;
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("sea_level")
    private int seaLevel;
    @JsonProperty("grnd_level")
    private int grndLevel;
    @JsonProperty("humidity")
    private int humidity;
    @JsonProperty("temp_kf")
    private int tempKf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Main withTemp(double temp) {
        this.temp = temp;
        return this;
    }

    @JsonProperty("feels_like")
    public double getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Main withFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    @JsonProperty("temp_min")
    public double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public Main withTempMin(double tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    @JsonProperty("temp_max")
    public double getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public Main withTempMax(double tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    @JsonProperty("pressure")
    public int getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public Main withPressure(int pressure) {
        this.pressure = pressure;
        return this;
    }

    @JsonProperty("sea_level")
    public int getSeaLevel() {
        return seaLevel;
    }

    @JsonProperty("sea_level")
    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Main withSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
        return this;
    }

    @JsonProperty("grnd_level")
    public int getGrndLevel() {
        return grndLevel;
    }

    @JsonProperty("grnd_level")
    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Main withGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
        return this;
    }

    @JsonProperty("humidity")
    public int getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Main withHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    @JsonProperty("temp_kf")
    public int getTempKf() {
        return tempKf;
    }

    @JsonProperty("temp_kf")
    public void setTempKf(int tempKf) {
        this.tempKf = tempKf;
    }

    public Main withTempKf(int tempKf) {
        this.tempKf = tempKf;
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

    public Main withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("temp", temp).append("feelsLike", feelsLike).append("tempMin", tempMin).append("tempMax", tempMax).append("pressure", pressure).append("seaLevel", seaLevel).append("grndLevel", grndLevel).append("humidity", humidity).append("tempKf", tempKf).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(feelsLike).append(tempMax).append(temp).append(seaLevel).append(humidity).append(pressure).append(tempKf).append(additionalProperties).append(grndLevel).append(tempMin).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Main) == false) {
            return false;
        }
        Main rhs = ((Main) other);
        return new EqualsBuilder().append(feelsLike, rhs.feelsLike).append(tempMax, rhs.tempMax).append(temp, rhs.temp).append(seaLevel, rhs.seaLevel).append(humidity, rhs.humidity).append(pressure, rhs.pressure).append(tempKf, rhs.tempKf).append(additionalProperties, rhs.additionalProperties).append(grndLevel, rhs.grndLevel).append(tempMin, rhs.tempMin).isEquals();
    }

}
