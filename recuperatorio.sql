drop table temas;
use recuperatorio;

CREATE TABLE `temas` (
  `id_tema` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tema` varchar(45) NOT NULL,
  `palabra_clave` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `dia` int(11) NOT NULL,
  `mes` int(11) NOT NULL,
  `año` int(11) NOT NULL,
  PRIMARY KEY (`id_tema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select* from temas;

UPDATE `recuperatorio`.`temas` SET  `nombre_tema` = 'sarasa', `palabra_clave` = 'pol', `dia` = 22, `mes` = 9, `año` = 1999 WHERE `id_tema` = 1;
