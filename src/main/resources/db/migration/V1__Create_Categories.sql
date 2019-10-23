create table categories(
id int primary key auto_increment,
category_name varchar(50) not null,
created_by int not null,
active boolean NOT NULL DEFAULT '1',
created_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
modified_date  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp,
unique key category_name (category_name));

CREATE TABLE category_details (
    sub_id INT PRIMARY KEY AUTO_INCREMENT,
    catename_id INT,
    sub_category VARCHAR(50) NOT NULL,
    FOREIGN KEY (catename_id)
        REFERENCES categories (id),
    UNIQUE KEY sub_category (sub_category)
); 