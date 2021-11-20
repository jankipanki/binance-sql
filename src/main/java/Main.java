import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Connection connect = Jsoup.connect("https://api.binance.com/api/v3/ticker/price");
        Document document = connect.ignoreContentType(true).get();
        Elements allTd = document.select("html");
        String str = allTd.text();
        int i = 1;

        String finalStr = str
                .replace(":", "")
                .replace("symbol", "")
                .replace("price", "")
                .replace("[{", "")
                .replace("}]", "")
                .replace("\"", "")
                .replace(",", ";");

        String[] division = finalStr.split("};\\{");
//        DbConnector.connect();

        for (String word : division) {
            String newWord = word.replace(";", "\", ");
            String instructionForSQL = "INSERT INTO binance (id, name_binance, value_binance) VALUES ("+ i + ", \"" + newWord + ")";
            Query.executeQuery(instructionForSQL);
            i++;
        }

        System.out.println("Aktualne kursy kryptowalut dla giełdy binance zostały zapisane w bazie danych.");
    }
}
