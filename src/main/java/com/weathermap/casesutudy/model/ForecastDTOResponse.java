package com.weathermap.casesutudy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ForecastDTOResponse {
    private String city;
    private List<ForecastDTO> forecasts;
    private String error;

    public ForecastDTOResponse(String city, List<ForecastDTO> forecasts) {
        this.city = city;
        this.forecasts = forecasts;
    }

    public ForecastDTOResponse(String city, String error) {
        this.city = city;
        this.error = error;
    }

}
