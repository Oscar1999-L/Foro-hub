package alura.foro.api.domain.usuario.records;

import alura.foro.api.domain.usuario.Usuario;

public record DatosRespuestaUsuarioId(String nombre, String email, String contrasena, String tipo) {

    public DatosRespuestaUsuarioId(Usuario usuario) {
        this(usuario.getNombre(), usuario.getCorreo(), usuario.getClave(), usuario.getTipo().toString());
    }
}
