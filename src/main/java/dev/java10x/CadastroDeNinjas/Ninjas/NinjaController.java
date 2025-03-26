package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Cadastrar um ninja";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/mostrarninjas")
    public String mostrarTodosNinjas(){
        return "Mostrar todos os ninjas";
    }

    // Mostrar Ninja por ID (READ)
    @GetMapping("/mostrarninjaporid")
    public String mostrarNinjaPorId(){
        return "Mostrar ninjas por id";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/atualizarninja")
    public String atualizarNinja(){
        return "Atualizar ninja por id";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletaninja")
    public String deletarNinja(){
        return "Deletar ninja por id";
    }
}
