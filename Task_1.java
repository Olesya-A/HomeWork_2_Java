/**
Задание 1.
Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.

Входная строка:
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

Выходная строка:
select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"
 */

/**
 * Task_1
 */
public class Task_1 {

    public static void main(String[] args) {
        String strDirty = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String str = strDirty.replace("{", "").replace("}", "")
                .replace("\"", "");
        String[] arr = str.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("select * from students where ");
        for (String pair : arr) {
            String[] arrFinal = pair.split(":");
            arrFinal[0] = arrFinal[0].trim();
            arrFinal[1] = arrFinal[1].trim();
            if (arrFinal[1].equals("null") == false) {
                sb.append(arrFinal[0]).append(" = ").append("'").append(arrFinal[1]).append("'");
                sb.append(" and ");
            }
        }
        sb.delete(sb.length()-4, sb.length());
        System.out.print(sb);
    }
}
