DROP DATABASE IF EXISTS vente;
CREATE DATABASE vente;

USE vente;


CREATE TABLE client(
no_client INTEGER,
nom_client VARCHAR(20) NOT NULL,
no_telephone VARCHAR(20) NOT NULL,
CONSTRAINT client_no_client_pk PRIMARY KEY (no_Client)
);


CREATE TABLE article (
no_article INTEGER,
description VARCHAR(20),
prix_unitaire DECIMAL(10,2) NOT NULL, 
quantite_en_stock INTEGER DEFAULT 0 NOT NULL
CHECK (quantite_en_stock >= 0),
CONSTRAINT article_no_article_pk PRIMARY KEY (no_article)
 );
 
 select * from article;
 
 create table commande(
 no_commande INTEGER,
 date_commande date not null,
 no_client integer not null,
 constraint commande_no_commande_pk primary key (no_commande),
 constraint commande_no_client_fk foreign key (no_client) references client (no_client)
 );
 
  select * from commande;
  
  create table lignecommande(
  no_commande INTEGER,
  no_article INTEGER,
  quantite integer not null check ( quantite > 0),
  constraint lignecommande_no_commande_pk primary key (no_commande, no_article),
  constraint lignecommande_no_commande_commande_fk foreign key (no_commande) references commande(no_commande),
  constraint ligne_commande_no_article_fk foreign key (no_article) references article(no_article)
  );
  
 select * from ligne_commande;
 
 
 create table livraison(
 no_livraison integer,
 date_livraison date not null,
 constraint livraison_no_livraison_pk primary key (no_livraison)
 );
 
 select * from livraison;
 
 create table detaillivraison(
 no_livraison integer,
 no_commande INTEGER,
 no_article INTEGER,
 quantite_livrer integer,
 constraint detail_livraison_no_livraison_no_commande_no_article_pk primary key (no_livraison,no_commande, no_article),
 constraint detail_livraison_no_livraison_fk foreign key (no_livraison) references livraison(no_livraison),
 constraint detail_livraison_no_commande_fk foreign key (no_commande) references commande(no_commande),
 constraint detail_livraison_no_article_fk foreign key (no_article) references article(no_article)
 );
 
 select * from detaillivraison;
 
 