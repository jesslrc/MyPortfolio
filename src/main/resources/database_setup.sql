DROP SCHEMA IF EXISTS myportfoliodb;

CREATE SCHEMA myportfoliodb;

USE myportfoliodb;

CREATE TABLE account
(
    id         varchar(36) PRIMARY KEY,
    first_name varchar(255),
    last_name  varchar(255),
    email      varchar(50) UNIQUE,
    pass       char(32),
    phone      varchar(15),
    about      longtext
);

CREATE TABLE project
(
    id                  varchar(36) PRIMARY KEY,
    account_id          varchar(36) NOT NULL,
    project_name        varchar(255),
    project_description longtext,
    link                varchar(255),
    image_link          varchar(1024),

    FOREIGN KEY (account_id) REFERENCES account (id)

);

CREATE TABLE education
(
    id              varchar(36) PRIMARY KEY,
    account_id      varchar(36) NOT NULL,
    course_name     varchar(255),
    institution     varchar(255),
    education_level varchar(36),

    FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE skill
(
    id         varchar(36) PRIMARY KEY,
    skill_name varchar(255)
);

CREATE TABLE account_skill
(
    account_id          varchar(36),
    skill_id            varchar(36),

    PRIMARY KEY (account_id, skill_id),
    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (skill_id) REFERENCES skill (id)
);

INSERT INTO skill
VALUES ('001', 'Java'),
       ('002', 'Spring Boot'),
       ('003', 'Thymeleaf'),
       ('004', 'JavaScript'),
       ('005', 'React.js'),
       ('006', 'Node.js'),
       ('007', 'HTML'),
       ('008', 'CSS'),
       ('009', 'Hibernate'),
       ('010', 'Spring Data JPA'),
       ('011', 'MySQL'),
       ('012', 'SQLServer'),
       ('013', 'AWS');


-- Adding Kiwi's info
INSERT INTO account
VALUES ('001', 'Kiwi Sauro', 'Cabral', 'kiwisauro@kiwi.com', 'IloveMom', '55-444-9444', 'Good Boy');

INSERT INTO project
VALUES ('001', '001', 'Dont ever lose your tail again', '', 'www.findyourtail.com', 'https://cdn.dribbble.com/userupload/3079047/file/original-40e155214e180fc53f5cca7ae9b74681.png?resize=1600x1200'),
       ('002', '001', 'How to get two dinners', '', 'www.twodinners.com', 'https://i.pinimg.com/originals/e0/70/4c/e0704c6b77b18dc718e19f4bf86b8cd3.jpg'),
       ('003', '001', 'Are you a good boy?', '', 'www.goodboy.com', 'https://img.freepik.com/free-vector/cute-corgi-dog-sitting-cartoon-vector-icon-illustration-animal-nature-icon-concept-isolated-premium-vector-flat-cartoon-style_138676-4181.jpg'),
       ('004', '001', 'Get that darn squirrel', '', 'www.wehatesquirrel.com', 'https://www.mccanndogs.com/cdn/shop/articles/is-your-dog-a-squirrel-chaser-366340.png?v=1680325731'),
       ('005', '001', 'How to obtain non-stop walkies?', '', 'www.letsgoforawalk.com', 'https://www.pngitem.com/pimgs/m/330-3306959_our-services-tassuvahti-dog-walk-transparent-cartoons.png');

INSERT INTO education
VALUES ('001', '001', 'How to be a Good Boy', 'School for Doggos', 'PHD');

