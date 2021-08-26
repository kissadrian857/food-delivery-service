package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.delivery.helper.BooleanWrapper;
import hu.ulyssys.java.course.food.delivery.entity.AbstractEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreService;

import java.io.Serializable;
import java.util.*;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {
    protected T newEntity;
    protected List<T> list;
    protected List<T> selectedEntities;
    protected CoreService<T> service;
    protected Map<T, BooleanWrapper> booleans;

    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        selectedEntities = new ArrayList<>();
        list = service.getAll();

        booleans = new HashMap<>();
        populateBooleanMap();
        newEntity = initNewEntity();
    }

    public void save() {
        newEntity.setCreationDate(new Date(System.currentTimeMillis()));
        service.add(newEntity);
        list = service.getAll();
        //megváltoznak a referenciák az egyes elemekre
        populateBooleanMap();
        newEntity = initNewEntity();
    }

    public void remove() {
        for (T entity : selectedEntities) {
            service.remove(entity);
        }

        list = service.getAll();
        //megváltoznak a referenciák az egyes elemekre
        populateBooleanMap();
        selectedEntities.clear();
    }

    public void populateBooleanMap() {
        if (!booleans.isEmpty()) {
            booleans.clear();
        }
        for (T entity : list) {
            booleans.put(entity, new BooleanWrapper(false));
        }
    }

    public boolean disableModifyButton() {
        return !(selectedEntities.size() == 1);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getNewEntity() {
        return newEntity;
    }

    public void setNewEntity(T newEntity) {
        this.newEntity = newEntity;
    }

    public List<T> getSelectedEntities() {
        return selectedEntities;
    }

    public void setSelectedEntities(List<T> selectedEntities) {
        this.selectedEntities = selectedEntities;
    }

    public Map<T, BooleanWrapper> getBooleans() {
        return booleans;
    }

    public void setBooleans(Map<T, BooleanWrapper> booleans) {
        this.booleans = booleans;
    }

    protected abstract T initNewEntity();

    public void handleCheckbox(T entity) {
        if (selectedEntities.contains(entity)) {
            selectedEntities.remove(entity);
        } else {
            selectedEntities.add(entity);
        }
    }
}
