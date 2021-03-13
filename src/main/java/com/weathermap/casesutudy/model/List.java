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
        "dt",
        "main",
        "weather",
        "clouds",
        "wind",
        "visibility",
        "pop",
        "rain",
        "sys",
        "dt_txt"
})
public class List implements Serializable {

    private final static long serialVersionUID = 7240549674764129186L;
    @JsonProperty("dt")
    private int dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("pop")
    private int pop;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dt")
    public int getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(int dt) {
        this.dt = dt;
    }

    public List withDt(int dt) {
        this.dt = dt;
        return this;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    public List withMain(Main main) {
        this.main = main;
        return this;
    }

    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public List withWeather(java.util.List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public List withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    @JsonProperty("visibility")
    public int getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public List withVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    @JsonProperty("pop")
    public int getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(int pop) {
        this.pop = pop;
    }

    public List withPop(int pop) {
        this.pop = pop;
        return this;
    }

    @JsonProperty("rain")
    public Rain getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public List withRain(Rain rain) {
        this.rain = rain;
        return this;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public List withSys(Sys sys) {
        this.sys = sys;
        return this;
    }

    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public List withDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
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

    public List withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("main", main).append("weather", weather).append("clouds", clouds).append("wind", wind).append("visibility", visibility).append("pop", pop).append("rain", rain).append("sys", sys).append("dtTxt", dtTxt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dt).append(pop).append(rain).append(visibility).append(dtTxt).append(weather).append(main).append(clouds).append(additionalProperties).append(sys).append(wind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof List) == false) {
            return false;
        }
        List rhs = ((List) other);
        return new EqualsBuilder().append(dt, rhs.dt).append(pop, rhs.pop).append(rain, rhs.rain).append(visibility, rhs.visibility).append(dtTxt, rhs.dtTxt).append(weather, rhs.weather).append(main, rhs.main).append(clouds, rhs.clouds).append(additionalProperties, rhs.additionalProperties).append(sys, rhs.sys).append(wind, rhs.wind).isEquals();
    }

}
