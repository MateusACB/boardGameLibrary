# boardGameLibrary

Biblioteca de jogos de tabuleiro.
Registra o endereço do usuário e quais jogos de tabuleiro ele possui.
A API consome uma API de CEP para resgatar informações sobre o endereço.
Em relação aos jogos, é possível registrar quais jogos base e expansões o usuário possui. O usuário pode ter expansões mesmo ainda não tendo o jogo base.

<img width="511" alt="image" src="https://user-images.githubusercontent.com/116609357/231017557-5234824b-5500-4fee-b662-3b74791b9bfb.png">


Formulários:

board-games
{
    "nome": "",
    "dataLancamento": "",
    "genero": "",
}

expansions
{
    "nome": "",
    "dataLancamento": "",
    "boardGameNumber": 
}

users
{
    "nome": "",
    "dataDeNascimento": "",
    "cpf": "",
    "email": "",
    "cep": "",
    "numero": "",
    "complemento": "",
    "boardGames": [],
    "expansions": []
}
