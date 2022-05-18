# Consumo da API Spring Restful

## :white_check_mark: Acolhido



## :white_check_mark: Servico

### Inserir `POST` | `/Servico`

Enviar: 
```json
{
 "designacao":"Abrigo"
}
```

### Atualizar `PUT` | `/Servico`

Enviar: 
```json
{
 "id":"1",
 "designacao":"Abrigo"
}
```

### Ler `GET` | `/Servico/{id}`

Retorno: 
```json
{
  "id": 1,
  "designacao": "Abrigo"
}
```

### Deletar `DELETE` | `/Servico/{id}`

### Ler Todos `GET` | `/Servico`

Retorno:
```json
[
 {
  "id": 1,
  "designacao": "Abrigo"
 },
 {
  "id": 3,
  "designacao": "Abrigo"
 }
]
```
