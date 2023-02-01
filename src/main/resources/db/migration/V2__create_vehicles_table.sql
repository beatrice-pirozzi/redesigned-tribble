CREATE TABLE vehicles (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    model_year SMALLINT NOT NULL,
    vin VARCHAR(17) NULL,
    price_in_cents INT NOT NULL
);
