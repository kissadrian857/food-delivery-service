package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.delivery.helper.BooleanWrapper;
import hu.ulyssys.java.course.food.delivery.entity.AbstractEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {
    protected List<T> list;
    protected List<T> selectedEntities;
    protected CoreService<T> service;
    protected Map<T,BooleanWrapper> booleans;

    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        selectedEntities = new ArrayList<>();
        list = service.getAll();

        booleans= new HashMap<>();
        for(T entity : list){
            booleans.put(entity,new BooleanWrapper(false));
        }
    }

    public void save(T entity) {
        //TODO implement
    }



    public void remove(T entity) {
        //TODO implement
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
}
