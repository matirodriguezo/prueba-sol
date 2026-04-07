package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.BusEntity;
import com.example.demo.interfaces.IBusService;

@Service
public class BusServiceImpl implements IBusService {

    private final String BASE_URL = "http://localhost:6789/api/v1/entities/bus/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<BusEntity> findAll() {
        try {
            BusEntity[] busesArray = restTemplate.getForObject(BASE_URL, BusEntity[].class);
            if (busesArray != null) {
                return Arrays.asList(busesArray);
            }
            return Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public BusEntity findById(Long id) {
        try {
            return restTemplate.getForObject(BASE_URL + id, BusEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BusEntity save(BusEntity bus) {
        try {
            if (bus.getId() != null) {

                restTemplate.put(BASE_URL + bus.getId(), bus);
                return bus;
            } else {

                return restTemplate.postForObject(BASE_URL, bus, BusEntity.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            restTemplate.delete(BASE_URL + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}