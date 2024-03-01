CREATE DATABASE train_db;
USE train_db;

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE Train (
    id INT AUTO_INCREMENT PRIMARY KEY,
    section VARCHAR(255),
    seat_number VARCHAR(255)
);


CREATE TABLE Ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    train_id INT,
    from_location VARCHAR(255),
    to_location VARCHAR(255),
    price_paid DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (train_id) REFERENCES Train(id)
);

CREATE TABLE userTrainInfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    train_id INT,
    section_number VARCHAR(255),
    seat_number VARCHAR(255)
);


INSERT INTO train_db.user (id, email, first_name, last_name) VALUES (1, 'avirupmondal1994@gmail.com', 'Avirup', 'Mondal');
INSERT INTO train_db.user (id, email, first_name, last_name) VALUES (2, 'monishadev95@gmail.com', 'Monisha', 'Dev');
INSERT INTO train_db.train (id, seat_number, section_no) VALUES (12345, '012', 'A');
INSERT INTO train_db.train (id, seat_number, section_no) VALUES (24680, '014', 'B');

