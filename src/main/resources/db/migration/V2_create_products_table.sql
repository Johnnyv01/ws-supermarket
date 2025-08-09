CREATE TABLE products
(
    pdt_id     UUID PRIMARY KEY,
    pdt_name   VARCHAR(100),
    pdt_price  DECIMAL,
    pdt_usr_id UUID,

    CONSTRAINT NN_01_NAME CHECK (pdt_name IS NOT NULL),
    CONSTRAINT NN_02_PRICE CHECK (pdt_price IS NOT NULL),
    CONSTRAINT FK_PDT_USR_ID FOREIGN KEY (pdt_usr_id) REFERENCES USERS (usr_id)
);
