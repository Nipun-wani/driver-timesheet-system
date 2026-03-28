CREATE DATABASE driver_timesheet_db;

USE driver_timesheet_db;

CREATE TABLE drivers (
    driver_id INT PRIMARY KEY AUTO_INCREMENT,
    driver_name VARCHAR(100) NOT NULL,
    hourly_rate DOUBLE NOT NULL
);

CREATE TABLE timesheet (
    timesheet_id INT PRIMARY KEY AUTO_INCREMENT,
    driver_id INT NOT NULL,
    work_date DATE NOT NULL,
    hours_worked DOUBLE NOT NULL,
    
    CONSTRAINT fk_driver
        FOREIGN KEY (driver_id) 
        REFERENCES drivers(driver_id)
        ON DELETE CASCADE,
        
    CONSTRAINT unique_driver_date
        UNIQUE (driver_id, work_date)
);

CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    driver_id INT NOT NULL,
    week_start DATE NOT NULL,
    week_end DATE NOT NULL,
    total_hours DOUBLE NOT NULL,
    overtime_hours DOUBLE NOT NULL,
    total_payment DOUBLE NOT NULL,
    
    CONSTRAINT fk_payment_driver
        FOREIGN KEY (driver_id)
        REFERENCES drivers(driver_id)
        ON DELETE CASCADE,
        
    CONSTRAINT unique_driver_week
        UNIQUE (driver_id, week_start, week_end)
);


ALTER TABLE drivers
ADD CONSTRAINT unique_driver_name
UNIQUE (driver_name);