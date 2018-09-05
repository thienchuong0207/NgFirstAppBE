CREATE TABLE IF NOT EXISTS classes (
	id CHAR(4) CONSTRAINT class_id PRIMARY KEY,
	name VARCHAR(10) NOT NULL,
	teacher_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
	id CHAR(4) CONSTRAINT student_id PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	gender INTEGER NOT NULL,
	photo bytea,
	class_id CHAR(4) REFERENCES classes(id)
);