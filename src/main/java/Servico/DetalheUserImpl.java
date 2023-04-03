package Servico;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

import java.util.Optional;


@Component
public class DetalheUserImpl implements UserDetailsService {

         private final RepositorioFuncionario rep;
        
        public DetalheUserImpl(RepositorioFuncionario rep) {
            this.rep = rep;
            }
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            
            Optional<Funcionario> func = rep.findByEmail(username);
            if(func.isPresent()) {
                throw new UsernameNotFoundException("Usuário não encontrado");
            }
            return new DetalheUsuarioData(func);
        }
    

}