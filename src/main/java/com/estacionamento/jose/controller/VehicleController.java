package com.estacionamento.jose.controller;


import com.estacionamento.jose.entity.Vehicle;
import com.estacionamento.jose.repository.VehicleRepository;
import com.estacionamento.jose.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam("id") final Long id){
        Vehicle vehicle = this.vehicleRepository.findById(id).orElse(null);

        return vehicle == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado")
                : ResponseEntity.ok(vehicle);
    }

//    @GetMapping("/ativo")
//    public ResponseEntity<?> getByAtivo(){
//        return ResponseEntity.ok(this.vehicleRepository.findAtivo());
//    }

//    @GetMapping("/lista")
//    public ResponseEntity<?> listaCompleta(){
//        return ResponseEntity.ok(this.vehicleRepository.findAll());
//    }
//    @PostMapping
//    public ResponseEntity<?> cadastrar(@RequestBody final Vehicle vehicle){
//        try {
//            this.vehicleService.register(vehicle);
//            return ResponseEntity.ok("Registrado com Sucesso");
//        }
//        catch (DataIntegrityViolationException e){
//            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
//        }
//        catch (RuntimeException e){
//            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
//        }
//        catch (Exception e) {
//            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
//        }
//    }

//    @PutMapping
//    public ResponseEntity<?> editar(@RequestParam("id") final Long id,
//                                    @RequestBody final Vehicle vehicle
//    ){
//        try{
//            this.vehicleService.editar(vehicle, id);
//            return ResponseEntity.ok("Registro atualizado com sucesso");
//        }
//        catch (DataIntegrityViolationException e){
//            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
//        }
//        catch (RuntimeException e){
//            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
//        }
//    }

//    @DeleteMapping
//    public ResponseEntity<?> deletar (@RequestParam ("id") final Long id) {
//        final Veiculo veiculoBanco = this.veiculoRepository.findById(id).orElse(null);
//
//        this.veiculoService.deletar(veiculoBanco);
//
//        return ResponseEntity.ok("Veiculo deletado com sucesso");
//    }

}