package com.weathermap.casesutudy.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDTO {
    private String date;
    private double maxTemp;
    private double minTemp;
    private String recommendation;
}
