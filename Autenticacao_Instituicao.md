## :white_check_mark: Autenticação - Instituicao

### Inserir `POST` | `/Instituicao/Auth`

Enviar: 
```json
{
  "email":"bruce@wayne.com",
  "senha":"temias"
}
```

**Observação 1:** Se a autenticação estiver correta, o servidor irá devolver o CNPJ do usuário Instituicao. <br>
**Observação 2:** Se a autenticação estiver errada, o servidor irá devolver a mensagem "Acesso negado".
