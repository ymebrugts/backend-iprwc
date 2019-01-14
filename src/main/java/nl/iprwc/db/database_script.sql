CREATE TABLE item (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(500) NOT NULL,
	price_cents INTEGER NOT NULL
	);
	
CREATE TABLE account (
	email VARCHAR(100) PRIMARY KEY,
	password VARCHAR(32) NOT NULL,
	is_admin INTEGER NOT NULL
	);
	
CREATE TABLE location (
	account_email VARCHAR(100) REFERENCES account(email) ON DELETE CASCADE,
	street_name VARCHAR(100) NOT NULL,
	house_nr VARCHAR(10) NOT NULL,
	zipcode CHAR(10) NOT NULL,
	city VARCHAR(50)
	);
	
CREATE TABLE basket (
	account_email VARCHAR(100) REFERENCES account (email) ON DELETE CASCADE,
	item_id INTEGER UNIQUE NOT NULL REFERENCES item (id) ON DELETE CASCADE
	);
	