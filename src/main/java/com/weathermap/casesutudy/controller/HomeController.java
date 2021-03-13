package com.weathermap.casesutudy.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weathermap.casesutudy.model.CityDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class HomeController {
    @Autowired
    private ResourceLoader resourceLoader;
    @GetMapping("/")
    public ModelAndView index(ModelAndView model) throws IOException {
        ObjectMapper objectMapper= new ObjectMapper();
        Resource fileResource = resourceLoader.getResource("classpath:city.list.json");
        List<CityDetail> cityDetails = objectMapper.readValue(fileResource.getInputStream(), new TypeReference<List<CityDetail>>(){});
        int totalCities = cityDetails.size();
        model.getModel().putIfAbsent("cities", cityDetails.stream()
                .map(cityDetail -> cityDetail.getName())
                .collect(Collectors.toList())
                .subList(0, getRandomNumberInRange(1, totalCities/10)));
        model.setViewName("index");
        return model;
    }

    /**
     * This is done purposefully wrong to reduce the list in the UI - Ideally pagination is to be used.
     * @param min
     * @param max
     * @return
     */
      private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}