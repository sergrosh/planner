INSERT IGNORE INTO families VALUES (1, 'Johns');
INSERT IGNORE INTO families VALUES (2, 'Stevens');
INSERT IGNORE INTO families VALUES (3, 'Jenkins');

INSERT IGNORE INTO members VALUES (1, 1, 'John', '1980-09-07');
INSERT IGNORE INTO members VALUES (2, 1, 'Helen', '1985-05-05');
INSERT IGNORE INTO members VALUES (3, 2, 'Henry', '1965-10-25');
INSERT IGNORE INTO members VALUES (4, 2, 'Linda', '1970-07-30');
INSERT IGNORE INTO members VALUES (5, 2, 'Jeremy', '2005-03-12');
INSERT IGNORE INTO members VALUES (6, 3, 'Rafael', '1993-05-03');
INSERT IGNORE INTO members VALUES (7, 3, 'Sharon', '1995-11-10');

INSERT IGNORE INTO transactions VALUES (1, 1, 0, 3000, 'EUR', '2020-12-01', 'Salary');
INSERT IGNORE INTO transactions VALUES (2, 1, 1, 1000, 'EUR', '2020-12-05', 'Apartment rental payment');
INSERT IGNORE INTO transactions VALUES (3, 2, 0, 2500, 'EUR', '2020-12-01', 'Salary');
INSERT IGNORE INTO transactions VALUES (4, 2, 1, 700, 'EUR', '2020-12-07', 'VW leasing');
INSERT IGNORE INTO transactions VALUES (5, 3, 0, 5000, 'USD', '2020-12-01', 'Salary');
INSERT IGNORE INTO transactions VALUES (6, 3, 1, 800, 'EUR', '2020-12-07', 'Apartment rental payment');
INSERT IGNORE INTO transactions VALUES (7, 4, 0, 3000, 'USD', '2020-12-01', 'Salary');
INSERT IGNORE INTO transactions VALUES (8, 4, 1, 300, 'EUR', '2020-12-01', 'Amazon');
INSERT IGNORE INTO transactions VALUES (9, 5, 0, 3000, 'EUR', '2020-12-01', 'Salary');
INSERT IGNORE INTO transactions VALUES (10, 5, 1, 1500, 'EUR', '2020-12-01', 'Apartment rental payment');
INSERT IGNORE INTO transactions VALUES (11, 6, 0, 2500, 'EUR', '2020-12-01', 'Salary');
INSERT IGNORE INTO transactions VALUES (12, 6, 1, 700, 'EUR', '2020-12-01', 'Audi leasing');
INSERT IGNORE INTO transactions VALUES (13, 7, 0, 300, 'EUR', '2020-12-01', 'Child money');
INSERT IGNORE INTO transactions VALUES (14, 7, 1, 550, 'EUR', '2020-12-01', 'PS 5');