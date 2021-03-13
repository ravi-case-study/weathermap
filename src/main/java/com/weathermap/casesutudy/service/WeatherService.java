package com.weathermap.casesutudy.service;

import com.weathermap.casesutudy.model.ForecastDTO;
import com.weathermap.casesutudy.model.ForecastResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@Service
public class WeatherService {
    private Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private static final int FORECAST_DAYS = 3;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");

    @Value("${api.weather.forecast.maxtemp:40}")
    private double maxTempForRecommendation;
    @Value("${api.weather.forecast.url:http://api.openweathermap.org/data/2.5/forecast?units=imperial&appid=2151e963173c318d3e21b973c984391a&q=}")
    private String apiUrlBase;
    @Autowired
    private RestTemplate restTemplate;

    public List<ForecastDTO> getWeatherData(String city) {
        final int[] count = {0};
        List<ForecastDTO> forecastDTOs = new ArrayList<>();
        String apiUrl = apiUrlBase + city;

        ResponseEntity<ForecastResponse> responseEntity = restTemplate.getForEntity(apiUrl, ForecastResponse.class);
        if (OK.equals(responseEntity.getStatusCode())) {
            processResponse(count, forecastDTOs, responseEntity);
        }
        return forecastDTOs;
    }

    private void processResponse(int[] count, List<ForecastDTO> forecastDTOs, ResponseEntity<ForecastResponse> responseEntity) {
        List<com.weathermap.casesutudy.model.List> weatherData = responseEntity.getBody().getList();
        Map<String, List<com.weathermap.casesutudy.model.List>> weatherDataMapByDate = weatherData.stream().collect(Collectors.groupingBy(list -> list.getDtTxt().substring(0, 10)));
        weatherDataMapByDate.keySet().stream().sorted().forEach(weatherDataDateKey -> {
            String recommendation = StringUtils.EMPTY;
            logger.info("Data for date {} ", weatherDataDateKey);

            List<com.weathermap.casesutudy.model.List> weatherDataForDay = weatherDataMapByDate.get(weatherDataDateKey);
            Optional<com.weathermap.casesutudy.model.List> minTempForDay = weatherDataForDay.stream().min(Comparator.comparing(list -> list.getMain().getTempMin()));
            if (minTempForDay.isPresent() && minTempForDay.get() != null && minTempForDay.get().getMain() != null) {
                logger.info("MinTemp of {} for the date {} ", minTempForDay.get().getMain().getTempMin(), weatherDataDateKey);
            }
            Optional<com.weathermap.casesutudy.model.List> maxTempForDay = weatherDataForDay.stream().max(Comparator.comparing(list -> list.getMain().getTempMax()));
            if (maxTempForDay.isPresent() && maxTempForDay.get() != null && maxTempForDay.get().getMain() != null) {
                logger.info("MaxTemp of {} for the date {} ", maxTempForDay.get().getMain().getTempMax(), weatherDataDateKey);
            }

            boolean isRainyDay = weatherDataForDay.stream().anyMatch(list -> list.getWeather().stream().anyMatch(weather -> weather.getMain().equalsIgnoreCase("Rain")));
            if (isRainyDay) {
                recommendation = "Carry an Umbrella as it could be raining soon";
            }
            Optional<com.weathermap.casesutudy.model.List> maxTempForTheDay = weatherDataForDay.stream().max(Comparator.comparing(list -> list.getMain().getTemp()));
            if (maxTempForTheDay.isPresent() && maxTempForTheDay.get() != null && maxTempForTheDay.get().getMain() != null && maxTempForTheDay.get().getMain().getTemp() > maxTempForRecommendation) {
                recommendation = "Use Sunscreen as the temperature could rise till " + maxTempForTheDay.get().getMain().getTemp();
            }
            if (count[0] < FORECAST_DAYS) {
                forecastDTOs.add(new ForecastDTO(weatherDataDateKey, maxTempForDay.get().getMain().getTempMax(), minTempForDay.get().getMain().getTempMin(), recommendation));
                count[0]++;
            }
        });
    }
}
