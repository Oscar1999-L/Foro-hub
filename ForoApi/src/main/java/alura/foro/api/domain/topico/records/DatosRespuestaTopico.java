package alura.foro.api.domain.topico.records;

import alura.foro.api.domain.topico.Topico;

public record DatosRespuestaTopico(String titulo, String mensaje, String autor, String curso) {

    public DatosRespuestaTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor().getUsername(), topico.getCurso().getNombre());
    }
}
