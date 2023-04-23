package countries.controller;

import countries.model.Country;
import countries.model.CountryRepository;
import countries.model.CountrySearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchCountryByContNameResultController {
    @RequestMapping("/searchresbycontinentandname")
    public String searchByContinentAndName(){
        return "searchresbycontinentandname";
    }

    @ModelAttribute("countriesbycontandname")
    @PostMapping("/searchresbycontinentandname")
    public List<Country> search(@RequestParam String continent, @RequestParam String name){
        CountryRepository a =new CountryRepository();
        return a.findByContinentAndNameStartingWith(continent,name);
    }
}
