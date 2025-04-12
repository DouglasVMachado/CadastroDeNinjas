package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO missoes = missoesService.listarMissoesPorId(id);
        if (missoes != null){
            return ResponseEntity.ok(missoes);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel listar a missao, digite um id valido");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missoesDTO = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão com id " + missoesDTO.getId() + " criada com sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarMissoes(@PathVariable Long id, @RequestBody MissoesDTO missaoatualizada){
        if (missoesService.listarMissoesPorId(id) != null){
            missoesService.atualizarMissao(id, missaoatualizada);
            return ResponseEntity.ok("Missao com o id " + id + " atualizado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada, digite um id valido");
        }
    }

    @DeleteMapping("/deletar/{od}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){
        if (missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao com o id " + id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não foi encontrada, tente novamente com outro id");
        }
    }

}
