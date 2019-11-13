drop database if exists springblog_db;
use springblog_db;
INSERT INTO posts (title, body, post_details_id, user_id)
VALUES
( 'Chuck', 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.',1, 2),
( 'Fred', 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.',2, 2),
( 'Bud', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',3, 1),
( 'Bailey', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.',4, 1),
('Lexie', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.',5, 3),
('Snickers', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.',6, 2),
('Red', 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.',7, 3),
('Barney', 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',8,  4),
('Bowser', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.',9,  4);


use springblog_db;
INSERT INTO post_details (is_awesome, history_of_post, topic_description)
VALUES
( 0, 'history this', 'lil bout chuck'),
( 0, 'history that', 'lil bout fred'),
( 1, 'history the other', 'lil bout Bud'),
( 1, 'history this', 'lil bout bailey'),
(1, 'history ok', 'lil bout lexie'),
(0, 'history almost', 'lil bout snickers'),
(1, 'history ready', 'lil bout Red'),
(1, 'history and', 'lil bout barney'),
(0, 'history done', 'lil bout bowser');
use springblog_db;
INSERT INTO post_images (image_title, url, post_id)
VALUES
( 'Chuck Pic', 'https://placedog.net/750/300?random', 1),
( 'Fred pic', 'https://placedog.net/750/300?random', 2),
( 'Bud Pic', 'https://placedog.net/750/300?random', 3),
( 'Bailey Pic', 'https://placedog.net/750/300?random', 4),
('Lexie Pic', 'https://placedog.net/750/300?random', 5),
('Snickers Pic', 'https://placedog.net/750/300?random', 6),
('Red Pic', 'https://placedog.net/750/300?random', 7),
('Barney Pic', 'https://placedog.net/750/300?random', 8),
('Bowser Pic', 'https://placedog.net/750/300?random', 9);
# seed vets
insert into tags (name) values
('Funny'),
('Not Funny'),
('Litte Bit Funny');

# seed pet_vet
insert into post_tag (post_id, tag_id) values
(1, 1),
(2, 3),
(3, 2),
(4, 2),
(5, 1),
(6, 3),
(7, 2),
(8, 3),
(9, 1);


insert into users(email, password, username) values
('bridget@gmail.com','bridgetpass', 'bboo4u'),
('elzhi@gmail.com','elzhipass', 'mrelzhimills'),
('darrell@gmail.com','darrellpass', 'dmilly'),
('ellis@gmail.com','ellispass', 'elliebuttbutt');

use springblog_db;
show tables;
describe users;
describe  post_tag;
describe tags;
describe  posts;
select * from posts;