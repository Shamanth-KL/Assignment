
--
-- Table structure for table `clerk`
--

CREATE SEQUENCE clerk_id_seq
    START WITH 1001
    INCREMENT BY 1
    MINVALUE 1001
    NO MAXVALUE
    CACHE 1;

CREATE TABLE collegeassetmgmt.clerk (
    id bigint DEFAULT nextval('collegeassetmgmt.clerk_id_seq'::regclass) NOT NULL,
    name character varying(100) NOT NULL,
    password character varying(100),
    email character varying(100) NOT NULL,
    address text,
    city character varying(100) NOT NULL,
    contact character varying(20) NOT NULL
);

--
-- Dumping data for table `clerk`
--

INSERT INTO collegeassetmgmt.clerk (name, password, email, address, city, contact) VALUES
('Emily', 'test1234', 'Emily@xyz.com', 'XyZ College', 'London', '44012345678'),
('Jon', 'test12345', 'Jon@xyz.com', 'XyZ College', 'London', '44012345679'),
('Arya', 'test123456', 'Arya@xyz.com', 'XyZ College', 'London', '44012345680');

