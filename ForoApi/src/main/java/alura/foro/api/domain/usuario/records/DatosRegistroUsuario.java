package alura.foro.api.domain.usuario.records;

import alura.foro.api.domain.usuario.Tipo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contrasena,
        @NotNull
        Tipo tipo
) {
}
