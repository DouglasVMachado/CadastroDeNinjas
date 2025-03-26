package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listar(){
        return "Listar todos os ninjas";
    }

    @PostMapping("/criar")
    public String criarMissoes(){
        return "Criar missoes no BD";
    }

    @PutMapping("/atualizar")
    public String atualizarMissoes(){
        return "Atualiza a missao no banco de dados";
    }

    @DeleteMapping("/deletar")
    public String deletar(){
        return "Deleta a missao no banco de dados";
    }

}
