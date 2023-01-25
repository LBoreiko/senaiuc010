Criando Usuário

CREATE USER 'Leonardo Boreiko'@'comabem' IDENTIFIED BY '1234';
SET PASSWORD FOR 'Leonardo Boreiko'@'comabem' = PASSWORD('1234');



Liberar acesso 

GRANT Grant option ON *.* TO 'Leonardo Boreiko'@'comabem' WITH GRANT OPTION;

Restringir Acesso 

REVOKE Grant option ON *.* FROM 'Leonardo Boreiko'@'comabem';
GRANT Event ON *.* TO 'Leonardo Boreiko'@'comabem';



