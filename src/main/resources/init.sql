
INSERT INTO `psbankdb`.`event`
(`id`,
`name`,
`date`,
`time`,
`price`,
`imageUrl`,
`onlineUrl`)
VALUES
(0,
'event1',
STR_TO_DATE('1-01-2012', '%d-%m-%Y'),
'10 am',
'99',
'google.com/image.jpg',
'google.com');

INSERT INTO `psbankdb`.`location`
(`id`,
`street`,
`city`,
`country`,
`eventId`)
VALUES
(0,
'9 grandview',
'jackson',
'usa',
0);
