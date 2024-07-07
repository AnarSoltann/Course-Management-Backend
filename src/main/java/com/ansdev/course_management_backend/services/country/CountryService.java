package com.ansdev.course_management_backend.services.country;

import com.ansdev.course_management_backend.models.mybatis.country.Country;
import java.util.List;

public interface CountryService {

    void insert(Country country);
    Country findById(long id);

    List<Country> findAll();

    void update(Country country);
}