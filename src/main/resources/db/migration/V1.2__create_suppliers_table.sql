CREATE TABLE suppliers
(
    id                 uuid PRIMARY KEY,
    fnc_name           VARCHAR(100),
    fnc_cod_fornecedor INTEGER,
    fnc_email          VARCHAR(100),
    fnc_login          VARCHAR(100),
    fnc_senha          VARCHAR(100)

        CONSTRAINT NN_01_NAME CHECK ( fnc_name IS NOT NULL ),
    CONSTRAINT NN_02_COD_FORNECEDOR CHECK ( fnc_cod_fornecedor IS NOT NULL ),
    CONSTRAINT NN_03_EMAIL CHECK ( fnc_email IS NOT NULL),
    CONSTRAINT NN_04_LOGIN CHECK ( fnc_login IS NOT NULL ),
    CONSTRAINT NN_05_SENHA CHECK ( fnc_senha IS NOT NULL )
)
