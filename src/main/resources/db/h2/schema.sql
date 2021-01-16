DROP TABLE families IF EXISTS;
DROP TABLE members IF EXISTS;
DROP TABLE transactions IF EXISTS;

CREATE TABLE families (
  id         INTEGER IDENTITY PRIMARY KEY,
  last_name  VARCHAR_IGNORECASE(30)
);
CREATE INDEX families_last_name ON families (last_name);

CREATE TABLE members (
  id         INTEGER IDENTITY PRIMARY KEY,
  family_id   INTEGER NOT NULL,
  name       VARCHAR(30),
  birth_date DATE
);
ALTER TABLE members ADD CONSTRAINT fk_members_families FOREIGN KEY (family_id) REFERENCES families (id);
CREATE INDEX members_name ON members (family_id);

CREATE TABLE transactions (
  id          INTEGER IDENTITY PRIMARY KEY,
  member_id      INTEGER NOT NULL,
  operation_type          INTEGER NOT NULL,
  amount DECIMAL (19,4),
  currency       VARCHAR(3),
  execution_date  DATE,
  description VARCHAR(255)

);
ALTER TABLE transactions ADD CONSTRAINT fk_transactions_members FOREIGN KEY (member_id) REFERENCES members (id);
CREATE INDEX transactions_execution_date ON transactions (execution_date);