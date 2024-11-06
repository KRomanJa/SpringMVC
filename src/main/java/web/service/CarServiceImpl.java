package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("bmw", 6, 612000));
        cars.add(new Car("lada", 9, 15000));
        cars.add(new Car("bugatti", 10, 841000));
        cars.add(new Car("toyota", 4, 69120));
        cars.add(new Car("bentley", 11, 321600));
    }
    public List<Car> getCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
