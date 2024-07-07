package com.ansdev.course_management_backend.controller;
import com.ansdev.course_management_backend.models.base.BaseResponse;
import com.ansdev.course_management_backend.models.mappers.CountryEntityMapper;
import com.ansdev.course_management_backend.models.payload.country.CountryPayload;
import com.ansdev.course_management_backend.services.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/countries")
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public BaseResponse<Void> insert(@RequestBody CountryPayload countryPayload){
        countryService.insert(CountryEntityMapper.INSTANCE.toEntity(countryPayload));
        return BaseResponse.success();
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> update(@PathVariable("id") long id, @RequestBody CountryPayload countryPayload){
        countryService.update(CountryEntityMapper.INSTANCE.toEntity(countryPayload, id));
        return BaseResponse.success();
    }

}