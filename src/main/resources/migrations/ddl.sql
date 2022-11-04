CREATE DATABASE zhangbu1java;

USE zhangbu1java;
DROP TABLE IF EXISTS `hi_gua`;
CREATE TABLE `hi_gua` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `displayName` varchar(128) NOT NULL COMMENT 'displayName',
    `innerId` varchar(128) NOT NULL COMMENT 'innerId',
    `createAt` datetime NOT NULL COMMENT 'createAt',
    `modifiedAt` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'modifiedAt',
    primary key `pk_id` (`id`),
    unique key `uk_displayname` (`displayName`)
);

insert hi_gua value (null, 'first_xiaog', 'fgg', NOW(), null);
select * from zhangbu1java.hi_gua;
update hi_gua set innerId='fgg1' where displayName='first_xiaog';
