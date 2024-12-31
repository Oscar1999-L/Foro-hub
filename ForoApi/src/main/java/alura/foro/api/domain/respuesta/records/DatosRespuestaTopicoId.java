package alura.foro.api.domain.respuesta.records;

import alura.foro.api.domain.curso.DatosRespuestaCurso;
import alura.foro.api.domain.topico.Topico;
import alura.foro.api.domain.usuario.records.DatosRespuestaUsuario;

public record DatosRespuestaTopicoId(Long id, String titulo, String mensaje, String fechaCreacion, String estado, DatosRespuestaUsuario autor,
                                     DatosRespuestaCurso curso) {

    public DatosRespuestaTopicoId(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(),
                topico.getEstado().toString(), new DatosRespuestaUsuario(topico.getAutor()),
                new DatosRespuestaCurso(topico.getCurso()));
    }
}
