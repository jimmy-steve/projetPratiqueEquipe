

insert into client (no_client, nom_client, no_telephone)
values
(10,'Luc Samsom', '(999)999-9999'),
(20,'Dollard Tremplay', '(888)888-8888'),
(30,'Lin Bo', '(777)777-7777'),
(40,'Jean Leconte', '(777)777-7777'),
(50,'Hafedh Alaoui', '(555)555-5555'),
(60,'Marie Leconte', '(666)666-6666'),
(70,'Simon Lecoq', '(444)444-4419'),
(80,'DollardTremblay', '(333)333-3333')
;



INSERT INTO article (no_article, description, prix_unitaire, quantite_en_stock)
VALUES
(10, 'Cèdre en boule', 10.99, 10),
(20, 'Sapin', 12.99, 10),
(40, 'Epinette bleue', 25.99, 10),
(50, 'Chêne', 22.99, 10),
(60, 'Erable argenté', 15.99, 10),
(70, 'Herbe à puce', 10.99, 10),
(80, 'Poirier', 26.99, 10),
(81, 'Catalpa', 25.99, 10),
(90, 'Pommier', 25.99, 10),
(95, 'Génévrier', 15.99, 10);




INSERT INTO commande (no_Commande, date_commande, no_Client)
VALUES
(1,STR_TO_DATE('01/06/2000', '%d/%m/%Y'), 10),
(2, '2000-06-02', 20),
(3, '2000-06-02', 10),
(4, '2000-07-05', 10),
(5, '2000-07-09', 30),
(6, '2000-07-09', 20),
(7, '2000-07-15', 40),
(8, '2000-07-15', 40)
;



INSERT INTO ligne_commande (no_commande, no_article, quantite)
VALUES
(1, 10, 10),
(1, 70, 5),
(1, 90, 1),
(2, 40, 2),
(2, 95, 3),
(3, 20, 1),
(4, 40, 1),
(4, 50, 1),
(5, 70, 3),
(5, 10, 5),
(5, 20, 5),
(6, 10, 5),
(6, 40, 1),
(7, 50, 1),
(7, 95, 2),
(8, 20, 3)
;





INSERT INTO livraison (no_livraison, date_livraison)
VALUES
(100, '2000-06-03'),
(101, '2000-06-04'),
(102, '2000-06-04'),
(103, '2000-06-05'),
(104, '2000-06-07'),
(105, '2000-06-09')
;



INSERT INTO detail_livraison (no_livraison, no_commande, no_article, quantite_livrer)
VALUES
(100, 1, 10, 7),
(100, 1, 70, 5),
(101, 1, 10, 3),
(102, 2, 40, 2),
(102, 2, 95, 1),
(100, 3, 20, 1),
(103, 1, 90, 1),
(104, 4, 40, 1),
(105, 5, 70, 2)
;



