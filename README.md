# Consumo da API Spring Restful

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

## :white_check_mark: Acolhido

### Inserir `POST` | `/Acolhido`

Enviar: 
```json
{
	"cpf":"096.147.852-45",
	"rg":"8.147.598",
	"nome":"Bruce Wayne",
	"tipoContato":"Telegram",
	"contato":"(81)945875236",
	"dataNascimento":"12/05/1996",
	"coordenada":{
		"id":"4",
		"latitude":"66.40338",
		"longitude":"22.17403"
	}
}
```

