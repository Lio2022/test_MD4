package cg.validate;

import cg.model.City;
import cg.service.ICityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class Validate_Name implements Validator {
    @Autowired
    ICityService iCityService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        City city = (City) target;
        List<City> cityList = iCityService.findAll();
        for (City s : cityList ) {
            if (city.getName().equals(s.getName())) {
                errors.rejectValue("name", "", "Name had exist, Please enter name!!!");
                return;
            }
        }
    }
}