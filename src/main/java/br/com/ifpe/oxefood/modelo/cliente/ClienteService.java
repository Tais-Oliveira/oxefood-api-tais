package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class ClienteService extends GenericService {
    
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {

        super.preencherCamposAuditoria(cliente);
        return repository.save(cliente);
    }
    

    public List<Cliente> listarTodos() {
  
        return repository.findAll();
    }
 
    public Cliente obterPorID(Long id) {
 
        return repository.findById(id).get();
    }
 
    /*Botão de Alteração*/

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
 
       Cliente cliente = repository.findById(id).get();
       cliente.setNome(clienteAlterado.getNome());
       cliente.setDataNascimento(clienteAlterado.getDataNascimento());
       cliente.setCpf(clienteAlterado.getCpf());
       cliente.setFoneCelular(clienteAlterado.getFoneCelular());
       cliente.setFoneFixo(clienteAlterado.getFoneFixo());
         
       super.preencherCamposAuditoria(cliente);
       repository.save(cliente);
   }
 
}