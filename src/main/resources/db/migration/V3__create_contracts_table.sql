CREATE TABLE contracts (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    monthly_rate_in_cents INT NOT NULL,
    customer_id INT NULL,
    vehicle_id INT NULL UNIQUE,
    CONSTRAINT fk_contracts_customers_id FOREIGN KEY (customer_id) REFERENCES customers (id),
    CONSTRAINT fk_contracts_vehicles_id FOREIGN KEY (vehicle_id) REFERENCES vehicles (id)
);
