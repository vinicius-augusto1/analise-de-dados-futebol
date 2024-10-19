# Análise de Dados do Futebol

Este projeto tem como foco a análise de dados de partidas de futebol, oferecendo a capacidade de extrair e calcular diversas estatísticas sobre jogadores, times, cartões, entre outros aspectos importantes. Utilizando arquivos CSV, a aplicação permite a leitura de dados e oferece funcionalidades para realizar consultas e gerar insights relevantes sobre o desempenho dos participantes no campeonato.

## Estrutura do Projeto

O projeto está organizado de maneira a facilitar a separação de responsabilidades e garantir que cada parte tenha seu papel claramente definido. Abaixo, descrevemos os principais diretórios e seus conteúdos:

- O pacote `controller` é responsável por controlar o fluxo principal da aplicação. A classe principal, `CampeonatoController`, gerencia as interações e a execução do campeonato.

- Em `data`, encontram-se os arquivos CSV que contêm os dados brutos do campeonato, como estatísticas gerais, cartões, e dados de gols.

- O diretório `exceptions` lida com as exceções personalizadas. Ele inclui exceções como `ArquivoNaoEncontradoException` e `DadosIncompletosException`, que tratam erros comuns relacionados à falta de arquivos ou dados incorretos.

- No pacote `model`, encontram-se as classes que representam as entidades do projeto, como `Jogador`, `Time`, `Partida`, `Cartao`, e `Estatistica`. Essas classes modelam os principais elementos do sistema.

- O diretório `repository` contém a lógica para manipulação e persistência dos dados lidos dos arquivos CSV, com classes como `JogadorRepository`, `TimeRepository`, e `PartidaRepository`.

- O pacote `service` abriga a lógica de negócios, como a manipulação de estatísticas do campeonato, que é gerenciada pela classe `CampeonatoService`.

- No diretório `utils`, temos utilitários como `LeitorCsv`, responsável pela leitura dos dados dos arquivos, e `MenuEstilizado`, que oferece uma interface mais amigável para o usuário interagir com a aplicação.

- Finalmente, o arquivo `Main` é o ponto de entrada do sistema, onde a execução da aplicação começa.

## Pré-requisitos

Para compilar e executar o projeto, é necessário ter os seguintes itens instalados:

- **Java 21** ou uma versão superior.

## Como Compilar o Projeto

A compilação do projeto é bastante simples.
Primeiro você deve clonar o repositório. 
```bash
git clone https://github.com/vinicius-augusto1/analise-de-dados-futebol.git
```
Após isso navegue até o diretório raiz do projeto e execute o seguinte comando para compilar todos os arquivos:
```bash
javac -d out $(find src -name "*.java")
```

## Como Executar o Projeto
```bash
java -cp out Main
```

Isso iniciará a aplicação e você será apresentado a um menu, que permitirá explorar as estatísticas dos jogadores, times, e partidas registradas no campeonato.


## Funcionalidades Principais
Entre as principais funcionalidades da aplicação, estão:

- Consulta de Estatísticas de Jogadores: Permite visualizar o desempenho individual de cada jogador, incluindo gols, assistências e cartões recebidos.

- Análise de Partidas: Detalha informações sobre as partidas jogadas, como placar e jogadores envolvidos.

- Ranking de Times: Exibe a classificação dos times com base em seus resultados ao longo do campeonato.

- Estatísticas de Cartões: Permite consultar quais jogadores receberam mais cartões amarelos e vermelhos, proporcionando uma visão clara sobre o comportamento disciplinar dos atletas.

## Tratamento de Exceções
O sistema inclui várias exceções personalizadas para melhorar o tratamento de erros:

- ArquivoNaoEncontradoException: Lançada quando algum dos arquivos CSV necessários não é encontrado no diretório de dados.

- DadosIncompletosException: Lançada quando os dados no arquivo estão incompletos ou corrompidos, impedindo o correto processamento das estatísticas.

- EstatisticaNaoEncontradaException: Lançada quando uma estatística solicitada não pode ser encontrada nos dados disponíveis.
