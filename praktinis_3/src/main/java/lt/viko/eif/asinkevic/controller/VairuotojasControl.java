package lt.viko.eif.asinkevic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lt.viko.eif.asinkevic.assembler.VairuotojasAssembler;
import lt.viko.eif.asinkevic.model.Vairuotojas;
import lt.viko.eif.asinkevic.Service.VairuotojasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vairuotojas")
public class VairuotojasControl {
    @Autowired
    private VairuotojasService vairuotojasService;
    @Autowired
    private VairuotojasAssembler vairuotojasAssembler;

    @Operation(summary = "Get all vairuotojai")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found All Vairuotojai",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @GetMapping()
    public ResponseEntity<?> all() {
        List<Vairuotojas> vairuotojai = vairuotojasService.getAllVairuotojai();
        vairuotojasAssembler.Ref = "All";
        return ResponseEntity.ok(vairuotojasAssembler.toModelList(vairuotojai));
    }

    @Operation(summary = "Find vairuotojas by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Vairuotojas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByID(@RequestParam(value = "id", required = false) long id) {
        try {
            Vairuotojas vairuotojas = vairuotojasService.getVairuotojasById(id);
            vairuotojasAssembler.Ref = "findID";
            return ResponseEntity.ok(vairuotojasAssembler.toModel(vairuotojas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find vairuotojas by telefono numeris")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Vairuotojas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(params = {"telefonoNumeris"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByTelefonoNumeris(@RequestParam(value = "telefonoNumeris", required = false) String telefonoNumeris) {
        try {
            List<Vairuotojas> vairuotojas = vairuotojasService.findByTelefonoNumeris(telefonoNumeris);
            vairuotojasAssembler.Ref = "findTelefonoNumeris";
            return ResponseEntity.ok(vairuotojasAssembler.toModelList(vairuotojas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find vairuotojai by first name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Vairuotojai",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(params = {"firstName"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByFirstName(@RequestParam(value = "firstName", required = false) String firstName) {
        try {
            List<Vairuotojas> vairuotojai = vairuotojasService.findByFirstName(firstName);
            vairuotojasAssembler.Ref = "findFirstName";
            return ResponseEntity.ok(vairuotojasAssembler.toModelList(vairuotojai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find vairuotojai by last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Vairuotojai",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(params = {"lastName"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByLastName(@RequestParam(value = "lastName", required = false) String lastName) {
        try {
            List<Vairuotojas> vairuotojai = vairuotojasService.findByLastName(lastName);
            vairuotojasAssembler.Ref = "findLastName";
            return ResponseEntity.ok(vairuotojasAssembler.toModelList(vairuotojai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find vairuotojai by first and last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Vairuotojai",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(params = {"firstName", "lastName"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByFirstNameAndLastName(@RequestParam(value = "firstName", required = false) String firstName,
                                                        @RequestParam(value = "lastName", required = false) String lastName) {
        try {
            List<Vairuotojas> vairuotojai = vairuotojasService.findByFirstNameAndLastName(firstName, lastName);
            vairuotojasAssembler.Ref = "findFirstNameAndLastName";
            return ResponseEntity.ok(vairuotojasAssembler.toModelList(vairuotojai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "New vairuotojas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New Vairuotojas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @PostMapping()
    public ResponseEntity<?> newVairuotojas(@RequestParam(name = "firstName") String firstName,
                                            @RequestParam(name = "lastName") String lastName,
                                            @RequestParam(name = "telefonoNumeris") String telefonoNumeris) {
        Vairuotojas vairuotojas = vairuotojasService.newVairuotojas(firstName, lastName, telefonoNumeris);
        vairuotojasAssembler.Ref = "New";
        return ResponseEntity.ok(vairuotojasAssembler.toModel(vairuotojas));
    }

    @Operation(summary = "Delete vairuotojas by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Vairuotojas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(params = {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVairuotojasByID(@RequestParam(value = "id") long id) {
        vairuotojasService.deleteVairuotojasById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update vairuotojas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Vairuotojas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vairuotojas.class))})
    })
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateVairuotojas(@RequestParam(value = "id") long id,
                                               @RequestParam(value = "firstName", required = false) String firstName,
                                               @RequestParam(value = "lastName", required = false) String lastName,
                                               @RequestParam(value = "telefonoNumeris", required = false) String telefonoNumeris) {
        try {
            Vairuotojas vairuotojas = vairuotojasService.updateVairuotojas(id, firstName, lastName, telefonoNumeris);
            vairuotojasAssembler.Ref = "Update";
            return ResponseEntity.ok(vairuotojasAssembler.toModel(vairuotojas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


