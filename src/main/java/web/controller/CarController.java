package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    List<Car> cars = new ArrayList<>();

    private void initCars() {
        cars.add(new Car("Lada", "priora", 2007));
        cars.add(new Car("Lada", "vesta", 2017));
        cars.add(new Car("Lada", "granta", 2013));
        cars.add(new Car("Lada", "kalina", 2004));
        cars.add(new Car("Lada", "2105", 1986));
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(value = "count", required = false) String countParam) {
        cars = new ArrayList<>();
        initCars();
        int count = cars.size();
        try {
            count = Integer.parseInt(countParam) > 5 ? 5 : Integer.parseInt(countParam);
        } catch (Exception ignore) {}
        model.addAttribute("cars", cars.subList(0, count));
        return "cars";
    }
}
