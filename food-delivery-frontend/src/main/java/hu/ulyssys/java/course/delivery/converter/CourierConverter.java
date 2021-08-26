package hu.ulyssys.java.course.delivery.converter;

import hu.ulyssys.java.course.food.delivery.entity.Courier;
import hu.ulyssys.java.course.food.delivery.service.CourierService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CourierConverter implements Converter {
    @Inject
    private CourierService courierService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        return courierService.findByFullName(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String check;
        if (o instanceof Courier) {
            check = ((Courier) o).getFullName();
            return check;
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
