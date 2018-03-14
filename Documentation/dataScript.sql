use donation;

/* DATA */
INSERT INTO donation.USUARIO VALUES(1,'rcolocho',md5('rcolocho1$'),'2018-12-03');

INSERT INTO country VALUES(1,'Afghanistan');
INSERT INTO country VALUES(2,'Albania');
INSERT INTO country VALUES(3,'Argentina');
INSERT INTO country VALUES(4,'Austria');
INSERT INTO country VALUES(5,'Belize');
INSERT INTO country VALUES(6,'Chile');
INSERT INTO country VALUES(7,'China');
INSERT INTO country VALUES(8,'Republic of the Congo');
INSERT INTO country VALUES(9,'El Salvador');
INSERT INTO country VALUES(10,'Greece');

INSERT INTO department values(1,1,'Department 1 Afghanistan');
INSERT INTO department values(2,1,'Department 2 Afghanistan');
INSERT INTO department values(3,1,'Department 3 Afghanistan');
INSERT INTO department values(4,1,'Department 4 Afghanistan');

INSERT INTO department values(5,9,'Department 1 El Salvador');
INSERT INTO department values(6,9,'Department 2 El Salvador');
INSERT INTO department values(7,9,'Department 3 El Salvador');
INSERT INTO department values(8,9,'Department 4 El Salvador');

INSERT INTO institution VALUES(1,1,'institution 1 Afghanistan','2018-03-13');
INSERT INTO institution VALUES(2,2,'institution 2 Afghanistan','2018-03-13');
INSERT INTO institution VALUES(3,3,'institution 3 Afghanistan','2018-03-13');
INSERT INTO institution VALUES(4,4,'institution 4 Afghanistan','2018-03-13');
INSERT INTO institution VALUES(5,3,'institution 5 Afghanistan','2018-03-13');


INSERT INTO institution VALUES(6,5,'institution 1 El Salvador','2018-03-13');
INSERT INTO institution VALUES(7,6,'institution 2 El Salvador','2018-03-13');
INSERT INTO institution VALUES(8,7,'institution 3 El Salvador','2018-03-13');
INSERT INTO institution VALUES(9,8,'institution 4 El Salvador','2018-03-13');
INSERT INTO institution VALUES(10,8,'institution 5 El Salvador','2018-03-13');



INSERT INTO donation(IDUSUARIO,ID_INSTITUTION,AMOUNT,CREDITCARD,TYPE_CREDIT_CARD,DONATION_DATE) 
VALUES(1,1,3000.55,'1229292929','V','2017-10-13');

INSERT INTO  donation(IDUSUARIO,ID_INSTITUTION,AMOUNT,CREDITCARD,TYPE_CREDIT_CARD,DONATION_DATE)
VALUES(1,6,4000.55,'1229292929','V','2017-11-12');

INSERT INTO  donation(IDUSUARIO,ID_INSTITUTION,AMOUNT,CREDITCARD,TYPE_CREDIT_CARD,DONATION_DATE)
VALUES(1,1,5000.55,'1229292929','V','2017-12-12');

INSERT INTO  donation(IDUSUARIO,ID_INSTITUTION,AMOUNT,CREDITCARD,TYPE_CREDIT_CARD,DONATION_DATE)
 VALUES(1,6,6000.55,'1229292929','V','2018-02-13');








