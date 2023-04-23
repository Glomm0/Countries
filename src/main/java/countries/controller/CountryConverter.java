package countries.controller;

import org.springframework.core.convert.converter.Converter;
import countries.model.Country;
import countries.model.CountryRepository;


public class CountryConverter implements Converter<String, Country> {


    @Override
    public Country convert(String code) {
        CountryRepository a = new CountryRepository();
        if(code.length()==3){
        return a.findByCode(code);
        }else{
        return a.findByName(code);
        }
    }
}
