package hu.ulyssys.java.course.delivery.rest;

import hu.ulyssys.java.course.delivery.rest.model.CoreRestModel;
import hu.ulyssys.java.course.delivery.util.CoreModelMapperBean;
import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreModifiableService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public abstract class CoreRestService<T extends AbstractModifiableEntity, M extends CoreRestModel> {
    @Inject
    private CoreModifiableService<T> coreModifiableService;

    @Inject
    private CoreModelMapperBean<M, T> coreModelMapperBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        T entity = coreModifiableService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<M> list = new ArrayList<>();
        for (T entity : coreModifiableService.getAll()) {
            list.add(createModelFromEntity(entity));
        }
        return Response.ok(list).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(M model) {
        T entity = initNewEntity();
        populateEntityFromModel(entity, model);
        coreModifiableService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(M model) {
        T entity = coreModifiableService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        coreModifiableService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        T entity = coreModifiableService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        coreModifiableService.remove(entity);
        return Response.ok().build();
    }

    protected abstract T initNewEntity();

    private M createModelFromEntity(T entity) {
        return coreModelMapperBean.createModelFromEntity(entity);
    }

    private void populateEntityFromModel(T entity, M model) {
        coreModelMapperBean.populateEntityFromModel(entity, model);
    }

}
