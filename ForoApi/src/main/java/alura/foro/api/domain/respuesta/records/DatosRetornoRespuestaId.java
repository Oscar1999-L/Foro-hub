package alura.foro.api.domain.respuesta.records;

import alura.foro.api.domain.respuesta.Respuesta;
import alura.foro.api.domain.topico.records.DatosRespuestaTopico;
import alura.foro.api.domain.usuario.records.DatosRespuestaUsuario;

public record DatosRetornoRespuestaId(String mensaje, DatosRespuestaTopico topico, String fechaCreacion, DatosRespuestaUsuario autor, String solucion) {

    public DatosRetornoRespuestaId(Respuesta respuesta) {
        this(respuesta.getMensaje(), new DatosRespuestaTopico(respuesta.getTopico()), respuesta.getFechaCreacion().toString(),
                new DatosRespuestaUsuario(respuesta.getAutor()), respuesta.getSolucion().toString());
    }
}
