-- ============================================================================
-- SCRIPT FENCEPRO (v6.0)
-- Contenido: Tablas, Datos, Vistas, Funciones, Procedures, Triggers y Eventos.
-- ============================================================================

DROP DATABASE IF EXISTS fencepro;
CREATE DATABASE fencepro CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE fencepro;

-- Habilitar programador de eventos (necesario para que los Events funcionen)
SET GLOBAL event_scheduler = ON;
SET FOREIGN_KEY_CHECKS = 0;

-- ============================================================================
-- 1. ESTRUCTURA DE TABLAS (SCHEMA)
-- ============================================================================

CREATE TABLE usuarios (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          password_hash VARCHAR(255) NOT NULL,
                          nombre VARCHAR(100) NOT NULL,
                          apellidos VARCHAR(150) NOT NULL,
                          telefono VARCHAR(20),
                          rol ENUM('ADMIN', 'CLUB', 'ENTRENADOR', 'DEPORTISTA', 'ARBITRO') NOT NULL,
                          fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          activo BOOLEAN DEFAULT TRUE,
                          email_verificado BOOLEAN DEFAULT FALSE,
                          INDEX idx_email (email),
                          INDEX idx_rol (rol)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE clubes (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        usuario_id BIGINT UNIQUE NOT NULL,
                        nombre_club VARCHAR(200) NOT NULL,
                        cif VARCHAR(20) UNIQUE NOT NULL,
                        direccion VARCHAR(255),
                        ciudad VARCHAR(100),
                        provincia VARCHAR(100),
                        codigo_postal VARCHAR(10),
                        presidente VARCHAR(150),
                        email_club VARCHAR(100),
                        telefono_club VARCHAR(20),
                        fecha_fundacion DATE,
                        FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                        INDEX idx_ciudad (ciudad),
                        INDEX idx_provincia (provincia)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE deportistas (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             usuario_id BIGINT UNIQUE NOT NULL,
                             dni VARCHAR(20) UNIQUE NOT NULL,
                             fecha_nacimiento DATE NOT NULL,
                             genero ENUM('MASCULINO', 'FEMENINO', 'OTRO') NOT NULL,
                             foto_url VARCHAR(255),
                             categoria ENUM('M15', 'M17', 'M20', 'ABS') NOT NULL,
                             nivel_tecnico ENUM('INICIACION', 'INTERMEDIO', 'AVANZADO', 'COMPETICION') NOT NULL,
                             arma_principal ENUM('FLORETE', 'ESPADA', 'SABLE') NOT NULL,
                             contacto_emergencia VARCHAR(150),
                             telefono_emergencia VARCHAR(20),
                             grupo_sanguineo VARCHAR(5),
                             alergias TEXT,
                             lesiones TEXT,
                             club_id BIGINT,
                             FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                             FOREIGN KEY (club_id) REFERENCES clubes(id) ON DELETE SET NULL,
                             INDEX idx_dni (dni),
                             INDEX idx_club (club_id),
                             INDEX idx_categoria (categoria),
                             INDEX idx_arma (arma_principal)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE entrenadores (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              usuario_id BIGINT UNIQUE NOT NULL,
                              dni VARCHAR(20) UNIQUE NOT NULL,
                              fecha_nacimiento DATE NOT NULL,
                              especialidad ENUM('FLORETE', 'ESPADA', 'SABLE', 'TODAS') NOT NULL,
                              titulacion VARCHAR(200),
                              anos_experiencia INT,
                              numero_licencia VARCHAR(50) UNIQUE,
                              fecha_alta DATE,
                              FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                              INDEX idx_dni_entrenador (dni),
                              INDEX idx_especialidad (especialidad)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE arbitros (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          usuario_id BIGINT UNIQUE NOT NULL,
                          dni VARCHAR(20) UNIQUE NOT NULL,
                          fecha_nacimiento DATE NOT NULL,
                          nivel ENUM('AUTONOMICO', 'NACIONAL', 'INTERNACIONAL') NOT NULL,
                          numero_licencia VARCHAR(50) UNIQUE,
                          fecha_certificacion DATE,
                          competiciones_arbitradas INT DEFAULT 0,
                          FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                          INDEX idx_dni_arbitro (dni),
                          INDEX idx_nivel (nivel)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE pagos (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       usuario_id BIGINT NOT NULL,
                       monto DECIMAL(10,2) NOT NULL,
                       concepto ENUM('LICENCIA', 'INSCRIPCION_COMPETICION', 'CUOTA') NOT NULL,
                       metodo_pago ENUM('TARJETA', 'TRANSFERENCIA', 'EFECTIVO', 'BIZUM') NOT NULL,
                       estado ENUM('PENDIENTE', 'COMPLETADO', 'FALLIDO', 'REEMBOLSADO') DEFAULT 'PENDIENTE',
                       fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       referencia_pago VARCHAR(100) UNIQUE,
                       descripcion TEXT,
                       FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                       INDEX idx_usuario_pago (usuario_id),
                       INDEX idx_estado_pago (estado),
                       INDEX idx_fecha_pago (fecha_pago)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE licencias (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           usuario_id BIGINT NOT NULL,
                           tipo_licencia ENUM('DEPORTISTA', 'ENTRENADOR', 'ARBITRO', 'CLUB') NOT NULL,
                           fecha_emision DATE NOT NULL,
                           fecha_vencimiento DATE NOT NULL,
                           estado ENUM('PENDIENTE', 'APROBADA', 'RECHAZADA', 'CADUCADA') DEFAULT 'PENDIENTE',
                           pago_id BIGINT,
                           fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                           FOREIGN KEY (pago_id) REFERENCES pagos(id) ON DELETE SET NULL,
                           INDEX idx_usuario_licencia (usuario_id),
                           INDEX idx_tipo_licencia (tipo_licencia),
                           INDEX idx_estado_licencia (estado),
                           INDEX idx_fecha_vencimiento (fecha_vencimiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE registros_salud (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 deportista_id BIGINT NOT NULL,
                                 fecha_registro DATE NOT NULL,
                                 peso DECIMAL(5,2),
                                 altura DECIMAL(5,2),
                                 frecuencia_cardiaca INT,
                                 presion_arterial VARCHAR(20),
                                 observaciones TEXT,
                                 certificado_medico BOOLEAN,
                                 fecha_certificado DATE,
                                 fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (deportista_id) REFERENCES deportistas(id) ON DELETE CASCADE,
                                 INDEX idx_deportista_salud (deportista_id),
                                 INDEX idx_fecha_registro (fecha_registro)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE entrenamientos (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                club_id BIGINT NOT NULL,
                                entrenador_id BIGINT NOT NULL,
                                fecha DATE NOT NULL,
                                hora_inicio TIME NOT NULL,
                                hora_fin TIME NOT NULL,
                                arma ENUM('FLORETE', 'ESPADA', 'SABLE') NOT NULL,
                                nivel VARCHAR(50) NOT NULL,
                                capacidad_maxima INT,
                                descripcion TEXT,
                                FOREIGN KEY (club_id) REFERENCES clubes(id) ON DELETE CASCADE,
                                FOREIGN KEY (entrenador_id) REFERENCES entrenadores(id) ON DELETE CASCADE,
                                INDEX idx_club_entrenamiento (club_id),
                                INDEX idx_entrenador_entrenamiento (entrenador_id),
                                INDEX idx_fecha_entrenamiento (fecha),
                                INDEX idx_arma_entrenamiento (arma)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE asistencias (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             entrenamiento_id BIGINT NOT NULL,
                             deportista_id BIGINT NOT NULL,
                             asistio BOOLEAN DEFAULT FALSE,
                             observaciones TEXT,
                             fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (entrenamiento_id) REFERENCES entrenamientos(id) ON DELETE CASCADE,
                             FOREIGN KEY (deportista_id) REFERENCES deportistas(id) ON DELETE CASCADE,
                             UNIQUE KEY uk_entrenamiento_deportista (entrenamiento_id, deportista_id),
                             INDEX idx_entrenamiento_asistencia (entrenamiento_id),
                             INDEX idx_deportista_asistencia (deportista_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE competiciones (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               nombre VARCHAR(200) NOT NULL,
                               descripcion TEXT,
                               fecha_inicio DATE NOT NULL,
                               fecha_fin DATE NOT NULL,
                               ubicacion VARCHAR(255) NOT NULL,
                               arma ENUM('FLORETE', 'ESPADA', 'SABLE') NOT NULL,
                               categoria ENUM('M15', 'M17', 'M20', 'ABS') NOT NULL,
                               nivel ENUM('LOCAL', 'AUTONOMICO', 'NACIONAL', 'INTERNACIONAL') NOT NULL,
                               capacidad_maxima INT,
                               precio_inscripcion DECIMAL(10,2) NOT NULL,
                               estado ENUM('ABIERTA', 'EN_CURSO', 'FINALIZADA', 'CANCELADA') DEFAULT 'ABIERTA',
                               arbitro_id BIGINT,
                               fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (arbitro_id) REFERENCES arbitros(id) ON DELETE SET NULL,
                               INDEX idx_arbitro_competicion (arbitro_id),
                               INDEX idx_fecha_inicio (fecha_inicio),
                               INDEX idx_estado_competicion (estado),
                               INDEX idx_nivel_competicion (nivel),
                               INDEX idx_arma_competicion (arma),
                               INDEX idx_categoria_competicion (categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE inscripciones (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               competicion_id BIGINT NOT NULL,
                               deportista_id BIGINT NOT NULL,
                               estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') DEFAULT 'PENDIENTE',
                               fecha_inscripcion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               observaciones TEXT,
                               FOREIGN KEY (competicion_id) REFERENCES competiciones(id) ON DELETE CASCADE,
                               FOREIGN KEY (deportista_id) REFERENCES deportistas(id) ON DELETE CASCADE,
                               UNIQUE KEY uk_deportista_competicion (deportista_id, competicion_id),
                               INDEX idx_competicion_inscripcion (competicion_id),
                               INDEX idx_deportista_inscripcion (deportista_id),
                               INDEX idx_estado_inscripcion (estado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE resultados (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            inscripcion_id BIGINT UNIQUE NOT NULL,
                            competicion_id BIGINT NOT NULL,
                            posicion INT NOT NULL,
                            puntuacion DECIMAL(10,2),
                            medalla VARCHAR(20),
                            observaciones TEXT,
                            FOREIGN KEY (inscripcion_id) REFERENCES inscripciones(id) ON DELETE CASCADE,
                            FOREIGN KEY (competicion_id) REFERENCES competiciones(id) ON DELETE CASCADE,
                            INDEX idx_inscripcion_resultado (inscripcion_id),
                            INDEX idx_competicion_resultado (competicion_id),
                            INDEX idx_posicion (posicion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ============================================================================
-- 2. CARGA DE DATOS DE PRUEBA (DATA SEEDING)
-- ============================================================================

INSERT INTO usuarios (id, email, password_hash, nombre, apellidos, telefono, rol, email_verificado) VALUES
                                                                                                        (1, 'admin1@fencepro.com', 'hash_admin1', 'Super', 'Admin Uno', '600000001', 'ADMIN', 1),
                                                                                                        (2, 'admin2@fencepro.com', 'hash_admin2', 'Tecnico', 'Admin Dos', '600000002', 'ADMIN', 1),
                                                                                                        (3, 'admin3@fencepro.com', 'hash_admin3', 'Gerente', 'Admin Tres', '600000003', 'ADMIN', 1),
                                                                                                        (4, 'club.madrid@fencepro.com', 'hash_club1', 'Club Esgrima', 'Madrid', '910000001', 'CLUB', 1),
                                                                                                        (5, 'sala.bcn@fencepro.com', 'hash_club2', 'Sala Armas', 'Barcelona', '930000001', 'CLUB', 1),
                                                                                                        (6, 'club.valencia@fencepro.com', 'hash_club3', 'Esgrima', 'Valencia', '960000001', 'CLUB', 1),
                                                                                                        (7, 'club.sevilla@fencepro.com', 'hash_club4', 'Club', 'Hispalis', '950000001', 'CLUB', 1),
                                                                                                        (8, 'club.bilbao@fencepro.com', 'hash_club5', 'Sala', 'Bilbao', '940000001', 'CLUB', 1),
                                                                                                        (9, 'coach.carlos@fencepro.com', 'hash_coach1', 'Carlos', 'García', '610000001', 'ENTRENADOR', 1),
                                                                                                        (10, 'coach.ana@fencepro.com', 'hash_coach2', 'Ana', 'López', '610000002', 'ENTRENADOR', 1),
                                                                                                        (11, 'coach.luis@fencepro.com', 'hash_coach3', 'Luis', 'Martínez', '610000003', 'ENTRENADOR', 1),
                                                                                                        (12, 'coach.elena@fencepro.com', 'hash_coach4', 'Elena', 'Sánchez', '610000004', 'ENTRENADOR', 1),
                                                                                                        (13, 'coach.david@fencepro.com', 'hash_coach5', 'David', 'Ruiz', '610000005', 'ENTRENADOR', 1),
                                                                                                        (14, 'ref.julio@fencepro.com', 'hash_ref1', 'Julio', 'Iglesias', '620000001', 'ARBITRO', 1),
                                                                                                        (15, 'ref.maria@fencepro.com', 'hash_ref2', 'Maria', 'Callas', '620000002', 'ARBITRO', 1),
                                                                                                        (16, 'dep.juan@fencepro.com', 'hash_dep1', 'Juan', 'Pérez', '630000001', 'DEPORTISTA', 1),
                                                                                                        (17, 'dep.lucia@fencepro.com', 'hash_dep2', 'Lucía', 'Gómez', '630000002', 'DEPORTISTA', 1),
                                                                                                        (18, 'dep.marcos@fencepro.com', 'hash_dep3', 'Marcos', 'Alonso', '630000003', 'DEPORTISTA', 1),
                                                                                                        (19, 'dep.sofia@fencepro.com', 'hash_dep4', 'Sofía', 'Vergara', '630000004', 'DEPORTISTA', 1),
                                                                                                        (20, 'dep.pedro@fencepro.com', 'hash_dep5', 'Pedro', 'Pascal', '630000005', 'DEPORTISTA', 1),
                                                                                                        (21, 'dep.carmen@fencepro.com', 'hash_dep6', 'Carmen', 'Maura', '630000006', 'DEPORTISTA', 1),
                                                                                                        (22, 'dep.antonio@fencepro.com', 'hash_dep7', 'Antonio', 'Banderas', '630000007', 'DEPORTISTA', 1),
                                                                                                        (23, 'dep.penelope@fencepro.com', 'hash_dep8', 'Penélope', 'Cruz', '630000008', 'DEPORTISTA', 1),
                                                                                                        (24, 'dep.javier@fencepro.com', 'hash_dep9', 'Javier', 'Bardem', '630000009', 'DEPORTISTA', 1),
                                                                                                        (25, 'dep.elsa@fencepro.com', 'hash_dep10', 'Elsa', 'Pataky', '630000010', 'DEPORTISTA', 1);

INSERT INTO clubes (id, usuario_id, nombre_club, cif, ciudad, provincia) VALUES
                                                                             (1, 4, 'Club Esgrima Madrid', 'G28000001', 'Madrid', 'Madrid'),
                                                                             (2, 5, 'Sala de Armas Barcelona', 'G08000002', 'Barcelona', 'Barcelona'),
                                                                             (3, 6, 'Esgrima Valencia', 'G46000003', 'Valencia', 'Valencia'),
                                                                             (4, 7, 'Club Hispalis', 'G41000004', 'Sevilla', 'Sevilla'),
                                                                             (5, 8, 'Sala Bilbao', 'G48000005', 'Bilbao', 'Vizcaya');

INSERT INTO entrenadores (id, usuario_id, dni, fecha_nacimiento, especialidad, titulacion) VALUES
                                                                                               (1, 9, '10000001A', '1980-01-01', 'FLORETE', 'Maestro de Armas Nivel 3'),
                                                                                               (2, 10, '10000002B', '1985-05-15', 'ESPADA', 'Técnico Deportivo Nivel 2'),
                                                                                               (3, 11, '10000003C', '1990-08-20', 'SABLE', 'Instructor Nivel 1'),
                                                                                               (4, 12, '10000004D', '1982-11-30', 'TODAS', 'Maestro de Armas Internacional'),
                                                                                               (5, 13, '10000005E', '1995-02-14', 'ESPADA', 'Monitor Iniciación');

INSERT INTO arbitros (id, usuario_id, dni, fecha_nacimiento, nivel, competiciones_arbitradas) VALUES
                                                                                                  (1, 14, '20000001X', '1975-03-10', 'INTERNACIONAL', 150),
                                                                                                  (2, 15, '20000002Y', '1988-07-22', 'NACIONAL', 45);

INSERT INTO deportistas (id, usuario_id, dni, fecha_nacimiento, genero, categoria, nivel_tecnico, arma_principal, club_id) VALUES
                                                                                                                               (1, 16, '30000001A', '2005-01-01', 'MASCULINO', 'M20', 'COMPETICION', 'ESPADA', 1),
                                                                                                                               (2, 17, '30000002B', '2008-05-05', 'FEMENINO', 'M17', 'AVANZADO', 'FLORETE', 1),
                                                                                                                               (3, 18, '30000003C', '2010-02-15', 'MASCULINO', 'M15', 'INTERMEDIO', 'SABLE', 2),
                                                                                                                               (4, 19, '30000004D', '1999-11-20', 'FEMENINO', 'ABS', 'COMPETICION', 'ESPADA', 2),
                                                                                                                               (5, 20, '30000005E', '2006-09-09', 'MASCULINO', 'M20', 'AVANZADO', 'FLORETE', 3),
                                                                                                                               (6, 21, '30000006F', '2000-12-12', 'FEMENINO', 'ABS', 'COMPETICION', 'SABLE', 3),
                                                                                                                               (7, 22, '30000007G', '2009-04-04', 'MASCULINO', 'M15', 'INICIACION', 'ESPADA', 4),
                                                                                                                               (8, 23, '30000008H', '2004-06-30', 'FEMENINO', 'M20', 'INTERMEDIO', 'FLORETE', 4),
                                                                                                                               (9, 24, '30000009I', '1995-08-08', 'MASCULINO', 'ABS', 'COMPETICION', 'SABLE', 5),
                                                                                                                               (10, 25,'30000010J', '2007-03-03', 'FEMENINO', 'M17', 'AVANZADO', 'ESPADA', 5);

INSERT INTO pagos (usuario_id, monto, concepto, metodo_pago, estado, referencia_pago) VALUES
                                                                                          (4, 150.00, 'LICENCIA', 'TRANSFERENCIA', 'COMPLETADO', 'REF001'),
                                                                                          (5, 150.00, 'LICENCIA', 'TARJETA', 'COMPLETADO', 'REF002'),
                                                                                          (6, 150.00, 'LICENCIA', 'BIZUM', 'COMPLETADO', 'REF003'),
                                                                                          (7, 150.00, 'LICENCIA', 'EFECTIVO', 'PENDIENTE', 'REF004'),
                                                                                          (8, 150.00, 'LICENCIA', 'TRANSFERENCIA', 'COMPLETADO', 'REF005'),
                                                                                          (9, 50.00, 'LICENCIA', 'TARJETA', 'COMPLETADO', 'REF006'),
                                                                                          (10, 50.00, 'LICENCIA', 'TARJETA', 'FALLIDO', 'REF007'),
                                                                                          (11, 50.00, 'LICENCIA', 'BIZUM', 'COMPLETADO', 'REF008'),
                                                                                          (12, 50.00, 'LICENCIA', 'TARJETA', 'COMPLETADO', 'REF009'),
                                                                                          (13, 50.00, 'LICENCIA', 'TARJETA', 'REEMBOLSADO', 'REF010'),
                                                                                          (14, 40.00, 'LICENCIA', 'TRANSFERENCIA', 'COMPLETADO', 'REF011'),
                                                                                          (15, 40.00, 'LICENCIA', 'BIZUM', 'COMPLETADO', 'REF012'),
                                                                                          (16, 25.00, 'INSCRIPCION_COMPETICION', 'TARJETA', 'COMPLETADO', 'REF013'),
                                                                                          (17, 30.00, 'CUOTA', 'EFECTIVO', 'COMPLETADO', 'REF014'),
                                                                                          (18, 30.00, 'CUOTA', 'TRANSFERENCIA', 'PENDIENTE', 'REF015'),
                                                                                          (19, 25.00, 'INSCRIPCION_COMPETICION', 'TARJETA', 'COMPLETADO', 'REF016'),
                                                                                          (20, 30.00, 'CUOTA', 'BIZUM', 'COMPLETADO', 'REF017'),
                                                                                          (21, 25.00, 'INSCRIPCION_COMPETICION', 'TARJETA', 'COMPLETADO', 'REF018'),
                                                                                          (22, 30.00, 'CUOTA', 'EFECTIVO', 'PENDIENTE', 'REF019'),
                                                                                          (23, 30.00, 'CUOTA', 'TRANSFERENCIA', 'COMPLETADO', 'REF020'),
                                                                                          (24, 45.00, 'LICENCIA', 'TARJETA', 'COMPLETADO', 'REF021'),
                                                                                          (25, 45.00, 'LICENCIA', 'TARJETA', 'COMPLETADO', 'REF022');

INSERT INTO licencias (usuario_id, tipo_licencia, fecha_emision, fecha_vencimiento, estado) VALUES
                                                                                                (25, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 400 DAY), DATE_SUB(NOW(), INTERVAL 35 DAY), 'CADUCADA'),
                                                                                                (24, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 350 DAY), DATE_ADD(NOW(), INTERVAL 15 DAY), 'APROBADA'),
                                                                                                (9, 'ENTRENADOR', DATE_SUB(NOW(), INTERVAL 355 DAY), DATE_ADD(NOW(), INTERVAL 10 DAY), 'APROBADA'),
                                                                                                (16, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (17, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_ADD(NOW(), INTERVAL 10 MONTH), 'APROBADA'),
                                                                                                (18, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 3 MONTH), DATE_ADD(NOW(), INTERVAL 9 MONTH), 'APROBADA'),
                                                                                                (19, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (20, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (21, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (22, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 6 MONTH), DATE_ADD(NOW(), INTERVAL 6 MONTH), 'APROBADA'),
                                                                                                (23, 'DEPORTISTA', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (10, 'ENTRENADOR', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (11, 'ENTRENADOR', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (12, 'ENTRENADOR', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (13, 'ENTRENADOR', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (14, 'ARBITRO', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA'),
                                                                                                (15, 'ARBITRO', DATE_SUB(NOW(), INTERVAL 1 MONTH), DATE_ADD(NOW(), INTERVAL 11 MONTH), 'APROBADA');

INSERT INTO competiciones (nombre, fecha_inicio, fecha_fin, ubicacion, arma, categoria, nivel, precio_inscripcion, estado, arbitro_id) VALUES
                                                                                                                                           ('Campeonato Regional Centro', DATE_SUB(NOW(), INTERVAL 1 DAY), DATE_ADD(NOW(), INTERVAL 1 DAY), 'Madrid Arena', 'ESPADA', 'ABS', 'AUTONOMICO', 25.00, 'EN_CURSO', 1),
                                                                                                                                           ('Torneo Nacional de Invierno', DATE_SUB(NOW(), INTERVAL 2 MONTH), DATE_ADD(DATE_SUB(NOW(), INTERVAL 2 MONTH), INTERVAL 2 DAY), 'Pabellón Bilbao', 'SABLE', 'M20', 'NACIONAL', 30.00, 'FINALIZADA', 1),
                                                                                                                                           ('Open Internacional de Verano', DATE_ADD(NOW(), INTERVAL 3 MONTH), DATE_ADD(DATE_ADD(NOW(), INTERVAL 3 MONTH), INTERVAL 2 DAY), 'Valencia Sports', 'FLORETE', 'ABS', 'INTERNACIONAL', 50.00, 'ABIERTA', 2),
                                                                                                                                           ('Torneo Amistoso Cancelado', DATE_ADD(NOW(), INTERVAL 1 MONTH), DATE_ADD(DATE_ADD(NOW(), INTERVAL 1 MONTH), INTERVAL 1 DAY), 'Sevilla', 'ESPADA', 'M15', 'LOCAL', 15.00, 'CANCELADA', 2);

INSERT INTO entrenamientos (club_id, entrenador_id, fecha, hora_inicio, hora_fin, arma, nivel, descripcion) VALUES
                                                                                                                (1, 1, DATE_ADD(NOW(), INTERVAL 1 DAY), '17:00:00', '19:00:00', 'FLORETE', 'AVANZADO', 'Clase técnica de desplazamientos'),
                                                                                                                (1, 2, DATE_ADD(NOW(), INTERVAL 2 DAY), '18:00:00', '20:00:00', 'ESPADA', 'COMPETICION', 'Asaltos dirigidos'),
                                                                                                                (2, 3, DATE_SUB(NOW(), INTERVAL 5 DAY), '17:30:00', '19:30:00', 'SABLE', 'INTERMEDIO', 'Fundamentos de ataque'),
                                                                                                                (3, 1, DATE_ADD(NOW(), INTERVAL 3 DAY), '16:00:00', '18:00:00', 'FLORETE', 'INICIACION', 'Juegos de coordinación'),
                                                                                                                (4, 5, DATE_ADD(NOW(), INTERVAL 1 DAY), '19:00:00', '21:00:00', 'ESPADA', 'M20', 'Preparación física y asaltos');

INSERT INTO asistencias (entrenamiento_id, deportista_id, asistio, observaciones) VALUES
                                                                                      (3, 3, TRUE, 'Buena actitud'),
                                                                                      (3, 9, FALSE, 'Avisó por enfermedad'),
                                                                                      (1, 2, FALSE, NULL),
                                                                                      (1, 5, FALSE, NULL),
                                                                                      (2, 1, FALSE, NULL);

INSERT INTO inscripciones (competicion_id, deportista_id, estado) VALUES
                                                                      (2, 1, 'CONFIRMADA'), (2, 5, 'CONFIRMADA'), (2, 9, 'CONFIRMADA'),
                                                                      (1, 4, 'CONFIRMADA'), (1, 10, 'CONFIRMADA');

INSERT INTO resultados (inscripcion_id, competicion_id, posicion, puntuacion, medalla) VALUES
                                                                                           (1, 2, 1, 15.0, 'ORO'),
                                                                                           (2, 2, 2, 13.0, 'PLATA'),
                                                                                           (3, 2, 3, 10.0, 'BRONCE');

INSERT INTO registros_salud (deportista_id, fecha_registro, peso, altura, certificado_medico, fecha_certificado) VALUES
                                                                                                                     (1, NOW(), 75.5, 1.82, TRUE, DATE_SUB(NOW(), INTERVAL 1 MONTH)),
                                                                                                                     (4, NOW(), 62.0, 1.70, TRUE, DATE_SUB(NOW(), INTERVAL 2 MONTH));

-- ============================================================================
-- 3. VISTAS DEL SISTEMA (VIEWS)
-- ============================================================================

-- VISTAS DE PAGOS
CREATE OR REPLACE VIEW v_pagos_pendientes AS SELECT p.id, u.email, u.nombre, u.apellidos, p.monto, p.concepto, p.fecha_pago FROM pagos p JOIN usuarios u ON p.usuario_id = u.id WHERE p.estado = 'PENDIENTE';
CREATE OR REPLACE VIEW v_pagos_ingresos_reales AS SELECT id, monto, concepto, metodo_pago, fecha_pago, referencia_pago FROM pagos WHERE estado = 'COMPLETADO' ORDER BY fecha_pago DESC;
CREATE OR REPLACE VIEW v_pagos_incidencias AS SELECT p.id, u.email, p.monto, p.estado, p.descripcion FROM pagos p JOIN usuarios u ON p.usuario_id = u.id WHERE p.estado IN ('FALLIDO', 'REEMBOLSADO');
CREATE OR REPLACE VIEW v_pagos_concepto_licencias AS SELECT * FROM pagos WHERE concepto = 'LICENCIA';
CREATE OR REPLACE VIEW v_pagos_total_por_usuario AS SELECT u.nombre, u.apellidos, COUNT(p.id) as total_transacciones, SUM(p.monto) as total_gastado FROM pagos p JOIN usuarios u ON p.usuario_id = u.id WHERE p.estado = 'COMPLETADO' GROUP BY u.id, u.nombre, u.apellidos;

-- VISTAS DE LICENCIAS
CREATE OR REPLACE VIEW v_licencias_vigentes AS SELECT l.id, u.nombre, u.apellidos, l.tipo_licencia, l.fecha_vencimiento FROM licencias l JOIN usuarios u ON l.usuario_id = u.id WHERE l.estado = 'APROBADA' AND l.fecha_vencimiento >= CURDATE();
CREATE OR REPLACE VIEW v_licencias_por_vencer AS SELECT l.id, u.email, l.tipo_licencia, l.fecha_vencimiento, DATEDIFF(l.fecha_vencimiento, CURDATE()) as dias_restantes FROM licencias l JOIN usuarios u ON l.usuario_id = u.id WHERE l.estado = 'APROBADA' AND l.fecha_vencimiento BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);
CREATE OR REPLACE VIEW v_licencias_caducadas AS SELECT l.id, u.nombre, u.apellidos, l.fecha_vencimiento FROM licencias l JOIN usuarios u ON l.usuario_id = u.id WHERE l.estado = 'CADUCADA' OR (l.estado = 'APROBADA' AND l.fecha_vencimiento < CURDATE());
CREATE OR REPLACE VIEW v_licencias_pendientes_revision AS SELECT l.id, u.nombre, u.apellidos, l.tipo_licencia, l.fecha_solicitud FROM licencias l JOIN usuarios u ON l.usuario_id = u.id WHERE l.estado = 'PENDIENTE';
CREATE OR REPLACE VIEW v_licencias_staff AS SELECT u.nombre, u.apellidos, l.tipo_licencia, l.estado FROM licencias l JOIN usuarios u ON l.usuario_id = u.id WHERE l.tipo_licencia IN ('ENTRENADOR', 'ARBITRO');

-- VISTAS DE INSCRIPCIONES
CREATE OR REPLACE VIEW v_inscripciones_lista_salida AS SELECT i.id, c.nombre as competicion, u.nombre, u.apellidos, d.arma_principal, i.estado FROM inscripciones i JOIN competiciones c ON i.competicion_id = c.id JOIN deportistas d ON i.deportista_id = d.id JOIN usuarios u ON d.usuario_id = u.id WHERE i.estado = 'CONFIRMADA';
CREATE OR REPLACE VIEW v_inscripciones_pendientes AS SELECT i.fecha_inscripcion, c.nombre as torneo, u.nombre as deportista FROM inscripciones i JOIN competiciones c ON i.competicion_id = c.id JOIN deportistas d ON i.deportista_id = d.id JOIN usuarios u ON d.usuario_id = u.id WHERE i.estado = 'PENDIENTE';
CREATE OR REPLACE VIEW v_inscripciones_canceladas AS SELECT i.id, c.nombre, u.email, i.observaciones FROM inscripciones i JOIN competiciones c ON i.competicion_id = c.id JOIN deportistas d ON i.deportista_id = d.id JOIN usuarios u ON d.usuario_id = u.id WHERE i.estado = 'CANCELADA';
CREATE OR REPLACE VIEW v_inscripciones_conteo_torneo AS SELECT c.nombre, COUNT(i.id) as total_inscritos, c.capacidad_maxima FROM competiciones c LEFT JOIN inscripciones i ON c.id = i.competicion_id AND i.estado = 'CONFIRMADA' GROUP BY c.id, c.nombre, c.capacidad_maxima;
CREATE OR REPLACE VIEW v_inscripciones_recientes AS SELECT * FROM inscripciones WHERE fecha_inscripcion >= DATE_SUB(NOW(), INTERVAL 7 DAY);

-- VISTAS DE DEPORTISTAS
CREATE OR REPLACE VIEW v_deportistas_ficha_completa AS SELECT d.id, u.nombre, u.apellidos, d.categoria, d.arma_principal, c.nombre_club FROM deportistas d JOIN usuarios u ON d.usuario_id = u.id LEFT JOIN clubes c ON d.club_id = c.id;
CREATE OR REPLACE VIEW v_deportistas_elite AS SELECT u.nombre, u.apellidos, d.categoria, d.arma_principal FROM deportistas d JOIN usuarios u ON d.usuario_id = u.id WHERE d.nivel_tecnico = 'COMPETICION';
CREATE OR REPLACE VIEW v_deportistas_alertas_medicas AS SELECT u.nombre, u.apellidos, u.telefono, d.alergias, d.lesiones, d.contacto_emergencia, d.telefono_emergencia FROM deportistas d JOIN usuarios u ON d.usuario_id = u.id WHERE d.alergias IS NOT NULL OR d.lesiones IS NOT NULL;
CREATE OR REPLACE VIEW v_deportistas_cantera AS SELECT u.nombre, u.apellidos, d.fecha_nacimiento, d.categoria FROM deportistas d JOIN usuarios u ON d.usuario_id = u.id WHERE d.categoria IN ('M15', 'M17', 'M20');
CREATE OR REPLACE VIEW v_deportistas_sin_club AS SELECT u.nombre, u.apellidos, u.email, d.arma_principal FROM deportistas d JOIN usuarios u ON d.usuario_id = u.id WHERE d.club_id IS NULL;

-- VISTAS DE COMPETICIONES
CREATE OR REPLACE VIEW v_competiciones_abiertas AS SELECT id, nombre, fecha_inicio, ubicacion, precio_inscripcion FROM competiciones WHERE estado = 'ABIERTA';
CREATE OR REPLACE VIEW v_competiciones_calendario AS SELECT fecha_inicio, fecha_fin, nombre, ubicacion, nivel FROM competiciones ORDER BY fecha_inicio ASC;
CREATE OR REPLACE VIEW v_competiciones_internacionales AS SELECT nombre, ubicacion, arma, categoria FROM competiciones WHERE nivel = 'INTERNACIONAL';
CREATE OR REPLACE VIEW v_competiciones_live AS SELECT nombre, ubicacion, arbitro_id FROM competiciones WHERE estado = 'EN_CURSO';
CREATE OR REPLACE VIEW v_competiciones_precios AS SELECT nombre, nivel, precio_inscripcion FROM competiciones ORDER BY precio_inscripcion DESC;

-- ============================================================================
-- 4. FUNCIONES ALMACENADAS (STORED FUNCTIONS)
-- ============================================================================
DELIMITER //

CREATE FUNCTION f_calcular_edad(fecha_nac DATE) RETURNS INT DETERMINISTIC
BEGIN RETURN TIMESTAMPDIFF(YEAR, fecha_nac, CURDATE()); END //

CREATE FUNCTION f_obtener_categoria_sugerida(fecha_nac DATE) RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
    DECLARE edad INT; SET edad = TIMESTAMPDIFF(YEAR, fecha_nac, CURDATE());
    IF edad < 15 THEN RETURN 'M15'; ELSEIF edad < 17 THEN RETURN 'M17'; ELSEIF edad < 20 THEN RETURN 'M20'; ELSE RETURN 'ABS'; END IF;
END //

CREATE FUNCTION f_tiene_licencia_activa(p_deportista_id BIGINT) RETURNS BOOLEAN READS SQL DATA
BEGIN
    DECLARE v_conteo INT;
SELECT COUNT(*) INTO v_conteo FROM licencias l JOIN deportistas d ON l.usuario_id = d.usuario_id WHERE d.id = p_deportista_id AND l.tipo_licencia = 'DEPORTISTA' AND l.estado = 'APROBADA' AND l.fecha_vencimiento >= CURDATE();
RETURN (v_conteo > 0);
END //

CREATE FUNCTION f_plazas_disponibles_torneo(p_competicion_id BIGINT) RETURNS INT READS SQL DATA
BEGIN
    DECLARE v_capacidad INT; DECLARE v_inscritos INT;
SELECT capacidad_maxima INTO v_capacidad FROM competiciones WHERE id = p_competicion_id;
SELECT COUNT(*) INTO v_inscritos FROM inscripciones WHERE competicion_id = p_competicion_id AND estado = 'CONFIRMADA';
IF v_capacidad IS NULL THEN RETURN 9999; END IF;
RETURN (v_capacidad - v_inscritos);
END //

CREATE FUNCTION f_generar_referencia_pago() RETURNS VARCHAR(50) NOT DETERMINISTIC
BEGIN
    DECLARE chars_str VARCHAR(20) DEFAULT 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    DECLARE random_str VARCHAR(5) DEFAULT '';
    DECLARE i INT DEFAULT 1;
    WHILE i <= 4 DO SET random_str = CONCAT(random_str, SUBSTRING(chars_str, FLOOR(1 + RAND() * 36), 1)); SET i = i + 1; END WHILE;
RETURN CONCAT('PAY-', DATE_FORMAT(NOW(), '%Y%m%d'), '-', random_str);
END //

CREATE FUNCTION f_calcular_rendimiento(p_deportista_id BIGINT) RETURNS DECIMAL(5,2) READS SQL DATA
BEGIN
    DECLARE v_total_torneos INT; DECLARE v_total_medallas INT;
SELECT COUNT(*) INTO v_total_torneos FROM inscripciones i JOIN competiciones c ON i.competicion_id = c.id WHERE i.deportista_id = p_deportista_id AND c.estado = 'FINALIZADA';
IF v_total_torneos = 0 THEN RETURN 0.00; END IF;
SELECT COUNT(*) INTO v_total_medallas FROM resultados r JOIN inscripciones i ON r.inscripcion_id = i.id WHERE i.deportista_id = p_deportista_id AND r.medalla IS NOT NULL;
RETURN (v_total_medallas / v_total_torneos) * 100;
END //

-- ============================================================================
-- 5. PROCEDIMIENTOS ALMACENADOS (STORED PROCEDURES)
-- ============================================================================

-- PROC 1: Registro Completo
CREATE PROCEDURE sp_registrar_deportista_completo(IN p_email VARCHAR(100), IN p_password VARCHAR(255), IN p_nombre VARCHAR(100), IN p_apellidos VARCHAR(150), IN p_dni VARCHAR(20), IN p_fecha_nac DATE, IN p_genero ENUM('MASCULINO', 'FEMENINO', 'OTRO'), IN p_arma ENUM('FLORETE', 'ESPADA', 'SABLE'), IN p_categoria ENUM('M15', 'M17', 'M20', 'ABS'), IN p_nivel ENUM('INICIACION', 'INTERMEDIO', 'AVANZADO', 'COMPETICION'))
BEGIN
    DECLARE new_user_id BIGINT;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION BEGIN ROLLBACK; SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error Transaccion Abortada'; END;
START TRANSACTION;
INSERT INTO usuarios (email, password_hash, nombre, apellidos, rol, activo) VALUES (p_email, p_password, p_nombre, p_apellidos, 'DEPORTISTA', TRUE);
SET new_user_id = LAST_INSERT_ID();
INSERT INTO deportistas (usuario_id, dni, fecha_nacimiento, genero, categoria, nivel_tecnico, arma_principal) VALUES (new_user_id, p_dni, p_fecha_nac, p_genero, p_categoria, p_nivel, p_arma);
COMMIT;
END //

-- PROC 2: Inscribir Torneo
CREATE PROCEDURE sp_inscribir_torneo(IN p_deportista_id BIGINT, IN p_competicion_id BIGINT)
BEGIN
    DECLARE v_estado VARCHAR(20); DECLARE v_arma_t VARCHAR(20); DECLARE v_arma_d VARCHAR(20); DECLARE v_precio DECIMAL(10,2);
SELECT estado, arma, precio_inscripcion INTO v_estado, v_arma_t, v_precio FROM competiciones WHERE id = p_competicion_id;
SELECT arma_principal INTO v_arma_d FROM deportistas WHERE id = p_deportista_id;
IF v_estado != 'ABIERTA' THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Competición cerrada.'; END IF;
    IF v_arma_t != v_arma_d THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Arma incorrecta.'; END IF;
INSERT INTO inscripciones (competicion_id, deportista_id, estado, fecha_inscripcion) VALUES (p_competicion_id, p_deportista_id, 'PENDIENTE', NOW());
INSERT INTO pagos (usuario_id, monto, concepto, metodo_pago, estado, descripcion) SELECT usuario_id, v_precio, 'INSCRIPCION_COMPETICION', 'TARJETA', 'PENDIENTE', CONCAT('Torneo ID ', p_competicion_id) FROM deportistas WHERE id = p_deportista_id;
END //

-- PROC 3: Cobros Masivos
CREATE PROCEDURE sp_generar_cobros_licencias_anuales(IN p_club_id BIGINT, IN p_monto DECIMAL(10,2))
BEGIN
INSERT INTO pagos (usuario_id, monto, concepto, metodo_pago, estado, descripcion)
SELECT d.usuario_id, p_monto, 'LICENCIA', 'TRANSFERENCIA', 'PENDIENTE', CONCAT('Renovación Anual ', YEAR(NOW())) FROM deportistas d JOIN usuarios u ON d.usuario_id = u.id WHERE d.club_id = p_club_id AND u.activo = TRUE;
END //

-- PROC 4: Registrar Resultados
CREATE PROCEDURE sp_registrar_resultado_final(IN p_competicion_id BIGINT, IN p_deportista_id BIGINT, IN p_posicion INT, IN p_puntuacion DECIMAL(10,2))
BEGIN
    DECLARE v_inscripcion_id BIGINT; DECLARE v_medalla VARCHAR(20) DEFAULT NULL;
SELECT id INTO v_inscripcion_id FROM inscripciones WHERE competicion_id = p_competicion_id AND deportista_id = p_deportista_id;
IF v_inscripcion_id IS NULL THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No inscrito.'; END IF;
    IF p_posicion = 1 THEN SET v_medalla = 'ORO'; ELSEIF p_posicion = 2 THEN SET v_medalla = 'PLATA'; ELSEIF p_posicion = 3 THEN SET v_medalla = 'BRONCE'; END IF;
INSERT INTO resultados (inscripcion_id, competicion_id, posicion, puntuacion, medalla) VALUES (v_inscripcion_id, p_competicion_id, p_posicion, p_puntuacion, v_medalla) ON DUPLICATE KEY UPDATE posicion = p_posicion, puntuacion = p_puntuacion, medalla = v_medalla;
UPDATE inscripciones SET estado = 'CONFIRMADA' WHERE id = v_inscripcion_id;
END //

-- PROC 5: Reporte Club
CREATE PROCEDURE sp_reporte_estado_club(IN p_club_id BIGINT)
BEGIN
SELECT c.nombre_club, (SELECT COUNT(*) FROM deportistas WHERE club_id = p_club_id) as total_deportistas, (SELECT COUNT(*) FROM entrenamientos WHERE club_id = p_club_id AND fecha >= CURDATE()) as entrenamientos_proximos, (SELECT IFNULL(SUM(monto), 0) FROM pagos p JOIN usuarios u ON p.usuario_id = u.id JOIN deportistas d ON d.usuario_id = u.id WHERE d.club_id = p_club_id AND p.estado = 'PENDIENTE') as deuda_pendiente_cobro FROM clubes c WHERE c.id = p_club_id;
END //

DELIMITER ;

-- ============================================================================
-- 6. TRIGGERS (13 REGLAS)
-- ============================================================================
DELIMITER //

CREATE TRIGGER trg_check_rol_deportista_insert BEFORE INSERT ON deportistas FOR EACH ROW BEGIN DECLARE user_rol VARCHAR(20); SELECT rol INTO user_rol FROM usuarios WHERE id = NEW.usuario_id; IF user_rol != 'DEPORTISTA' THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error Rol'; END IF; END //
CREATE TRIGGER trg_check_fechas_competicion BEFORE INSERT ON competiciones FOR EACH ROW BEGIN IF NEW.fecha_fin < NEW.fecha_inicio THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error Fechas'; END IF; END //
CREATE TRIGGER trg_check_cupo_competicion BEFORE INSERT ON inscripciones FOR EACH ROW BEGIN DECLARE cap INT; DECLARE ins INT; SELECT capacidad_maxima INTO cap FROM competiciones WHERE id = NEW.competicion_id; SELECT COUNT(*) INTO ins FROM inscripciones WHERE competicion_id = NEW.competicion_id AND estado = 'CONFIRMADA'; IF cap IS NOT NULL AND ins >= cap THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Torneo Lleno'; END IF; END //
CREATE TRIGGER trg_check_cupo_entrenamiento BEFORE INSERT ON asistencias FOR EACH ROW BEGIN DECLARE cap INT; DECLARE asis INT; SELECT capacidad_maxima INTO cap FROM entrenamientos WHERE id = NEW.entrenamiento_id; SELECT COUNT(*) INTO asis FROM asistencias WHERE entrenamiento_id = NEW.entrenamiento_id; IF cap IS NOT NULL AND asis >= cap THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Clase Llena'; END IF; END //
CREATE TRIGGER trg_validar_licencia_para_competir BEFORE INSERT ON inscripciones FOR EACH ROW BEGIN DECLARE lic_ok INT; SELECT COUNT(*) INTO lic_ok FROM licencias l JOIN deportistas d ON d.usuario_id = l.usuario_id WHERE d.id = NEW.deportista_id AND l.tipo_licencia = 'DEPORTISTA' AND l.estado = 'APROBADA' AND l.fecha_vencimiento >= CURDATE(); IF lic_ok = 0 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Sin Licencia'; END IF; END //
CREATE TRIGGER trg_bloquear_resultados_torneo_cerrado BEFORE UPDATE ON resultados FOR EACH ROW BEGIN DECLARE est VARCHAR(20); SELECT estado INTO est FROM competiciones WHERE id = NEW.competicion_id; IF est = 'CANCELADA' THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Torneo Cancelado'; END IF; END //
CREATE TRIGGER trg_activar_licencia_tras_pago AFTER UPDATE ON pagos FOR EACH ROW BEGIN IF NEW.estado = 'COMPLETADO' AND OLD.estado != 'COMPLETADO' AND NEW.concepto = 'LICENCIA' THEN UPDATE licencias SET estado = 'APROBADA' WHERE pago_id = NEW.id; END IF; END //
CREATE TRIGGER trg_auto_vencimiento_licencia BEFORE INSERT ON licencias FOR EACH ROW BEGIN IF NEW.fecha_vencimiento IS NULL THEN SET NEW.fecha_vencimiento = DATE_ADD(NEW.fecha_emision, INTERVAL 1 YEAR); END IF; END //
CREATE TRIGGER trg_audit_cancelacion_inscripcion BEFORE UPDATE ON inscripciones FOR EACH ROW BEGIN IF NEW.estado = 'CANCELADA' AND OLD.estado != 'CANCELADA' THEN SET NEW.observaciones = CONCAT(IFNULL(OLD.observaciones, ''), ' [Cancelado: ', NOW(), ']'); END IF; END //
CREATE TRIGGER trg_check_dni_unico_global_entrenador BEFORE INSERT ON entrenadores FOR EACH ROW BEGIN IF (SELECT COUNT(*) FROM deportistas WHERE dni = NEW.dni) > 0 OR (SELECT COUNT(*) FROM arbitros WHERE dni = NEW.dni) > 0 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DNI Duplicado'; END IF; END //
CREATE TRIGGER trg_bloquear_modificacion_pago_completado BEFORE UPDATE ON pagos FOR EACH ROW BEGIN IF OLD.estado = 'COMPLETADO' AND NEW.monto != OLD.monto THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No modificar pagados'; END IF; END //
CREATE TRIGGER trg_check_fecha_nacimiento_valida BEFORE INSERT ON deportistas FOR EACH ROW BEGIN IF NEW.fecha_nacimiento > CURDATE() THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nacimiento futuro invalido'; END IF; END //
CREATE TRIGGER trg_auto_incrementar_experiencia_arbitro AFTER UPDATE ON competiciones FOR EACH ROW BEGIN IF NEW.estado = 'FINALIZADA' AND OLD.estado != 'FINALIZADA' AND NEW.arbitro_id IS NOT NULL THEN UPDATE arbitros SET competiciones_arbitradas = competiciones_arbitradas + 1 WHERE id = NEW.arbitro_id; END IF; END //

DELIMITER ;

-- ============================================================================
-- 7. EVENTOS PROGRAMADOS (SCHEDULED EVENTS)
-- ============================================================================
DELIMITER //

-- Evento 1: Cierre automático de competiciones finalizadas ayer
CREATE EVENT evt_cerrar_competiciones_finalizadas
ON SCHEDULE EVERY 1 DAY
STARTS (TIMESTAMP(CURRENT_DATE) + INTERVAL 1 DAY + INTERVAL 3 HOUR) -- 03:00 AM
DO
UPDATE competiciones SET estado = 'FINALIZADA'
WHERE fecha_fin < CURDATE() AND estado IN ('ABIERTA', 'EN_CURSO');
//

-- Evento 2: Marcar licencias vencidas como CADUCADA
CREATE EVENT evt_caducar_licencias_vencidas
ON SCHEDULE EVERY 1 DAY
STARTS (TIMESTAMP(CURRENT_DATE) + INTERVAL 1 DAY + INTERVAL 4 HOUR) -- 04:00 AM
DO
UPDATE licencias SET estado = 'CADUCADA'
WHERE fecha_vencimiento < CURDATE() AND estado = 'APROBADA';
//

-- Evento 3: Limpieza de Pagos 'Zombis' (Pendientes > 30 días)
CREATE EVENT evt_limpiar_pagos_pendientes_antiguos
ON SCHEDULE EVERY 1 WEEK
STARTS (TIMESTAMP(CURRENT_DATE) + INTERVAL 1 DAY + INTERVAL 5 HOUR) -- 05:00 AM Domingo
DO
UPDATE pagos SET estado = 'FALLIDO', descripcion = CONCAT(IFNULL(descripcion, ''), ' [Auto-Cancelado por Sistema]')
WHERE estado = 'PENDIENTE' AND fecha_pago < DATE_SUB(NOW(), INTERVAL 30 DAY);
//

DELIMITER ;

SET FOREIGN_KEY_CHECKS = 1;

-- ============================================================================
-- 8. DIAGNÓSTICO FINAL COMPLETO
-- ============================================================================

SELECT '--- 1. CONTEO DE FILAS (DATOS) ---' AS Seccion;
SELECT 'Usuarios' as Tabla, COUNT(*) as Total FROM usuarios
UNION ALL SELECT 'Clubes', COUNT(*) FROM clubes
UNION ALL SELECT 'Deportistas', COUNT(*) FROM deportistas
UNION ALL SELECT 'Entrenadores', COUNT(*) FROM entrenadores
UNION ALL SELECT 'Arbitros', COUNT(*) FROM arbitros
UNION ALL SELECT 'Pagos', COUNT(*) FROM pagos
UNION ALL SELECT 'Licencias', COUNT(*) FROM licencias
UNION ALL SELECT 'Competiciones', COUNT(*) FROM competiciones
UNION ALL SELECT 'Inscripciones', COUNT(*) FROM inscripciones
UNION ALL SELECT 'Resultados', COUNT(*) FROM resultados;

SELECT '--- 2. OBJETOS DE BASE DE DATOS ---' AS Seccion;

-- Conteo de Vistas
SELECT 'Vistas (Views)' AS Objeto, COUNT(*) AS Cantidad FROM information_schema.views WHERE table_schema = 'fencepro'
UNION ALL
-- Conteo de Triggers
SELECT 'Triggers', COUNT(*) FROM information_schema.triggers WHERE trigger_schema = 'fencepro'
UNION ALL
-- Conteo de Procedimientos y Funciones
SELECT routine_type, COUNT(*) FROM information_schema.routines WHERE routine_schema = 'fencepro' GROUP BY routine_type
UNION ALL
-- Conteo de Eventos
SELECT 'Eventos (Events)', COUNT(*) FROM information_schema.events WHERE event_schema = 'fencepro';

-- Tamaño Total
SELECT table_schema AS 'Base de Datos', ROUND(SUM(data_length + index_length) / 1024 / 1024, 2) AS 'Tamaño (MB)'
FROM information_schema.tables WHERE table_schema = 'fencepro' GROUP BY table_schema;
