package com.izunatan.passwordsecurity.service;

public class Obfuscation {
    public void n(int f[])
    {
        int n = f.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            y(f, n, i);
        for (int i = n - 1; i > 0; i--) {
            int p = f[0];
            f[0] = f[i];
            f[i] = p;
            y(f, i, 0);
        }
    }

    void y(int w[], int n, int i)
    {
        int u = i;
        int m = 2 * i + 1;
        int g = 2 * i + 2;
        if (m < n && w[m] > w[u])
            u = m;
        if (g < n && w[g] > w[u])
            u = g;
        if (u != i) {
            int j = w[i];
            w[i] = w[u];
            w[u] = j;
            y(w, n, u);
        }
    }

    static void z(int v[])
    {
        int n = v.length;
        for (int i = 0; i < n; ++i)
            System.out.print(v[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int u[] = { 12, 11, 13, 5, 6, 7 };
        int n = u.length;
        Obfuscation k = new Obfuscation();
        k.n(u);
        z(u);
    }
}
