 select * from admin;
INSERT INTO Admin (Name, Username, Password, Age, Bloodgroup, Station, Attendance, Position, Address, Phone)
VALUES ('Jane Doe', 'imJane', '123123', 30, 'O+', 'ISL', 100, 'Station Master', '365 ave xyz', '5678-9012345');
select * from admin;

create table Maintenance(
	MainID int primary key Auto_increment,
	Date varchar(20),
    Time varchar(20),
    Reason varchar(200),
    Mechanic varchar(20),
    Adminid int,
    trainid int,
    foreign key (Adminid) references Admin(AdminID),
    foreign key (trainid) references Train(TrainID)
);

create table Train
(
	TrainID int primary key Auto_increment,
    TrName varchar(30),
    srcCity Varchar(40),
	dstCity Varchar(40),
	totalSeats int 
); 
UPDATE Train SET TrName="Thunder Expres", srcCity="LHR", dstCity="ISL", totalSeats=300 WHERE TrainID=1;
insert into Train(TrName,srcCity,dstCity,totalseats) values("Thunder Express","LHR","ISL",300);
insert into Train(TrName,srcCity,dstCity,totalseats) values();
insert into Train(TrName,srcCity,dstCity,totalseats) values("Nebula Express","PSH","LHR",300);
insert into Train(TrName,srcCity,dstCity,totalseats) values("Solar Voyager","LHR","KAR",300);
delete from Maintenance where MainID=7;
drop table Train;
select * from Schedule;

Create Table Schedule(
SchID int primary key Auto_increment,
trainid int,
Date varchar(20),
Time varchar(20),
Status Varchar(20),
foreign key (trainid) references Train(TrainID)
);

INSERT INTO Schedule (TrainID, Date, Time, Status) VALUES
(1, '2023-01-01', '08:00 AM', 'Scheduled'),
(2, '2023-01-02', '10:30 AM', 'Delayed'),
(3, '2023-01-03', '02:15 PM', 'On Time'),
(4, '2023-01-04', '05:45 PM', 'Canceled'),
(1, '2023-01-05', '11:20 AM', 'Scheduled'),
(3, '2023-01-06', '03:30 PM', 'Delayed');

update Schedule set Time = "11:20 AM" where SchID IN (7);
select * from Schedule;





select * from Train;
delete from Train where TrainID = 13;
insert into Maintenance (date,time,reason,Mechanic,Adminid,trainid) values ("12-03-2020","11:00 am","Component Failure","Jackson Gearsmith",20,2);
insert into Maintenance (date,time,reason,Mechanic,Adminid,trainid) values ("13-04-2020","09:00 am","Technological Upgrades","Jackson Gearsmith",20,1);
insert into Maintenance (date,time,reason,Mechanic,Adminid,trainid) values ("11-03-2021","12:00 pm","Mechanical Malfunctions","Max Boltmaster",21,4);
insert into Maintenance (date,time,reason,Mechanic,Adminid,trainid) values ("13-04-2020","09:00 am","Fixing Wear and Tear","Chloe Wrenchfield",21,3);

SELECT TrainID FROM Train WHERE TrName = "Swift Serenity";


create table User(
	userid int primary key auto_increment
);

