package lt.viko.eif.asinkevic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lt.viko.eif.asinkevic.assembler.UzsakovasAssembler;
import lt.viko.eif.asinkevic.model.Uzsakovas;
import lt.viko.eif.asinkevic.Service.UzsakovasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uzsakovas")
public class UzsakovasControl {

    @Autowired
    private UzsakovasService uzsakovasService;

    @Autowired
    private UzsakovasAssembler uzsakovasAssembler;

    @Operation(summary = "Get all uzsakovai")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found All Uzsakovai",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @GetMapping()
    public ResponseEntity<?> all() {
        List<Uzsakovas> uzsakovai = uzsakovasService.getAllUzsakovai();
        uzsakovasAssembler.Ref = "All";
        return ResponseEntity.ok(uzsakovasAssembler.toModelList(uzsakovai));
    }

    @Operation(summary = "Find uzsakovas by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByID(@RequestParam(value = "id", required = false) long id) {
        try {
            Uzsakovas uzsakovas = uzsakovasService.getUzsakovasById(id);
            uzsakovasAssembler.Ref = "findID";
            return ResponseEntity.ok(uzsakovasAssembler.toModel(uzsakovas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find uzsakovas by telefono numeris")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"telefonoNumeris"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByTelefonoNumeris(@RequestParam(value = "telefonoNumeris", required = false) String telefonoNumeris) {
        try {
            List<Uzsakovas> uzsakovai = uzsakovasService.findByTelefonoNumeris(telefonoNumeris);
            uzsakovasAssembler.Ref = "findTelefonoNumeris";
            return ResponseEntity.ok(uzsakovasAssembler.toModelList(uzsakovai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find uzsakovas by first name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"firstName"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByFirstName(@RequestParam(value = "firstName", required = false) String firstName) {
        try {
            List<Uzsakovas> uzsakovai = uzsakovasService.findByFirstName(firstName);
            uzsakovasAssembler.Ref = "findFirstName";
            return ResponseEntity.ok(uzsakovasAssembler.toModelList(uzsakovai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find uzsakovas by last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"lastName"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByLastName(@RequestParam(value = "lastName", required = false) String lastName) {
        try {
            List<Uzsakovas> uzsakovai = uzsakovasService.findByLastName(lastName);
            uzsakovasAssembler.Ref = "findLastName";
            return ResponseEntity.ok(uzsakovasAssembler.toModelList(uzsakovai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find uzsakovas by first and last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"firstName", "lastName"}, method = RequestMethod.GET)
    public ResponseEntity<?> findByFirstNameAndLastName(@RequestParam(value = "firstName", required = false) String firstName,
                                                        @RequestParam(value = "lastName", required = false) String lastName) {
        try {
            List<Uzsakovas> uzsakovai = uzsakovasService.findByFirstNameAndLastName(firstName, lastName);
            uzsakovasAssembler.Ref = "findFirstNameAndLastName";
            return ResponseEntity.ok(uzsakovasAssembler.toModelList(uzsakovai));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "New uzsakovas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"firstName", "lastName", "telefonoNumeris"}, method = RequestMethod.POST)
    public ResponseEntity<?> newUzsakovas(@RequestParam(name = "firstName") String firstName,
                                          @RequestParam(name = "lastName") String lastName,
                                          @RequestParam(name = "telefonoNumeris") String telefonoNumeris) {
        Uzsakovas uzsakovas = uzsakovasService.newUzsakovas(firstName, lastName, telefonoNumeris);
        uzsakovasAssembler.Ref = "New";
        return ResponseEntity.ok(uzsakovasAssembler.toModel(uzsakovas));
    }

    @Operation(summary = "Delete uzsakovas by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"id"}, method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUzsakovasByID(@RequestParam(value = "id", required = false) long id) {
        uzsakovasService.deleteUzsakovasById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update uzsakovas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Uzsakovas",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Uzsakovas.class))})
    })
    @RequestMapping(params = {"id", "firstName", "lastName", "telefonoNumeris"}, method = RequestMethod.PUT)
    public ResponseEntity<?> updateUzsakovas(@RequestParam(value = "id") long id,
                                             @RequestParam(value = "firstName", required = false) String firstName,
                                             @RequestParam(value = "lastName", required = false) String lastName,
                                             @RequestParam(value = "telefonoNumeris", required = false) String telefonoNumeris) {
        try {
            Uzsakovas uzsakovas = uzsakovasService.updateUzsakovas(id, firstName, lastName, telefonoNumeris);
            uzsakovasAssembler.Ref = "Update";
            return ResponseEntity.ok(uzsakovasAssembler.toModel(uzsakovas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
