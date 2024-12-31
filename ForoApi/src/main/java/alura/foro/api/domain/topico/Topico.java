package alura.foro.api.domain.topico;

import alura.foro.api.domain.curso.Curso;
import alura.foro.api.domain.respuesta.Respuesta;
import alura.foro.api.domain.topico.records.DatosActualizarTopico;
import alura.foro.api.domain.topico.records.DatosRegistroTopico;
import alura.foro.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.NO_RESPONDIDO;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "topico_id", referencedColumnName = "id")
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(DatosRegistroTopico datos, Usuario autor, Curso curso){
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor =  autor;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizar, Usuario autor, Curso curso){
        if (datosActualizar.titulo() != null) {
            this.titulo = datosActualizar.titulo();
        }
        if (datosActualizar.mensaje() != null) {
            this.mensaje = datosActualizar.mensaje();
        }
        if (datosActualizar.estado() != null && !this.estado.equals(datosActualizar.estado())) {
            this.estado = datosActualizar.estado();
        }
        if (this.autor != null) {
            this.autor = this.autor;
        }
        if (this.curso != null) {
            this.curso = this.curso;
        }
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
        if (respuesta.getSolucion()) {
            this.estado = Estado.SOLUCIONADO;
        } else {
            this.estado = Estado.NO_SOLUCIONADO;
        }
    }

    public void cerrarTopico() {
        this.estado = Estado.CERRADO;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public Long getId() {
        return id;
    }

    public Usuario getAutor() {
        return autor;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getTitulo() {
        return titulo;
    }
}
