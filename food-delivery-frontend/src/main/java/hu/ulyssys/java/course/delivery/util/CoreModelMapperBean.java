package hu.ulyssys.java.course.delivery.util;

import hu.ulyssys.java.course.delivery.rest.model.CoreRestModel;
import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;
import hu.ulyssys.java.course.food.delivery.service.UserService;

import javax.inject.Inject;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractModifiableEntity> {
    protected M model;

    @Inject
    private UserService userService;

    public M createModelFromEntity(T entity) {
        model = initNewModel();
        model.setId(entity.getId());
        model.setCreatorId(entity.getCreatorUser().getId());
        model.setCreationDate(entity.getCreationDate());
        if(entity.getModifierUser()!=null){
            model.setModifierId(entity.getModifierUser().getId());
        }
        model.setModifiedDate(entity.getModifiedDate());
        return model;
    }

    public void populateEntityFromModel(T entity, M model){
        entity.setId(model.getId());
        entity.setCreatorUser(userService.findById(model.getCreatorId()));
        entity.setCreationDate(model.getCreationDate());
        if(model.getModifierId()!=null){
            entity.setModifierUser(userService.findById(model.getModifierId()));
        }else{
            entity.setModifierUser(null);
        }
        entity.setModifiedDate(model.getModifiedDate());
    }

    public abstract M initNewModel();
}
