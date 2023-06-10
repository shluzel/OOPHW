const celsius = Number.parseInt(prompt("Введите температуру в градусах Цельсия"));
alert (`Температура в градусах Фарегейта: ${(Math.trunc((celsius * 1.8 + 32) * 100) / 100)}`);