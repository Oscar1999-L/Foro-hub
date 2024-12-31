package alura.foro.api.domain.respuesta.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Long topicoId,
        @NotNull
        Long autorId,
        @NotBlank
        Boolean solucion
) {
}
