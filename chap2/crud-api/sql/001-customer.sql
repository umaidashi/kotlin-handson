CREATE TABLE IF NOT EXISTS customers
(
    id         SERIAL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
)
;

INSERT INTO customers (first_name, last_name)
VALUES ('Alice', 'Sample1'),
       ('Bob', 'Sample2')
;
