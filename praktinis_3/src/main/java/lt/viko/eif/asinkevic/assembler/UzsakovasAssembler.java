package lt.viko.eif.asinkevic.assembler;
import lt.viko.eif.asinkevic.controller.UzsakovasControl;
import lt.viko.eif.asinkevic.model.Uzsakovas;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class UzsakovasAssembler implements RepresentationModelAssembler<Uzsakovas, EntityModel<Uzsakovas>> {
    public String Ref;
    public List<EntityModel<Uzsakovas>> toModelList(List<Uzsakovas> uzsakovai) {
        return uzsakovai.stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public EntityModel<Uzsakovas> toModel(Uzsakovas uzsakovas) {
        return EntityModel.of(uzsakovas,
                !Objects.equals(Ref, "All") ? linkTo(methodOn(UzsakovasControl.class).all()).withRel("Get all uzsakovai")
                        : linkTo(methodOn(UzsakovasControl.class).all()).withSelfRel(),
                !Objects.equals(Ref, "findID") ? linkTo(methodOn(UzsakovasControl.class).findByID(uzsakovas.getId())).withRel("Find uzsakovas")
                        : linkTo(methodOn(UzsakovasControl.class).findByID(uzsakovas.getId())).withSelfRel(),
                !Objects.equals(Ref, "findTelefonoNumeris") ? linkTo(methodOn(UzsakovasControl.class).findByTelefonoNumeris(uzsakovas.getTelefonoNumeris())).withRel("Find uzsakovas")
                        : linkTo(methodOn(UzsakovasControl.class).findByTelefonoNumeris(uzsakovas.getTelefonoNumeris())).withSelfRel(),
                !Objects.equals(Ref, "findFirstNameAndLastName") ? linkTo(methodOn(UzsakovasControl.class).findByFirstNameAndLastName(uzsakovas.getFirstname(), uzsakovas.getLastname())).withRel("Find uzsakovai")
                        : linkTo(methodOn(UzsakovasControl.class).findByFirstNameAndLastName(uzsakovas.getFirstname(), uzsakovas.getLastname())).withSelfRel(),
                !Objects.equals(Ref, "New") ? linkTo(methodOn(UzsakovasControl.class).newUzsakovas(uzsakovas.getFirstname(), uzsakovas.getLastname(), uzsakovas.getTelefonoNumeris())).withRel("New uzsakovas")
                        : linkTo(methodOn(UzsakovasControl.class).newUzsakovas(uzsakovas.getFirstname(), uzsakovas.getLastname(), uzsakovas.getTelefonoNumeris())).withSelfRel(),
                !Objects.equals(Ref, "Delete") ? linkTo(methodOn(UzsakovasControl.class).deleteUzsakovasByID(uzsakovas.getId())).withRel("Delete uzsakovas")
                        : linkTo(methodOn(UzsakovasControl.class).deleteUzsakovasByID(uzsakovas.getId())).withSelfRel(),
                !Objects.equals(Ref, "Update") ? linkTo(methodOn(UzsakovasControl.class).updateUzsakovas(uzsakovas.getId(), uzsakovas.getFirstname(), uzsakovas.getLastname(), uzsakovas.getTelefonoNumeris())).withRel("Update uzsakovas")
                        : linkTo(methodOn(UzsakovasControl.class).updateUzsakovas(uzsakovas.getId(), uzsakovas.getFirstname(), uzsakovas.getLastname(), uzsakovas.getTelefonoNumeris())).withSelfRel(),
                !Objects.equals(Ref, "findFirstName") ? linkTo(methodOn(UzsakovasControl.class).findByFirstName(uzsakovas.getFirstname())).withRel("Find uzsakovai by first name")
                        : linkTo(methodOn(UzsakovasControl.class).findByFirstName(uzsakovas.getFirstname())).withSelfRel(),
                !Objects.equals(Ref, "findLastName") ? linkTo(methodOn(UzsakovasControl.class).findByLastName(uzsakovas.getLastname())).withRel("Find uzsakovai by last name")
                        : linkTo(methodOn(UzsakovasControl.class).findByLastName(uzsakovas.getLastname())).withSelfRel());
    }
}
