/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  bglui
 * Created: 21 jul 2024
 */
DROP TABLE IF EXISTS estados CASCADE;
DROP TABLE IF EXISTS usuarios CASCADE;
DROP TABLE IF EXISTS cuentas CASCADE;
DROP TABLE IF EXISTS alojamientos CASCADE;
DROP TABLE IF EXISTS habitaciones CASCADE;
DROP TABLE IF EXISTS fotos CASCADE;
DROP TABLE IF EXISTS control_habitaciones CASCADE;
DROP TABLE IF EXISTS servicios_adicionales CASCADE;
DROP TABLE IF EXISTS reservas CASCADE;
DROP TABLE IF EXISTS detalle_hab_reserva CASCADE;
DROP TABLE IF EXISTS detalle_serv_reserva CASCADE;

CREATE TABLE estados (
    id_estado SERIAL PRIMARY KEY,
    nombre VARCHAR(30)
);

CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    correo VARCHAR(50),
    contrasena VARCHAR(50)
);

CREATE TABLE cuentas (
    id_cuenta SERIAL PRIMARY KEY,
    no_cuenta NUMERIC(20),
    banco VARCHAR(20),
    beneficiario VARCHAR(50)
);

CREATE TABLE alojamientos (
    id_alojamiento SERIAL PRIMARY KEY,
    id_usuario INTEGER,
    nombre VARCHAR(50),
    id_estado INTEGER,
    calle VARCHAR(50),
    numero INTEGER,
    codigo_postal INTEGER,
    correo VARCHAR(50),
    telefono INTEGER,
    id_cuenta INTEGER,
    CONSTRAINT fk_estado
        FOREIGN KEY (id_estado)
        REFERENCES estados(id_estado),
    CONSTRAINT fk_cuenta
        FOREIGN KEY (id_cuenta)
        REFERENCES cuentas(id_cuenta)
);

CREATE TABLE habitaciones (
    id_habitacion SERIAL,
    id_alojamiento INTEGER,
    identificador VARCHAR(20),
    capacidad INTEGER,
    costo NUMERIC(5,2),
    cantidad INTEGER,
    descripcion VARCHAR(200),
    PRIMARY KEY (id_habitacion),
    CONSTRAINT unique_id_habitacion
        UNIQUE (id_habitacion),
    CONSTRAINT fk_habitaciones_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento)
);

CREATE TABLE fotos (
    id_alojamiento INTEGER,
    id_habitacion INTEGER,
    ruta VARCHAR(200),
    CONSTRAINT fk_fotos_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento),
    CONSTRAINT fk_fotos_idHabitacion
        FOREIGN KEY (id_habitacion)
        REFERENCES habitaciones(id_habitacion)
);

CREATE TABLE control_habitaciones (
    id_alojamiento INTEGER,
    id_habitacion INTEGER,
    numero SERIAL,
    CONSTRAINT fk_control_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento),
    CONSTRAINT fk_control_idHabitacion
        FOREIGN KEY (id_habitacion)
        REFERENCES habitaciones(id_habitacion)
);

CREATE TABLE servicios_adicionales (
    id_servicio SERIAL PRIMARY KEY,
    id_alojamiento INTEGER,
    costo NUMERIC(4,2),
    descripcion VARCHAR(200),
    CONSTRAINT unique_servicio
        UNIQUE (id_servicio),
    CONSTRAINT fk_servicios_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento)
);

CREATE TABLE reservas (
    id_reserva SERIAL PRIMARY KEY,
    id_alojamiento INTEGER,
    total NUMERIC(5,2),
    estatus VARCHAR(15), 
    CONSTRAINT unique_reserva
        UNIQUE (id_reserva),
    CONSTRAINT fk_reservas_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento),
    CONSTRAINT chk_estatus 
        CHECK (estatus IN ('Pendiente', 'Finalizada', 'Proceso'))
);

CREATE TABLE detalle_hab_reserva (
    id_reserva INTEGER,
    id_alojamiento INTEGER,
    id_habitacion INTEGER,
    fecha_llegada DATE,
    fecha_salida DATE,
    CONSTRAINT fk_detalles_hab_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento),
    CONSTRAINT fk_detalles_hab_idReserva
        FOREIGN KEY (id_reserva)
        REFERENCES reservas(id_reserva),
    CONSTRAINT fk_detalles_hab_idHabitacion
        FOREIGN KEY (id_habitacion)
        REFERENCES habitaciones(id_habitacion)
);

CREATE TABLE detalle_serv_reserva (
    id_reserva INTEGER,
    id_alojamiento INTEGER,
    id_servicio INTEGER,
    CONSTRAINT fk_detalles_serv_idAlojamiento
        FOREIGN KEY (id_alojamiento)
        REFERENCES alojamientos(id_alojamiento),
    CONSTRAINT fk_detalles_serv_idReserva
        FOREIGN KEY (id_reserva)
        REFERENCES reservas(id_reserva),
    CONSTRAINT fk_detalles_serv_idServicio
        FOREIGN KEY (id_servicio)
        REFERENCES servicios_adicionales(id_servicio)
);