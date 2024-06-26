package lt.viko.eif.asinkevic.assembler;
import lt.viko.eif.asinkevic.controller.VairuotojasControl;
import lt.viko.eif.asinkevic.model.Vairuotojas;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class VairuotojasAssembler implements RepresentationModelAssembler<Vairuotojas, EntityModel<Vairuotojas>> {
    public String Ref;

    public List<EntityModel<Vairuotojas>> toModelList(List<Vairuotojas> vairuotojai) {
        return vairuotojai.stream().map(this::toModel).collect(Collectors.toList());
    }
    @Override
    public EntityModel<Vairuotojas> toModel(Vairuotojas vairuotojas) {
        return EntityModel.of(vairuotojas,
                !Objects.equals(Ref, "All") ? linkTo(methodOn(VairuotojasControl.class).all()).withRel("Get all vairuotojai")
                        : linkTo(methodOn(VairuotojasControl.class).all()).withSelfRel(),
                !Objects.equals(Ref, "findID") ? linkTo(methodOn(VairuotojasControl.class).findByID(vairuotojas.getId())).withRel("Find vairuotojas")
                        : linkTo(methodOn(VairuotojasControl.class).findByID(vairuotojas.getId())).withSelfRel(),
                !Objects.equals(Ref, "findTelefonoNumeris") ? linkTo(methodOn(VairuotojasControl.class).findByTelefonoNumeris(vairuotojas.getTelefonoNumeris())).withRel("Find vairuotojas by telefono numeris")
                        : linkTo(methodOn(VairuotojasControl.class).findByTelefonoNumeris(vairuotojas.getTelefonoNumeris())).withSelfRel(),
                !Objects.equals(Ref, "findFirstNameAndLastName") ? linkTo(methodOn(VairuotojasControl.class).findByFirstNameAndLastName(vairuotojas.getFirstname(), vairuotojas.getLastname())).withRel("Find vairuotojai by first and last name")
                        : linkTo(methodOn(VairuotojasControl.class).findByFirstNameAndLastName(vairuotojas.getFirstname(), vairuotojas.getLastname())).withSelfRel(),
                !Objects.equals(Ref, "New") ? linkTo(methodOn(VairuotojasControl.class).newVairuotojas(vairuotojas.getFirstname(), vairuotojas.getLastname(), vairuotojas.getTelefonoNumeris())).withRel("New Vairuotojas")
                        : linkTo(methodOn(VairuotojasControl.class).newVairuotojas(vairuotojas.getFirstname(), vairuotojas.getLastname(), vairuotojas.getTelefonoNumeris())).withSelfRel(),
                !Objects.equals(Ref, "Delete") ? linkTo(methodOn(VairuotojasControl.class).deleteVairuotojasByID(vairuotojas.getId())).withRel("Delete Vairuotojas")
                        : linkTo(methodOn(VairuotojasControl.class).deleteVairuotojasByID(vairuotojas.getId())).withSelfRel(),
                !Objects.equals(Ref, "Update") ? linkTo(methodOn(VairuotojasControl.class).updateVairuotojas(vairuotojas.getId(), vairuotojas.getFirstname(), vairuotojas.getLastname(), vairuotojas.getTelefonoNumeris())).withRel("Update Vairuotojas")
                        : linkTo(methodOn(VairuotojasControl.class).updateVairuotojas(vairuotojas.getId(), vairuotojas.getFirstname(), vairuotojas.getLastname(), vairuotojas.getTelefonoNumeris())).withSelfRel(),
                !Objects.equals(Ref, "findFirstName") ? linkTo(methodOn(VairuotojasControl.class).findByFirstName(vairuotojas.getFirstname())).withRel("Find vairuotojai by first name")
                        : linkTo(methodOn(VairuotojasControl.class).findByFirstName(vairuotojas.getFirstname())).withSelfRel(),
                !Objects.equals(Ref, "findLastName") ? linkTo(methodOn(VairuotojasControl.class).findByLastName(vairuotojas.getLastname())).withRel("Find vairuotojai by last name")
                        : linkTo(methodOn(VairuotojasControl.class).findByLastName(vairuotojas.getLastname())).withSelfRel());
    }
}
