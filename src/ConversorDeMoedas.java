import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorDeMoedas {

    public static String obterTaxasDeCambio() throws IOException {
        String urlStr = "https://api.exchangerate-api.com/v4/latest/USD";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Scanner sc = new Scanner(url.openStream());
        StringBuilder inline = new StringBuilder();
        while (sc.hasNext()) {
            inline.append(sc.nextLine());
        }
        sc.close();

        return inline.toString();
    }

    public static void main(String[] args) {
        try {
            String json = obterTaxasDeCambio();
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            JsonObject rates = jsonObject.getAsJsonObject("rates");

            // Map para armazenar moedas
            Map<Integer, Moeda> moedasMap = new HashMap<>();
            moedasMap.put(1, new Moeda("EUR", rates.has("EUR") ? rates.get("EUR").getAsDouble() : 0.0));
            moedasMap.put(2, new Moeda("GBP", rates.has("GBP") ? rates.get("GBP").getAsDouble() : 0.0));
            moedasMap.put(3, new Moeda("JPY", rates.has("JPY") ? rates.get("JPY").getAsDouble() : 0.0));
            moedasMap.put(4, new Moeda("BRL", rates.has("BRL") ? rates.get("BRL").getAsDouble() : 0.0));
            moedasMap.put(5, new Moeda("INR", rates.has("INR") ? rates.get("INR").getAsDouble() : 0.0));
            moedasMap.put(6, new Moeda("USD", 1.0)); // Adiciona USD para conversões

            Scanner scanner = new Scanner(System.in);
            int escolhaOrigem = -1;
            int escolhaDestino = -1;

            while (escolhaOrigem != 0 && escolhaDestino != 0) {
                System.out.println("Escolha a moeda de origem (digite 0 para sair):");
                for (Map.Entry<Integer, Moeda> entry : moedasMap.entrySet()) {
                    System.out.println(entry.getKey() + ". " + entry.getValue().getNome());
                }
                escolhaOrigem = scanner.nextInt();

                if (escolhaOrigem == 0) break;

                System.out.println("Escolha a moeda de destino (digite 0 para sair):");
                for (Map.Entry<Integer, Moeda> entry : moedasMap.entrySet()) {
                    System.out.println(entry.getKey() + ". " + entry.getValue().getNome());
                }
                escolhaDestino = scanner.nextInt();

                if (escolhaDestino == 0) break;

                if (moedasMap.containsKey(escolhaOrigem) && moedasMap.containsKey(escolhaDestino)) {
                    System.out.println("Digite o valor a ser convertido:");
                    double valor = scanner.nextDouble();

                    double taxaOrigemParaUSD = 1 / moedasMap.get(escolhaOrigem).getTaxa();
                    double taxaUSDParaDestino = moedasMap.get(escolhaDestino).getTaxa();
                    double valorConvertido = valor * taxaOrigemParaUSD * taxaUSDParaDestino;

                    System.out.println("Valor convertido: " + valorConvertido + " " + moedasMap.get(escolhaDestino).getNome());
                } else {
                    System.out.println("Escolha inválida. Tente novamente.");
                }
            }

            System.out.println("Programa finalizado.");
        } catch (IOException e) {
            System.out.println("Erro ao obter taxas de câmbio.");
            e.printStackTrace();
        }
    }
}


