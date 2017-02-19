-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema desbravador
--

CREATE DATABASE IF NOT EXISTS desbravador;
USE desbravador;

--
-- Definition of table `divisao`
--

DROP TABLE IF EXISTS `divisao`;
CREATE TABLE `divisao` (
  `CD_DIVISAO` int(10) unsigned NOT NULL auto_increment,
  `NM_DIVISAO` varchar(75) NOT NULL,
  `NM_SIGLA` varchar(45) NOT NULL,
  PRIMARY KEY  (`CD_DIVISAO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `divisao`
--

/*!40000 ALTER TABLE `divisao` DISABLE KEYS */;
INSERT INTO `divisao` (`CD_DIVISAO`,`NM_DIVISAO`,`NM_SIGLA`) VALUES 
 (2,'DIVISAO SUL AMERICANA','DSA'),
 (3,'DIVISAO CENTRAL AMERICANA','DCA');
/*!40000 ALTER TABLE `divisao` ENABLE KEYS */;


--
-- Definition of trigger `TRG_CAD_DIVISAO`
--

DROP TRIGGER /*!50030 IF EXISTS */ `TRG_CAD_DIVISAO`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `TRG_CAD_DIVISAO` BEFORE INSERT ON `divisao` FOR EACH ROW BEGIN
            SET @NOVA   = NEW.NM_DIVISAO;
            SET @SIGLA  = NEW.NM_SIGLA;
            SET @EXISTE_DIV   = (SELECT COUNT(*) FROM DIVISAO D WHERE D.NM_DIVISAO = @NOVA );
            SET @EXISTE_SIGLA = (SELECT COUNT(*) FROM DIVISAO D WHERE D.NM_SIGLA = @SIGLA );
            IF (@EXISTE_DIV > 0 ) THEN
               CALL FAIL('Divisão já informada anteiormente');
            ELSEIF (@EXISTE_SIGLA > 0) THEN
               CALL FAIL('Sigla já informada anteriormente');
            END IF;
          END $$

DELIMITER ;

--
-- Definition of table `uniao`
--

DROP TABLE IF EXISTS `uniao`;
CREATE TABLE `uniao` (
  `CD_UNIAO` int(10) unsigned NOT NULL auto_increment,
  `NM_UNIAO` varchar(75) NOT NULL,
  `NM_SIGLA` varchar(45) NOT NULL,
  `CD_DIVISAO` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`CD_UNIAO`),
  KEY `FK_UNIAO_1` (`CD_DIVISAO`),
  CONSTRAINT `FK_UNIAO_1` FOREIGN KEY (`CD_DIVISAO`) REFERENCES `divisao` (`CD_DIVISAO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uniao`
--

/*!40000 ALTER TABLE `uniao` DISABLE KEYS */;
/*!40000 ALTER TABLE `uniao` ENABLE KEYS */;


--
-- Definition of procedure `PROC_DIVISAO`
--

DROP PROCEDURE IF EXISTS `PROC_DIVISAO`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_DIVISAO`(
CODIGO INT,
NMDIVISAO VARCHAR(75),
SIGLA   VARCHAR(45),
ACAO    CHAR(1)
)
BEGIN
DECLARE DIVI VARCHAR(75);
DECLARE SIGL VARCHAR(45);
SET DIVI = CONCAT('%',NMDIVISAO,'%');
SET SIGL = CONCAT('%',SIGLA,'%');
CASE
   WHEN ACAO = 'I'  -- CASO SEJA PARA INCLUIR;
     THEN INSERT INTO DIVISAO VALUES (NULL, NMDIVISAO, SIGLA);
   WHEN ACAO = 'A' -- CASEO SEJA PARA ALTERAR
      THEN  UPDATE DIVISAO SET NM_DIVISAO = NMDIVISAO, NM_SIGLA = SIGLA WHERE CD_DIVISAO = CODIGO;
   WHEN ACAO = 'E' -- CASO SEJA PARA EXCLUIR
      THEN  DELETE FROM DIVISAO WHERE CD_DIVISAO = CODIGO;
   WHEN ACAO = 'N' -- CASO SEJA PARA PESQUISAR POR NOME
      THEN SELECT * FROM DIVISAO D WHERE D.NM_DIVISAO LIKE DIVI;
   WHEN ACAO = 'C' -- CASO SEJA PARA PESQUISAR POR CODIGO
      THEN SELECT * FROM DIVISAO D WHERE D.CD_DIVISAO = CODIGO;
   WHEN ACAO = 'T' -- CASO SEJA PARA EXIBIR TODOS
      THEN SELECT * FROM DIVISAO D;
   WHEN ACAO = 'S' -- CASO SEJA PARA PROCURAR POR SIGLA
      THEN SELECT * FROM DIVISAO D WHERE D.NM_SIGLA = SIGL;
END CASE;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
