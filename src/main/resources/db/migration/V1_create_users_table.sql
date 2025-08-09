CREATE TABLE USERS
(
    usr_id         uuid primary key,
    usr_name       VARCHAR(100),
    usr_email      VARCHAR(100),
    usr_telefone   VARCHAR(100),
    usr_ativo      bit,
    usr_dt_acoes DATE,

    CONSTRAINT NN_01_NAME check ( usr_name IS NOT NULL ),
    CONSTRAINT NN_02_EMAIL check ( usr_email IS NOT NULL ),
    CONSTRAINT NN_03_TELEFONE check ( usr_telefone IS NOT NULL ),
    CONSTRAINT NN_04_ATIVO check ( usr_ativo IS NOT NULL ),
    CONSTRAINT  NN_05_DT_ACOES check ( usr_dt_acoes IS NOT NULL )
)
