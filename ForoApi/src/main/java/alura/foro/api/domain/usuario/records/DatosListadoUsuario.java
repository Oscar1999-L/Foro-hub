package alura.foro.api.domain.usuario.records;

import alura.foro.api.domain.usuario.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email, String tipo) {

    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getTipo().toString());
    }
}
