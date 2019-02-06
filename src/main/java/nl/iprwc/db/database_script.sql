CREATE TABLE product (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(500) NOT NULL,
	price_cents INTEGER NOT NULL
);
	
CREATE TABLE account (
	email VARCHAR(100) PRIMARY KEY,
	password VARCHAR(32) NOT NULL,
	is_admin BOOLEAN NOT NULL
);
	
CREATE TABLE location (
	account_email VARCHAR(100) REFERENCES account(email) ON DELETE CASCADE NOT NULL,
	street_name VARCHAR(100) NOT NULL,
	house_nr VARCHAR(10) NOT NULL,
	zipcode CHAR(10) NOT NULL,
	city VARCHAR(50) NOT NULL
);
	
CREATE TABLE deliver (
  account_email VARCHAR(100) REFERENCES account(email) ON DELETE RESTRICT NOT NULL,
  product_id INTEGER REFERENCES product(id) NOT NULL,
  amount INTEGER NOT NULL
);

INSERT INTO product VALUES (DEFAULT, 'T480', 'Dit is een kleine laptop' , 90);
INSERT INTO product VALUES (DEFAULT, 'T580', 'Dit is een medium laptop' , 180);
INSERT INTO product VALUES (DEFAULT, 'T680', 'Dit is een grote laptop' , 270);
