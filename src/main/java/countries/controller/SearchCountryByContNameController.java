package countries.controller;

import countries.model.Country;
import countries.model.CountryRepository;
import countries.model.CountrySearch;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SearchCountryByContNameController {
    @RequestMapping("/searchbycontinentandname")
    public String searchByContinentAndName(Model model){
        CountrySearch cs = new CountrySearch();
        model.addAttribute("countrysearch",cs);
        return "searchbycontinentandname";
    }
    @ModelAttribute("Continents")
    public List<String> getContinents(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("countries");
        context.refresh();
        List<String> res = new ArrayList();
        CountryRepository CR=context.getBean(CountryRepository.class);
        return CR.getContinents();
    }
}
