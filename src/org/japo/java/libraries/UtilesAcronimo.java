/*
 * Copyright 2023 alumnoT.
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

/**
 *
 * @author alumnoT
 */
public class UtilesAcronimo {

    public static final String calcularAcronimo(String msg) {
        String s = msg;
        StringBuilder sb = new StringBuilder();
        String[] items = s.split(" ");
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i].charAt(0));
        }
        String a = sb.toString();
        System.out.println(s);
        //System.out.println(a);
        return a;
    }

    public static final String mostrarAcronimo() {
        String s = "Manel Eduard Tarazona Garcia";
        String resto = s;
        String a = s.charAt(0) + "";

        int posicion;
        do {
            posicion = s.indexOf(" ");
            if (posicion >= 0) {
                resto = resto.substring(posicion + 1);
                a = a + resto.charAt(0);
            }
        } while (posicion >= 0);

//        System.out.println("Acronimo...: " + a);
        return a;
    }
}
