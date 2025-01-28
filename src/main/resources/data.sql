DROP TABLE IF EXISTS Flight CASCADE;

CREATE TABLE Flight
(
    id                  INT PRIMARY KEY,
    departureLocation   VARCHAR(255) NOT NULL,
    destinationLocation VARCHAR(255) NOT NULL,
    date                DATE         NOT NULL,
    time                TIME         NOT NULL,
    availableSeats      INT          NOT NULL
);

DROP TABLE IF EXISTS AppUser CASCADE;

CREATE TABLE AppUser
(
    id       INT PRIMARY KEY NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS Booking CASCADE;

CREATE TABLE Booking
(
    id          INT PRIMARY KEY,
    user_id     INT NOT NULL,
    flight      INT NOT NULL,
    seatsBooked INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES AppUser (id),
    FOREIGN KEY (flight) REFERENCES Flight (id)
);


INSERT INTO Flight (id, departureLocation, destinationLocation, date, time, availableSeats)
VALUES (1, 'Baku', 'Kyiv', '2025-02-01', '08:00:00', 300),
       (2, 'London', 'Washington', '2025-02-02', '13:00:00', 250),
       (3, 'Paris', 'Ankara', '2025-02-03', '14:30:00', 200);


INSERT INTO AppUser (id, username, password)
VALUES (1, 'user1', '123abed'),
       (2, 'user2', '163kbas'),
       (3, 'user3', '523ansa');

INSERT INTO Booking (id, user_id, flight, seatsBooked)
VALUES (1, 1, 1, 2),
       (2, 2, 2, 3),
       (3, 3, 3, 5);



