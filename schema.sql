CREATE TABLE weather_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50),
    temperature DOUBLE,
    feels_like DOUBLE,
    condition VARCHAR(50),
    timestamp BIGINT
);

CREATE TABLE daily_summary (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50),
    avg_temperature DOUBLE,
    max_temperature DOUBLE,
    min_temperature DOUBLE,
    dominant_condition VARCHAR(50),
    date DATE
);