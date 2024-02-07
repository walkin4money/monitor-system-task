insert into sensor_type(name)VALUES ('Pressure');
insert into sensor_type(name)VALUES ('Voltage');
insert into sensor_type(name)VALUES ('Temperature');
insert into sensor_type(name)VALUES ('Humidity');

insert into sensor_unit(name) VALUES ('bar');
insert into sensor_unit(name) VALUES ('voltage');
insert into sensor_unit(name) VALUES ('°С');
insert into sensor_unit(name) VALUES ('%');

insert into users(password, role, status, username) VALUES ('$2a$12$jeeEPHAetJJO5Rmrm9HtWOc3Yq5IFLITrHVKmZrYJF8zp/GOdC9PC','ADMIN','ACTIVE','DANILA');
insert into users(password, role, status, username) VALUES ('$2a$12$jeeEPHAetJJO5Rmrm9HtWOc3Yq5IFLITrHVKmZrYJF8zp/GOdC9PC','USER','ACTIVE','VITALIK');

INSERT INTO sensor (name, model, range_from, range_to, type_id, unit_id, location, description)
VALUES
    ('Sensor1', 'ModelA`', 10, 20, 1, 1, 'Location1', 'Description1'),
    ('Sensor2', 'ModelB1', 15, 25, 2, 2, 'Location2', 'Description2'),
    ('Sensor3', 'ModelC3', 5, 15, 3, 3, 'Location3', 'Description3'),
    ('Sensor4', 'ModelAvxc4', 10, 20, 1, 1, 'Location4', 'Description4'),
    ('Sensor5', 'ModelBdsa5', 15, 25, 2, 2, 'Location5', 'Description5'),
    ('Sensor6', 'ModelCcz6', 5, 15, 3, 3, 'Location6', 'Description6'),
    ('Sensor7', 'ModelCcz7', 5, 15, 3, 3, 'Location7', 'Description7'),
    ('Sensor8', 'ModelCcz8', 5, 15, 3, 3, 'Location8', 'Description8'),
    ('Sensor9', 'ModelCcz9', 5, 15, 3, 3, 'Location9', 'Description9'),
    ('Sensor10', 'Modeld10', 30, 40, 4, 4, 'Location10', 'Description10'),
    ('Sensor11', 'Model11', 30, 40, 4, 4, 'Location11', 'Description11'),
    ('Sensor12', 'Model12', 30, 40, 4, 4, 'Location12', 'Description12');