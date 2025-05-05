CREATE TABLE movie (
  id BIGINT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  genre VARCHAR(100),
  ticket_price DOUBLE
);

INSERT INTO movie (id, title, genre, ticket_price) VALUES (1, 'Avengers: Endgame', 'Action', 10.0);
INSERT INTO movie (id, title, genre, ticket_price) VALUES (2, 'Spider-Man: No Way Home', 'Superhero', 9.5);


CREATE TABLE showtime (
  id        BIGINT PRIMARY KEY,
  movie_id  BIGINT NOT NULL,
  time      TIMESTAMP NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES movie(id)
);

-- Chèn suất chiếu mẫu
INSERT INTO showtime (id, movie_id, time) VALUES (1, 1, '2025-05-05 19:00:00');
INSERT INTO showtime (id, movie_id, time) VALUES (2, 1, '2025-05-05 21:00:00');
INSERT INTO showtime (id, movie_id, time) VALUES (3, 2, '2025-05-06 18:30:00');
