
# Aplicativos Android

Este repositório reúne diversos projetos desenvolvidos no Android Studio com foco em aprendizado prático. Cada aplicativo explora conceitos fundamentais da criação de interfaces, navegação entre telas e interação com o usuário utilizando a linguagem Java.

## 1. Simulador de Compras  
Aplicativo onde o usuário pode selecionar itens através de CheckBoxes e obter o valor final da compra com base nas escolhas feitas.

### Etapas do app:
- Apresentação de uma lista de produtos disponíveis.  
- O usuário marca os produtos que deseja adquirir.  
- O sistema calcula e exibe o preço total da seleção.

## 2. Reajuste de Salário  
Ferramenta simples que permite simular o aumento salarial de um funcionário a partir de percentuais predefinidos.

### Funcionamento:
- O usuário informa o salário atual.  
- Escolhe o percentual de reajuste (40%, 45% ou 50%).  
- O novo salário é calculado automaticamente e exibido na tela.

## 3. Cadastro de Clientes — Loja "Tem de Tudo"  
Aplicativo voltado ao registro rápido de novos clientes da loja "Tem de Tudo", ideal para feiras e eventos.

### Dinâmica:
- Tela inicial com botão para iniciar o cadastro.  
- Formulário simples para inserir o nome do cliente.  
- Após o envio, uma mensagem personalizada confirma o sucesso do cadastro.

## 4. Registro de Pedidos — Hamburgueria - "Lanche Fácil"  
Simula o atendimento básico em uma lanchonete, permitindo que o cliente escolha um lanche e visualize o pedido feito.

### Passos:
- Tela de boas-vindas com opção para iniciar um novo pedido.  
- Escolha de lanche e inserção do nome do cliente.  
- Tela final exibe o resumo com o nome e o item solicitado.

## 5. Simulação de Pedido em Pizzaria — **"Dante’s Pizza"**  
Aplicação divertida e interativa inspirada em jogos clássicos que simula o processo de pedido em uma pizzaria. O usuário escolhe sabores, tamanho da pizza e forma de pagamento, recebendo um resumo dinâmico ao final.

### Fluxo do app:
1. **Tela de Sabores:**  
   - O usuário escolhe um ou mais sabores entre Marguerita, Calabresa e Frango com Catupiry usando CheckBoxes.  
   - Cada sabor possui um valor fixo (R$30, R$40, R$50, respectivamente).  
   - Se nada for selecionado, uma mensagem solicita a escolha obrigatória.

2. **Tela de Tamanho e Pagamento:**  
   - O usuário escolhe o tamanho da pizza com RadioButtons: Brotinho (x0.75), Grande (x1.3) ou "Fome do Diabo" (x1.5).  
   - Também seleciona a forma de pagamento: Cartão ou Dinheiro.  
   - A aplicação valida ambas as escolhas e impede o avanço caso não sejam preenchidas.

3. **Tela de Resumo:**  
   - Exibe uma lista dos sabores escolhidos, o tamanho e a forma de pagamento.  
   - Calcula o valor total com base nos sabores e no multiplicador de tamanho.  
   - Apresenta o resultado com clareza e permite retornar ao início.

### Destaques:
- Uso de **Bundles** para passar dados entre as telas.  
- Validação completa para evitar envio de formulários incompletos.  
- Cálculo automatizado com base nas escolhas do usuário.  
- Interface leve, divertida e inspirada na cultura pop (estilo DMC).  

### Tecnologias Utilizadas:
- Java  
- Android Studio  
- XML para layouts  
- Manipulação de `Intent`, `Bundle`, `Toast` e validações com `RadioGroup` e `CheckBox`
