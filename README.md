# rest

В этот раз работает идеально. В сравнении идеально, конечно, тут всё равно куча проблем, вероятно... Но продвинулась вроде.

Изначально maven, в pom.xml добавила зависимости для логирования.
Распознаёт /start для начала, потом не может. /q может распознать при любом вводе. 
Берёт случайный вопрос с сайта(поэтому могут быть те же), вынимает regex-ом вопрос и правильный ответ, сравнивает с ответом пользователя, меняет показатели. В файл выводит информацию чуть подробнее. log4j2.xml отвечает за настройки уровней.
