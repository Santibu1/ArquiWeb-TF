INSERT INTO rol (tipo) VALUES ('ADMINISTRADOR');
INSERT INTO rol (tipo) VALUES ('MODERADOR');
INSERT INTO rol (tipo) VALUES ('CLIENTE');

INSERT INTO plan (nombre, costo, duracion_dias, porcentaje_extra, estado) VALUES ('Plan Basico', 9.99, 30, 0.0, 'Activo');
INSERT INTO plan (nombre, costo, duracion_dias, porcentaje_extra, estado) VALUES ('Plan Premium', 19.99, 90, 5.0, 'Activo');
INSERT INTO plan (nombre, costo, duracion_dias, porcentaje_extra, estado) VALUES ('Plan Anual', 49.99, 365, 10.0, 'Activo');

INSERT INTO usuario (nombre, apellido, correo, password, edad, estado, ecobits, id_rol, plan_id) VALUES ('Carlos', 'Admin', 'admin@eco.com', '$2a$12$MH7yW.pGW6vVruvgKqRHS.xm3VN2WVWsnBfNokHm/8hW/nEv9T8FK', 30, 'ACTIVO', 0, 1, 1);
INSERT INTO usuario (nombre, apellido, correo, password, edad, estado, ecobits, id_rol, plan_id) VALUES ('Lucía', 'Moderadora', 'moderador@eco.com', '$2a$12$/lYIOo0DTTIpeJBx7g56GOmJIKEPqFnWZRccrzmwhdwqWy64cdNCi', 28, 'ACTIVO', 0, 2, 1);
INSERT INTO usuario (nombre, apellido, correo, password, edad, estado, ecobits, id_rol, plan_id) VALUES ('Pedro', 'Cliente', 'cliente@eco.com', '$2a$12$3sv2KMRt8mSa59ts8gJ/hehjSurbtoGiLDa1.H5DO5opt/HoLT4Gm', 25, 'ACTIVO', 100, 3, 1);
INSERT INTO usuario (nombre, apellido, correo, password, edad, estado, ecobits, id_rol, plan_id) VALUES ('Ana', 'Premium', 'premium@eco.com', '$2a$12$uZbxt/nURv2wzumBz7E44O8a6I4Sy3Rt8gvP/CL1cuV97FxfVBAZW', 32, 'ACTIVO', 200, 3, 2);
