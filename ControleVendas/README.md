#### Projeto Controle de Vendas Desktop


+ 60. Retornando o Id da ultima venda e enviando o carrinho para a tela de Pagamentos

Regra de Negocio para finalizar uma venda

1 - Usuario seleciona os produtos

2 - Salvar a venda
    -> Id do cliente (cliente_id)
    -> Data da venda
    -> Total da venda
    -> Observaçoes da venda

3 - Retorna o id da venda efetuada

4 - Cadastra todos os itens do carrinho vinculados a ultima venda

5 - Realiza a baixa no estoque de produtos
    -> Pega o valor do estoque atual de cada item 
    -> Subtrai a quantidade vendida
    -> inseri o valor atualizado em qtd na tabela produtos

6 - Finaliza a venda


