package ch.bbw.cardgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewController
 *    Kontrolliert Zusammenspiel mit der View
 * @author Peter Rutschmann
 * @date 26.08.2021
 */
@Controller
public class ViewController {
    List<City> leftCityList = new ArrayList<>();
    List<City> rightCityList = new ArrayList<>();
    City leftCity = null;
    City rightCity = null;

    public ViewController() {
        setup();
    }

    private void setup(){
        leftCityList.clear();
        rightCityList.clear();


        leftCityList.add( new City("Prishtina", 145000, 527, "Kosovo", 300, "images/Prishtina.jpg", 1974));
        leftCityList.add( new City("Belgrad", 1400000, 360, "Serbien", 800, "images/Belgrad.jpg", 878));
        leftCityList.add( new City("Srajevo", 300000, 141, "Bosnien", 450, "images/Sarajevo.jpg", 1850));

        rightCityList.add( new City("Zagreb", 806000, 641, "Kroatien", 1194, "images/Zagreb.jpg", 1094));
        rightCityList.add( new City("Tirana", 418000, 41, "Albanien", 220,"images/Tirana.jpg", 1372));
        rightCityList.add( new City("Skopje", 546000, 571, "Nordmazedonien",800,"images/Skopje.jpg", 1918 ));

    }


    @GetMapping("/")
    public String redirect() {
        City leftCity = null;
        City rightCity = null;
        return "redirect:/cardGameView";
    }

    @GetMapping("/cardGameView")
    public String showView(Model model) {
        model.addAttribute("leftCity", leftCity);
        model.addAttribute("rightCity", rightCity);
        model.addAttribute("numberLeft", leftCityList.size());
        model.addAttribute("numberRight", rightCityList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"showButton=showLeft"})
    public String showLeftCard(Model model) {
        if(leftCityList.isEmpty()){
            leftCity = null;
        }else{
            leftCity = leftCityList.get(0);
        }
        model.addAttribute("leftCity", leftCity);
        model.addAttribute("rightCiy", rightCity);
        model.addAttribute("numberLeft", leftCityList.size());
        model.addAttribute("numberRight", rightCityList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"moveButton=moveToLeft"})
    public String moveCardToLeft(Model model) {
        if(rightCityList.isEmpty()){
            //do nothing
        }else{
            //Verliererkarte hinzufügen
            leftCityList.add(rightCityList.remove(0));
            //Siegerkarte nach hinten schieben
            leftCityList.add(leftCityList.remove(0));
        }
        leftCity = null;
        rightCity = null;
        model.addAttribute("leftCity", leftCity);
        model.addAttribute("rightCity", rightCity);
        model.addAttribute("numberLeft", leftCityList.size());
        model.addAttribute("numberRight", rightCityList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"showButton=showRight"})
    public String showRightCard(Model model) {
        if(rightCityList.isEmpty()){
            rightCity = null;
        }else{
            rightCity = rightCityList.get(0);
        }
        model.addAttribute("leftCity", leftCity);
        model.addAttribute("rightCity", rightCity);
        model.addAttribute("numberLeft", leftCityList.size());
        model.addAttribute("numberRight", rightCityList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"moveButton=moveToRight"})
    public String moveCardToRight(Model model) {
        if (leftCityList.isEmpty()) {
            //do nothing
        } else {
            //Verliererkarte hinzufügen
            rightCityList.add(leftCityList.remove(0));
            //Siegerkarte nach hinten schieben
            rightCityList.add(rightCityList.remove(0));
        }
        leftCity = null;
        rightCity = null;
        model.addAttribute("leftCity", leftCity);
        model.addAttribute("rightCity", rightCity);
        model.addAttribute("numberLeft", leftCityList.size());
        model.addAttribute("numberRight", rightCityList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"showButton=reset"})
    public String resetView(Model model) {
        setup();
        leftCity = null;
        rightCity = null;
        model.addAttribute("leftCity", leftCity);
        model.addAttribute("rightCity", rightCity);
        model.addAttribute("numberLeft", leftCityList.size());
        model.addAttribute("numberRight", rightCityList.size());
        return "cardGameForm";
    }

}
