package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<>();

    private void initCars() {
        cars.add(new Car("Lada", "priora", 2007));
        cars.add(new Car("Lada", "vesta", 2017));
        cars.add(new Car("Lada", "granta", 2013));
        cars.add(new Car("Lada", "kalina", 2004));
        cars.add(new Car("Lada", "2105", 1986));
    }

    @Override
    public List<Car> getCars(String countParam) {
        cars = new ArrayList<>();
        initCars();
        int count = cars.size();
        try {
            count = Integer.parseInt(countParam) > 5 ? 5 : Integer.parseInt(countParam);
        } catch (Exception ignore) {}
        return cars.subList(0, count);
    }
}
