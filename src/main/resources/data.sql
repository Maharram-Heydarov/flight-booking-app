CREATE TABLE Flight
(
    id                  INT PRIMARY KEY,
    departure_airport   VARCHAR(255)   NOT NULL,
    departureLocation   VARCHAR(255)   NOT NULL,
    destinationLocation VARCHAR(255)   NOT NULL,
    date                DATE           NOT NULL,
    time                TIME           NOT NULL,
    availableSeats      DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Booking
(
    id          INT PRIMARY KEY,
    user        INT NOT NULL,
    flight      INT NOT NULL,
    seatsBooked INT NOT NULL,
    FOREIGN KEY (user) REFERENCES User (id),
    FOREIGN KEY (flight) REFERENCES Flight (id)
);

CREATE TABLE User
(
    id       INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);


INSERT INTO Flight (id, departureLocation, destinationLocation, date, time, availableSeats)
VALUES (1, 'Baku', 'Kyiv', '2025-02-01', '08:00:00', 300.00),
       (2, 'London', 'Washington', '2025-02-02', '13:00:00', 250.00),
       (3, 'Paris', 'Ankara', '2025-02-03', '14:30:00', 200.00);


INSERT INTO Booking (id, user, flight, seatsBooked)
VALUES (1, 1, 'F1', 2),
       (2, 2, 'F2', 3),
       (3, 3, 'F3', 5);


INSERT INTO User (id, username, password)
VALUES (1, 'user1', '123abed'),
       (2, 'user2', '163kbas'),
       (3, 'user3', '523ansa');



