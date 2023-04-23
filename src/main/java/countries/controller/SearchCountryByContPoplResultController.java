package countries.controller;

import countries.model.Country;
import countries.model.CountryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchCountryByContPoplResultController {
    @RequestMapping("/searchresbycontinentandpopulation")
    public String searchByContinentAndName(){
        return "searchresbycontinentandpopulation";
    }

    @ModelAttribute("countriesbycontandpopl")
    @PostMapping("/searchresbycontinentandpopulation")
    public List<Country> search(@RequestParam String continent, @RequestParam Integer population){
        CountryRepository a =new CountryRepository();
        return a.findByContinentAndPopulationGreaterThanEqual(continent,population);
    }
}
