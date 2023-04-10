# boardGameLibrary

Biblioteca de jogos de tabuleiro.  
Registra o endereço do usuário e quais jogos de tabuleiro ele possui.  
A API consome uma API de CEP para resgatar informações sobre o endereço.  
Em relação aos jogos, é possível registrar quais jogos base e expansões o usuário possui.  
O usuário pode ter expansões mesmo ainda não tendo o jogo base.  

<img width="493" alt="image" src="https://user-images.githubusercontent.com/116609357/231020037-cdc84315-6b08-45c1-8c24-ee85c4368887.png">


Formulários:  

board-games  
{  
&nbsp;&nbsp;&nbsp;&nbsp;"nome": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"dataLancamento": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"genero": ""  
}  

expansions  
{  
&nbsp;&nbsp;&nbsp;&nbsp;"nome": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"dataLancamento": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"boardGameNumber":   
}  

users  
{  
&nbsp;&nbsp;&nbsp;&nbsp;"nome": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"dataDeNascimento": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"cpf": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"email": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"cep": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"numero": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"complemento": "",  
&nbsp;&nbsp;&nbsp;&nbsp;"boardGames": [],  
&nbsp;&nbsp;&nbsp;&nbsp;"expansions": []  
}  
