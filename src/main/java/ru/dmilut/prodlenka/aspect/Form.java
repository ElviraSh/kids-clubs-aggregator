package ru.dmilut.prodlenka.aspect;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by parents on 09.05.2017.
 */
public class Form {
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message="Неверный формат")
    private String area;

    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message="Неверный формат")
    private String city;


    @Size(min = 6, max = 6, message="Неверный формат")
    @NotEmpty(message = "Поле обязательно для заполнения")
    @Pattern(regexp = "^[0-9]+$", message="Неверный формат")
    private String index;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
