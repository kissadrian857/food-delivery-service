package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.food.delivery.entity.AbstractEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreService;

import java.io.Serializable;
import java.util.List;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {
    private List<T> list;
    private T selectedEntity;

    protected CoreService<T> service;

    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        selectedEntity= initNewEntity();
        list = service.getAll();
    }

    public void save(T entity){
        //TODO implement
    }

    public void remove(T entity){
        //TODO implement
    }

    protected abstract T initNewEntity();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
    }
}
