package com.ansdev.course_management_backend.services.country;

import com.ansdev.course_management_backend.exception.BaseException;
import com.ansdev.course_management_backend.models.mybatis.country.Country;
import com.ansdev.course_management_backend.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;

    @Override
    public void insert(Country country) {
        countryRepository.insert(country);
    }

    @Override
    public Country findById(long id) {
        return countryRepository.findById(id).orElseThrow(
                () -> BaseException.notFound(Country.class.getSimpleName(),"country",String.valueOf(id))
        );
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public void update(Country country) {
        countryRepository.update(country);
    }

}