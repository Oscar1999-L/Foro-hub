package alura.foro.api.domain.respuesta;
import alura.foro.api.domain.respuesta.records.DatosActualizarRespuesta;
import alura.foro.api.domain.respuesta.records.DatosRegistroRespuesta;
import alura.foro.api.domain.topico.Estado;
import alura.foro.api.domain.topico.Topico;
import alura.foro.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private Boolean solucion = false;

    public Respuesta(DatosRegistroRespuesta datos, Topico topico, Usuario autor) {
        this.mensaje = datos.mensaje();
        this.topico = topico;
        this.autor = autor;
        this.solucion = datos.solucion();
        if (datos.solucion()) {
            this.topico.setEstado(Estado.SOLUCIONADO);
        } else {
            this.topico.setEstado(Estado.NO_SOLUCIONADO);
        }
    }

    public void actualizarDatos(DatosActualizarRespuesta datosActualizar, Topico topico, Usuario autor) {
        if (datosActualizar.mensaje() != null) {
            this.mensaje = datosActualizar.mensaje();
        }
        if (topico != null) {
            this.topico = topico;
        }
        if (autor != null) {
            this.autor = autor;
        }
        if (datosActualizar.solucion() != this.solucion) {
            this.solucion = datosActualizar.solucion();
        }
    }

    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Topico getTopico() {
        return topico;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Boolean getSolucion() {
        return solucion;
    }
}
