    package org.uteq.reservaslabs.entity;

    import jakarta.persistence.*;

    @Entity
    @Table(name = "laboratorios")
    public class Laboratorio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 100)
        private String nombre;

        @Column(nullable = false, length = 150)
        private String ubicacion;

        @Column(nullable = false)
        private Integer capacidad;

        @Column(nullable = false, length = 30)
        private String estado; // Disponible / No disponible

        public Laboratorio() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        public Integer getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(Integer capacidad) {
            this.capacidad = capacidad;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }
