
INSERT INTO car (id, android_flag, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, token, year)
VALUES (1, false, 'Fiat', '500', 'Limuzina', false, 2, 'Dizel', 'Automatski', 120, null, STR_TO_DATE('20-05-2020', '%d-%m-%Y'));
INSERT INTO car (id, android_flag, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, token, year)
VALUES (3, false, 'Audi', 'A3', 'Limuzina', false, 3, 'Dizel', 'Automatski', 125, null, STR_TO_DATE('20-05-2017', '%d-%m-%Y'));
INSERT INTO car (id, android_flag, car_manufacturer, car_model, car_type, cdw, children_seat_num, fuel_type, gearbox_type, mileage, token, year)
VALUES (4, false, 'BMW', '320d', 'Limuzina', true, 3, 'Benzin', 'Manuelni', 200, null, STR_TO_DATE('20-05-2019', '%d-%m-%Y'));

INSERT INTO ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_list, publisher_user)
VALUES (1, 'slika1.jpg', false, 20, 'LIMITED', true, 'Beograd', 'Oglas za autic fiat', STR_TO_DATE('20-04-2020', '%d-%m-%Y'), 0, 0, 5, 3, 3);
INSERT INTO ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_list, publisher_user)
VALUES (3, 'slika9.jpg', false, 200, 'LIMITED', true, 'Beograd', 'Oglas za audi', STR_TO_DATE('22-05-2020', '%d-%m-%Y'), 3, 2, 10, 2, 4);
INSERT INTO ad(id, cover_photo, deleted, distance_limit, distance_limit_flag, enabled, location, name, publish_date, rating_count, rating_num, rent_cnt, price_list, publisher_user)
VALUES (4, 'slika16.jpg', false, 100, 'LIMITED', true, 'Novi Sad', 'Oglas za automobil BMW', STR_TO_DATE('29-03-2020', '%d-%m-%Y'), 0, 0, 1100, 2, 4);

INSERT INTO ad_car(ad_id, car_id) VALUES (1,1);
INSERT INTO ad_car(ad_id, car_id) VALUES (3,3);
INSERT INTO ad_car(ad_id, car_id) VALUES (4,4);

INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (1, STR_TO_DATE('09:00 06-02-2020', '%H:%i %d-%m-%Y'), STR_TO_DATE('09:00 02-09-2020', '%H:%i %d-%m-%Y'), 1);
INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (3, STR_TO_DATE('09:00 02-07-2020', '%H:%i %d-%m-%Y'), STR_TO_DATE('09:00 29-07-2020', '%H:%i %d-%m-%Y'), 3);
INSERT INTO car_calendar_term(id, start_date, end_date, ad_id)
VALUES (4, STR_TO_DATE('09:00 06-08-2020', '%H:%i %d-%m-%Y'), STR_TO_DATE('09:00 08-08-2020', '%H:%i %d-%m-%Y'), 4);


INSERT INTO image(id, name, ad_id)
VALUES (1, 'slika1.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (2, 'slika2.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (3, 'slika3.jpg', 1);
INSERT INTO image(id, name, ad_id)
VALUES (4, 'slika4.jpg', 1);
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