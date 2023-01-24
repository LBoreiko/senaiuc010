CREATE TABLE `produtos` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(200) DEFAULT NULL,
  `valorProduto` decimal(10,0) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `idUnidadeMedida` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `produtos_FK` (`idUnidadeMedida`),
  CONSTRAINT `produtos_FK` FOREIGN KEY (`idUnidadeMedida`) REFERENCES `unidademedida` (`idUnidadeMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `unidademedida` (
  `idUnidadeMedida` int(11) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idUnidadeMedida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `unidademedida` VALUES (1,'Kilos'),(2,'Unidade'),(3,'Litros');

INSERT INTO `produtos` VALUES (1,'Carne',30,2,1),(2,'Óleo',10,1,2),(3,'Leite',5,1,3),(4,'Alface',3,1,2);


