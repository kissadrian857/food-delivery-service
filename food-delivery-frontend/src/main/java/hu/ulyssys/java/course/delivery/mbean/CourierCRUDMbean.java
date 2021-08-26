package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.food.delivery.entity.Courier;
import hu.ulyssys.java.course.food.delivery.service.CourierService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreModifiableCRUDMbean<Courier> {

    @Inject
    public CourierCRUDMbean(CourierService service) {
        super(service);
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }

    @Override
    public void save() {
        newEntity.setFullName(newEntity.getFirstName() + " " + newEntity.getLastName());
        super.save();
    }
}
