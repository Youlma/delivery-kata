CREATE TABLE IF NOT EXISTS time_slots (
    id SERIAL PRIMARY KEY,
    start_date_time TIMESTAMP NOT NULL,
    end_date_time TIMESTAMP NOT NULL,
    reserved BOOLEAN DEFAULT FALSE
);

INSERT INTO time_slots (start_date_time, end_date_time, reserved) VALUES
('2023-11-15 10:00:00', '2023-11-15 12:00:00', false),
('2023-11-15 14:00:00', '2023-11-15 16:00:00', false);