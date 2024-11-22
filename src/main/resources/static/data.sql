USE basic_rest_api_example;

INSERT INTO roles (id, name, description) VALUES (1, 'ADMIN', 'Administrator');
INSERT INTO users (id, username, password, first_name, last_name) VALUES
(1,  'admin', '$2a$12$ZhGS.zcWt1gnZ9xRNp7inOvo5hIT0ngN7N.pN939cShxKvaQYHnnu');
INSERT INTO users_data (user_id, first_name, last_name) VALUES (1, 'Administrator', 'Adminstrator');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
