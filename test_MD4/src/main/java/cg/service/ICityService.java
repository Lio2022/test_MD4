package cg.service;

import cg.model.City;

import java.util.List;

public interface ICityService {

    List<City> findAll();

    City findById(Long id);

    void deleteById(Long id);

    City save(City city);
}
