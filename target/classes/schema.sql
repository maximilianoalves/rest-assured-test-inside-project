DROP TABLE IF EXISTS tutorials;
DROP TABLE IF EXISTS users;

CREATE TABLE tutorials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    published VARCHAR(250) NOT NULL
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(250),
    first_name VARCHAR(250),
    last_name VARCHAR(250),
    password VARCHAR(250),
    role VARCHAR(250)
);
