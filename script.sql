/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  bglui
 * Created: 24 jul 2024
 */

INSERT INTO reservas (id_alojamiento,total,estatus) VALUES (3,300,'Pendiente');

INSERT INTO detalle_hab_reserva (id_reserva,id_habitacion,fecha_llegada,fecha_salida) VALUES (1,3,'12/03/2024','12/04/2024');