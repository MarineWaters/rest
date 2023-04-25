package visual;

import requests.Data;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Write /start to start the game(doesn't work during the game). " +
                           "Write /q to quit the game. Questions are random and appear automatically.");
        Data data = new Data();
        Questions qu = new Questions();
        Scanner in = new Scanner(System.in);
        String response, ans;
        for (response = in.nextLine(); !Objects.equals(response, "/start"); ) {
            if (Objects.equals(response, "/q")) {
                break;
            }
        }
        while (true) {
            if ("/q".equals(response)) {
                data.statistics();
                break;
            } else {
                ans = qu.newQuestion();
                if (Objects.equals(ans, "/q"))
                    break;
                data.setOriginalAnswer(qu.original());
                data.result(ans);
            }
        }
    }
}