CREATE TABLE `setor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO `desafio-dev-back-1`.`setor` (`nome`) VALUES ('DP');
INSERT INTO `desafio-dev-back-1`.`setor` (`nome`) VALUES ('RH');

CREATE TABLE `colaborador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf` char(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `setor_id` int DEFAULT NULL,
  `data_nascimento` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  CONSTRAINT `FK_COLABORADOR_SETOR` FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id`)
)
