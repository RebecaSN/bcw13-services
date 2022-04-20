package SoulCode.Servicos.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoulCode.Servicos.Models.Funcionario;
import SoulCode.Servicos.Models.Servico;
import SoulCode.Servicos.Repositories.FuncionarioRepository;
import SoulCode.Servicos.Repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	// findAll (método da Spring Data) - busca todos os registros
	public List<Servico> mostrarTodosServicos(){
		return servicoRepository.findAll();	}
	
	// findById - busca um registro pela sua chave primária
	public Servico buscarUmServico(Integer idServico) {
		Optional<Servico> servico = servicoRepository.findById(idServico);
		return servico.orElseThrow();
	}
	
	
	// findByFuncionario - busca todos os serviços de um determinado
	//funcionario
	public List<Servico> buscarServicosDoFuncionario(Integer idFuncionario){
	   Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
	   return servicoRepository.findByFuncionario(funcionario);
	}
	
	public List<Servico> buscarServicoPelaData(Date dataEntrada){
		return servicoRepository.findByDataEntrada(dataEntrada);
	}
	
	public List<Servico> buscarServicoPorIntervaloData(Date data1, Date data2){
		return servicoRepository.findByIntervaloData(data1, data2);
	}

	
}
