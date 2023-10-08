package web.dao;


import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> car;
    {
        car = new ArrayList<>();
        car.add(new Car("Toyota", 250, 2010));
        car.add(new Car("BMW", 280, 207));
        car.add(new Car("Mazda", 230, 2013));
        car.add(new Car("Lada", 200, 2020));
        car.add(new Car("Audi", 235, 2018));
    }
    @Override
    public List<Car> getCars(int count) {
        return car.stream().limit(count).collect(Collectors.toList());
    }
}
