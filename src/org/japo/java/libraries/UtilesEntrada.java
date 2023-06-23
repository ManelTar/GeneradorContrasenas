/*
 * Copyright 2022 Javi - javgonpen@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author javi
 */
public final class UtilesEntrada {

    public static final Scanner SCN = new Scanner(System.in, "Windows-1252").useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final int leerEntero(String msg) {
        int num = 0;
        boolean esEntero = false;
        do {
            try {
                System.out.print(msg);
                num = SCN.nextInt();
                esEntero = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println("ERROR: Entrada incorrecta");
            } finally {
                System.out.println("---");
                SCN.nextLine();
            }
        } while (!esEntero);
        return num;
    }

    public static final int leerEnteroRango(String msg, int min, int max) {
        int num;
        boolean esRango;
        do {
            num = leerEntero(msg);
            esRango = num >= min && num <= max;
            if (!esRango) {
                System.out.println("ERROR NO esta en rango");
                System.out.println("---");
            }
        } while (!esRango);
        return num;
    }

    public static final char leerCaracter(String msg) {
        char caracter = ' ';
        boolean esCaracter = false;
        do {
            try {
                System.out.print(msg);
                caracter = SCN.nextLine().charAt(0);
                esCaracter = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println("ERROR: Entrada incorrecta");
            }
        } while (!esCaracter);
        return caracter;
    }

    public static final char leerCaracterRango(String msg, char min, char max) {
        char caracter;
        boolean esRango;
        do {
            caracter = leerCaracter(msg);
            esRango = caracter >= min && caracter <= max;
            if (!esRango) {
                System.out.println("ERROR NO esta en rango");
                System.out.println("---");
            }
        } while (!esRango);
        return caracter;
    }

    public static final double leerReal(String msg) {
        double num = 0;
        boolean esEntero = false;
        do {
            try {
                System.out.print(msg);
                num = SCN.nextDouble();
                esEntero = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println("ERROR: Entrada incorrecta");
            } finally {
                System.out.println("---");
                SCN.nextLine();
            }
        } while (!esEntero);
        return num;
    }

    public static final double leerRealRango(String msg, double min, double max) {
        double num;
        boolean esRango;
        do {
            num = leerReal(msg);
            esRango = num >= min && num <= max;
            if (!esRango) {
                System.out.println("ERROR NO esta en rango");
                System.out.println("---");
            }
        } while (!esRango);
        return num;
    }

    public static final boolean leerBolean(String msg) {
        boolean esTrue = false;
        boolean esBoolean = false;
        do {
            try {
                System.out.print(msg);
                esTrue = SCN.nextBoolean();
                esBoolean = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println("ERROR: Entrada incorrecta");
            }
        } while (!esBoolean);
        return esTrue;
    }
    
    public static final double obtenerNumero(String msgUsr, String msgErr) {
        double num = 0;
        boolean esEntero = false;
        do {
            try {
                System.out.print(msgUsr);
                num = SCN.nextDouble();
                esEntero = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                System.out.println("---");
                SCN.nextLine();
            }
        } while (!esEntero);
        return num;
    }

}
