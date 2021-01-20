CREATE TABLE ACCOUNT_MASTER(  
account_number VARCHAR(50) PRIMARY KEY,  
total_balance float NOT NULL
);    

CREATE TABLE accountname(  
transaction_id INT AUTO_INCREMENT  PRIMARY KEY,  
account_id VARCHAR(50),
FOREIGN KEY (account_id) REFERENCES ACCOUNT_MASTER(account_number),
transaction_type VARCHAR(50) NOT NULL,
transaction_amount float,
date_time date
); 