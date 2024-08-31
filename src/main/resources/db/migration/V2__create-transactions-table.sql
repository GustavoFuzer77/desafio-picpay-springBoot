CREATE TABLE TRANSACTIONS (
    ID SERIAL PRIMARY KEY,
    PAYER INT,
    PAYEE INT,
    VALUE DECIMAL(10, 2),
    CREATED_AT TIMESTAMP,
    FOREIGN KEY (PAYER) REFERENCES WALLETS (ID),
    FOREIGN KEY (PAYEE) REFERENCES WALLETS (ID)
)