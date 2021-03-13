package com.weathermap.casesutudy.controller;


import com.weathermap.casesutudy.model.ForecastDTOResponse;
import com.weathermap.casesutudy.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WeatherController {
    private Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public ModelAndView getWeatherData(@RequestParam("city") String city) {
        ModelAndView modelAndView = new ModelAndView();

        logger.info("forecasting weather for {} ", city);
        modelAndView.getModel().putIfAbsent("forecastdata", new ForecastDTOResponse(city, weatherService.getWeatherData(city)));
        modelAndView.setViewName("weatherdetails");
        return  modelAndView;
    }
}
