Аналог валидатора скобок, работающего во многих IDE.
Проверяет, все ли скобки корректно закрыты.
Правильной считается строка, где у каждой скобки есть закрывающая скобка.
При этом скобку одного типа может закрывать только скобка такого же типа.

На вход подается массив строк, состоящих из скобок: `{}[]()`
Если строка прошла валидацию, возвращаем true, если нет, то false.