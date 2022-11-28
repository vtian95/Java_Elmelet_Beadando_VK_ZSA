CREATE DATABASE IF NOT EXISTS `Cukraszda`
CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `Cukraszda`;

CREATE TABLE `cukraszda`.`suti` ( `id` INT NOT NULL AUTO_INCREMENT, `nev` VARCHAR(32) NOT NULL , `tipus` VARCHAR(32) NOT NULL ,
 `dijazott` BOOLEAN NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `cukraszda`.`tartalom` ( `id` INT NOT NULL AUTO_INCREMENT, `sutiid` INT NOT NULL , `mentes` VARCHAR(4) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;
CREATE TABLE `cukraszda`.`ar` ( `id` INT NOT NULL AUTO_INCREMENT, `sutiid` INT NOT NULL , `ertek` INT NOT NULL , `egyseg` VARCHAR(32) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('1', '32', '500', 'db');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('2', '76', '10900', '16 szeletes');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('3', '106', '4300', '8 szeletes');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('4', '88', '300', 'db');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('5', '116', '16200', '24 szeletes');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('6', '135', '250', 'db');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('7', '127', '4400', 'kg');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('8', '50', '13400', '24 szeletes');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('9', '70', '700', 'db');
INSERT INTO `ar` (`id`, `sutiid`, `ertek`, `egyseg`) VALUES ('10', '31', '5200', 'kg');

insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('1', '26', 'G');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('2', '37', 'L');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('3', '83', 'HC');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('4', '91', 'G');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('5', '137', 'G');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('6', '60', 'Te');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('7', '129', 'HC');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('8', '122', 'To');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('9', '90', 'G');
insert INTO `tartalom` (`id`, `sutiid`, `mentes`) VALUES ('10', '26', 'To');


insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('1', 'Süni', 'vegyes' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('2', 'Gesztenyealagút', 'vegyes' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('3', 'Sajtos pogácsa', 'sós teasütemény' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('4', 'Diós-mákos', 'bejgli' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('5', 'Sajttorta(málnás)', 'torta' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('6', 'Citrom', 'torta' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('7', 'Eszterházy', 'tortaszelet' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('8', 'Rákóczi-túrós', 'pite' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('9', 'Meggyes kocka', 'tejszínes sütemény' , '0');
insert INTO `suti` (`id`, `nev`, `tipus`, `dijazott`) VALUES 
('10', 'Legényfogó', 'torta' , '-1');




