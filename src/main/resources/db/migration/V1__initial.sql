CREATE TABLE car(
  id                INTEGER       NOT NULL,
  license_plate     VARCHAR(64)   NOT NULL,
  seat_count        VARCHAR(64)   NOT NULL,
  convertible       BOOLEAN,
  rating            VARCHAR(64),
  engine_type       VARCHAR(64),
  car_status        VARCHAR(64),
  manufacturer      VARCHAR(64)   NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE driver(
  driver_id         INTEGER       NOT NULL,
  user_name         VARCHAR(64)   NOT NULL,
  password          VARCHAR(64)   NOT NULL,
  status            VARCHAR(64)   NOT NULL,
  latitude          DOUBLE        NOT NULL,
  longitude         DOUBLE        NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (car_id) REFERENCES car(id)
);