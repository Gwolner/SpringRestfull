## :white_check_mark: Autenticação - Acolhido

### Inserir `POST` | `/Acolhido/Auth`

Enviar: 
```json
{
  "email":"bruce@wayne.com",
  "senha":"temias"
}
```

**Observação 1:** Se a autenticação estiver correta, o servidor irá devolver o CPF do usuário Acolhido. <br>
**Observação 2:** Se a autenticação estiver errada, o servidor irá devolver a mensagem "Acesso negado".
