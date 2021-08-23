package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.food.delivery.entity.Courier;
import hu.ulyssys.java.course.food.delivery.service.CoreService;
import hu.ulyssys.java.course.food.delivery.service.CourierService;
import org.apache.poi.ss.formula.functions.T;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreCRUDMbean<Courier> {

    @Inject
    public CourierCRUDMbean(CourierService service) {
        super(service);
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
