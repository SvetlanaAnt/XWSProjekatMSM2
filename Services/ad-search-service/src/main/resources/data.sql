INSERT INTO car (id, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, year)
VALUES (1, 'Fiat', '500', 'Limuzina', false, 2, 'Dizel', 'Automatski', 120, '2020-05-20');
INSERT INTO car (id, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, year)
VALUES (2, 'Mercedes-Benz', 'C-klasa', 'Limuzina', false, 2, 'Dizel', 'Automatski', 200, '2020-05-20');
INSERT INTO car (id, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, year)
VALUES (3, 'Audi', 'A3', 'Limuzina', false, 3, 'Dizel', 'Automatski', 125, '2017-05-20');
INSERT INTO car (id, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, year)
VALUES (4, 'BMW', '320d', 'Limuzina', true, 3, 'Benzin', 'Manuelni', 200, '2019-02-20');


INSERT INTO ad_search_db.ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_per_day, publisher_user)
VALUES (1, 'slika1.jpg', false, 20, 'LIMITED', true, 'Beograd', 'Oglas za autic fiat', '20.04.2020.', 0, 0, 5, 3500.0, 3);
INSERT INTO ad_search_db.ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_per_day, publisher_user)
VALUES (2, 'slika6.jpg', false, 25, 'LIMITED', true, 'Zrenjanin', 'Oglas za automobil mercedes', '20.04.2020.', 0, 0, 1100, 3500.0, 2);
INSERT INTO ad_search_db.ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_per_day, publisher_user)
VALUES (3, 'slika9.jpg', false, 200, 'LIMITED', true, 'Beograd', 'Oglas za audi', '20.05.2020.', 3, 2, 10, 3500.0, 4);
INSERT INTO ad_search_db.ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_per_day, publisher_user)
VALUES (4, 'slika16.jpg', false, 100, 'LIMITED', true, 'Novi Sad', 'Oglas za automobil BMW', '29.03.2020.', 0, 0, 1100, 3500.0, 4);

INSERT INTO ad_car(ad_id, car_id) VALUES (1,1);
INSERT INTO ad_car(ad_id, car_id) VALUES (2,2);
INSERT INTO ad_car(ad_id, car_id) VALUES (3,3);
INSERT INTO ad_car(ad_id, car_id) VALUES (4,4);

INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (1, '2020.06.02.', '2020.09.02', 1);
INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (2, '2020.06.03.', '2020.06.08.', 2);
INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (3, '2020.07.02.', '2020.07.29', 3);
INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (4, '2020.06.08.', '2020.08.08.', 4);

INSERT INTO image(id, name, ad_id)
VALUES (1, 'slika1.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (2, 'slika2.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (3, 'slika3.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (4, 'slika4.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (5, 'slika5.jpg', 2);
INSERT INTO image(id, name, ad_id)
VALUES (6, 'slika6.jpg', 2);
INSERT INTO image(id, name, ad_id)
VALUES (7, 'slika7.jpg', 2);
INSERT INTO image(id, name, ad_id)
VALUES (8, 'slika8.jpg', 2);
INSERT INTO image(id, name, ad_id)
VALUES (9, 'slika9.jpg', 3);
INSERT INTO image(id, name, ad_id)
VALUES (10, 'slika10.jpg', 3);
INSERT INTO image(id, name, ad_id)
VALUES (11, 'slika11.jpg', 3);
INSERT INTO image(id, name, ad_id)
VALUES (12, 'slika12.jpg', 3);
INSERT INTO image(id, name, ad_id)
VALUES (13, 'slika13.jpg', 4);
INSERT INTO image(id, name, ad_id)
VALUES (14, 'slika14.jpg', 4);
INSERT INTO image(id, name, ad_id)
VALUES (15, 'slika15.jpg', 4);
INSERT INTO image(id, name, ad_id)
VALUES (16, 'slika16.jpg', 4);