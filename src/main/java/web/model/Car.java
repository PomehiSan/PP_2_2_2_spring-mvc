package web.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Car {
    private String name;
    private String model;
    private int old;

    public Car(String name, String model, int old) {
        this.name = name;
        this.model = model;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getOld() {
        return old;
    }
}
