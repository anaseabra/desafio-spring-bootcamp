# desafio-spring-bootcamp

# SocialMeli


##Desafio foi realizado utilizando dois arquivos como banco de dados, ambos estão na pasta principal do projeto: 
    -->globalUsers.json
    -->posts.json
    
##Arquivo json com a collection do postman está na pasta principal do projeto

##Alguns users já foram criados. Eles se diferenciam em usuarios comuns ou vendedores pela flag "seller", sendo eles:
    -->ids dos usuários comuns: 2,3,6,7,8,9,10
    -->ids dos usuarios vendedores: 1,5,11,12,13
    
##É possível criar um novo usuário, retornar um usuário pelo seu id, retornar uma lista com todos os usuários criados e deletar um usuario pelo seu id.


##Qualquer tipo de usuário pode seguir ou deixar de seguir um vendedor.

##Usuários vendedores podem publicar posts sendo eles promocionais ou não. Nestes posts podem ser incluidos produtos das seguintes categorias: VARINHAS(0), CORUJAS(1), CALDEIRÕES(2), CAPAS(3), DOCES(4) E VASSOURAS(5).

##É possível retornar uma lista com todos os seguidores de um  dado vendedor, ou todos os vendedores que um dado usuário segue, sendo estas ordenadas ou não pelo nome do usuário de forma crescente ou descrecente. 

##É possível retornar uma lista com todos os posts publicados nas ultimas duas semanas pelos vendedores que um dado usuário segue, tendo a possibilidade de orderná-la ou não pela data de publicação de forma crescente ou decrescente.


##Uma documentação técnica mais detalhada de cada endpoint desta aplicação está dispoível em: https://drive.google.com/file/d/1-Gf6t2G-_WnEpspYXSASkYjlOJZD2LNH/view?usp=sharing