# ICU On Call

Course project for CS-360 (HY-360) "Files and Databases", Computer Science Department, University of Crete, winter 2020.

A web application that manages the day-to-day running of an ICU on-call service: patients, doctors, nurses and administrative staff, night-shift scheduling, visits with symptoms, ordered exams, diagnoses and prescriptions. Doctors are matched to patients by specialty (a disease maps to the doctor type that treats it), and night shifts are assembled automatically from the available doctors and nurses.

## Tech stack

Java 8 servlets (Java EE 7), Maven (WAR packaging), MySQL/MariaDB over JDBC, Gson, and a plain HTML/CSS/JavaScript front end. Deploys on Tomcat under the `/Project` context path.

## Repository layout

- `cs360.sql` — database schema plus demo seed data
- `Project/src/main/java/.../CS360DB` — data-access layer, one class per entity
- `Project/src/main/java/.../Servlet` — Login, Register, Finder, ExamServlet, VisitServlet
- `Project/src/main/java/.../ontologies` — entity classes
- `Project/src/main/webapp` — login, registration and role profile pages

## Setup

1. Install JDK 8, Maven, Tomcat (8/9) and MySQL or MariaDB.
2. Create the database: `CREATE DATABASE cs360;` then import `cs360.sql` into it.
3. DB connection settings (user, password, host) are constants in `CS360DB.java` — adjust to your local setup.
4. Build: `cd Project && mvn clean package`
5. Deploy the WAR from `Project/target/` to Tomcat and open `/Project/`.

Demo accounts from the seed data: `admin`/`admin`, `doc1`/`docdoc`, `pat1`/`pat` — demo data only, nothing here is production-grade security.

## Known limitations

A student project, preserved as such: passwords are stored in plain text, the landing page includes a raw SQL console used during development, and there are no automated tests.

## Authors

Haralambos Varsamis, Apostolos Mavrogiannakis