CREATE TABLE Feedbacks (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    userid INT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    contact_method VARCHAR(20) NOT NULL,
    phone_number VARCHAR(15) NULL CHECK (LENGTH(phone_number) <= 15),
    email VARCHAR(255) NOT NULL,
    details LONGTEXT NOT NULL,
    outcome_expectations LONGTEXT NOT NULL,
    feedback_date VARCHAR(20),
    FOREIGN KEY (userid) REFERENCES User(userid)
);
-- Inserting data into the Feedbacks table
INSERT INTO Feedbacks (userid, first_name, last_name, contact_method, phone_number, email, details, outcome_expectations, feedback_date)
VALUES
    (1, 'John', 'Doe', 'Email', NULL, 'john.doe@example.com', 'Great service!', 'Quick response and excellent support.', '2023-01-05'),
    (2, 'Jane', 'Smith', 'Phone', '123-456-7890', 'jane.smith@example.com', 'Very satisfied!', 'Resolved my issue promptly.', '2023-02-10'),
    (3, 'Alice', 'Johnson', 'Email', NULL, 'alice.johnson@example.com', 'Feedback on a product', 'Provided valuable insights for product improvement.', '2023-03-15'),
    (4, 'Bob', 'Williams', 'Phone', '987-654-3210', 'bob.williams@example.com', 'Excellent support', 'Helpful and knowledgeable staff.', '2023-04-20'),
    (5, 'Eva', 'Miller', 'Email', NULL, 'eva.miller@example.com', 'Suggestions for improvement', 'Would like to see more features in the next release.', '2023-05-25'),
    (6, 'Chris', 'Lee', 'Phone', '555-123-4567', 'chris.lee@example.com', 'Impressed with the service', 'Quick resolution and friendly support.', '2023-06-30'),
    (7, 'Sophie', 'Brown', 'Email', NULL, 'sophie.brown@example.com', 'Positive experience', 'Appreciate the quick turnaround and helpful responses.', '2023-07-05'),
    (8, 'Daniel', 'Jones', 'Phone', '111-222-3333', 'daniel.jones@example.com', 'Good customer service', 'Resolved my issue effectively.', '2023-08-10'),
    (9, 'Olivia', 'Clark', 'Email', NULL, 'olivia.clark@example.com', 'Great product', 'Happy with the features and performance.', '2023-09-15'),
    (10, 'William', 'Davis', 'Phone', '999-888-7777', 'william.davis@example.com', 'Constructive feedback', 'Suggesting improvements for better user experience.', '2023-10-20');


CREATE TABLE applicants (
    applicant_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(10),
    institution VARCHAR(100),
    field_of_study VARCHAR(100),
    graduation_year INT
)
select * from applicants;
-- Inserting data into the Applicants table
INSERT INTO applicants (full_name, email, phone, address, city, state, zip_code, institution, field_of_study, graduation_year)
VALUES
    ('John Doe', 'john.doe@example.com', '123-456-7890', '123 Main St', 'Anytown', 'CA', '12345', 'University A', 'Computer Science', 2022),
    ('Jane Smith', 'jane.smith@example.com', '987-654-3210', '456 Oak St', 'Sometown', 'NY', '54321', 'College B', 'Engineering', 2023),
    ('Alice Johnson', 'alice.johnson@example.com', NULL, '789 Pine St', 'Othercity', 'TX', '67890', 'School C', 'Biology', 2021),
    ('Bob Williams', 'bob.williams@example.com', '555-123-4567', '101 Cedar St', 'Cityville', 'FL', '13579', 'Institute D', 'Physics', 2024),
    ('Eva Miller', 'eva.miller@example.com', '333-222-1111', '246 Elm St', 'Villagetown', 'WA', '98765', 'University E', 'Mathematics', 2025),
    ('Chris Lee', 'chris.lee@example.com', NULL, '369 Maple St', 'Smalltown', 'IL', '24680', 'College F', 'Chemistry', 2023);

CREATE TABLE interview (
    id INT AUTO_INCREMENT PRIMARY KEY,
    applicant_id INT,
    date varchar(20) NOT NULL,
    time varchar(20) NOT NULL,
    place VARCHAR(255) NOT NULL,
    message TEXT,
    interviewer_name VARCHAR(100) NOT NULL,
    interviewer_email VARCHAR(100) NOT NULL,
    interviewer_phone VARCHAR(15),
    FOREIGN KEY (applicant_id) REFERENCES applicants(applicant_id)
);

-- Inserting data into the Interview table
-- Inserting data into the Interview table with applicant IDs from 1 to 6
INSERT INTO interview (applicant_id, date, time, place, message, interviewer_name, interviewer_email, interviewer_phone)
VALUES
    (1, '2023-01-15', '14:30:00', '123 Main St, Anytown', 'Technical interview for software developer position.', 'Sarah Johnson', 'sarah.johnson@example.com', '555-123-4567'),
    (2, '2023-02-01', '10:00:00', '456 Oak St, Sometown', 'HR interview for entry-level position.', 'Michael Smith', 'michael.smith@example.com', '987-654-3210');
    
