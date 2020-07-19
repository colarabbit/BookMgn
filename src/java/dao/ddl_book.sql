/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  luke.galic
 * Created: 26/05/2020
 * Edited by: kira
 */

DROP TABLE tbl_book;
CREATE TABLE tbl_book (
bookId INT NOT NULL  ,
title VARCHAR(20) NOT NULL,
author VARCHAR(20) NOT NULL,
publisher VARCHAR(100) NOT NULL,
PRIMARY KEY (bookId));


