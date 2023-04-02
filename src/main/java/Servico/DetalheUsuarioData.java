package Servico;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.pro4tech.modelo.Funcionario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<Funcionario> funcionario;

    public DetalheUsuarioData(Optional<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return funcionario.orElse(new Funcionario()).getSenha();
    }

    @Override
    public String getUsername() {
        return  funcionario.orElse(new Funcionario()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}