select * from Train;
drop table User;

CREATE TABLE User (
    userid INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(11) NULL CHECK (LENGTH(phone) <= 11)
);
-- Inserting data into the User table
INSERT INTO User (username, password, email, phone)
VALUES
    ('JohnDoe', 'password123', 'john.doe@example.com', '12345678901'),
    ('JaneSmith', 'pass456', 'jane.smith@example.com', '98765432109'),
    ('AliceJohnson', 'securepass', 'alice.johnson@example.com', NULL),
    ('BobWilliams', 'strongpass', 'bob.williams@example.com', '9876543210'),
    ('EvaMiller', 'mypassword', 'eva.miller@example.com', NULL),
    ('ChrisLee', 'secret123', 'chris.lee@example.com', '5551234567'),
    ('SophieBrown', 'securepassword', 'sophie.brown@example.com', NULL),
    ('DanielJones', 'pass123', 'daniel.jones@example.com', '1112223333'),
    ('OliviaClark', 'userpass', 'olivia.clark@example.com', NULL),
    ('WilliamDavis', 'newpass', 'william.davis@example.com', '9998887777');

create table Passenger(
pid int,
cnic varchar(15),
name varchar(200),
age int, 
gender varchar(20),
phone int8,
foreign key (pid) references user(userid)
);  
select * from passenger;
select * from User;
INSERT INTO User (username, password, email, phone) VALUES
    ('user1', 'pass1', 'user1@example.com', '12345678901'),
    ('user2', 'pass2', 'user2@example.com', '98765432109'),
    ('user3', 'pass3', 'user3@example.com', NULL),
    ('user4', 'pass4', 'user4@example.com', '9876543210');
INSERT INTO Passenger (pid, cnic, name, age, gender, phone) VALUES
    (1, '123456789012345', 'John Doe', 30, 'Male', 1234567890),
    (2, '234567890123456', 'Jane Smith', 25, 'Female', 9876543210),
    (3, '345678901234567', 'Alice Johnson', 35, 'Female', 8765432109),
    (4, '456789012345678', 'Bob Williams', 40, 'Male', 7654321098);    

INSERT INTO PaymentMethod (methodname) VALUES
('Card Payment'),
('Bank Transfer'),
('Online Payment');

-- Inserting sample data into Booking table
INSERT INTO Booking (userid, tickettypeid, paymentmethodid, numtickets, bookingdate) VALUES
(1, 1, 1, 2, '2023-01-02'),
(2, 2, 3, 1, '2023-01-03');

-- Inserting sample data into Ticket table
-- Inserting sample data into Ticket table
INSERT INTO Ticket (ticketid, bookingid, trid) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

CREATE TABLE Booking (
    bookingid INT PRIMARY KEY AUTO_INCREMENT,
    userid INT,
    tickettypeid INT,
    paymentmethodid INT,
    numtickets INT,
    bookingdate DATE,
    FOREIGN KEY (userid) REFERENCES User(userid),
    FOREIGN KEY (tickettypeid) REFERENCES TicketType(typeid),
    FOREIGN KEY (paymentmethodid) REFERENCES PaymentMethod(methodid)
);
CREATE TABLE Ticket (
    ticketid INT PRIMARY KEY AUTO_INCREMENT,
    bookingid INT,
    trid INT,
    FOREIGN KEY (bookingid) REFERENCES Booking(bookingid),
    FOREIGN KEY (trid) REFERENCES Train(TrainID)
);
drop table Ticket;
CREATE TABLE Tickets (
    ticketid INT PRIMARY KEY AUTO_INCREMENT,
    passengerid INT,
    scheduleid INT,
    trainid INT,
    FOREIGN KEY (passengerid) REFERENCES Passenger(pid),
    FOREIGN KEY (scheduleid) REFERENCES Schedule(SchID),
    FOREIGN KEY (trainid) REFERENCES Train(trainid)
);

CREATE TABLE PaymentMethod (
    methodid INT PRIMARY KEY AUTO_INCREMENT,
    methodname VARCHAR(255) NOT NULL
);