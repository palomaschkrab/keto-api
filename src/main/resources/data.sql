-- Ingredients
INSERT INTO ingredients (name)
VALUES
	('mozzarella'),
	('cream cheese'),
	('almond flour'),
	('salt'),
	('egg'),
	('oregano'),
	('psyllium rusk'),
	('yeast'),
	('yeast for bread'),
	('baking powder'),
	('olive oil'),
	('broccoli'),
	('chopped broccoli'),
	('cheddar'),
	('cheddar (in cubes)'),
	('almonds'),
	('thinly sliced almonds'),
	('red onion'),
	('diced red onion'),
	('bacon'),
	('bacon (fried and crambled)'),
	('mayonnaise'),
	('sour cream'),
	('onion powder'),
	('garlic powder'),
	('wine vinegar'),
	('white vinegar'),
	('large egg'),
	('dried parsley'),
	('Pink Himalayan salt'),
	('Sriracha Hot  chili sauce'),
	('chicken breast'),
	('cod fish'),
	('onion'),
	('green pepper'),
	('yellow pepper'),
	('red pepper'),
	('black olive'),
	('heavy cream'),
	('yellow mustard'),
	('paprika'),
	('black pepper'),
	('parsley'),
	('coconut oil'),
	('peanut butter'),
	('cocoa powder'),
	('sweetner'),
	('vanila extract'),
	('unsalted butter'),
	('butter'),
	('Beef Stew'),
	('grape tomatoes'),
	('soy sauce'),
	('garlic'),
	('parmesan cheese'),
	('coarse sea salt');
	
-- Recipe 3-min-bread
insert into images(url) values ('https://s3.ca-central-1.amazonaws.com/how.to.keto.cook.recipes.images/bread.jpg');
insert into macro_nutrients(carbs, fat, protein) values(0.0, 0.0, 0.0);

insert into recipes(name, cooking_time, prep_time, portions, note, additional_info, image_id, macronutrients_id, approved) values('3-min keto bread', 2, 1, 1, 'I usually cut the bread, fill it with cheese and turkey and put it on a frying pan', 'Missing the bread? This keto bread is super easy and you can use your favorite filling. I usually do it for breakfast', (select max(id) from images), (select max(id) from macro_nutrients), true);	
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(3, 'TABLE_SPOON', (select id from ingredients where name = 'almond flour'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(0.5, 'TEA_SPOON', (select id from ingredients where name = 'baking powder'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(1.0, 'TABLE_SPOON', (select id from ingredients where name = 'olive oil'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(1.0, 'UNIT', (select id from ingredients where name = 'egg'), (select max(id) from recipes));

insert into instructions (index, step, recipe_id) values(1, 'Mix almond flour and paking powder in bread size recipient', (select max(id) from recipes));
insert into instructions (index, step, recipe_id) values(2, 'Add oil and egg', (select max(id) from recipes));
insert into instructions (index, step, recipe_id) values(3, 'Beat it like you are making an omelette', (select max(id) from recipes));
insert into instructions (index, step, recipe_id) values(4, 'Microwave on high for 90 seconds', (select max(id) from recipes));

--Recipe Brocolli salad	
insert into images(url) values ('https://s3.ca-central-1.amazonaws.com/how.to.keto.cook.recipes.images/broccoli_salad.jpg');
insert into macro_nutrients(carbs, fat, protein) values(0.0, 0.0, 0.0);

insert into recipes(name, cooking_time, prep_time, portions, additional_info, image_id, macronutrients_id, approved) values('Broccoli Salad with Bacon', 5, 10, 5, 'This keto salad is perfect for those moments when you want something easy, tasty and more colorful. It goes well with your protein and makes your meal look amazing', (select max(id) from images), (select max(id) from macro_nutrients), true);	
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(8, 'CUP', (select id from ingredients where name = 'chopped broccoli'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(6, 'OUNCE', (select id from ingredients where name = 'cheddar (in cubes)'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(0.25, 'CUP', (select id from ingredients where name = 'diced red onion'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(0.25, 'CUP', (select id from ingredients where name = 'thinly sliced almonds'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(8, 'SLICE', (select id from ingredients where name = 'bacon (fried and crambled)'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(0.5, 'CUP', (select id from ingredients where name = 'mayonnaise'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(0.25, 'CUP', (select id from ingredients where name = 'sour cream'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(2, 'TEA_SPOON', (select id from ingredients where name = 'onion powder'), (select max(id) from recipes));
insert into recipe_ingredients(quantity, unit,ingredient_id, recipe_id) values(1, 'TEA_SPOON', (select id from ingredients where name = 'wine vinegar'), (select max(id) from recipes));

insert into instructions (index, step, recipe_id) values(1, 'Add the chopped broccoli, cheddar, onion, almonds, and bacon to a large mixing bowl and stir to combine', (select max(id) from recipes));
insert into instructions (index, step, recipe_id) values(2, 'Add mayo, sour cream, onion powder, and vinegar to a small mixing bowl and stir as well', (select max(id) from recipes));
insert into instructions (index, step, recipe_id) values(3, 'Pour the dressing over the broccoli mixture and stir well to coat', (select max(id) from recipes));
	
	
	