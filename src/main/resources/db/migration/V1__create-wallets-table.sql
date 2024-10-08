
CREATE TABLE WALLETS (
  ID SERIAL PRIMARY KEY,
  FULL_NAME VARCHAR(100),
  DOCUMENT BIGINT,
  EMAIL VARCHAR(100),
  PASSWORD VARCHAR(100),
  TYPE INT,
  BALANCE DECIMAL(10, 2)
);

CREATE UNIQUE INDEX document_idx on WALLETS (DOCUMENT);

CREATE UNIQUE INDEX email_idx on WALLETS (EMAIL);