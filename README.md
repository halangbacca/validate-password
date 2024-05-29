# Senha segura

Implementação de um serviço que valida se uma senha é considerada segura com base em critérios pré-definidos.

## Exemplo

O serviço recebe uma chamada para validar uma senha.

**[POST]** `{{host}}/validate-password`

```json
{
    "password": "vYQIYxO&p$yfI^r"
}
```

Se a senha atender a todos os critérios de segurança, então, o serviço deve retornar uma resposta de sucesso.

```
HTTP/1.1 204 NoContent
```

Caso contrário, é retornado uma mensagem informando quais critérios não foram atendidos.

```
HTTP/1.1 400 Bad Request
```

```json
{
    ...
}
```

## Requisitos

- Verificar se a senha possui pelo menos 08 caracteres.
- Verificar se a senha contém pelo menos uma letra maiúscula.
- Verificar se a senha contém pelo menos uma letra minúscula.
- Verificar se a senha contém pelo menos um dígito numérico.
- Verificar se a senha contém pelo menos um caractere especial (e.g, !@#$%).

## **Ferramentas Utilizadas para Desenvolvimento**

```
IntelliJ IDEA
Postman
Spring Boot   
Java
```

## **Dependências**

O desenvolvimento de código em Java, em geral, usufrui de um significativo conjunto de bibliotecas e _frameworks_. Esta
reutilização é incorporada em um projeto por meio de dependências. Para gerenciar foi utilizado o _Maven_.

```
Spring Web
```

## **Métodos**

Requisições para a API devem seguir os padrões:

| Método | Descrição |
|---|---|
| `POST` | Utilizado para criar um novo registro. |

## **Respostas**

| Status | Descrição                                                          |
|--------|--------------------------------------------------------------------|
| `200`  | Requisição executada com sucesso (success).                        |
| `201`  | Requisição executada com sucesso (success).                        |
| `400`  | Erros de validação ou os campos informados não existem no sistema. |
| `409`  | Conflito.                                                          |
| `405`  | Método não implementado.                                           |

# **Recursos da API**

| Método     | Endpoint                                             |
|------------|---------------------------------------------------|
| `POST`     | /validate-password                                |
