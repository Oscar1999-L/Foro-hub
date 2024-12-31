package alura.foro.api.domain.respuesta.records;

import alura.foro.api.domain.respuesta.Respuesta;

public record DatosRetornoRespuesta(String mensaje, String topico, String autor) {

    public DatosRetornoRespuesta(Respuesta respuesta) {
        this(respuesta.getMensaje(), respuesta.getTopico().getTitulo(), respuesta.getAutor().getNombre());
    }
}
