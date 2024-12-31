package alura.foro.api.domain.usuario.records;

import alura.foro.api.domain.usuario.Tipo;

public record DatosActualizarUsuario(Long id, String nombre, String email, String contrasena, Tipo tipo) {
}
