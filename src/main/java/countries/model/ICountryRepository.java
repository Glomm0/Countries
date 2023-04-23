/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package countries.model;

import java.util.List;

/**
 *
 * @author а353
 */
public interface ICountryRepository {
    Country findByCode(String code);
    List<Country> findByContinent(String continent);    
    List<Country> findByContinentAndNameStartingWith(String continent, String name) throws Exception;
    List<Country> findByContinentAndPopulationGreaterThanEqual(String continent, Integer population) throws Exception;
    Country findByName(String name);
    List<String> getContinents(); 
}
