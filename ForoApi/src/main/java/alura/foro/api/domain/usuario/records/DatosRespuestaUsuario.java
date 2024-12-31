package alura.foro.api.domain.usuario.records;

import alura.foro.api.domain.usuario.Usuario;

public record DatosRespuestaUsuario(String nombre, String email, String tipo) {

    public DatosRespuestaUsuario(Usuario usuario) {
        this(usuario.getNombre(), usuario.getCorreo(), usuario.getTipo().toString());
    }

}

