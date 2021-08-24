package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.delivery.helper.BooleanWrapper;
import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreModifiableService;
import hu.ulyssys.java.course.food.delivery.service.CoreService;

import java.util.Date;

public abstract class CoreModifiableCRUDMbean<T extends AbstractModifiableEntity> extends CoreCRUDMbean<T> {
    private T selectedModifiable;

    public CoreModifiableCRUDMbean(CoreService<T> service) {
        super(service);
    }

    public T getSelectedModifiable() {
        return selectedModifiable;
    }

    public void setSelectedModifiable(T selectedModifiable) {
        this.selectedModifiable = selectedModifiable;
    }

    public void initializeModifiable() {
        System.out.println();
        selectedModifiable = selectedEntities.get(0);
        System.out.println();
    }

    public void modify() {
        selectedModifiable.setModifiedDate(new Date(System.currentTimeMillis()));
        ((CoreModifiableService<T>) service).update(selectedModifiable);
        booleans.put(selectedModifiable,new BooleanWrapper(false));
        selectedModifiable = initNewEntity();
        selectedEntities.clear();

    }
}
