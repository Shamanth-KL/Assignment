
-- --------------------------------------------------------

--
-- Table structure for table bookroom
--
CREATE SEQUENCE collegeassetmgmt.bookroom_id_seq
    START WITH 1001
    INCREMENT BY 1
    MINVALUE 1001
    NO MAXVALUE
    CACHE 1;

CREATE TABLE collegeassetmgmt.bookroom (
    bookroom_id bigint DEFAULT nextval('collegeassetmgmt.bookroom_id_seq'::regclass) NOT NULL,
    roomid varchar(10) NOT NULL,
    bookedby varchar(100) NOT NULL,
    guestid varchar(50) NOT NULL,
    guestaddress varchar(500) NOT NULL,
    guestcontact varchar(20) NOT NULL,
    bookedfor varchar(200) NOT NULL,
    bookedfrom timestamp without time zone NOT NULL,
    bookedto timestamp without time zone NOT NULL,
    reason varchar(200) NOT NULL
  );

ALTER TABLE ONLY collegeassetmgmt.bookroom ADD CONSTRAINT x1bookroomid UNIQUE (bookroom_id);
ALTER TABLE ONLY collegeassetmgmt.bookroom ADD CONSTRAINT fk1_bookroom FOREIGN KEY (roomid) REFERENCES rooms(roomid) ON DELETE CASCADE;

