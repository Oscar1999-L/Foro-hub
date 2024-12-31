package alura.foro.api.domain.respuesta.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull
        Long id,
        @NotBlank
        String mensaje,
        @NotNull
        Long topicoId,
        @NotBlank
        Long autorId,
        @NotNull
        Boolean solucion
) {
}
