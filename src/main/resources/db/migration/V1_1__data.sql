-- Data for Cars
insert into car (id, license_plate, seat_count, convertible, rating, engine_type, car_status, manufacturer) values
(1, '12311-ax', 4, TRUE, 2, 'GAS', 'free', 'Skoda'),
(2, '125-cf', 5, FALSE, 3, 'ELECTRIC', 'free', 'Fiat'),
(4, '125-54-c', 2, TRUE, 3, 'GAS', 'free', 'Ford'),
(5, '985-54-c', 3, TRUE, 5, 'HYBRID', 'free', 'BMW'),
(6, '111-44-s', 4, TRUE, 5, 'GAS', 'free', 'AUDI'),
(7, '331-66-sx', 4, TRUE, 5, 'ELECTRIC', 'free', 'VolksWagen');

-- driver 9 and 10 will have cars selected

-- Create 3 OFFLINE drivers

insert into driver (driver_id, coordinate, status, password, user_name)values
    (1, 'OFFLINE','driver01pw', 'driver01');

insert into driver (driver_id, coordinate, status, password, user_name) values
    (2, 'OFFLINE', 'driver02pw', 'driver02');

insert into driver (driver_id, coordinate, status, password, user_name) values
    (3, 'OFFLINE', 'driver03pw', 'driver03');


-- Create 3 ONLINE drivers

insert into driver (driver_id, status, password, user_name) values
    (4, 'ONLINE', 'driver04pw', 'driver04');

insert into driver (driver_id, status, password, user_name) values
    (5, 'ONLINE','driver05pw', 'driver05');

insert into driver (driver_id, status, password, user_name) values
    (6, 'ONLINE', 'driver06pw', 'driver06');

insert into driver (driver_id, status, password, user_name, car_id) values
    (10, 'ONLINE', 'driver10pw', 'driver10', 6);

-- Create 1 OFFLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, status, password, username)
values
    (7,
     'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', 'OFFLINE',
     'driver07pw', 'driver07');

-- Create 1 ONLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, status, password, username)
values
    (8,
     'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', 'ONLINE',
     'driver08pw', 'driver08');

insert into driver (id, coordinate, status, password, username, car_id)
values
    (9,
     'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', 'ONLINE',
     'driver09pw', 'driver09', 7);