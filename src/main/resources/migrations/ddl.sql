CREATE DATABASE zhangbu1java;

USE zhangbu1java;
DROP TABLE IF EXISTS `hi_gua`;
CREATE TABLE `hi_gua` (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `display_name` varchar(128) NOT NULL COMMENT 'displayName',
    `inner_id` varchar(128) NOT NULL COMMENT 'innerId',
    `create_at` datetime NOT NULL COMMENT 'createAt',
    `modified_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'modifiedAt',
    primary key `pk_id` (`id`),
    unique key `uk_displayname` (`display_name`)
);

insert hi_gua value (null, 'first_xiaog', 'fgg', NOW(), null);
select * from zhangbu1java.hi_gua;
update hi_gua set inner_id='fgg1' where display_name='first_xiaog';
