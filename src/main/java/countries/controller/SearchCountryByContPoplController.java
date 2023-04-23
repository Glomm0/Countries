package countries.controller;

import countries.model.CountryRepository;
import countries.model.CountrySearch;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchCountryByContPoplController {
    @RequestMapping("/searchbycontinentandpopulation")
    public String searchByContinentAndPopulation(Model model){
        CountrySearch cs = new CountrySearch();
        model.addAttribute("countrysearch",cs);
        return "searchbycontinentandpopulation";
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
