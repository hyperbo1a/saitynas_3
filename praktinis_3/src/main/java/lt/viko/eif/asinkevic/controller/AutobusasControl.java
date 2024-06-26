package lt.viko.eif.asinkevic.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lt.viko.eif.asinkevic.assembler.AutobusasAssembler;
import lt.viko.eif.asinkevic.model.Autobusas;
import lt.viko.eif.asinkevic.Service.AutobusasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autobusas")
public class AutobusasControl {

    @Autowired
    private AutobusasService autobusasService;

    @Autowired
    private AutobusasAssembler autobusasAssembler;

    @Operation(summary = "Get all buses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all buses",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Autobusas> autobuses = autobusasService.getAllAutobusai();
        autobusasAssembler.Ref = "All";
        return ResponseEntity.ok(autobusasAssembler.toModelList(autobuses));
    }

    @Operation(summary = "Find bus by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found bus",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @RequestMapping(params = {"id"}, method = RequestMethod.GET)
    public ResponseEntity<?> getById(@RequestParam(value = "id") long id) {
        try {
            Autobusas autobusas = autobusasService.getAutobusasById(id);
            autobusasAssembler.Ref = "findID";
            return ResponseEntity.ok(autobusasAssembler.toModel(autobusas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find buses by color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found buses",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @RequestMapping(params = {"spalva"}, method = RequestMethod.GET)
    public ResponseEntity<?> getBySpalva(@RequestParam(value = "spalva") String spalva) {
        try {
            List<Autobusas> autobuses = autobusasService.findBySpalva(spalva);
            autobusasAssembler.Ref = "findColor";
            return ResponseEntity.ok(autobusasAssembler.toModelList(autobuses));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find buses by registration number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found buses",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @RequestMapping(params = {"valstybinisNumeris"}, method = RequestMethod.GET)
    public ResponseEntity<?> getByValstybinisNumeris(@RequestParam(value = "valstybinisNumeris") String valstybinisNumeris) {
        try {
            List<Autobusas> autobuses = autobusasService.findByValstybinisNumeris(valstybinisNumeris);
            autobusasAssembler.Ref = "findByRegistration";
            return ResponseEntity.ok(autobusasAssembler.toModelList(autobuses));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Find buses by seat count")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found buses",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @RequestMapping(params = {"vietuSkaicius"}, method = RequestMethod.GET)
    public ResponseEntity<?> getByVietuSkaicius(@RequestParam(value = "vietuSkaicius") int vietuSkaicius) {
        try {
            List<Autobusas> autobuses = autobusasService.findByVietuSkaicius(vietuSkaicius);
            autobusasAssembler.Ref = "findBySeatCount";
            return ResponseEntity.ok(autobusasAssembler.toModelList(autobuses));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create new bus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New bus created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @PostMapping()
    public ResponseEntity<?> createNewBus(@RequestParam(name = "spalva") String spalva,
                                          @RequestParam(name = "valstybinisNumeris") String valstybinisNumeris,
                                          @RequestParam(name = "vietuSkaicius") int vietuSkaicius) {
        Autobusas autobusas = autobusasService.newAutobusas(spalva, valstybinisNumeris, vietuSkaicius);
        autobusasAssembler.Ref = "New";
        return ResponseEntity.ok(autobusasAssembler.toModel(autobusas));
    }

    @Operation(summary = "Delete bus by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bus deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})

    })
    @DeleteMapping("/byId")
    public ResponseEntity<?> deleteById(@RequestParam(value = "id") long id) {
        try {
            autobusasService.deleteAutobusasById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update bus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bus updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Autobusas.class))})
    })
    @PutMapping()
    public ResponseEntity<?> updateBus(@RequestParam(value = "id") long id,
                                       @RequestParam(value = "spalva", required = false) String spalva,
                                       @RequestParam(value = "valstybinisNumeris", required = false) String valstybinisNumeris,
                                       @RequestParam(value = "vietuSkaicius", required = false) Integer vietuSkaicius) {
        try {
            Autobusas autobusas = autobusasService.updateAutobusas(id, spalva, valstybinisNumeris, vietuSkaicius);
            autobusasAssembler.Ref = "Update";
            return ResponseEntity.ok(autobusasAssembler.toModel(autobusas));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}



