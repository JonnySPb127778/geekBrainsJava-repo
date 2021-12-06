create table if not exists products (id bigserial primary key, title varchar(255), unit varchar(255), cost float);

insert into products (title, unit, cost)
values
('Хлеб', 'бух.', 68.95),
('Батон', 'бух.', 75.95),
('Хало', 'бух.', 85.95),
('Крендель', 'шт.', 45.75),
('Молоко', 'л', 65.35),
('Кефир', 'л', 70.25),
('Сливки', 'л', 120.25),
('Масло', 'кг', 520.25),
('Сметана', 'кг', 120.65),
('Сыр', 'кг', 585.69),
('Яйцо куриное','дес. шт.',  59.99),
('Яйцо перепелиное','дес. шт.',  79.99),
('Сёмга','кг',  1199.00),
('Форель','кг',  1349.00),
('Скумбрия','кг',  829.00),
('Раки','кг',  579.40),
('Курятина','кг',  150.99),
('Индюшатина','кг', 160.99),
('Говядина','кг',  325.49),
('Свинина','кг',   285.99);

