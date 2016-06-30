Feature: Busca
  As a funcionário no setor administrativo
  I want to buscar equipamentos pelos nomes
  So that posso saber informações sobre os equipamentos cadastrados

  Scenario: Busca utilizando nome completo
    Given exista cadastrados equipamentos "monitor","cpu" e "tv"
    When solicito uma busca por "monitor"
    Then o nome "monitor" esta contido na lista

  Scenario: Busca utilizando nome completo redericionamento
    Given eu criei os equipamentos "monitor" e "cpu"
    And eu estou na página de index
    When preencho o campo de busca com o nome "monitor" e seleciono o buscar
    Then a página de busca será reedericionada para uma página de resultado


  Scenario: Busca equipamento não existente
    Given eu estou na página de index
    And não exista nenhum equipamento cadastrado com nome "mouse"
    When preencho o campo de busca com o nome "mouse" e seleciono o buscar
    Then na página de index uma mensagem é exibida

  Scenario: Busca utilizando nome incompleto
    Given exista cadastrados equipamentos "monitor","cpu" e "tv"
    When solicito uma busca por "monit"
    Then o nome "monitor" esta contido na lista
