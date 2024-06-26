package lt.viko.eif.asinkevic.assembler;
import lt.viko.eif.asinkevic.controller.AutobusasControl;
import lt.viko.eif.asinkevic.model.Autobusas;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class AutobusasAssembler implements RepresentationModelAssembler<Autobusas, EntityModel<Autobusas>> {
    public String Ref;

    public List<EntityModel<Autobusas>> toModelList(List<Autobusas> autobusai) {
        return autobusai.stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public EntityModel<Autobusas> toModel(Autobusas autobusas) {
        return EntityModel.of(autobusas,
                !Objects.equals(Ref, "all") ? linkTo(methodOn(AutobusasControl.class).getAll()).withRel("Get all buses")
                        : linkTo(methodOn(AutobusasControl.class).getAll()).withSelfRel(),
                !Objects.equals(Ref, "findById") ? linkTo(methodOn(AutobusasControl.class).getById(autobusas.getId())).withRel("Find bus by ID")
                        : linkTo(methodOn(AutobusasControl.class).getById(autobusas.getId())).withSelfRel(),
                !Objects.equals(Ref, "findBySpalva") ? linkTo(methodOn(AutobusasControl.class).getBySpalva(autobusas.getSpalva())).withRel("Find bus by color")
                        : linkTo(methodOn(AutobusasControl.class).getBySpalva(autobusas.getSpalva())).withSelfRel(),
                !Objects.equals(Ref, "findByValstybinisNumeris") ? linkTo(methodOn(AutobusasControl.class).getByValstybinisNumeris(autobusas.getValstybinisNumeris())).withRel("Find bus by registration number")
                        : linkTo(methodOn(AutobusasControl.class).getByValstybinisNumeris(autobusas.getValstybinisNumeris())).withSelfRel(),
                !Objects.equals(Ref, "findByVietuSkaicius") ? linkTo(methodOn(AutobusasControl.class).getByVietuSkaicius(autobusas.getVietuSkaicius())).withRel("Find bus by seat count")
                        : linkTo(methodOn(AutobusasControl.class).getByVietuSkaicius(autobusas.getVietuSkaicius())).withSelfRel(),
                !Objects.equals(Ref, "createNewBus") ? linkTo(methodOn(AutobusasControl.class).createNewBus(autobusas.getSpalva(), autobusas.getValstybinisNumeris(), autobusas.getVietuSkaicius())).withRel("Create new bus")
                        : linkTo(methodOn(AutobusasControl.class).createNewBus(autobusas.getSpalva(), autobusas.getValstybinisNumeris(), autobusas.getVietuSkaicius())).withSelfRel(),
                !Objects.equals(Ref, "deleteById") ? linkTo(methodOn(AutobusasControl.class).deleteById(autobusas.getId())).withRel("Delete bus")
                        : linkTo(methodOn(AutobusasControl.class).deleteById(autobusas.getId())).withSelfRel(),
                !Objects.equals(Ref, "updateBus") ? linkTo(methodOn(AutobusasControl.class).updateBus(autobusas.getId(), autobusas.getSpalva(), autobusas.getValstybinisNumeris(), autobusas.getVietuSkaicius())).withRel("Update bus")
                        : linkTo(methodOn(AutobusasControl.class).updateBus(autobusas.getId(), autobusas.getSpalva(), autobusas.getValstybinisNumeris(), autobusas.getVietuSkaicius())).withSelfRel());
    }
}

