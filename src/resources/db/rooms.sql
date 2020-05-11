
-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE rooms (
      roomid varchar(10) NOT NULL,
      name varchar(100) NOT NULL,
      capacity bigint NOT NULL,
      room_type varchar(100) NOT NULL,
      available boolean DEFAULT true
  );

ALTER TABLE ONLY rooms ADD CONSTRAINT x1rooms UNIQUE (roomid);

--
-- Dumping data for table rooms
--

INSERT INTO rooms (roomid, name, capacity, room_type, available) VALUES
(101, 'Class Room', 30, 'class', true),
(102, 'Sports', 200, 'auditorium', true),
(103, 'dining hall', 200, 'cafeteria', true);
