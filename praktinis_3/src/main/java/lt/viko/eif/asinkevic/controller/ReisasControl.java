package lt.viko.eif.asinkevic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lt.viko.eif.asinkevic.assembler.ReisasAssembler;
import lt.viko.eif.asinkevic.model.Reisas;
import lt.viko.eif.asinkevic.Service.ReisasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reisas")
public class ReisasControl {

    @Autowired
    private ReisasService reisasService;

    @Autowired
    private ReisasAssembler reisasAssembler;

    @Operation(summary = "Get all reisai")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all reisai",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @GetMapping()
    public ResponseEntity<?> all() {
        List<Reisas> reisai = reisasService.getAllReisai();
        reisasAssembler.Ref = "All";
        return ResponseEntity.ok(reisasAssembler.toModelList(reisai));
    }

    @Operation(summary = "New reisas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @PostMapping(params = {"autobusas_id", "uzsakovas_id", "vairuotojas_id", "adresas"})
    public ResponseEntity<?> newReisas(@RequestParam(value = "autobusas_id") long autobusasId,
                                       @RequestParam(value = "uzsakovas_id") long uzsakovasId,
                                       @RequestParam(value = "vairuotojas_id") long vairuotojasId,
                                       @RequestParam(value = "adresas") String adresas) {
        try {
            Reisas reisas = reisasService.insertReisas(autobusasId, uzsakovasId, vairuotojasId, adresas);
            reisasAssembler.Ref = "New";
            return ResponseEntity.ok(reisasAssembler.toModel(reisas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find by autobusas license plate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @GetMapping("/findByAutobusasValstybinisNumeris")
    public ResponseEntity<?> findByAutobusasValstybinisNumeris(@RequestParam(value = "valstybinisNumeris") String valstybinisNumeris) {
        try {
            List<Reisas> reisai = reisasService.findByAutobusasValstybinisNumeris(valstybinisNumeris);
            reisasAssembler.Ref = "findAutobusas";
            return ResponseEntity.ok(reisasAssembler.toModelList(reisai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find by uzsakovas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @GetMapping("/findByUzsakovas")
    public ResponseEntity<?> findByUzsakovas(@RequestParam(value = "firstName", required = false) String firstName,
                                             @RequestParam(value = "lastName", required = false) String lastName) {
        try {
            List<Reisas> reisai;
            if (firstName != null && lastName != null) {
                reisai = reisasService.findByUzsakovas(firstName, lastName);
            } else if (firstName != null) {
                reisai = reisasService.findByUzsakovasFirstName(firstName);
            } else if (lastName != null) {
                reisai = reisasService.findByUzsakovasLastName(lastName);
            } else {
                return ResponseEntity.notFound().build();
            }
            reisasAssembler.Ref = "findUzsakovas";
            return ResponseEntity.ok(reisasAssembler.toModelList(reisai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find by vairuotojas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @GetMapping("/findByVairuotojas")
    public ResponseEntity<?> findByVairuotojas(@RequestParam(value = "firstName", required = false) String firstName,
                                               @RequestParam(value = "lastName", required = false) String lastName) {
        try {
            List<Reisas> reisai;
            if (firstName != null && lastName != null) {
                reisai = reisasService.findByVairuotojas(firstName, lastName);
            } else if (firstName != null) {
                reisai = reisasService.findByVairuotojasFirstName(firstName);
            } else if (lastName != null) {
                reisai = reisasService.findByVairuotojasLastName(lastName);
            } else {
                return ResponseEntity.notFound().build();
            }
            reisasAssembler.Ref = "findVairuotojas";
            return ResponseEntity.ok(reisasAssembler.toModelList(reisai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update reisas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @PutMapping()
    public ResponseEntity<?> updateReisas(@RequestParam(value = "id") long id,
                                          @RequestParam(value = "autobusas_id", required = false) Long autobusasId,
                                          @RequestParam(value = "uzsakovas_id", required = false) Long uzsakovasId,
                                          @RequestParam(value = "vairuotojas_id", required = false) Long vairuotojasId,
                                          @RequestParam(value = "adresas", required = false) String adresas) {
        try {
            reisasService.updateReisas(id, autobusasId, uzsakovasId, vairuotojasId, adresas);
            Reisas updatedReisas = reisasService.getReisasById(id);
            reisasAssembler.Ref = "Update";
            return ResponseEntity.ok(reisasAssembler.toModel(updatedReisas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @GetMapping(params = {"id"})
    public ResponseEntity<?> findById(@RequestParam(value = "id") long id) {
        try {
            Reisas reisas = reisasService.getReisasById(id);
            reisasAssembler.Ref = "findID";
            return ResponseEntity.ok(reisasAssembler.toModel(reisas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete reisas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete Reisas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reisas.class))})
    })
    @RequestMapping(params = {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReisasByID(@RequestParam(value = "id", required = false)long id) {
        reisasService.deleteReisasById(id);
        return ResponseEntity.noContent().build();
    }
}

