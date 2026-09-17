package br.com.calculadora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar/{numero1}/{numero2}")
    public BigDecimal somar(@PathVariable BigDecimal numero1, @PathVariable BigDecimal numero2) {
        return numero1.add(numero2);
    }

    @GetMapping("/subtrair")
    public BigDecimal subtrair(@RequestParam BigDecimal numero1, @RequestParam BigDecimal numero2) {
        return numero1.subtract(numero2);
    }

    @GetMapping("/calcular/{operacao}")
    public String calcular(
            @PathVariable String operacao,
            @RequestParam BigDecimal numero1,
            @RequestParam BigDecimal numero2,
            @RequestParam(defaultValue = "2") int casasDecimais) {

        String operacaoNormalizada = operacao.toLowerCase(Locale.ROOT);
        BigDecimal resultado;
        String nomeOperacao;

        switch (operacaoNormalizada) {
            case "somar":
                resultado = numero1.add(numero2);
                nomeOperacao = "soma";
                break;
            case "subtrair":
                resultado = numero1.subtract(numero2);
                nomeOperacao = "subtração";
                break;
            case "multiplicar":
                resultado = numero1.multiply(numero2);
                nomeOperacao = "multiplicação";
                break;
            case "dividir":
                if (numero2.compareTo(BigDecimal.ZERO) == 0) {
                    return "Erro: não é possível dividir por zero.";
                }
                resultado = numero1.divide(numero2, casasDecimais, RoundingMode.HALF_UP);
                nomeOperacao = "divisão";
                break;
            default:
                return "Erro: operação inválida. Use somar, subtrair, multiplicar ou dividir.";
        }

        return "Operação: " + nomeOperacao + "\n"
                + "Número 1: " + numero1.stripTrailingZeros().toPlainString() + "\n"
                + "Número 2: " + numero2.stripTrailingZeros().toPlainString() + "\n"
                + "Resultado: " + resultado.stripTrailingZeros().toPlainString();
    }

    @GetMapping("/par-ou-impar/{numero}")
    public String parOuImpar(@PathVariable long numero) {
        return numero % 2 == 0 ? "PAR" : "ÍMPAR";
    }

    @GetMapping("/analisar/{numero}")
    public String analisar(@PathVariable BigDecimal numero) {
        BigDecimal dois = BigDecimal.valueOf(2);
        String paridade = numero.remainder(dois).compareTo(BigDecimal.ZERO) == 0 ? "PAR" : "ÍMPAR";
        String sinal = numero.compareTo(BigDecimal.ZERO) > 0
                ? "POSITIVO"
                : numero.compareTo(BigDecimal.ZERO) < 0 ? "NEGATIVO" : "ZERO";

        return "Número: " + numero.stripTrailingZeros().toPlainString() + "\n"
                + "Par ou ímpar: " + paridade + "\n"
                + "Positivo, negativo ou zero: " + sinal + "\n"
                + "Dobro: " + numero.multiply(dois).stripTrailingZeros().toPlainString() + "\n"
                + "Metade: " + numero.divide(dois).stripTrailingZeros().toPlainString() + "\n"
                + "Quadrado: " + numero.pow(2).stripTrailingZeros().toPlainString();
    }

    @GetMapping("/media")
    public String media(
            @RequestParam BigDecimal nota1,
            @RequestParam BigDecimal nota2,
            @RequestParam BigDecimal nota3) {

        BigDecimal media = nota1.add(nota2).add(nota3).divide(BigDecimal.valueOf(3), 1, RoundingMode.HALF_UP);
        String situacao = media.compareTo(BigDecimal.valueOf(7)) >= 0
                ? "APROVADO"
                : media.compareTo(BigDecimal.valueOf(4)) >= 0 ? "RECUPERAÇÃO" : "REPROVADO";

        return "Média: " + media.toPlainString() + "\n"
                + "Situação: " + situacao;
    }
}
