package org.example;

import lombok.SneakyThrows;

import java.io.*;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу UPIT из файла contest7_tasks.pdf
     */
    @SneakyThrows
    public void upit(InputStream in, OutputStream out) {

        if (in == null) {
            throw new IllegalArgumentException("Входящий поток не может быть null");
        }
        if (out == null) {
            throw new IllegalArgumentException("Выходящий поток не может быть null");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter pw = new PrintWriter(out);

        String[] first = br.readLine().split(" ");

        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);
        long[] a = new long[200001];


        String[] strings = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(strings[i - 1]);
        }

        while (q > 0) {
            q--;
            String[] command = br.readLine().split(" ");
            int operation = Integer.parseInt(command[0]);
            int x = Integer.parseInt(command[1]);
            int y = Integer.parseInt(command[2]);
            long z = Long.parseLong(command[3]);
            switch (operation) {
                // update
                case 1:
                    for (int i = x; i <= y; i++) {
                        a[i] = z;
                    }
                    break;
                // add
                case 2:
                    long sum_2 = 0;
                    for (int i = x; i <= y; i++) {
                        sum_2 += z;
                        a[i] += sum_2;
                    }
                    break;
                // insert
                case 3:
                    int u = Integer.parseInt(command[1]);
                    long l = Long.parseLong(command[2]);
                    n++;
                    for (int i = n; i > u; i--) {
                        a[i] = a[i - 1];
                    }
                    a[u] = l;
                    break;
                // sum
                case 4:
                    long sum_4 = 0;
                    for (int i = x; i <= y; i++) {
                        sum_4 += a[i];
                    }
                    pw.println(sum_4);
                    break;
            }
        }
    }
}
