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

/**
 *
 * @author Manel Tarazona Garcia
 */
public final class UtilesFecha {

    private UtilesFecha() {
    }

    public static final String devuelveFecha(int num) {
        String fecha = "";
        switch (num) {
            case 1:
                fecha = "Enero";
                break;
            case 2:
                fecha = "Febrero";
                break;
            case 3:
                fecha = "Marzo";
                break;
            case 4:
                fecha = "Abril";
                break;
            case 5:
                fecha = "Mayo";
                break;
            case 6:
                fecha = "Junio";
                break;
            case 7:
                fecha = "Julio";
                break;
            case 8:
                fecha = "Agosto";
                break;
            case 9:
                fecha = "Septiembre";
                break;
            case 10:
                fecha = "Octubre";
                break;
            case 11:
                fecha = "Noviembre";
                break;
            case 12:
                fecha = "Diciembre";
                break;
        }
        return fecha;
    }

    public static final boolean validarBisiesto(int ano) {
        boolean validar = ano % 400 == 0 || ano % 100 != 0 && ano % 4 == 0;
        return validar;
    }

    public static final int contarDiasMes(int mes, int ano) {
        int dias;
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            dias = 31;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            dias = 30;
        } else if (mes == 2 && validarBisiesto(ano)) {
            dias = 29;
        } else if (mes == 2) {
            dias = 28;
        } else {
            dias = 0;
        }
        return dias;
    }

    public static final int calcularDiasRestantesMes(int diaIni, int diaFin, int mes, int ano) {
        int dias;
        if (diaIni < 1 || diaIni > contarDiasMes(mes, ano)) {
            dias = 0;
        } else if (diaFin < 1 || diaFin > contarDiasMes(mes, ano)) {
            dias = 0;
        } else if (diaFin <= diaIni) {
            dias = 0;
        } else {
            dias = contarDiasMes(mes, ano) - diaIni;
        }
        return dias;
    }

    public static final int contarDiasEntreMeses(int mes, int diaIni, int diaFin, int ano) {
        int dias;
        dias = calcularDiasRestantesMes(diaIni, diaFin, mes, ano) + diaFin;
        return dias;
    }

    public static final int calcularDosMesesComplejos(int mesIni, int mesFin, int ano) {
        int dias = 0;
        for (int mes = mesIni; mes <= mesFin; mes++) {
            dias = dias + contarDiasMes(mes, ano);
        }
        return dias;
    }
    
    public static final int calcularMesesCompletosAno(int mesIni, int mesFin, int diaIni, int diaFin, int ano) {
        int dias = calcularDiasRestantesMes(diaIni, diaFin, mesIni, ano);
        if (mesFin > mesIni + 1) {
            dias = dias + calcularDosMesesComplejos(mesIni + 1, mesFin - 1, ano);
        }
        dias = dias + diaFin;
        if (mesIni == mesFin) {
            dias = diaFin - diaIni;
        }
        return dias;
    }

    public static final int calcularDiasRestantesAno(int dias, int mes, int ano) {
        int dia = calcularMesesCompletosAno(mes, 12, dias, 31, ano);
        return dia;
    }

    public static final int calcularDiasLlevadosAno(int dias, int mes, int ano) {
        int dia = calcularMesesCompletosAno(1, mes, 1, dias, ano) + 1;
        return dia;
    }

    public static final int calcularDiasAnosProximos(int dias, int diasFin, int mesIni, int mesFin, int ano) {
        int diaPrimerano = calcularDiasRestantesAno(dias, mesIni, ano);
        int diaAnoProximo = calcularDiasLlevadosAno(diasFin, mesFin, ano + 1);
        return diaPrimerano + diaAnoProximo;
    }

    public static final int calcularDiasAnosCompletos(int anoIni, int anoFin) {
        int dias = 0;
        for (int ano = anoIni; ano <= anoFin; ano++) {
            if (ano % 400 == 0 || ano % 100 != 0 && ano % 4 == 0) {
                dias = dias + 366;
            } else if (!(ano % 400 == 0 || ano % 100 != 0 && ano % 4 == 0)) {
                dias = dias + 365;
            }
        }
        return dias;
    }

    public static final int calcularAnosCompletos(int mesIni, int mesFin, int diaIni, int diaFin, int ano, int anoFin) {
        int dias = calcularDiasRestantesAno(diaIni, mesIni, ano);
        int diaAnoFinal = calcularDiasLlevadosAno(diaFin, mesFin, anoFin);
        if (anoFin > ano + 1) {
            dias = dias + calcularDiasAnosCompletos(ano + 1, anoFin - 1);
        }
        dias = dias + diaAnoFinal;
        if (ano == anoFin) {
            dias = calcularMesesCompletosAno(mesIni, mesFin, diaIni, diaFin, ano);
        }
        return dias;
    }
}
