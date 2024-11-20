# Conversor de Moedas

Este projeto é um Conversor de Moedas que oferece interação textual (via console) com os usuários, proporcionando no mínimo 6 opções distintas de conversões de moedas em um menu. As taxas de conversão são obtidas dinamicamente por meio de uma API, garantindo dados precisos e em tempo real para uma experiência mais atualizada e eficaz.

## Funcionalidades

- **Conversão Dinâmica:** As taxas de conversão são atualizadas em tempo real utilizando a API Exchange Rate API.
- **Interação com o Usuário:** O usuário pode interagir com o programa via console, escolhendo a moeda de origem e a moeda de destino para realizar a conversão.
- **Várias Moedas Suportadas:** Suporta pelo menos 6 opções distintas de moedas para conversão.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação usada para desenvolver o projeto.
- **IntelliJ IDEA:** IDE usada para desenvolvimento do projeto.
- **Gson:** Biblioteca utilizada para manipulação de JSON.
- **API Exchange Rate API:** API utilizada para obter as taxas de câmbio em tempo real.

## Pré-requisitos

- **JDK:** Java Development Kit instalado.
- **IntelliJ IDEA:** Ou outra IDE de sua preferência.
- **Biblioteca Gson:** Incluída no projeto via dependência Maven.

## Configuração do Ambiente

1. **Instalar o JDK:** Baixe e instale o JDK do site da Oracle [aqui](https://www.oracle.com/java/technologies/javase-downloads.html).
2. **Instalar IntelliJ IDEA:** Baixe e instale o IntelliJ IDEA [aqui](https://www.jetbrains.com/idea/download/).

## Dependências

Adicione a dependência Gson no `pom.xml` se estiver utilizando Maven:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>
