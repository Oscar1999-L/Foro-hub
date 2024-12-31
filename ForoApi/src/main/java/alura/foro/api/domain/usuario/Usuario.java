package alura.foro.api.domain.usuario;

import alura.foro.api.domain.usuario.records.DatosActualizarUsuario;
import alura.foro.api.domain.usuario.records.DatosRegistroUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clave;
    private String correo;
    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.ROLE_USER;

    public Usuario(DatosRegistroUsuario datos) {
        this.nombre = datos.nombre();
        this.correo = datos.email();
        this.clave = datos.contrasena();
        if (datos.tipo() != this.tipo) {
            this.tipo = datos.tipo();
        }
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizar) {
        if (datosActualizar.nombre() != null) {
            this.nombre = datosActualizar.nombre();
        }
        if (datosActualizar.email() != null) {
            this.correo = datosActualizar.email();
        }
        if (datosActualizar.contrasena() != null) {
            this.clave = datosActualizar.contrasena();
        }
        if (datosActualizar.tipo() != datosActualizar.tipo()) {
            this.tipo = datosActualizar.tipo();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

