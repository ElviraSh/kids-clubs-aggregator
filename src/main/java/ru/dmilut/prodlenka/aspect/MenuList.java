package ru.dmilut.prodlenka.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmilut.prodlenka.service.UnitService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by parents on 09.05.2017.
 */
@Aspect
@Component
public class MenuList {
    @Autowired
    private HttpServletRequest request;


    @Pointcut("@annotation(ru.dmilut.prodlenka.aspect.ann.IncludeMenuList)")
    public void includeMenuListMethod() {
    }

    @Autowired
    private UnitService unit;

    @Before("includeMenuListMethod()")
    public void includeMenuInfo() {
        request.setAttribute("listMenu", unit.findAll());
    }
}
