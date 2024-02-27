INSERT INTO worker (id, name, birthday, level, salary) VALUES
	(1, 'John', '1995-02-15', 'Trainee', 800),
    (2, 'Ivan', '1990-07-10', 'Junior', 1200),
    (3, 'Bob', '1985-11-25', 'Middle', 3000),
    (4, 'Lilia', '1980-03-20', 'Senior', 6000),
    (5, 'Mike', '1998-08-05', 'Trainee', 900),
    (6, 'Emily', '1992-04-12', 'Junior', 1400),
    (7, 'David', '1987-09-18', 'Middle', 3500),
    (8, 'Sophia', '1983-12-30', 'Senior', 7000),
    (9, 'Alex ', '1996-06-22', 'Trainee', 950),
    (10, 'Herman', '1993-01-08', 'Junior', 1600);

INSERT INTO client (id, name) VALUES
	(1, 'Robert'),
	(2, 'Thomas'),
	(3, 'Cosmin'),
	(4, 'Chiprian'),
	(5, 'Catalin');

INSERT INTO project (id, client_id, start_date, finish_date) VALUES
	(1,1, '2024-01-01', '2024-02-02'),
    (2,3, '2024-02-02', '2024-03-03'),
    (3,2, '2024-04-04', '2024-05-05'),
    (4,3, '2024-05-05', '2024-06-06'),
    (5,3, '2024-07-07', '2024-08-08'),
    (6,4, '2024-09-09', '2024-10-10'),
    (7,4, '2024-10-10', '2024-11-11'),
    (8,4, '2024-11-11', '2024-12-12'),
    (9,5, '2024-12-12', '2025-01-01'),
    (10,5, '2025-01-01', '2025-02-02');

INSERT INTO project_worker (project_id, worker_id) VALUES
(1,5),
(2,4),
(3,6),
(3,3),
(4,1),
(4,2),
(5,4),
(5,3),
(5,2),
(6,1),
(6,10),
(6,9),
(7,10),
(7,9),
(7,8),
(7,7),
(8,8),
(8,7),
(8,6),
(8,5),
(9,8),
(9,7),
(9,6),
(9,4),
(9,3),
(10,5),
(10,4),
(10,3),
(10,2),
(10,1);

INSERT INTO project_name(project_id,name) VALUES
(1,'Project A'),
(2,'Project B'),
(3,'Project C'),
(4,'Project D'),
(5,'Project E'),
(6,'Project F'),
(7,'Project G'),
(8,'Project H'),
(9,'Project I'),
(10,'Project J');