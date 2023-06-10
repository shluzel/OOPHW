const number1 = Number.parseInt(prompt("Введите температуру в градусах Цельсия"));
alert (`Температура в градусах Фарегейта: ${(Math.trunc((number1 * 1.8 + 32) * 100) / 100)}`);