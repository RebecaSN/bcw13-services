package SoulCode.Servicos.Controllers;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import SoulCode.Servicos.Models.Funcionario;
import SoulCode.Servicos.Models.Servico;
import SoulCode.Servicos.Services.ServicoService;

@CrossOrigin 
@RestController 
@RequestMapping("servicos")
public class ServicoController {
	
	@Autowired
	ServicoService servicoService;
	
	// o método get serve para fazer buscar no banco de dados
	@GetMapping("/servico")
	public List<Servico> mostrarTodosServicos(){
		List<Servico> servicos = servicoService.mostrarTodosServicos();
		return servicos;
	}
	
	@GetMapping("/servico/{idServico}")
	public ResponseEntity<Servico> buscarUmServico(@PathVariable Integer idServico){
		Servico servico  = servicoService.buscarUmServico(idServico);
		return ResponseEntity.ok().body(servico);
		
	}
	
	@GetMapping("/servicoFuncionario/{idFuncionario}")
	public List<Servico> buscarServicosDoFuncionario(@PathVariable Integer idFuncionario){
		
		List<Servico> servicos = servicoService.buscarServicosDoFuncionario(idFuncionario);
		return servicos;
		
	}
	
		
	//@RequestParam permite que os dados da requisação venham pelos parâmetros da requisição
	@GetMapping("/servicoData")
	public List<Servico> buscarServicoPelaData(@RequestParam("dataEntrada") @DateTimeFormat(
			iso = DateTimeFormat.ISO.DATE) Date dataEntrada){
		List<Servico> servicos = servicoService.buscarServicoPelaData(dataEntrada);
		return servicos;
	
	}
	
	@GetMapping("/servicoIntervaloData")
	public List<Servico> buscarServicoPorIntervaloData(@RequestParam("data1") @DateTimeFormat(
			iso = DateTimeFormat.ISO.DATE) Date data1, @RequestParam("data2") @DateTimeFormat(
					iso = DateTimeFormat.ISO.DATE) Date data2 ){
		List<Servico> servicos = servicoService.buscarServicoPorIntervaloData(data1, data2);
		return servicos;
	}
}














