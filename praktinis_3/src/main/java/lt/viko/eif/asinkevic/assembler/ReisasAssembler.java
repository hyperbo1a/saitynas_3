package lt.viko.eif.asinkevic.assembler;

import lt.viko.eif.asinkevic.controller.ReisasControl;
import lt.viko.eif.asinkevic.model.Reisas;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ReisasAssembler implements RepresentationModelAssembler<Reisas, EntityModel<Reisas>> {

    public String Ref;

    public List<EntityModel<Reisas>> toModelList(List<Reisas> reisai) {
        return reisai.stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public EntityModel<Reisas> toModel(Reisas reisas) {
        return EntityModel.of(reisas,
                !Objects.equals(Ref, "All") ? linkTo(methodOn(ReisasControl.class).all()).withRel("Get all reisai")
                        : linkTo(methodOn(ReisasControl.class).all()).withSelfRel(),
                !Objects.equals(Ref, "New") ? linkTo(methodOn(ReisasControl.class).newReisas(reisas.getAutobusas().getId(), reisas.getUzsakovas().getId(), reisas.getVairuotojas().getId(), reisas.getAdresas())).withRel("New reisas")
                        : linkTo(methodOn(ReisasControl.class).newReisas(reisas.getAutobusas().getId(), reisas.getUzsakovas().getId(), reisas.getVairuotojas().getId(), reisas.getAdresas())).withSelfRel(),
                !Objects.equals(Ref, "findAutobusas") ? linkTo(methodOn(ReisasControl.class).findByAutobusasValstybinisNumeris(reisas.getAutobusas().getValstybinisNumeris())).withRel("Find by autobusas license plate")
                        : linkTo(methodOn(ReisasControl.class).findByAutobusasValstybinisNumeris(reisas.getAutobusas().getValstybinisNumeris())).withSelfRel(),
                !Objects.equals(Ref, "findUzsakovas") ? linkTo(methodOn(ReisasControl.class).findByUzsakovas(reisas.getUzsakovas().getFirstname(), reisas.getUzsakovas().getLastname())).withRel("Find by uzsakovas")
                        : linkTo(methodOn(ReisasControl.class).findByUzsakovas(reisas.getUzsakovas().getFirstname(), reisas.getUzsakovas().getLastname())).withSelfRel(),
                !Objects.equals(Ref, "findVairuotojas") ? linkTo(methodOn(ReisasControl.class).findByVairuotojas(reisas.getVairuotojas().getFirstname(), reisas.getVairuotojas().getLastname())).withRel("Find by vairuotojas")
                        : linkTo(methodOn(ReisasControl.class).findByVairuotojas(reisas.getVairuotojas().getFirstname(), reisas.getVairuotojas().getLastname())).withSelfRel(),
                !Objects.equals(Ref, "Update") ? linkTo(methodOn(ReisasControl.class).updateReisas(reisas.getId(), reisas.getAutobusas().getId(), (long) reisas.getUzsakovas().getId(), (long) reisas.getVairuotojas().getId(), reisas.getAdresas())).withRel("Update reisas")
                        : linkTo(methodOn(ReisasControl.class).updateReisas(reisas.getId(), reisas.getAutobusas().getId(), (long) reisas.getUzsakovas().getId(), (long) reisas.getVairuotojas().getId(), reisas.getAdresas())).withSelfRel(),
                !Objects.equals(Ref, "findID") ? linkTo(methodOn(ReisasControl.class).findById(reisas.getId())).withRel("Find by ID")
                        : linkTo(methodOn(ReisasControl.class).findById(reisas.getId())).withSelfRel(),
                !Objects.equals(Ref, "Delete") ? linkTo(methodOn(ReisasControl.class).deleteReisasByID(reisas.getId())).withRel("Delete reisas")
                        : linkTo(methodOn(ReisasControl.class).deleteReisasByID(reisas.getId())).withSelfRel());
    }
}

