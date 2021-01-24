USE planner;
CREATE TABLE IF NOT EXISTS families (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  last_name  VARCHAR(30),
  INDEX(last_name)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS members (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  family_id INT(4) UNSIGNED NOT NULL,
  name       VARCHAR(30),
  birth_date DATE,
  FOREIGN KEY (family_id) REFERENCES families(id),
  INDEX (family_id)
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS transactions (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  member_id      INT(4) UNSIGNED NOT NULL,
  operation_type ENUM('DEBIT', 'CREDIT'),
  amount DECIMAL (15,2),
  currency       VARCHAR(3),
  execution_date  DATE,
  description VARCHAR(255),
  FOREIGN KEY (member_id) REFERENCES members(id),
  INDEX(member_id)
)engine=InnoDB;