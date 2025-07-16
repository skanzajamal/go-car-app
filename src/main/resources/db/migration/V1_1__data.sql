-- Data for Cars
insert into car (id, license_plate, seat_count, convertible, rating, engine_type, car_status, manufacturer) values
(1, '12311-ax', 4, TRUE, 4, 'GAS', 'free', 'Skoda'),
(2, '125-cf', 5, FALSE, 3, 'ELECTRIC', 'free', 'Fiat'),
(3, '125-54-c', 2, FALSE, 3, 'GAS', 'free', 'Ford'),
(4, '985-54-c', 7, FALSE, 5, 'HYBRID', 'free', 'BMW'),
(5, '111-44-s', 5, TRUE, 5, 'GAS', 'free', 'AUDI'),
(6, '331-66-sx', 5, TRUE, 5, 'ELECTRIC', 'free', 'VolksWagen');

-- Data for Drivers

-- Create 3 OFFLINE drivers
insert into driver (driver_id, latitude, longitude, status, password, user_name)values
    (1, -33.8688, 151.2093, 'OFFLINE','driver01pw', 'driver01');

insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (2, 40.7128, -74.0060, 'OFFLINE', 'driver02pw', 'driver02');

insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (3, 35.6895, 139.6917, 'OFFLINE', 'driver03pw', 'driver03');

-- Create ONLINE drivers
insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (4, -23.5505, -46.6333, 'ONLINE', 'driver04pw', 'driver04');

insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (5, 55.7558, 37.6173, 'ONLINE','driver05pw', 'driver05');

insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (6, 19.4326, -99.1332, 'ONLINE', 'driver06pw', 'driver06');

insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (7, 55.954, 9.5, 'OFFLINE','driver07pw', 'driver07');

insert into driver (driver_id, latitude, longitude, status, password, user_name) values
    (8, 37.7, 2.3522, 'ONLINE', 'driver08pw', 'driver08');

-- driver 9 and 10 will have cars selected
insert into driver (driver_id, latitude, longitude, status, password, user_name, car_id) values
    (9, 51.5074, -0.1278, 'ONLINE', 'driver09pw', 'driver09', 5);

insert into driver (driver_id, latitude, longitude, status, password, user_name, car_id) values
    (10, 1.3521, 103.8198, 'ONLINE', 'driver10pw', 'driver10', 6);