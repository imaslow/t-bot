--liquibase formatted sql

--changeset maslov_ilya:1.0.19
--comment travel
INSERT INTO travel (phrase, translate, travel_identifier)
VALUES ('Do you know where I can get a taxi?', 'Вы не знаете, где можно поймать такси?', 'taxi'),
       ('Do you have a taxi number?','У вас есть номер такси?','taxi'),
       ('I would like a taxi, please', 'Я бы хотел заказать такси', 'taxi'),
       ('Sorry, there are not available at the moment', 'Извините сейчас свободных нет', 'taxi'),
       ('Where are you?', 'Где вы находитесь?', 'taxi'),
       ('What is the address?', 'Какой адрес?', 'taxi'),
       ('I am at the .. airport, hotel', 'Я в аэропорту, отеле', 'taxi'),
       ('Could I take your name, please?', 'Могу я узнать ваше имя?', 'taxi'),
       ('How long will I have to wait?', 'Как долго мне придется ждать?', 'taxi'),
       ('The car is on its way', 'Машина в пути', 'taxi'),
       ('Your passport and ticket, please', 'Ваш паспорт и билет пожалуйста', 'airline'),
       ('I have come to collect my tickets', 'Я хотел бы забрать свой билет', 'airline'),
       ('I booked on the internet', 'Я заказал билет в интернете', 'airline'),
       ('Do you have your booking reference?', 'У вас есть код бронирования?', 'airline'),
       ('Here is my booking reference', 'Это мой код бронирования', 'airline'),
       ('Where are you flying to?', 'Куда вы летите?', 'airline'),
       ('Do you have any liquids or sharp objects in your hand baggage?', 'В вашем багаже есть жидкости или острые предметы?', 'airline'),
       ('How many bags are you checking in?', 'Сколько сумок вы сдаете?', 'airline'),
       ('Could I see your hand baggage, please?', 'Покажите вашу ручную кладь пожалуйста', 'airline'),
       ('Do I need to check this in or can I take it with me?', 'Я должен это сдать или могу взять с собой?', 'airline'),
       ('There is an excess baggage charge of 20$', 'Дополнительная плата за багаж 20$', 'airline'),
       ('Would you like a window or an aisle seat?', 'Вы хотите сидеть у окна или в проходе?', 'airline'),
       ('You have to fill in this form', 'Вы должны заполнить эту форму', 'custom'),
       ('Please show me how to fill it in', 'Покажите, пожалуйста, как это заполнять', 'custom'),
       ('Could I see your passport, please?', 'Пожалуйста, покажите ваш паспорт', 'custom'),
       ('Here is my passport', 'Вот мой паспорт', 'custom'),
       ('Where have you travelled from?', 'Откуда вы прибыли?', 'custom'),
       ('What is the purpose of your visit?', 'Какова цель вашей поездки?', 'custom'),
       ('I am a tourist', 'Я турист', 'custom'),
       ('I am on vacation', 'Я в отпуске', 'custom'),
       ('I am on a business trip', 'Я в командировке', 'custom'),
       ('This is my first visit', 'Это мой первый визит', 'custom'),
       ('How long will you be staying here?', 'Как долго вы собираетесь здесь пробыть?', 'custom'),
       ('Where will you be staying?', 'Где вы будете жить?', 'custom'),
       ('I plan to stay two weeks', 'Я собираюсь пробыть здесь две недели', 'custom'),
       ('This is my transit visa', 'Это моя транзитная виза', 'custom'),
       ('Could you open your bag, please?', 'Откройте вашу сумку, пожалуйста', 'custom'),
       ('Do you have anything to declare?', 'У вас есть что-нибудь подлежащее декларации?', 'custom'),
       ('You have to pay duty on these items', 'Вы должны уплатить за это пошлину', 'custom'),
       ('I only have items for personal use', 'У меня только предметы личного пользования', 'custom'),
       ('I have nothing to declare', 'Мне нечего декларировать', 'custom'),
       ('Where is the parking lot, please?', 'Где находится парковка?', 'car'),
       ('Can I park my car here?', 'Здесь можно припарковаться?', 'car'),
       ('Where is the nearest petrol station?', 'Где ближайшая заправочная станция?', 'car'),
       ('How much petrol would you like?', 'Сколько бензина вы желаете?', 'car'),
       ('Full, please', 'Полный бак пожалуйста', 'car'),
       ('20 litres, please', '20 литров, пожалуйста', 'car'),
       ('This car takes diesel', 'Эта машина заправляется дизелем', 'car'),
       ('I would like some oil', 'Мне нужно масло', 'car'),
       ('Can I check my tyre pressure here?', 'Тут можно проверить давление в колесах?', 'car'),
       ('Can I have the car washed?', 'Здесь можно помыть машину?', 'car'),
       ('The car has broken down', 'Машина сломалась', 'car'),
       ('The car will not start', 'Машина не заводится', 'car'),
       ('We have run out petrol', 'У нас закончился бензин', 'car'),
       ('The battery is flat', 'Сел аккумулятор', 'car'),
       ('I have got a flat tyre', 'У меня спустило колесо', 'car'),
       ('I have got a puncture', 'У меня проколото колесо', 'car'),
       ('The car is loosing oil', 'Из машины течет масло', 'car'),
       ('The .. is not\are not working', 'Не работает', 'car'),
       ('Speedometer', 'Спидометр', 'car'),
       ('Fuel gauge', 'Датчик топлива', 'car'),
       ('Brake lights', 'Стоп-сигналы', 'car'),
       ('Marker lights', 'Габаритные огни', 'car'),
       ('There is some problem with ..', 'Какие-то проблемы с ..', 'car'),
       ('The engine', 'С мотором', 'car'),
       ('The steering', 'С рулевым управлением', 'car'),
       ('The brakes', 'С тормозами', 'car'),
       ('Show me your driving licence, please', 'Покажите ваши водительские права', 'car'),
       ('Do you know how fast you were going?', 'Вы знаете с какой скоростью вы ехали?', 'car'),
       ('Do you have insurance on this vehicle?', 'У вас есть страховка на это транспортное средство?', 'car'),
       ('Could I see your insurance documents?', 'Могу я увидеть вашу страховку?', 'car'),
       ('Have you had anything to drink?', 'Вы принимали алкоголь?', 'car'),
       ('How much have you had to drink?', 'Как много вы выпили?', 'car'),
       ('Could you blow into this tube, please?', 'Подуйте в эту трубку пожалуйста', 'car'),
       ('Do you have any vacancies?', 'У вас есть свободные места?', 'hotel'),
       ('From what date?', 'С какого числа?', 'hotel'),
       ('For how many nights?', 'На сколько ночей?', 'hotel'),
       ('How long will you be staying for?', 'Как долго вы планируете оставаться?', 'hotel'),
       ('What sort of room would you like?', 'Какой номер вы желаете?', 'hotel'),
       ('Does the room have ... ?', 'В этом номере есть ...?', 'hotel'),
       ('Internet access', 'Доступ в интернет', 'hotel'),
       ('air conditioning', 'Кондиционер', 'hotel'),
       ('Is there a ...?', 'Есть ли тут ...?', 'hotel'),
       ('Swimming pool', 'Бассейн', 'hotel'),
       ('Sauna', 'Сауна', 'hotel'),
       ('Do you have a car park?', 'У вас есть автомобильная стоянка?', 'hotel'),
       ('What is the price per night?', 'Сколько стоит одна ночь?', 'hotel'),
       ('Is breakfast included?', 'Завтракт включен?', 'hotel'),
       ('Can you offer me any discount?', 'Вы можете сделать скидку?', 'hotel'),
       ('Could I see the room?', 'Я могу посмотреть комнату?', 'hotel'),
       ('Ok, I will take it', 'Хорошо, я беру этот номер', 'hotel'),
       ('I would like to make a reservation', 'Я хотел бы произвести бронирование', 'hotel'),
       ('Can I take your credit card number', 'Назовите ваш номер кредитки', 'hotel'),
       ('What time will you be arriving', 'Вос сколько вы приезжаете?', 'hotel'),
       ('I have got a reservation', 'У меня забронировано', 'hotel'),
       ('My booking was for a twin room', 'Я бронировал номер с двумя кроватями', 'hotel'),
       ('My booking was for a double room', 'Я бронировал двухместный номер с одной кроватью', 'hotel'),
       ('What time is breakfast?', 'Во сколько завтрак?', 'hotel'),
       ('Where is the breakfast place?', 'Где находится место завтрака?', 'hotel'),
       ('Could I have breakfast in my room, please?', 'Могу я заказать завтрак в номер пожалуйста?', 'hotel'),
       ('What time is the restaurant open for dinner?', 'Во сколько ресторан открывается для ужина?', 'hotel'),
       ('What time does the bar close?', 'Во сколько закрывается бар?', 'hotel'),
       ('Would you like any help with your luggage?', 'Вам нужна помощь с багажом?', 'hotel'),
       ('Here is your room key', 'это ваш ключ от номера', 'hotel'),
       ('Your room number is 259', 'Ваш номер 259', 'hotel'),
       ('Your room is the first floor', 'Ваш номер на втором этаже', 'hotel'),
       ('Where are the lifts?', 'Где лифты?', 'hotel'),
       ('My room number is 259', 'Мой номер 259', 'hotel'),
       ('Could I have a wake-up call at seven o`clock?', 'Вы могли бы разбудить меня в 7 утра?', 'hotel'),
       ('Where do we have breakfast?', 'Где мы можем позавтракать?', 'hotel'),
       ('Where is the restaurant?', 'Где находится ресторан?', 'hotel'),
       ('Could you please call me a taxi?', 'Вы не могли бы вызвать мне такси?', 'hotel'),
       ('Are there any laundry facilities?', 'Тут можно постирать одежду?', 'hotel'),
       ('What time do I need to check out?', 'Во сколько я должен освободить номер?', 'hotel'),
       ('Would it be possible to have a late check out?', 'Возможно ли освободить номер попозже?', 'hotel'),
       ('The key does not work', 'Ключ не подходит', 'hotel'),
       ('There is no hot water', 'Нет горячей воды', 'hotel'),
       ('The room is too ... hot, cold, noisy', 'В номере слишком ... жарко, холодно, шумно', 'hotel'),
       ('The ... does not work', '... не работает', 'hotel'),
       ('heating, shower, television', 'отопление, душ, телевизор', 'hotel'),
       ('There is no ... toilet paper, soap, shampoo', 'Там нет бумаги, мыла, шампуня', 'hotel'),
       ('Could I have a towel, please?', 'Не могли бы вы дать мне полотенце?', 'hotel'),
       ('My room has not been made up', 'Моя комната не прибрана', 'hotel'),
       ('Could you please change the sheets?', 'Поменяйте постельное белье пожалуйста', 'hotel'),
       ('I have lost my room key', 'Я потерял ключ от номера', 'hotel'),
       ('I want to leave one day earlier', 'Я хотел бы уехать на день раньше', 'hotel'),
       ('I would like to extend my stay for a few days', 'Я хотел бы продлить свое пребывание на несколько дней', 'hotel'),
       ('I would like to check out', 'Я хотел бы освободить номер', 'hotel'),
       ('May I have the bill?', 'Могу я получить счет?', 'hotel'),
       ('I would like to pay my bill, please', 'Я хотел бы оплатить счет', 'hotel'),
       ('How would you like to pay?', 'Как вы желаете оплатить?', 'hotel'),
       ('I will pay ... by credit card, in cash', 'Я заплачу ... кредиткой, наличными', 'hotel'),
       ('Have you used the minibar?', 'Вы пользовались минибаром?', 'hotel'),
       ('We have not used the minibar', 'Мы не пользовались минибаром', 'hotel'),
       ('Could I have a receipt, please?', 'Могу я получить чек, пожалуйста?', 'hotel'),
       ('I hope you had an enjoyable stay', 'Надеюсь ваше пребывание было приятным', 'hotel'),
       ('I have really enjoyed my stay', 'Мое пребывание было очень приятным', 'hotel');
